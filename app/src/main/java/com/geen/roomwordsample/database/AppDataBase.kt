package com.geen.roomwordsample.database

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.geen.roomwordsample.bean.Word
import com.geen.roomwordsample.dao.WordDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @Author LuoJi
 * @Date 2021/8/16-16:49
 * @Desc
 */
@Database(entities = arrayOf(Word::class),version = 1)
public abstract class AppDataBase: RoomDatabase() {

    abstract fun getWordDao():WordDao

    class DataBaseCallBack(private val scope: CoroutineScope):RoomDatabase.Callback(){

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let {
                scope.launch(Dispatchers.IO) {
                    it.getWordDao().deleteAll()
                    var word = Word("Hello")
                    it.getWordDao().insertWord(word)
                    word = Word("World!")
                    it.getWordDao().insertWord(word)
                }
            }
        }

    }

    companion object{
        @Volatile
        private var INSTANCE : AppDataBase? = null
        fun getDatabase(context: Context, scope:CoroutineScope):AppDataBase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "word_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(DataBaseCallBack(scope))
                    .build()

                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
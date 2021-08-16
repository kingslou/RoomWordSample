package com.geen.roomwordsample.database

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.geen.roomwordsample.bean.Word
import com.geen.roomwordsample.dao.WordDao
import kotlinx.coroutines.CoroutineScope

/**
 * @Author LuoJi
 * @Date 2021/8/16-16:49
 * @Desc
 */
@Database(entities = arrayOf(Word::class),version = 1)
public abstract class AppDataBase: RoomDatabase() {

    abstract fun getWordDao():WordDao

    class DataBaseCallBack(scope: CoroutineScope):RoomDatabase.Callback(){

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let {
                val word = Word(1,"xxx")
                it.getWordDao().insertWord(word)
            }
        }

    }

    companion object{

        private var INSTANCE : AppDataBase? = null
        fun getDatabase(context: Context, scop:CoroutineScope):AppDataBase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "word_database"
                )
                    .addCallback(DataBaseCallBack(scop))
                    .build()

                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
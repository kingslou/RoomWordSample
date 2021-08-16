package com.geen.roomwordsample.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.geen.roomwordsample.bean.Word
import kotlinx.coroutines.flow.Flow

/**
 * @Author LuoJi
 * @Date 2021/8/16-16:22
 * @Desc
 */
@Dao
interface WordDao {

    @Query("select * from word_tab order by word asc")
    fun getAllWords(): Flow<List<Word>>

    @Query("delete from word_tab")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertWord(word: Word)
}
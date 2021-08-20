package com.geen.roomwordsample.repository

import androidx.annotation.WorkerThread
import com.geen.roomwordsample.bean.Word
import com.geen.roomwordsample.dao.WordDao
import kotlinx.coroutines.flow.Flow

/**
 * @Author LuoJi
 * @Date 2021/8/16-17:19
 * @Desc
 */
class WordRepository(private val wordDao: WordDao) {

    val allWords : Flow<List<Word>> = wordDao.getAllWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun addWord(word: Word){
        wordDao.insertWord(word)
    }

}
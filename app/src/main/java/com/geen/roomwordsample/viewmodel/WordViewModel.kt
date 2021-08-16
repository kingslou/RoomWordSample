package com.geen.roomwordsample.viewmodel

import androidx.lifecycle.*
import com.geen.roomwordsample.bean.Word
import com.geen.roomwordsample.repository.WordRepository
import kotlinx.coroutines.launch

/**
 * @Author LuoJi
 * @Date 2021/8/16-17:21
 * @Desc
 */
class WordViewModel(private val wordRepository: WordRepository) : ViewModel() {


    val allWords : LiveData<List<Word>> = wordRepository.allWords.asLiveData()


    fun addWord(word: Word) = viewModelScope.launch {

        wordRepository.addWord(word)
    }

}

//传参
class WordViewModelFactory(private val wordRepository: WordRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(WordViewModel::class.java)){
            return WordViewModel(wordRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
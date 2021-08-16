package com.geen.roomwordsample

import android.app.Application
import com.geen.roomwordsample.database.AppDataBase
import com.geen.roomwordsample.repository.WordRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

/**
 * @Author LuoJi
 * @Date 2021/8/16-17:29
 * @Desc
 */
class AppWord : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())


    val dataBase by lazy {
        AppDataBase.getDatabase(this,applicationScope)
    }

    val repository by lazy{
        WordRepository(dataBase.getWordDao())
    }

    override fun onCreate() {
        super.onCreate()
    }
}
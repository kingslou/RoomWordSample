package com.geen.roomwordsample.bean

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author LuoJi
 * @Date 2021/8/16-16:12
 * @Desc
 */
@Entity(tableName = "word_tab")
data class Word(@PrimaryKey(autoGenerate = true) val id:Int, @ColumnInfo(name = "word") val word:String)
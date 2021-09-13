package com.geen.roomwordsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.geen.roomwordsample.databinding.ActivityNavBinding

/**
 * @Author LuoJi
 * @Date 2021/9/7-11:36
 * @Desc
 */
class NavMainActivity : AppCompatActivity() {
    private lateinit var mBinding : ActivityNavBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityNavBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

}
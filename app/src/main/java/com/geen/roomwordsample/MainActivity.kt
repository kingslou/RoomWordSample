package com.geen.roomwordsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.geen.roomwordsample.adapter.WordListAdapter
import com.geen.roomwordsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mAdapter : WordListAdapter? = null
    private lateinit var mBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mAdapter = WordListAdapter()
        mBinding.mRecycleView.adapter = mAdapter
        
    }
}
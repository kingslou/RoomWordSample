package com.geen.roomwordsample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.geen.roomwordsample.adapter.WordListAdapter
import com.geen.roomwordsample.bean.Word
import com.geen.roomwordsample.databinding.ActivityMainBinding
import com.geen.roomwordsample.viewmodel.WordViewModel
import com.geen.roomwordsample.viewmodel.WordViewModelFactory
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

class MainActivity : AppCompatActivity() {

    private var mAdapter : WordListAdapter? = null
    private lateinit var mBinding : ActivityMainBinding

    private val viewModel : WordViewModel by viewModels {
        WordViewModelFactory((application as AppWord).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mAdapter = WordListAdapter()
        mBinding.mRecycleView.adapter = mAdapter

        mBinding.add.setOnClickListener {
            startActivityForResult(Intent(this,NewWordActivity::class.java),100)
        }
//
        viewModel.allWords.observe(this, {
            it?.let {
                mAdapter?.submitList(it)
            }
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode==Activity.RESULT_OK){
           data?.getStringExtra(NewWordActivity.EXTRA_REPLY)?.let {
               val word  = Word(it)
                viewModel.addWord(word)
           }

        }
    }
}
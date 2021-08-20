package com.geen.roomwordsample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.geen.roomwordsample.databinding.ActivityNewWordBinding

/**
 * @Author LuoJi
 * @Date 2021/8/19-16:30
 * @Desc
 */
class NewWordActivity : AppCompatActivity() {

    private lateinit var mBinding:ActivityNewWordBinding

    companion object{

        const val  EXTRA_REPLY  = "0X1001"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityNewWordBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.buttonSave.setOnClickListener {
            if(TextUtils.isEmpty(mBinding.editWord.text)){
                return@setOnClickListener
            }
            val replyIntent = Intent()
            replyIntent.putExtra(EXTRA_REPLY,mBinding.editWord.text.toString())
            setResult(Activity.RESULT_OK,replyIntent)
            finish()
        }
    }
}
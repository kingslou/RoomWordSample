package com.geen.roomwordsample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.geen.roomwordsample.R
import com.geen.roomwordsample.databinding.FragmentTitleBinding

/**
 * @Author LuoJi
 * @Date 2021/9/7-13:35
 * @Desc
 */
class TitleFragment : Fragment() {
    private lateinit var mBinding : FragmentTitleBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentTitleBinding.inflate(inflater,container,false)
        initView()
        return mBinding.root
    }



    private fun initT(){


    }

    private fun initView(){
        mBinding.tvTitle.setOnClickListener {
            it.findNavController().navigate(R.id.action_titleFragment_to_gameFragment2)
        }
    }
}
package com.geen.roomwordsample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.geen.roomwordsample.databinding.FragmentGameBinding

/**
 * @Author LuoJi
 * @Date 2021/9/7-13:35
 * @Desc
 */
class GameFragment : ViewBindingFragment<FragmentGameBinding>() {

    override fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): FragmentGameBinding {
        return FragmentGameBinding.inflate(inflater,container,false)
    }

    override fun FragmentGameBinding.viewCreate() {

    }
}
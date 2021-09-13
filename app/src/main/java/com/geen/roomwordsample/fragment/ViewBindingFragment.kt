package com.geen.roomwordsample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * @Author LuoJi
 * @Date 2021/9/10-15:21
 * @Desc
 */
abstract class ViewBindingFragment<T:ViewBinding> : Fragment() {

    private var mBinding :T ? = null

    val binding :T get() = mBinding!!

    abstract fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):T

    abstract fun T.viewCreate()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return createViewBinding(inflater,container,savedInstanceState).also {
            mBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewCreate()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}
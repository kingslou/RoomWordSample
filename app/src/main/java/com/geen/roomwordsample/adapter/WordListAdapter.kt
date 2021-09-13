package com.geen.roomwordsample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geen.roomwordsample.R
import com.geen.roomwordsample.bean.Word
import com.geen.roomwordsample.databinding.ItemWordBinding

/**
 * @Author LuoJi
 * @Date 2021/8/16-17:36
 * @Desc
 */
class WordListAdapter :ListAdapter<Word,WordListAdapter.WordViewHolder>(WordComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder.createView(parent)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val wordInfo = getItem(position)
        holder.mbinding.str = wordInfo.word
    }

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mbinding  = DataBindingUtil.findBinding<ItemWordBinding>(itemView) as ItemWordBinding
        companion object {
            fun createView(parent: ViewGroup): WordViewHolder {
                val mBinding = DataBindingUtil.inflate( LayoutInflater.from(parent.context),R.layout.item_word,parent,false) as ItemWordBinding
                return WordViewHolder(mBinding.root)
            }
        }
    }

    class WordComparator : DiffUtil.ItemCallback<Word>() {
        override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem.word == newItem.word
        }
    }
}
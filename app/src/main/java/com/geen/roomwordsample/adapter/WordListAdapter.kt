package com.geen.roomwordsample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geen.roomwordsample.R
import com.geen.roomwordsample.bean.Word

/**
 * @Author LuoJi
 * @Date 2021/8/16-17:36
 * @Desc
 */
class WordListAdapter :ListAdapter<Word,WordListAdapter.WordViewHolder>(WordComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder(parent)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val wordInfo = getItem(position)
        holder.setText(wordInfo.word)
    }

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvWord = itemView.findViewById<AppCompatTextView>(R.id.tvWord)

        fun setText( wordText:String){
            tvWord.text = wordText
        }

        companion object {
            fun createView(parent: ViewGroup): WordViewHolder {
                val view: View =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false)
                return WordViewHolder(view)
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
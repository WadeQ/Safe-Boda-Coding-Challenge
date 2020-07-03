package com.wadektech.androidsafebodacodingchallenge.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wadektech.androidsafebodacodingchallenge.databinding.MagicCardListItemBinding

class MagicCardAdapter(private var singleCardItemClicked: OnSingleCardItemClicked) :
    ListAdapter<Data, MagicCardAdapter.ViewHolder>(ConcertsDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val magicCard = getItem(position)
        if (magicCard != null){
            holder.bind(magicCard , singleCardItemClicked)
        }
    }

    class ViewHolder private constructor(private val binding: MagicCardListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(magicCard: Data, singleCardItemClicked: OnSingleCardItemClicked){
            binding.cards = magicCard
            binding.executePendingBindings()

            itemView.setOnClickListener {
                singleCardItemClicked.onSingleCardItemClicked(magicCard)
            }
        }
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MagicCardListItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class OnSingleCardItemClicked(val cardItemClicked: (magicCard : Data)-> Unit) {
        fun onSingleCardItemClicked(magicCard: Data) = cardItemClicked(magicCard)
    }

    class ConcertsDiffUtil : DiffUtil.ItemCallback<Data>(){
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }
}
package com.wadektech.androidsafebodacodingchallenge.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wadektech.androidsafebodacodingchallenge.data.Data
import com.wadektech.androidsafebodacodingchallenge.data.DataX
import com.wadektech.androidsafebodacodingchallenge.databinding.MagicCardListItemBinding

class MagicCardAdapter(private var singleCardItemClicked: OnSingleCardItemClicked) :
    ListAdapter<DataX, MagicCardAdapter.ViewHolder>(ConcertsDiffUtil()) {

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

        fun bind(magicCard: DataX, singleCardItemClicked: OnSingleCardItemClicked){
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

    class OnSingleCardItemClicked(val cardItemClicked: (magicCard : DataX)-> Unit) {
        fun onSingleCardItemClicked(magicCard: DataX) = cardItemClicked(magicCard)
    }

    class ConcertsDiffUtil : DiffUtil.ItemCallback<DataX>(){
        override fun areItemsTheSame(oldItem: DataX, newItem: DataX): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: DataX, newItem: DataX): Boolean {
            return oldItem == newItem
        }
    }
}
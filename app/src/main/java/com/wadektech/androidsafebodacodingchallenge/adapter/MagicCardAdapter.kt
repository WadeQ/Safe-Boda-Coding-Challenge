package com.wadektech.androidsafebodacodingchallenge.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wadektech.androidsafebodacodingchallenge.data.MagicCard
import com.wadektech.androidsafebodacodingchallenge.databinding.MagicCardListItemBinding

class MagicCardAdapter(private var singleCardItemClicked: OnSingleCardItemClicked) :
    ListAdapter<MagicCard, MagicCardAdapter.ViewHolder>(ConcertsDiffUtil()) {

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

        fun bind(magicCard: MagicCard, singleCardItemClicked: OnSingleCardItemClicked){
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

    class OnSingleCardItemClicked(val cardItemClicked: (magicCard : MagicCard)-> Unit) {
        fun onSingleCardItemClicked(magicCard: MagicCard) = cardItemClicked(magicCard)
    }

    class ConcertsDiffUtil : DiffUtil.ItemCallback<MagicCard>(){
        override fun areItemsTheSame(oldItem: MagicCard, newItem: MagicCard): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: MagicCard, newItem: MagicCard): Boolean {
            return oldItem == newItem
        }
    }
}
package com.wadektech.androidsafebodacodingchallenge.utils

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.wadektech.androidsafebodacodingchallenge.R
import com.wadektech.androidsafebodacodingchallenge.adapter.MagicCardAdapter
import com.wadektech.androidsafebodacodingchallenge.data.Data
import com.wadektech.androidsafebodacodingchallenge.data.DataX
import timber.log.Timber


@BindingAdapter("status")
fun apiResponseStatus(imageView: AppCompatImageView, status: MagicCardDownloadStatus?){
    when(status){
        MagicCardDownloadStatus.LOADING -> {
            imageView.visibility = View.VISIBLE
            imageView.setImageResource(R.drawable.loading)
        }
        MagicCardDownloadStatus.ERROR -> {
            imageView.visibility = View.VISIBLE
            imageView.setImageResource(R.drawable.error)
        }
        MagicCardDownloadStatus.SUCCESS -> {
            imageView.visibility = View.GONE
        }
    }
}

@BindingAdapter("cardsBindingAdapter")
fun bindCardsAdapter(recyclerView: RecyclerView, magicCardList:  List<DataX>?){
    val adapter = recyclerView.adapter as MagicCardAdapter
    Timber.d("binding adapter list size is: ${magicCardList?.size}")
    adapter.submitList(magicCardList)
}

@BindingAdapter("cardImage")
fun bindCardImages(imageView: AppCompatImageView, imageUrl: String?){
    imageUrl?.let {
        val imageUri = imageUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context)
            .load(imageUri)
            .apply(RequestOptions()
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
            )
            .into(imageView)
    }
}

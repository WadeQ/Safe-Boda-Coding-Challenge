package com.wadektech.androidsafebodacodingchallenge.utils

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wadektech.androidsafebodacodingchallenge.data.MagicCard
import com.wadektech.androidsafebodacodingchallenge.viewmodels.CardDetailViewModel

@Suppress("UNCHECKED_CAST")
class MagicCardViewModelFactory(private val application: Application, private val magicCard: MagicCard)
    : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CardDetailViewModel(magicCard,application) as T
    }
}
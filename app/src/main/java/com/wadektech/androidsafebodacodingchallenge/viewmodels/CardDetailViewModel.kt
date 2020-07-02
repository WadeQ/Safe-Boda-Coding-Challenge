package com.wadektech.androidsafebodacodingchallenge.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wadektech.androidsafebodacodingchallenge.data.MagicCard

class CardDetailViewModel(magicCard: MagicCard, application: Application) : AndroidViewModel(application){

    //details view
    private val _selectedCard = MutableLiveData<MagicCard>()
    val selectedCard : LiveData<MagicCard>
        get() = _selectedCard

    init {
        _selectedCard.value = magicCard
    }
}
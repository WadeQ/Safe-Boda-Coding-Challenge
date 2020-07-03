package com.wadektech.androidsafebodacodingchallenge.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wadektech.androidsafebodacodingchallenge.data.Data

class CardDetailViewModel(magicCard: Data, application: Application) : AndroidViewModel(application){

    //details view
    private val _selectedCard = MutableLiveData<Data>()
    val selectedCard : LiveData<Data>
        get() = _selectedCard

    init {
        _selectedCard.value = magicCard
    }
}
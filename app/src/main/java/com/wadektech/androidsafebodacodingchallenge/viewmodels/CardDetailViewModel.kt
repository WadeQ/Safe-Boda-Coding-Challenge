package com.wadektech.androidsafebodacodingchallenge.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wadektech.androidsafebodacodingchallenge.data.Data
import com.wadektech.androidsafebodacodingchallenge.data.DataX

class CardDetailViewModel(magicCard: DataX, application: Application) : AndroidViewModel(application){

    //details view
    private val _selectedCard = MutableLiveData<DataX>()
    val selectedCard : LiveData<DataX>
        get() = _selectedCard

    init {
        _selectedCard.value = magicCard
    }
}
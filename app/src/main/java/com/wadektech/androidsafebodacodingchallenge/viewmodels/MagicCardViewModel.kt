package com.wadektech.androidsafebodacodingchallenge.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wadektech.androidsafebodacodingchallenge.data.MagicCard
import com.wadektech.androidsafebodacodingchallenge.network.MagicCardApi
import com.wadektech.androidsafebodacodingchallenge.utils.MagicCardDownloadStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber

class MagicCardViewModel : ViewModel() {

    //status
    private val _status = MutableLiveData<MagicCardDownloadStatus>()
    val status : LiveData<MagicCardDownloadStatus>
        get() = _status

     //list of cards
    private val _response = MutableLiveData<List<MagicCard>>()
    val response : LiveData<List<MagicCard>>
    get() = _response

    //navigation to details fragment
    private val _navigateToDetailsFragment = MutableLiveData<MagicCard>()
    val navigateToDetailsFragment : LiveData<MagicCard>
    get() = _navigateToDetailsFragment

    private var job = Job()
    private val _coroutineScope = CoroutineScope(job + Dispatchers.Main)

    private fun getAllMagicCardsFromApi(filter : String){
        _coroutineScope.launch {
            val getCardsList = MagicCardApi.retrofitService.getAllMagicCardsAsync(filter)
            try {
                //status loading
                _status.value = MagicCardDownloadStatus.LOADING
                val cardsList = getCardsList.await()
                //loading successful
                _status.value = MagicCardDownloadStatus.SUCCESS
                _response.value = cardsList
                Timber.d("Results are ${cardsList.size}")
            } catch (t :Throwable){
                Timber.d("Failure due to ${t.message}")
                //loading failure
                _status.value = MagicCardDownloadStatus.ERROR
                _response.value = ArrayList()
            }
        }
    }

    init {
        getAllMagicCardsFromApi("duress")
    }
    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    //display details to details fragment
    fun displayMagicCardDetails(magicCard: MagicCard){
        _navigateToDetailsFragment.value = magicCard
    }

    //we have the details so we stop function being triggered again
    fun displayMagicCardDetailsCompleted(){
        _navigateToDetailsFragment.value = null
    }
    //filter method to get cards by name
    fun filterThroughCards(filter: String){
        getAllMagicCardsFromApi(filter)
    }
}
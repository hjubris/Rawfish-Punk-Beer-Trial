package com.example.rawfishtest.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rawfishtest.network.BeerApi
import com.example.rawfishtest.network.BeerModel
import kotlinx.coroutines.launch

enum class BeerApiStatus { LOADING, ERROR, DONE }

/**
 *  The view model used in the layout files
 */
class OverviewViewModel : ViewModel() {

    //monitors the server status and checks whether there are loading errors
    private val _status = MutableLiveData<BeerApiStatus>()

    //gets the (mutable) list of beers and encapsulates it in an immutable List
    private val _beers = MutableLiveData<List<BeerModel>>()
    val beers: LiveData<List<BeerModel>> = _beers

    init {
        getBeers()
    }

    // Gets Beers info from API retrofit service and updates status and list
    private fun getBeers() {
        viewModelScope.launch {
            _status.value = BeerApiStatus.LOADING
            try {
                _beers.value = BeerApi.retrofitService.getBeers()
//                Log.d("BeerApiService", "getBeers: loaded ${beers.value?.size} items", )
                _status.value = BeerApiStatus.DONE
            } catch (e: Exception) {
                _status.value = BeerApiStatus.ERROR
                _beers.value = listOf()
            }
        }
    }
    fun onBeerClicked(beer: BeerModel){

      //  beer.findNavController().navigate(R.id.action_overviewFragment_to_detailView)

    }
}
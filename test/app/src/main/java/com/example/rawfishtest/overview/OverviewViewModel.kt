package com.example.rawfishtest.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rawfishtest.R
import com.example.rawfishtest.network.BeerApi
import com.example.rawfishtest.network.BeerModel
import kotlinx.coroutines.launch
import androidx.navigation.findNavController
import com.example.rawfishtest.detail.DetailViewFragment

enum class BeerApiStatus { LOADING, ERROR, DONE }

/**
 *  The view model used in the layout files
 */
class OverviewViewModel : ViewModel() {

    //monitors the server status and checks whether there are loading errors
    private val _status = MutableLiveData<BeerApiStatus>()
    val status: LiveData<BeerApiStatus> = _status

    //gets the (mutable) list of beers and encapsulates it in an immutable List
    private val _beers = MutableLiveData<List<BeerModel>>()
    val beers: LiveData<List<BeerModel>> = _beers

    /**
     * These values would be passed to the detail view through onBeerClicked and the onClick value in grid_view_item.xml's CardView
     */
//    private val _selectedBeer = MutableLiveData<BeerModel>()
//    val selectedBeer: LiveData<BeerModel> = _selectedBeer

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

    /**function to send to the detail view,
     *also used in the layout to make the beer a clickable button
     **/
//    fun onBeerCLicked(beer: BeerModel) {
//        _selectedBeer.value = beer
//    }
}
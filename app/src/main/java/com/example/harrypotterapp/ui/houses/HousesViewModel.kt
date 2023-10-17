package com.example.harrypotterapp.ui.houses

import androidx.lifecycle.ViewModel
import com.example.harrypotterapp.data.provider.HousesProvider
import com.example.harrypotterapp.domain.model.HousesInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HousesViewModel @Inject constructor(housesProvider: HousesProvider):ViewModel() {
    private val _houses= MutableStateFlow<List<HousesInfo>>(emptyList())
    val houses:StateFlow<List<HousesInfo>> = _houses

    init {
        _houses.value= housesProvider.getHouses()
    }
}
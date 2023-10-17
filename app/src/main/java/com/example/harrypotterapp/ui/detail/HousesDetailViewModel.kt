package com.example.harrypotterapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harrypotterapp.domain.model.usecase.GetCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HousesDetailViewModel @Inject constructor(private val getCharacterUseCase:GetCharacterUseCase):ViewModel() {
    private var _state = MutableStateFlow<HousesDetailState>(HousesDetailState.Loading)
    val state: StateFlow<HousesDetailState> = _state

    fun getCharacter(house: String) {
        viewModelScope.launch {
            _state.value = HousesDetailState.Loading
            val result = withContext(Dispatchers.IO) { getCharacterUseCase(house) }
            if (result != null) {
                _state.value=HousesDetailState.Success(result)
            }else{
                _state.value=HousesDetailState.Error("Ha ocurrifo un error")
            }
        }
    }
}
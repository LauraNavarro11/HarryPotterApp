package com.example.harrypotterapp.ui.detail

import com.example.harrypotterapp.domain.model.CharacterModel

sealed class HousesDetailState {
    data object Loading:HousesDetailState()
    data class Error(val error:String):HousesDetailState()
    data class Success(val characterList: List<CharacterModel>?):HousesDetailState()

}
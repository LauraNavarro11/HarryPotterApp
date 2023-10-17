package com.example.harrypotterapp.domain.model.usecase

import com.example.harrypotterapp.domain.model.CharacterModel
import com.example.harrypotterapp.domain.model.Repository
import javax.inject.Inject

class GetCharacterUseCase@Inject constructor(private val repository:Repository) {
    suspend operator fun invoke(house: String):List<CharacterModel>? = repository.getCharacter(house)

}
package com.example.harrypotterapp.data

import android.util.Log
import com.example.harrypotterapp.data.network.DetailApiService
import com.example.harrypotterapp.data.network.response.CharacterResponse
import com.example.harrypotterapp.domain.model.CharacterModel
import com.example.harrypotterapp.domain.model.Repository
import javax.inject.Inject

class ReposirotyImp @Inject constructor(private val apiService: DetailApiService):Repository {
    override suspend fun getCharacter(house: String): List<CharacterModel>? {

        kotlin.runCatching { apiService.getHoroscope(house)
        }
            .onSuccess {
                return it.toDomain()}
            .onFailure { Log.i("alura", "ha ocurrido error") }

        return null
    }
    fun List<CharacterResponse>.toDomain(): List<CharacterModel> {
        return this.map {
            CharacterModel(
                name = it.name,
                house = it.house,
                image = it.image,
                ancestry = it.ancestry
            )
        }
    }


}





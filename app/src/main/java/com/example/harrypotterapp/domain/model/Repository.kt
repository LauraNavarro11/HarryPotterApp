package com.example.harrypotterapp.domain.model

interface Repository {
    suspend fun getCharacter(house:String):List<CharacterModel>?
}
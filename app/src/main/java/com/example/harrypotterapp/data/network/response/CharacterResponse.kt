package com.example.harrypotterapp.data.network.response

import com.example.harrypotterapp.domain.model.CharacterModel
import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("name") val name: String,
    @SerializedName("house") val house: String,
    @SerializedName("image") val image: String,
    @SerializedName("ancestry") val ancestry: String,
)




package com.example.harrypotterapp.data.network

import com.example.harrypotterapp.data.network.response.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailApiService {
    @GET("{house}")
    suspend fun getHoroscope(@Path("house") house:String):List<CharacterResponse>
}
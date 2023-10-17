package com.example.harrypotterapp.data.provider

import com.example.harrypotterapp.domain.model.HousesInfo
import com.example.harrypotterapp.domain.model.HousesInfo.*
import javax.inject.Inject

class HousesProvider @Inject constructor() {
    fun getHouses():List<HousesInfo>{
        return listOf(gryffindor,hufflepuff,ravenclaw,slytherin)
    }
}
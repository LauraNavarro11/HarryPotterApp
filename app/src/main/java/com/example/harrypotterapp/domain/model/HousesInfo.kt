package com.example.harrypotterapp.domain.model

import com.example.harrypotterapp.R

sealed class HousesInfo(val imagen:Int, val name: Int) {
    object gryffindor: HousesInfo(R.drawable.gryffindor,R.string.gryffindor)
    object slytherin: HousesInfo(R.drawable.slytherin,R.string.slytherin)
    object hufflepuff: HousesInfo(R.drawable.hufflepuff,R.string.hufflepuff)
    object ravenclaw: HousesInfo(R.drawable.ravenclaw,R.string.ravenclaw)

}
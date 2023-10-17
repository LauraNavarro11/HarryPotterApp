package com.example.harrypotterapp.ui.providers

import com.example.harrypotterapp.R
import com.example.harrypotterapp.ui.luck.LuckyModel
import javax.inject.Inject
import kotlin.random.Random

class CardsProviders @Inject constructor(){
    fun getLuck(): LuckyModel? {
        return when (Random.nextInt(0, 10)) {
            0 -> LuckyModel(R.drawable.card_pentacles, R.string.luck_0)
            1 -> LuckyModel(R.drawable.card_death, R.string.luck_1)
            2 -> LuckyModel(R.drawable.card_devil, R.string.luck_2)
            3 -> LuckyModel(R.drawable.card_empresion, R.string.luck_3)
            4 -> LuckyModel(R.drawable.card_fool, R.string.luck_4)
            5 -> LuckyModel(R.drawable.card_hermit, R.string.luck_5)
            6 -> LuckyModel(R.drawable.card_hierophant, R.string.luck_6)
            7 -> LuckyModel(R.drawable.card_judgement, R.string.luck_7)
            8 -> LuckyModel(R.drawable.card_king_swords, R.string.luck_8)
            9 -> LuckyModel(R.drawable.card_lovers, R.string.luck_9)
            else -> null

        }
    }
}
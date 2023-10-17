package com.example.harrypotterapp.ui.luck

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class LuckyModel (
    @DrawableRes
    val imagen: Int,
    @StringRes
    val text: Int,
    )
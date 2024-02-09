package com.example.ballondorapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.ballondorapp.R

data class Player(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val nationality: String,
    @StringRes val years: Int
)

val players = listOf(
    Player(R.drawable.messi, R.string.messi,"Argentina", R.string.messi_description),
    Player(R.drawable.cr7, R.string.cr7,"Portugal" ,R.string.cr7_description),
    Player(R.drawable.platini, R.string.platini,"France" ,R.string.platini_description),
    Player(R.drawable.cruyff, R.string.cruyff,"Netherlands" ,R.string.cruyff_description),
    Player(R.drawable.vanbasten, R.string.vanBasten,"Netherlands", R.string.vanBasten_description),
    Player(R.drawable.beckenbauer, R.string.beckenbauer,"Germany", R.string.beckenbauer_description),
    Player(R.drawable.ronal, R.string.ronaldo,"Brazil" ,R.string.ronaldo_description),
    Player(R.drawable.ronadinho, R.string.ronaldinho,"Brazil", R.string.ronaldinho_description),
    Player(R.drawable.zidane, R.string.zidane,"France" , R.string.zidane_description),
    Player(R.drawable.kaka, R.string.kaka, "Brazil",R.string.kaka_description),
)
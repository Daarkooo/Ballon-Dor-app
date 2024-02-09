package com.example.ballondorapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.ballondorapp.R

data class Player(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val nationality: String,
    val numBallonDor: Int,
    @StringRes val winningYear: Int
)

val players = listOf(
    Player(R.drawable.messi, R.string.messi,"Argentina",8, R.string.messi_description),
    Player(R.drawable.cr7, R.string.cr7,"Portugal" ,5 ,R.string.cr7_description),
    Player(R.drawable.platini, R.string.platini,"France",3 ,R.string.platini_description),
    Player(R.drawable.cruyff, R.string.cruyff,"Netherlands",3 ,R.string.cruyff_description),
    Player(R.drawable.vanbasten, R.string.vanBasten,"Netherlands",3, R.string.vanBasten_description),
    Player(R.drawable.beckenbauer, R.string.beckenbauer,"Germany",2, R.string.beckenbauer_description),
    Player(R.drawable.ronal, R.string.ronaldo,"Brazil" ,2, R.string.ronaldo_description),
    Player(R.drawable.ronadinho, R.string.ronaldinho,"Brazil",2, R.string.ronaldinho_description),
    Player(R.drawable.zidane, R.string.zidane,"France" ,1, R.string.zidane_description),
    Player(R.drawable.kaka, R.string.kaka, "Brazil",1 ,R.string.kaka_description),
)
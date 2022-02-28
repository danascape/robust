package dev.dsi.robust.utils

import dev.dsi.robust.R

class Constants {


    companion object{
        fun getRandomCardColor(): Int {
            val cardColors: Array<Int> = arrayOf(
                R.color.cardColor1,
                R.color.cardColor2,
                R.color.cardColor3,
                R.color.cardColor4,
                R.color.cardColor5,
                R.color.cardColor6,
                R.color.cardColor7,
                R.color.cardColor8,
                R.color.cardColor9,
                R.color.cardColor10,
                R.color.cardColor11,
                R.color.cardColor12,
                R.color.cardColor13,
                R.color.cardColor14,
                R.color.cardColor15
            )
            return cardColors.random()
        }
    }

}
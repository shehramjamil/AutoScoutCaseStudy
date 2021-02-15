package com.example.autoscoutcasestudy.utility

import android.graphics.Color
import javax.inject.Inject

class ChooseColorByFindingDivisible @Inject constructor() {

    fun getSpecificColorByFindingDivisible(index: Int): Int {
        return when {
            index % 3 == 0 && index % 5 == 0 -> Color.YELLOW
            index % 3 == 0 -> Color.RED
            index % 5 == 0 -> Color.BLUE
            else -> Color.WHITE
        }
    }
}
package com.example.autoscoutcasestudy.ui

import androidx.lifecycle.ViewModel
import com.example.autoscoutcasestudy.utility.ChooseColorByFindingDivisible
import com.example.autoscoutcasestudy.model.ColoredItems
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ColoredItemViewModel @Inject constructor(private val chooseColorByFindingDivisible: ChooseColorByFindingDivisible) :
    ViewModel() {

    fun mapItemToColor(itemList: List<Int>): List<ColoredItems> {
        return itemList.map {
            ColoredItems(
                it,
                chooseColorByFindingDivisible.getSpecificColorByFindingDivisible(it)
            )
        }
    }
}
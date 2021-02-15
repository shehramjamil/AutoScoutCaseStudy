package com.example.autoscoutcasestudy

import android.graphics.Color
import com.example.autoscoutcasestudy.utility.ChooseColorByFindingDivisible
import org.junit.jupiter.api.Assertions.assertAll

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

class ChooseColorByFindingDivisibleTest {

    lateinit var chooseColorByFindingDivisible: ChooseColorByFindingDivisible

    @BeforeEach
    fun beforeTest() {
        chooseColorByFindingDivisible = ChooseColorByFindingDivisible()
    }

    @Test
    fun testForDivisibleOf_5_and_3() {
        assertAll(Executable {
            assertEquals(
                Color.YELLOW,
                getColor(15)
            )
        }, Executable {
            assertEquals(
                Color.YELLOW,
                getColor(30)
            )
        },
            Executable {
                assertEquals(
                    Color.YELLOW,
                    getColor(150)
                )
            })
    }

    @Test
    fun testForDivisibleOf_5() {
        assertAll(Executable {
            assertEquals(
                Color.BLUE,
                getColor(5)
            )
        }, Executable {
            assertEquals(
                Color.BLUE,
                getColor(20)
            )
        },
            Executable {
                assertEquals(
                    Color.BLUE,
                    getColor(175)
                )
            })
    }

    @Test
    fun testForDivisibleOf_3() {
        assertAll(Executable {
            assertEquals(
                Color.RED,
                getColor(3)
            )
        }, Executable {
            assertEquals(
                Color.RED,
                getColor(18)
            )
        },
            Executable {
                assertEquals(
                    Color.RED,
                    getColor(33)
                )
            })
    }

    private fun getColor(number: Int): Int {
        return chooseColorByFindingDivisible.getSpecificColorByFindingDivisible(number)
    }
}

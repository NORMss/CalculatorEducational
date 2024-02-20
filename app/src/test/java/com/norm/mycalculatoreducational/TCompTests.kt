package com.norm.mycalculatoreducational

import org.junit.Test
import org.junit.Assert.*

class TCompTests {
    @Test
    fun TComp_toString(){
        val number = TComp("1", "2", 10)

        val result = number.toString()

        val expect = "1i2"

        assertEquals(result, expect)
    }

    @Test
    fun TComp_writeNumberToString(){
        val number = TComp("1", "2", 10)

        number.writeNumberToString("3i45")

        val result = number.toString()

        val expect = "3i45"

        assertEquals(result, expect)
    }

    @Test
    fun TComp_isZero(){
        val number = TComp("0", "0", 10)

        val result = number.isZero()

        val expect = true

        assertEquals(result, expect)
    }

    @Test
    fun TComp_equals(){
        val number1 = TComp("1", "2", 10)
        val number2 = TComp("1", "10", 2)

        val result = number1 == number2

        val expect = true

        assertEquals(result, expect)
    }

    @Test
    fun TComp_plus1(){
        val number1 = TComp("1", "2", 10)
        val number2 = TComp("2", "5", 10)

        val calculate = number1 + number2

        val result = calculate.toString()

        val expect = "3+i7"

        assertEquals(result, expect)
    }

    @Test
    fun TComp_plus2(){
        val number1 = TComp("-1", "2", 10)
        val number2 = TComp("2", "-5", 10)

        val calculate = number1 + number2

        val result = calculate.toString()

        val expect = "1+i-3"

        assertEquals(result, expect)
    }

    @Test
    fun TComp_minus(){
        val number1 = TComp("3", "5", 10)
        val number2 = TComp("2", "3", 10)

        val calculate = number1 - number2

        val result = calculate.toString()

        val expect = "1+i2"

        assertEquals(result, expect)
    }

    @Test
    fun TComp_times(){
        val number1 = TComp("3", "3", 10)
        val number2 = TComp("2", "3", 10)

        val calculate = number1 * number2

        val result = calculate.toString()

        val expect = "-3+i15"

        assertEquals(result, expect)
    }
}
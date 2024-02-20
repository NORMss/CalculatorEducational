package com.norm.mycalculatoreducational

import org.junit.Test
import org.junit.Assert.*

class TPNumberTests {
    @Test
    fun TPNumber_number_convertToDecimal1() {
        val result = TPNumber("A", 11)._number

        val expect = 10

        assertEquals(result, expect)
    }

    @Test
    fun TPNumber_number_convertToDecimal2() {
        val result = TPNumber("11111", 2)._number

        val expect = 31

        assertEquals(result, expect)
    }

    @Test
    fun TPNumber_number_isZero_0() {
        val number = TPNumber("0", 2)

        val result = number.isZero()

        val expect = true

        assertEquals(result, expect)
    }

    @Test
    fun TPNumber_number_isZero_1() {
        val number = TPNumber("1", 2)

        val result = number.isZero()

        val expect = false

        assertEquals(result, expect)
    }

    @Test
    fun TPNumber_number_isEqualTo() {
        val number1 = TPNumber("AB", 16)
        val number2 = TPNumber("10101011", 2)

        val result = number1 == number2

        val expect = true

        assertEquals(result, expect)
    }

    @Test
    fun TPNumber_readNumberFromString() {
        val number = TPNumber("A1", 16)

        val result = number.toString()

        val expect = "A1"

        assertEquals(result, expect)
    }

    @Test
    fun TPNumber_writeNumberToString() {
        val number = TPNumber("AB", 16)

        number.writeNumberToString("123")
        val result = number.toString()

        val expect = "123"

        assertEquals(result, expect)
    }

    @Test
    fun TPNumber_multiply() {
        val number1 = TPNumber("AB", 16)
        val number2 = TPNumber("5", 16)

//        val calculate = number1.times(number2)
        val calculate = number1 * number2
        val result = calculate.toString()

        val expect = "357"

        assertEquals(result, expect)
    }

    @Test
    fun TPNumber_square() {
        val number = TPNumber("12", 8)

        val calculate = number.square()
        val result = calculate.toString()

        val expect = "144"

        assertEquals(result, expect)
    }
}
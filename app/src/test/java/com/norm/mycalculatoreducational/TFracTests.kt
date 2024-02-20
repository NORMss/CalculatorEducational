package com.norm.mycalculatoreducational

import org.junit.Test
import org.junit.Assert.*

class TFracTests {
    @Test
    fun TFrac_isZero_true() {
        val number = TFrac("0", "A", 16)

        val result = number.isZero()

        val expect = true

        assertEquals(result, expect)
    }

    @Test
    fun mdaaa(){
        val r = 1512.toString(16)
        assertEquals(r,"5e8")
    }

    @Test
    fun mdaaa2(){
        val r = "111".toInt(2)
        assertEquals(r,7)
    }

    @Test
    fun TFrac_isZero_false() {
        val number = TFrac("1", "A", 16)

        val result = number.isZero()

        val expect = false

        assertEquals(result, expect)
    }

    @Test
    fun TFrac_equals1() {
        val number1 = TFrac("4", "5", 10)
        val number2 = TFrac("8", "10", 10)

        val result = number1 == number2

        val expect = true

        assertEquals(result, expect)
    }

    @Test
    fun TFrac_equals2() {
        val number1 = TFrac("4", "5", 10)
        val number2 = TFrac("1000", "1010", 2)

        val result = number1 == number2

        val expect = true

        assertEquals(result, expect)
    }

    @Test
    fun TFrac_equals3() {
        val number1 = TFrac("111", "1111", 2)
        val number2 = TFrac("7", "15", 10)

        val result = number1 == number2

        val expect = true

        assertEquals(result, expect)
    }

    @Test
    fun TFrac_plus() {
        val number1 = TFrac("3", "8", 10)
        val number2 = TFrac("2", "8", 10)

        val calculate = number1 + number2

        val result = calculate.toString()
        val expect = "5/8"

        assertEquals(result, expect)
    }

    @Test
    fun TFrac_minus() {
        val number1 = TFrac("3", "8", 10)
        val number2 = TFrac("2", "8", 10)

        val calculate = number1 - number2

        val result = calculate.toString()
        val expect = "1/8"

        assertEquals(result, expect)
    }

    @Test
    fun TFrac_times1() {
        val number1 = TFrac("2", "3", 10)
        val number2 = TFrac("1", "2", 10)

        val calculate = number1 * number2

        val result = calculate.toString()
        val expect = "1/3"

        assertEquals(result, expect)
    }

    @Test
    fun TFrac_times2() {
        val number1 = TFrac("11", "111", 2)
        val number2 = TFrac("24", "12", 10)

        val calculate = number1 * number2

        val result = calculate.toString()

        //72/84 = 6/7
        val expect = "110/111"

        assertEquals(result, expect)
    }

    @Test
    fun TFrac_div() {
        val number1 = TFrac("2", "5", 10)
        val number2 = TFrac("5", "10", 10)

        val calculate = number1 * number2

        val result = calculate.toString()

        //20/25 = 1/5
        val expect = "1/5"

        assertEquals(result, expect)
    }

    @Test
    fun TFrac_square() {
        val number = TFrac("2", "5", 10)

        val calculate = number.square()

        val result = calculate.toString()

        val expect = "4/25"

        assertEquals(result, expect)
    }

    @Test
    fun TFrac_inverse() {
        val number = TFrac("11", "111", 2)

        val calculate = number.inverse()

        val result = calculate.toString()

        val expect = "111/11"

        assertEquals(result, expect)
    }

    @Test
    fun TFrac_writeNumberToString() {
        val number = TFrac("A", "1F", 16)

        number.writeNumberToString("B/1A")

        val result = number.toString()

        val expect = "B/1A"

        assertEquals(result, expect)
    }

    @Test
    fun TFrac_copy() {
        val number1 = TFrac("111", "1111", 2)

        val number2 = number1.copy()

        val result = number2.toString()

        val expect = "111/1111"

        assertEquals(result, expect)
    }
}
package com.norm.mycalculatoreducational

class TPNumber(
    override val number: String,
    private val base: Int,
) : TANumber() {
    var _number: Int = 0
        get() = field
        set(value) {
            field = value
        }

    init {
        _number = convertToDecimal(number, base)
    }

    override fun isZero(): Boolean {
        return this._number == 0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        val otherTPNumber = other as TPNumber
        return _number == otherTPNumber._number
    }

    override fun plus(number_second: TANumber): TANumber {
        val calculate = this._number + (number_second as TPNumber)._number
        val result = convertFromDecimal(calculate, base)
        return TPNumber(result, base)
    }

    override fun minus(number_second: TANumber): TANumber {
        val calculate = this._number - (number_second as TPNumber)._number
        val result = convertFromDecimal(calculate, base)
        return TPNumber(result, base)
    }

    override fun times(number_second: TANumber): TANumber {
        val calculate = this._number * (number_second as TPNumber)._number
        val result = convertFromDecimal(calculate, base)
        return TPNumber(result, base)
    }

    override fun div(number_second: TANumber): TANumber {
        TODO("fun divide()")
//        val calculate = this._number / (number_second as TPNumber)._number
//        val result = convertFromDecimal(calculate, base)
//        return TPNumber(result, 10)
    }

    override fun square(): TANumber {
        val calculate = this._number * this._number
        val result = convertFromDecimal(calculate, base)
        return TPNumber(result, 10)
    }

    override fun inverse(): TANumber {
        TODO("fun inverse()")
//        val calculate = 1 / this._number
//        val result = convertFromDecimal(calculate, base)
//        return TPNumber(result, base)
    }

    override fun toString(): String {
        return convertFromDecimal(this._number, base)
    }

    override fun writeNumberToString(number_new: String) {
        this._number = convertToDecimal(number_new, base)
    }

    override fun copy(): TANumber {
        val result = convertFromDecimal(_number, base)
        return TPNumber(result, 10)
    }

    private fun convertToDecimal(number: String, base: Int): Int {
        var result = 0
        val digits = "0123456789ABCDEF"
        var startIndex = 0

        // Проверяем, если число отрицательное, то пропускаем знак минуса
        if (number.startsWith("-")) {
            startIndex = 1
        }

        for (i in startIndex until number.length) {
            val digit = digits.indexOf(number[i])
            result += digit * Math.pow(base.toDouble(), (number.length - 1 - i).toDouble()).toInt()
        }

        // Если число было отрицательным, меняем знак результата
        if (number.startsWith("-")) {
            result = -result
        }

        return result
    }

    private fun convertFromDecimal(number: Int, base: Int): String {
        var quotient = Math.abs(number) // Работаем с абсолютным значением числа
        var result = ""
        val digits = "0123456789ABCDEF"

        if (number == 0) {
            return "0"
        }

        while (quotient > 0) {
            val remainder = quotient % base
            result = digits[remainder] + result
            quotient /= base
        }

        // Если число было отрицательным, добавляем знак минуса
        if (number < 0) {
            result = "-" + result
        }

        return result
    }


    override fun hashCode(): Int {
        var result = number.hashCode()
        result = 31 * result + base
        return result
    }

}
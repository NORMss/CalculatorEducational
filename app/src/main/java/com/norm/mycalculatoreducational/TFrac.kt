package com.norm.mycalculatoreducational


class TFrac(
    override val number: String,
    denominator: String,
    val base: Int
) : TANumber() {
    var _number: TPNumber
    var _denominator: TPNumber

    init {
        _number = TPNumber(number, base)
        _denominator = TPNumber(denominator, base)

        //simplify the fraction
        val simplifiedFraction = simplifyFraction(_number._number, _denominator._number)

        //convert to base number system
        _number = TPNumber(simplifiedFraction.first.toString(base), base)
        _denominator = TPNumber(simplifiedFraction.second.toString(base), base)
    }

    override fun isZero(): Boolean {
        return _number == TPNumber("0", base)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        val otherTFrac = other as TFrac
        return this._number == otherTFrac._number && this._denominator == otherTFrac._denominator
    }

    override fun plus(number_second: TANumber): TANumber {
        number_second as TFrac
        val calculate_number = this._number * number_second._denominator +
                this._denominator * number_second._number
        val calculate_denominator = this._denominator * number_second._denominator
        return TFrac(
            calculate_number.number,
            calculate_denominator.number,
            base
        )
    }

    override fun minus(number_second: TANumber): TANumber {
        number_second as TFrac
        val calculate_number = this._number * number_second._denominator -
                this._denominator * number_second._number
        val calculate_denominator = this._denominator * number_second._denominator
        return TFrac(
            calculate_number.number,
            calculate_denominator.number,
            base
        )
    }

    override operator fun times(number_second: TANumber): TANumber {
        number_second as TFrac
        val calculate_number = this._number * number_second._number
        val calculate_denominator = this._denominator * number_second._denominator
        return TFrac(
            calculate_number.number,
            calculate_denominator.number,
            base
        )
    }

    override fun div(number_second: TANumber): TANumber {
        number_second as TFrac
        val calculate_number = this._number * number_second._denominator
        val calculate_denominator = this._denominator * number_second._number
        return TFrac(
            calculate_number.number,
            calculate_denominator.number,
            base
        )
    }

    override fun square(): TANumber {
        val calculate_number = this._number * this._number
        val calculate_denominator = this._denominator * this._denominator
        return TFrac(
            calculate_number.number,
            calculate_denominator.number,
            base
        )
    }

    override fun inverse(): TANumber {
        val calculate_number = this._denominator
        val calculate_denominator = this._number
        return TFrac(
            calculate_number.number,
            calculate_denominator.number,
            base
        )
    }

    override fun toString(): String {
        return "${this._number}/${this._denominator}"
    }

    override fun writeNumberToString(number_new: String) {
        val parts = number_new.split("/")
        this._number = TPNumber(parts[0], base)
        this._denominator = TPNumber(parts[1], base)
    }

    override fun copy(): TFrac {
        return TFrac(this._number.number, this._denominator.number, base)
    }

    override fun hashCode(): Int {
        var result = number.hashCode()
        result = 31 * result + base
        result = 31 * result + _number.hashCode()
        result = 31 * result + _denominator.hashCode()
        return result
    }

    private fun simplifyFraction(num: Int, dnom: Int): Pair<Int, Int> {
        val gcdValue = gcd(num, dnom)

        val simplifiedNum = num / gcdValue
        val simplifiedDnom = dnom / gcdValue

        return Pair(simplifiedNum, simplifiedDnom)
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }
}
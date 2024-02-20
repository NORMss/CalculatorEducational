package com.norm.mycalculatoreducational

class TComp(
    override val number: String = "0",
    im: String = "0",
    val base: Int
) : TANumber() {
    var _real: TPNumber
    var _imaginary: TPNumber

    init {
        _real = TPNumber(number, base)
        _imaginary = TPNumber(im, base)
    }

    override fun isZero(): Boolean {
        return _real == TPNumber("0", base) && _imaginary == TPNumber("0", base)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        val otherTComp = other as TComp
        return this._real == otherTComp._real && this._imaginary == otherTComp._imaginary
    }

    override fun plus(number_second: TANumber): TANumber {
        number_second as TComp
        val calculate_real = this._real + number_second._real
        val calculate_imaginary = this._imaginary + number_second._imaginary

        return TComp(calculate_real.number, calculate_imaginary.number, base)
    }

    override fun minus(number_second: TANumber): TANumber {
        number_second as TComp
        val calculate_real = this._real - number_second._real
        val calculate_imaginary = this._imaginary - number_second._imaginary

        return TComp(calculate_real.number, calculate_imaginary.number, base)
    }

    override fun times(number_second: TANumber): TANumber {
        number_second as TComp
        val calculate_real =
            this._real * number_second._real - this._imaginary * number_second._imaginary
        val calculate_imaginary =
            this._real * number_second._imaginary + this._imaginary * number_second._real

        return TComp(calculate_real.number, calculate_imaginary.number, base)
    }

    override fun div(number_second: TANumber): TANumber {
        number_second as TComp
        val divisor =
            number_second._real * number_second._real + number_second._imaginary * number_second._imaginary

        val _num_re =
            (this._real * number_second._real + this._imaginary * number_second._imaginary).number
        val _num_im =
            (this._real * number_second._real + this._imaginary * number_second._imaginary).number

        val calculate_real = TFrac(_num_re, divisor.number, base)
        val calculate_imaginary = TFrac(_num_im, divisor.number, base)

        return TComp(
            calculate_real.toString(),
            calculate_imaginary.toString(),
            base
        )
    }

    override fun square(): TANumber {
        val calculate_real =
            this._real * this._real - this._imaginary * this._imaginary
        val calculate_imaginary =
            this._real * this._real + this._imaginary * this._imaginary

        return TComp(calculate_real.number, calculate_imaginary.number, base)
    }

    override fun inverse(): TANumber {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return "${this._real}+i*${this._imaginary}"
    }

    override fun writeNumberToString(number_new: String) {
        val parts = number_new.split("+i")
        this._real = TPNumber(parts[0], base)
        this._imaginary = TPNumber(parts[1], base)
    }

    override fun copy(): TANumber {
        TODO("Not yet implemented")
    }

    override fun hashCode(): Int {
        TODO("Not yet implemented")
    }
}
package com.norm.mycalculatoreducational

abstract class TANumber {
    abstract val number: String

    abstract fun isZero(): Boolean

    abstract override operator fun equals(other: Any?): Boolean

    abstract operator fun plus(number_second: TANumber): TANumber

    abstract operator fun minus(number_second: TANumber): TANumber

    abstract operator fun times(number_second: TANumber): TANumber

    abstract operator fun div(number_second: TANumber): TANumber

    abstract fun square(): TANumber

    abstract fun inverse(): TANumber

    abstract override fun toString(): String

    abstract fun writeNumberToString(number_new: String)

    abstract fun copy(): TANumber

    abstract override fun hashCode(): Int
}
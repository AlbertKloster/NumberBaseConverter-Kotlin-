package converter

import java.math.BigInteger

class Converter {
    fun decimalToBase(decimalNumber: String, base: String): String {
        val decimal = decimalNumber.toBigInteger()
        val stringBuilder = StringBuilder()

        if (decimal == BigInteger.ZERO) return "0"

        var num = decimal

        while (num > BigInteger.ZERO) {
            val remainder = (num % base.toBigInteger()).toInt()

            if (remainder < 10) {
                stringBuilder.append(remainder.toString())
            } else {
                val asciiChar = ('a'.code + remainder - 10).toChar()
                stringBuilder.append(asciiChar)
            }

            num /= base.toBigInteger()
        }

        return stringBuilder.reverse().toString()
    }

    fun baseToDecimal(number: String, base: String): String {
        var decimal = BigInteger.ZERO
        var power = BigInteger.ONE

        for (i in number.length - 1 downTo 0) {
            val digit = if (number[i].isDigit()) number[i].toString().toBigInteger() else (number[i].code - 'a'.code + 10).toBigInteger()
            decimal += digit * power
            power *= base.toBigInteger()
        }

        return decimal.toString()
    }

}
package converter

import java.math.BigDecimal
import java.math.RoundingMode

const val FLOATING_POINT_PRECISION = 5
const val BIG_DECIMAL_PRECISION = 100

class Converter {

    fun baseToDecimal(number: String, base: String): String {
        val parts = number.split(".")
        val wholePart = parts[0]
        val fractionalPart = if (parts.size > 1) parts[1] else ""

        var decimal = BigDecimal.ZERO
        var power = BigDecimal.ONE

        for (i in wholePart.lastIndex downTo 0) {
            val digit = if (wholePart[i].isDigit()) wholePart[i].toString().toBigDecimal() else (wholePart[i].code - 'a'.code + 10).toBigDecimal()
            decimal += digit * power
            power *= base.toBigDecimal()
        }

        if (fractionalPart.isNotEmpty()) {
            power = BigDecimal.ONE.setScale(BIG_DECIMAL_PRECISION) / base.toBigDecimal()

            for (i in fractionalPart.indices) {
                val digit = if (fractionalPart[i].isDigit()) fractionalPart[i].toString().toBigDecimal() else (fractionalPart[i].code - 'a'.code + 10).toBigDecimal()
                decimal += digit * power
                power /= base.toBigDecimal()
            }
        }

        return decimal.toString()
    }

    fun decimalToBase(decimalNumber: String, base: String): String {

        val parts = decimalNumber.split('.')
        val wholePart = parts[0]
        val fractionalPart = parts.getOrElse(1) { "" }

        val stringBuilder = StringBuilder()

        var quotient = wholePart.toBigDecimal().abs().setScale(BIG_DECIMAL_PRECISION)
        while (quotient >= BigDecimal.ONE) {
            val remainder = (quotient % BigDecimal(base)).toInt()
            stringBuilder.insert(0, if (remainder < 10) remainder else ('a' + remainder - 10).toString())
            quotient /= BigDecimal(base)
        }

        if (fractionalPart.isEmpty()) {
            return stringBuilder.toString()
        }

        stringBuilder.append('.')

        var remainingFraction = BigDecimal("0.$fractionalPart")

        repeat(FLOATING_POINT_PRECISION) {
            remainingFraction *= base.toBigDecimal()
            val digit = remainingFraction.setScale(0, RoundingMode.DOWN)
            val digitInt = digit.toInt()
            stringBuilder.append(if (digitInt < 10) digitInt.toString() else ('a' + digitInt - 10).toString())
            remainingFraction -= digit
        }

        return stringBuilder.toString()
    }

}
package converter

class Converter {
    fun decimalToBase(decimalNumber: String, base: Int): String {
        val decimal = decimalNumber.toLong()
        val stringBuilder = StringBuilder()

        if (decimal == 0L) return "0"

        var num = decimal

        while (num > 0) {
            val remainder = (num % base).toInt()

            if (remainder < 10) {
                stringBuilder.append(remainder.toString())
            } else {
                val asciiChar = ('a'.code + remainder - 10).toChar()
                stringBuilder.append(asciiChar)
            }

            num /= base
        }

        return stringBuilder.reverse().toString()
    }

    fun baseToDecimal(number: String, base: Int): String {
        var decimal = 0L
        var power = 1L

        for (i in number.length - 1 downTo 0) {
            val digit = if (number[i].isDigit()) number[i].toString().toLong() else (number[i].code - 'a'.code + 10).toLong()
            decimal += digit * power
            power *= base
        }

        return decimal.toString()
    }

}
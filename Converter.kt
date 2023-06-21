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
                val asciiChar = ('A'.code + remainder - 10).toChar()
                stringBuilder.append(asciiChar)
            }

            num /= base
        }

        return stringBuilder.reverse().toString()
    }

}
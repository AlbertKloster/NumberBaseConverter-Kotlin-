package converter // Do not delete this line

val converter = Converter()

fun main() {
    var exit = false
    while (!exit) {
        print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ")
        val input = readln()
        if (input == "/exit") {
            exit = true
        } else {
            convertNumberToBase(input)
        }
    }
}

private fun convertNumberToBase(input: String) {
    val (sourceBase, targetBase) = input.split(" ")
    var back = false
    while (!back) {
        print("Enter number in base $sourceBase to convert to base $targetBase (To go back type /back) ")
        val number = readln()
        if (number == "/back") {
            back = true
        } else {
            println("Conversion result: ${convertFromDecimal(convertToDecimal(number, sourceBase), targetBase)}")
        }
    }
}

private fun convertToDecimal(number: String, base: String) = converter.baseToDecimal(number, base)

private fun convertFromDecimal(decimalNumber: String, base: String) = converter.decimalToBase(decimalNumber, base)

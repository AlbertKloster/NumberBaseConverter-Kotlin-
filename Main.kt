package converter // Do not delete this line

val converter = Converter()

fun main() {
    var exit = false
    while (!exit) {
        print("Do you want to convert /from decimal or /to decimal? (To quit type /exit) ")
        when (Commands.getCommand(readln())) {
            Commands.TO -> convertToDecimal()
            Commands.FROM -> convertFromDecimal()
            Commands.EXIT -> exit = true
        }
    }
}

private fun convertToDecimal() {
    print("Enter source number: ")
    val number = readln()
    print("Enter source base: ")
    val base = readln().toInt()
    println("Conversion to decimal result: ${converter.baseToDecimal(number, base)}")
}

private fun convertFromDecimal() {
    print("Enter a number in decimal system: ")
    val decimalNumber = readln()
    print("Enter the target base: ")
    val base = readln().toInt()
    println("Conversion result: ${converter.decimalToBase(decimalNumber, base)}\n")
}
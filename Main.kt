package converter // Do not delete this line

fun main() {
    val converter = Converter()
    print("Enter number in decimal system: ")
    val decimalNumber = readln()
    print("Enter target base: ")
    val base = readln().toInt()
    println("Conversion result: ${converter.decimalToBase(decimalNumber, base)}")
}
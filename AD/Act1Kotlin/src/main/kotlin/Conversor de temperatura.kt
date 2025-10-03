fun main() {
    printFinalTemperature(27.0,"Celsius","Fahrenheit"){27.0*1.8+32}
    printFinalTemperature(350.00,"Kelvin","Celsius"){350.00 - 273.15}
    printFinalTemperature(10.00,"Fahrenheit","Kelvin"){(10-32)/1.8+ 273.15}
}

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}
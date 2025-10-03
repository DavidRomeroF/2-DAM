import jdk.internal.agent.resources.agent

fun main() {
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    var precio = 0
    if (age>100)
        precio = -1
    else if (age>60)
        precio = 20
    else if (age>12){
        precio = 30
        if (isMonday)
            precio=25
    }else if (age>0)
        precio = 25
    else
        precio = -1
    return precio
}
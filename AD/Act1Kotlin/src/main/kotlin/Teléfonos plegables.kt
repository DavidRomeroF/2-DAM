open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(var estaCerrado: Boolean=true) : Phone(){
    override fun switchOn() {
        if (estaCerrado)
            isScreenLightOn=false
        else
            isScreenLightOn=true
    }

    fun abrir(){
        estaCerrado=false
    }

    fun cerrar (){
        estaCerrado=true
    }

}

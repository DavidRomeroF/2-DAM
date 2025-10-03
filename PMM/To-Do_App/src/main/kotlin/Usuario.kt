package drf.pro

class Usuario(var nombre: String, ) {
    var listaTareas: ListaTareas = ListaTareas()
    fun saludar(){
        println("Hola, soy $nombre. Estas son mis tareas pendientes:")
        listaTareas.tareasCompletadas()
    }
}
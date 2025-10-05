package drf.pro

fun main() {
    var seguir = true
    var user1 = Usuario("David")
    var idTarea = 1

    var tituloTarea: String?
    var descripcion: String?
    var completada : String?
    var completa = false
    var comp = true
    do {
        println("\nBienvenido ${user1.nombre} al sistema de Usuario y tareas. \n" +
                "Selecciona una opcion:")
        println("""
            1-Agregar una Tarea
            2-Mostrar Tareas
            3-Buscar tareas por id
            4-Eliminar tarea por id
            5-Mostrar tareas completadas
            6-Salir
        """.trimIndent())

        val seleccion = readlnOrNull()?.toIntOrNull()

        when (seleccion) {
            1 -> {
                println("Agregar tarea")
                print("Titulo de la tarea: ")
                tituloTarea = readlnOrNull()
                print("Descipcion de la tarea: ")
                descripcion = readlnOrNull()
                do {
                    print("La tarea esta completada: (S/N)")
                    completada = readlnOrNull()
                    if (completada.equals("S")){
                        completa = true
                        comp = false
                    } else if (completada.equals("N")){
                        completa = false
                        comp = false
                    } else
                        comp = true
                }while (comp)
                user1.listaTareas.agregarTarea(Tarea(idTarea,tituloTarea,descripcion,completa))
                idTarea++
            }
            2 -> {
                user1.listaTareas.mostrarTareas()
            }
            3 ->{
                println("buscar tarea por ID")
                print("ID de la tarea: ")
                val idTareaBusc = readLine()?.toIntOrNull()
                val result = user1.listaTareas.buscarTarea(idTareaBusc)
                if (result == null){
                    println("No existe ninguna tarea con ese ID")
                }else
                    result.mostrarinfo()
            }
            4 -> {
                println("Eliminar tarea por ID")
                print("ID de la tarea: ")
                val idTareaBusc = readLine()?.toIntOrNull()
                user1.listaTareas.eliminarTarea(idTareaBusc)

            }
            5 -> {
                user1.listaTareas.tareasCompletadas()
            }
            6 ->{
                seguir=false
            }
            else -> println("No es un número válido")
        }
    }while (seguir)
}
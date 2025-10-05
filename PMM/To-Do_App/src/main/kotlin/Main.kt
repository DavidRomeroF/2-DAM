package drf.pro

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var seguir = true
    var user1 = Usuario("David")
    var idTarea = 1

    var tituloTarea: String? = ""
    var descripcion: String? = ""
    var completada : String? = ""
    var completa = false
    var comp = false

    do {
        println("Bienvenido ${user1.nombre} al sistema de Usuario y tareas. \n" +
                "Selecciona una opcion:")
        println("""
            1-Agregar una Tarea
            2-Mostrar Tareas
            3-Buscar tareas por id
            4-Eliminar tarea por id
            5-Mostrar tareas completadas
            6-Salir
        """.trimIndent())

        val seleccion = readLine()?.toIntOrNull()

        when (seleccion) {
            1 -> {
                println("Agregar tarea:")
                print("Titulo de la tarea: ")
                tituloTarea = readLine()
                print("Descipcion de la tarea: ")
                descripcion = readLine()
                do {
                    print("La tarea esta completada: (S/N)")
                    completada = readLine()
                    if (completa.equals("S")){
                        completa = true
                        comp = true
                    } else if (completa.equals("N")){
                        completa = false
                        comp = true
                    } else
                        comp = true
                }while (comp)



            }
            2 -> {
                println("")

            }
            3 ->{
                println("")

            }
            4 -> {
                println("")

            }
            5 -> {
                println("")

            }
            6 ->{
                println("")

            }
            else -> println("No es un número válido")
        }




    }while (seguir)





    user1.listaTareas.agregarTarea(Tarea(1,"Estudiar","Para el examen de PMM", false))
    user1.listaTareas.mostrarTareas()
    user1.listaTareas.buscarTarea(1)?.marcarComoCompletada()
    user1.listaTareas.eliminarTarea(1)
    user1.listaTareas.tareasCompletadas()

}
package drf.pro

class ListaTareas() {
    var tareas: MutableList<Tarea> = mutableListOf()

    fun agregarTarea(tarea: Tarea){
        tareas.add(tarea)
        println("Tarea añadida correcta mente")
    }

    fun eliminarTarea(id: Int){
        var tarea = buscarTarea(id)
        if (tarea != null){
            tareas.remove(tarea)
            println("Tarea eliminada correctamente")
        }else{
            println("la tarea no existe")
        }
    }

    fun mostrarTareas(){
        for (i in tareas)
            i.descripcion
    }

    fun buscarTarea(id: Int): Tarea? {
        return tareas.find { it.id == id }
    }


    fun tareasCompletadas(){
        for (i in tareas){
            if (i.completadas){
                i.descripcion
            }
        }
    }
}
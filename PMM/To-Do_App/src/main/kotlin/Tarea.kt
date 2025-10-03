package drf.pro

class Tarea(var id: Int, var titulo:String, var descripcion: String, var completadas: Boolean ) {

    fun marcarComoCompletada(){
        completadas = true
        println("la tarea se a completado")
    }

    fun mostrarinfo(){

        if (completadas){
            print("[✔] $id - $titulo ($descripcion)")
        }else{
            print("[ ] $id - $titulo ($descripcion)")
        }

    }

}
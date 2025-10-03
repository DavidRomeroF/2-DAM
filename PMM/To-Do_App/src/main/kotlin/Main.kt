package drf.pro

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var nombre = "david"
    var user1 = Usuario(nombre)

    user1.listaTareas.agregarTarea(Tarea(1,"Estudiar","Para el examen de PMM", false))
    user1.listaTareas.mostrarTareas()
    user1.listaTareas.buscarTarea(1)?.marcarComoCompletada()
    user1.listaTareas.eliminarTarea(1)
    user1.listaTareas.tareasCompletadas()

}
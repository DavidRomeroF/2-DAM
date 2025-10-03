class Song(var titulo : String, var artista : String, var anyoPublicacion: Int, var recRepro: Int){
    var popularidad = if (recRepro<1000) "Poco popular" else "Popular"
    fun descripcion() {
      println("$titulo, interpretada por $artista, se lanzó en $anyoPublicacion")
    }
}
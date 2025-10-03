package org.semana01.modelos;

public class Libro implements Comparable {
    String isbn;
    String titulo;
    String autor;
    int paginas;

    public Libro() {
    }

    public Libro(String isbn, String titulo, String autor, int paginas) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        String datos = isbn+","+titulo+","+autor+","+paginas;
        return datos;
    }

    /**
     *Método que compara los títulos de los libros
     * @param o el objeto con el que comparo el libro
     * @return devuelvo un número dependiendo de la comparacion de los títulos.
     */
    @Override
    public int compareTo(Object o) {
        Libro otro = (Libro) o;
        return this.titulo.compareToIgnoreCase(otro.getTitulo());
    }
}

package org.semana01.modelos;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ColeccionLibros {
    private ArrayList<Libro> biblioteca = new ArrayList<>();

    /**
     * Método sencillo para volcar los datos que se encuentran el csv.
     *<p>
     * Mayor organización y facilidad de mantenimiento, ya que de esta forma
     * los datos quedan separados del código, son más legibles, reutilizables
     * y se pueden modificar sin necesidad de recompilar el programa.
     */
    public void volcarDatos() {

        InputStream input = getClass().getClassLoader().getResourceAsStream("libros.csv");
        if (input == null) throw new RuntimeException("Archivo no encontrado");
        try (Scanner lector = new Scanner(input)) {
            while (lector.hasNextLine()) {
                String[] informacion = lector.nextLine().split(",");
                Libro tmp = new Libro(informacion[0], informacion[1], informacion[2], Integer.parseInt(informacion[3]));
                biblioteca.add(tmp);
            }
        }

    }

    /**
     * Metodo para ordenar el array de libros mediente orden alfabetico de libros
     */
    public void ordenarArray(){
        Collections.sort(biblioteca);
    }

    /**
     * Método para mostrar rápidamente el contenido del array
     */
    public void mostrar() {

        for (Libro e: biblioteca){
            System.out.println(e.toString());
        }

    }

    /**
     * Método para calcular el promedio de páginas de todos los libros que se encuentran en el array
     * @return devuelvo el promedio
     */
    public int calcProm(){
        int todo = sumaTotalPaginas();
        return todo/biblioteca.size();
    }

    /**
     * Método donde creo un ArrayList nuevo y dentro de el vuelco los datos del ArrayList con los libros pero ordenado
     * @return devuelvo un array de libros ordenado
     */
    public ArrayList<Libro> ordenarLibrosPorPag(){
        ArrayList<Libro> bibliord = new ArrayList<>(biblioteca);

        bibliord.sort((e1, e2) -> Integer.compare(e2.getPaginas(), e1.getPaginas()));

        return bibliord;
    }


    public int cantidadLibrosMas500Paginas(){
        int lib500 = biblioteca.stream().filter(libro -> libro.getPaginas()>500).toList().size();
        return lib500;
    }

    public int cantidadLibrosMenos300Paginas() {
        int lib300 = biblioteca.stream().filter(libro -> libro.getPaginas()<300).toList().size();
        return lib300;
    }

    public String listarLibrosMas500Paginas() {
        String lib500 = biblioteca.stream()
                .filter(libro -> libro.getPaginas()>500)
                .map(Libro::getTitulo)
                .toList().toString();
        return lib500;
    }

    public String listarTresLibrosMasPaginas() {
        ArrayList<Libro> bibliord = ordenarLibrosPorPag();
        String lib3 = bibliord.stream()
                .limit(3)
                .map(Libro::getTitulo)
                .toList().toString();
        return lib3;
    }

    public int sumaTotalPaginas() {
        int todasPag = biblioteca.stream()
                .mapToInt(Libro::getPaginas)
                .sum();
        return todasPag;
    }

    public String listarLibrosMasPaginasPromedio() {
        int media = (int) biblioteca.stream().mapToInt(Libro::getPaginas).average().orElse(0);
        String masProm = biblioteca.stream()
                .filter(libro -> libro.getPaginas()>media)
                .map(Libro::getTitulo)
                .toList().toString();
        return masProm;
    }

    public String listarAutores() {
        String autores = biblioteca.stream().map(Libro::getAutor).distinct().toList().toString();
        return autores;
    }

    public String libroMasPaginas() {
        ArrayList<Libro> bibliord = ordenarLibrosPorPag();
        String ordenado = bibliord.stream()
                .limit(1)
                .map(Libro::getTitulo)
                .toList().toString();
        return ordenado;
    }

    public String listarTitulos() {
        String titulos= biblioteca.stream()
                .map(Libro::getTitulo)
                .toList().toString();
        return titulos;
    }

    public String listarAutoresConMasDeUnLibro() {
        // Obtener autores con más de 1 libro
        String autores = biblioteca.stream()
                .collect(Collectors.groupingBy(Libro::getAutor, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList().toString();
        return autores;
    }
}

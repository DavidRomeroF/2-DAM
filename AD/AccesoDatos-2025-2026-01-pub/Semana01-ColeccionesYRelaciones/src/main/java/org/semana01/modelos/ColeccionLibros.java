package org.semana01.modelos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

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
        int lib500 = 0;
        for (Libro e: biblioteca){
            if (e.getPaginas()>500){
                lib500 ++;
            }
        }
        return lib500;
    }

    public int cantidadLibrosMenos300Paginas() {
        int lib300 = 0;
        for (Libro e: biblioteca){
            if (e.getPaginas()<300){
                lib300 ++;
            }
        }
        return lib300;
    }

    public String listarLibrosMas500Paginas() {
        String lib500 = "";
        for (Libro e: biblioteca){
            if (e.getPaginas()>500){
                lib500 += e.titulo+", ";
            }
        }
        return lib500;
    }

    public String listarTresLibrosMasPaginas() {
        ArrayList<Libro> bibliord = ordenarLibrosPorPag();
        String lib3 = "";
        for (int i=0; i<3; i++){
            lib3+= bibliord.get(i).titulo+", ";
        }
        return lib3;
    }

    public int sumaTotalPaginas() {
        int todasPag = 0;
        for (Libro e: biblioteca){
            todasPag +=e.paginas;
        }
        return todasPag;
    }

    public String listarLibrosMasPaginasPromedio() {
        int promedio = calcProm();
        String masProm = "";
        for (Libro e: biblioteca){
            if (e.getPaginas()>promedio){
                masProm += e.titulo+", ";
            }
        }
        return masProm;

    }

    public String listarAutores() {
        ArrayList<String> autores = new ArrayList<>();
        for (Libro e: biblioteca){
            if (!autores.contains(e.autor)){
                autores.add(e.autor);
            }
        }
       return autores.toString();
    }

    public String libroMasPaginas() {
        ArrayList<Libro> ordenados = ordenarLibrosPorPag();
        return ordenados.get(0).titulo;
    }

    public String listarTitulos() {
        String titulos = " ";
        for (Libro e: biblioteca){
                titulos += e.getTitulo()+", ";
        }
        return titulos;
    }

    public String listarAutoresConMasDeUnLibro() {
        HashMap<String, Integer> autores = new HashMap<>();
        String autorMas2 = "";
        for (Libro e: biblioteca){
            if (!autores.containsKey(e.autor)){
                autores.put(e.autor,1);
            }else {
                autores.put(e.autor,autores.get(e.autor)+1);
            }
        }
        for (String i : autores.keySet()) {
            if (autores.get(i)>1){
                autorMas2 += i+", ";
            }
        }
        return autorMas2;
    }

}

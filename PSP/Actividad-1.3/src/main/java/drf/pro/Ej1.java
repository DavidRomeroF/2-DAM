package drf.pro;

import java.util.Scanner;

public class Ej1 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String comando;
        String[] listaComando;
        System.out.println("Introduce el comando:");
        comando = teclado.nextLine();

        listaComando = comando.split("\\s+");



        Ejecuta proceso1 = new Ejecuta(listaComando);

        proceso1.lanzar();
    }
}
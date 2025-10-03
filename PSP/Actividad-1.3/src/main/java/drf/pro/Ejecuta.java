package drf.pro;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ejecuta {
    List<String> cadena = new ArrayList<>();

    public Ejecuta(String... comando) {
        cadena.add("cmd");//Aceptamos muchos parámetros
        cadena.add("/c");//Aceptamos muchos parámetros
        cadena.addAll(List.of(comando));// pasamos la cantidad de parámetros a una lista.
    }


    public void lanzar(){
        System.out.println(cadena.toString());
        ProcessBuilder comando;
        Process process;
        Scanner lector;
        try {
            comando = new ProcessBuilder(cadena);
            process = comando.start();

            if (process.waitFor()==0){
                lector = new Scanner(process.getInputStream());
                while (lector.hasNextLine()){
                    System.out.println(lector.nextLine());
                }
            }else {
                System.out.println("Error, no lanzo correctamente el comando");
            }

        }catch (IOException e){
            System.out.println(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

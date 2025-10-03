package drf.pro;

import java.io.IOException;
import java.util.Scanner;

class Ej1 {
    public static void main(String[] args) {
        String so = System.getProperty("os.name");
        Process process;
        Scanner lector;
        try {
            System.out.println(so);
            if (so.contains("Windows")) {
                process = Runtime.getRuntime().exec("cmd /c dir");
            }else{
                process = Runtime.getRuntime().exec("ls");
            }
            lector = new Scanner(process.getInputStream());

            while (lector.hasNextLine()){
                System.out.println(lector.nextLine());
            }

            System.out.println(lector);
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
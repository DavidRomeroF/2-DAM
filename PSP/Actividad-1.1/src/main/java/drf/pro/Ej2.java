package drf.pro;

import java.io.IOException;
import java.util.Scanner;

class Ej2 {
    public static void main(String[] args) {
        String so = System.getProperty("os.name");
        ProcessBuilder process;
        Scanner lector;
        try {
            System.out.println(so);
            if (so.contains("Windows")) {
                process = new ProcessBuilder("cmd", "/c", "dir");
            }else{
                process = new ProcessBuilder("ls");
            }
            Process process1 = process.start();

            lector = new Scanner(process1.getInputStream());

            while (lector.hasNextLine()){
                System.out.println(lector.nextLine());
            }

            System.out.println(lector);
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
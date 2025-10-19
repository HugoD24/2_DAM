package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *      Crea dos aplicaciones
 *          a. Aplicación 1
 *              i. Le pide al usuario el número de palabras que quiere introducir.
 *              ii. Le pide al usuario que introduzca estas palabras.
 *              iii. Todas estas palabras se las pasará en una única cadena a Aplicación 2
 *              iv. Recibirá una cadena con estas palabras ordenadas de Aplicación 2 y mostrará estas
 *                  palabras poniendo cada palabra en una línea distinto y al final indicará el número
 *                  total de palabras.
 *          b. Aplicación 2
 *              i. Recibe una cadena con sucesivas palabras
 *              ii. Le devolverá todas las palabras en una única cadena a Aplicación ordenadas
 *                  alfabéticamente en orden descendente (Si recibe Mario Ana Zaragoza devolverá
 *                  Zaragoza Mario Ana)
 *
 */

public class Aplicación1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.println("Cuantas palabras quieres introducir?");
        int numPalabras = sc.nextInt();
        String [] palabras = new String[numPalabras];

        for (int i = 0; i < numPalabras; i++){
            System.out.println("Introduce la palabra " + (i+1) + ": ");
            palabras[i] = sc.next();
        }

        String cadenaPalabras = String.join(" ", palabras);


        String RUTA_APP2 = "D:\\HUGO\\Proyectos_2DAM\\2_DAM\\PSP\\HugoDesiderio_Act_01Multiproceso\\HugoDesiderioGarcia_Act_01Multiproceso\\src\\main\\java\\ejercicio2\\Aplicación2.java";

        try {
            ProcessBuilder pb = new ProcessBuilder("java", RUTA_APP2, cadenaPalabras);
            pb.redirectErrorStream(true);
            Process p = pb.start();

            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            p.waitFor();
        }
        catch (IOException | InterruptedException e) {
            System.out.println("Error" + e.getMessage());
            e.printStackTrace();
        }
    }
}

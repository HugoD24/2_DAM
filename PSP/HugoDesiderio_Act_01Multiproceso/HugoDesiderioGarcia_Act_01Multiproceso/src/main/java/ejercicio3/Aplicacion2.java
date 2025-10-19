package ejercicio3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Aplicacion2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        String RUTA_APP1 = "D:\\HUGO\\Proyectos_2DAM\\2_DAM\\PSP\\HugoDesiderio_Act_01Multiproceso\\HugoDesiderioGarcia_Act_01Multiproceso\\src\\main\\java\\ejercicio3\\Aplicacion1.java";


        System.out.println("¿Que nombre quieres ponerle al fichero?");
        final String NOMBRE_FICHERO = sc.nextLine();

        int vecesEjecutadas;
        do {
            System.out.println("¿Cuantas veces quieres llamar a la app (opciones posibles entre 4-6)?");
            vecesEjecutadas = sc.nextInt();
        } while (vecesEjecutadas<4 || vecesEjecutadas>6);

        for (int i = 0; i < vecesEjecutadas; i++) {
            String modo = (i == 0) ? "n" : "a";

            try {
                ProcessBuilder pb = new ProcessBuilder("java",RUTA_APP1, NOMBRE_FICHERO, modo);
                pb.inheritIO();
                Process p = pb.start();

                p.waitFor();

                int espera = 2 + rand.nextInt(4);
                Thread.sleep(espera * 1000);

            } catch (IOException | InterruptedException e) {
                System.out.println("Error" + e.getMessage());
                e.printStackTrace();
            }
        }
        System.out.println("Contenido final del fichero:");
        try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_FICHERO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea.replace(" ", " a las "));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

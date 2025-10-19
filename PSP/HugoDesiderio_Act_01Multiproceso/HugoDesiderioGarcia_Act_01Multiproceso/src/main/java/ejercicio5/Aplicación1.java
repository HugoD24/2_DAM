package ejercicio5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 *      Crea dos aplicaciones
 *          Aplicación 1
 *              i. Le va pidiendo números enteros al usuario hasta que este le introduzca un 0 o un número negativo.
 *              ii. Todos estos números se los enviará a una Aplicación 2 que le deberá una serie de
 *                  información que deberá mostrar por terminal. Estos datos se enviarán para que
 *                  Aplicación 2 los reciba por su entrada estándar.
 *          Aplicación 2
 *              i. Recibirá un número indeterminado de números mayores a 0 y deberá imprimir por
 *                 consola los siguientes resultados
 *                      1. Dos números mayores
 *                      2. Menor número
 *                      3. Media
 *                      4. Número más repetido.
 *
 */

public class Aplicación1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 1;
        String cadena = "";
        String RUTA_APP2 = "D:\\HUGO\\Proyectos_2DAM\\2_DAM\\PSP\\HugoDesiderio_Act_01Multiproceso\\HugoDesiderioGarcia_Act_01Multiproceso\\src\\main\\java\\ejercicio5\\Aplicación2.java";

        while (num>0){
            System.out.println("Introduce un numero positivo (0 o negativo para salir ): ");
            num = sc.nextInt();
            cadena += num + " ";
        }

        ProcessBuilder pb = new ProcessBuilder("java", RUTA_APP2, cadena);

        try {
            Process p = pb.start();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
            bw.write(cadena);
            bw.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

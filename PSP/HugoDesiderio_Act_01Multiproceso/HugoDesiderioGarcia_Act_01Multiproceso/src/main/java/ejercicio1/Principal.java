package ejercicio1;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *      a. Crea una aplicación “MiniCalc” que realice operaciones básicas (suma, resta,
 *      multiplicación y división) a partir de dos números y un operador recibidos por argumentos.
 *      b. Luego crea una aplicación principal que:
 *          i. Pida los datos al usuario.
 *          ii. Llame a MiniCalc.
 *          iii. Muestre el resultado devuelto.
 *
 */

public class Principal {
    public static void main(String[] args) {
        String RUTA_MINICALC = "D:\\HUGO\\Proyectos_2DAM\\2_DAM\\PSP\\HugoDesiderio_Act_01Multiproceso\\HugoDesiderioGarcia_Act_01Multiproceso\\src\\main\\java\\ejercicio1\\MiniCalc.java";
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el primer número de la operacion: ");
        String num1 = sc.next();
        System.out.println("Introduce el segundo número de la operacion: ");
        String num2 = sc.next();
        System.out.println("Introduce que operacion quieres realizar(+,-,/,* o x)");
        String operacion = sc.next();

   try {
        ProcessBuilder pb = new ProcessBuilder("java", RUTA_MINICALC, num1, num2, operacion);
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

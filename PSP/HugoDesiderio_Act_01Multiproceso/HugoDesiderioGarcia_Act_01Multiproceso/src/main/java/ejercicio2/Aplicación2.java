package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Aplicación2 {
    public static void main(String[] args) {

        String cadenaRecivida = args[0];
        String [] palabras = cadenaRecivida.split(" ");
        int contador = 0;

        ArrayList<String> cadenaArray = new ArrayList<>(Arrays.asList(palabras));

        Collections.sort(cadenaArray, Collections.reverseOrder());

        for (String p : cadenaArray){
            System.out.println(p);
            contador++;
        }
        System.out.println("Número total de palabras: " + contador);
    }
}

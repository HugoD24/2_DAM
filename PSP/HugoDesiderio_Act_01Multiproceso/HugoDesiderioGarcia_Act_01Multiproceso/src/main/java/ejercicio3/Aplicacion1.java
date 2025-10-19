package ejercicio3;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *      Crea dos aplicaciones
 *          a. Aplicación 1
 *              i. Guarda en un fichero la fecha y hora actual.
 *              ii. Debe recibir dos argumentos, el primero es el nombre del fichero y el segundo
 *                  indica si el fichero se genera nuevo y, por tanto, se machaca su contenido o si por
 *                  el contrario la fecha se debe añadir en una nueva línea.
 *          b. Aplicación 2
 *              i. Debe llamar entre 4 y 6 veces (se le pedirá al usuario que introduzca número) a
 *                  Aplicación 1 con una diferencia entre 2 y 5 segundos cada vez que se llama (se
 *                  calcula de forma aleatorio la espera entre llamadas).
 *              ii. La primera de las llamadas indicará que el fichero se genera nuevo y el resto de
 *                  veces que se sobrescribe.
 *              iii. El nombre del fichero debe ser un valor constante en la Aplicación 2.
 *              iv. Muestra por terminal el resultado del fichero. Debe mostrarse para cada fecha el
 *                  formato siguiente 10/10/2026 a las 12:23:46
 *
 */



public class Aplicacion1 {
    public static void main(String[] args) {

        String nombreFichero = args[0];
        String queHacer = args[1].toLowerCase();
        boolean append = false;

        if (queHacer.equals("n")) {
            append = false;
        } else if (queHacer.equals("a")) {
            append = true;
        } else {
            System.out.println("Opción inválida. Usa 'n' para nuevo o 'a' para añadir.");
            return;
        }

        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaHora = ahora.format(formato);

        try {
            FileWriter escritor = new FileWriter(nombreFichero, append);
            escritor.write(fechaHora + "\n");
            escritor.close();
            System.out.println("Fecha y hora guardadas correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
            e.printStackTrace();
        }
    }


}

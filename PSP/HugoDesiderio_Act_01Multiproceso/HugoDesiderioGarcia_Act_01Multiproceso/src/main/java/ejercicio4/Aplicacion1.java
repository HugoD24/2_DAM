package ejercicio4;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *      Crea tres aplicaciones
 *          a. Aplicación 1
 *              i. Guarda en un fichero la fecha y hora actual y un número que se corresponde con la
 *                  temperatura y que será un número aleatorio entre dos números que recibirá por
 *                  argumento.
 *              ii. El nombre del fichero lo deberá recibir también como un argumento.
 *          b. Aplicación 2.
 *              i. Recibirá el nombre de un fichero que contiene fechas y temperaturas y deberá
 *                  mostrar por terminal la fecha y el día con mayor temperatura.
 *          c. Aplicación 3
 *              i. Llamará a Aplicación 1 para añadir al menos 4 entradas en el fichero que se
 *                  indique. Se recomienda dejar una pausa entre llamadas de al menos un segundo.
 *              ii. Llamará a Aplicación 2 para que le indique qué día y hora ha hecho más calor por
 *                  terminal.
 *
 */




public class
Aplicacion1 {
    public static void main(String[] args) {

        int min = Integer.parseInt(args[0]);
        int max = Integer.parseInt(args[1]);
        String nombreFichero = args[2];

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaActual = LocalDateTime.now().format(formato);

        File fichero = new File(nombreFichero);
        boolean append = fichero.exists();


        int temperatura = rand(min, max);

        try {
            FileWriter fw = new FileWriter(nombreFichero, append);
            fw.write(temperatura + " - " + fechaActual + System.lineSeparator()); //aqui he guardado la temperatura lo primero siguiendo el consejo que nos diste en clase
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static int rand(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

}


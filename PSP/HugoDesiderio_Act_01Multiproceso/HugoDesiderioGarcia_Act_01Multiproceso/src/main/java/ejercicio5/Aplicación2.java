package ejercicio5;

import java.util.*;

public class Aplicación2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numeros = new ArrayList<>();

        System.out.println("Introduce los números separados por espacios:");
        while (sc.hasNextInt()) {
            numeros.add(sc.nextInt());
        }

        if (numeros.isEmpty()) {
            System.out.println("No se ingresaron números.");
            return;
        }


        int suma = 0;
        for (int n : numeros) suma += n;
        double media = (double) suma / numeros.size();


        Collections.sort(numeros);

        int menor = numeros.get(0);
        int mayor = numeros.get(numeros.size() - 1);
        int segundoMayor;
        if (numeros.size() > 1) {
            segundoMayor = numeros.get(numeros.size() - 2);
        } else {
            segundoMayor = numeros.get(0);
        }

        //aqui he tenido que informarme bien para aprender a usar el hasmap ya que es algo nuevo para mi
        Map<Integer, Integer> frecuencia = new HashMap<>();
        for (int n : numeros) {
            if (frecuencia.containsKey(n)) {
                int conteo = frecuencia.get(n);
                frecuencia.put(n, conteo + 1);
            } else {
                frecuencia.put(n, 1);
            }
        }

        int numMasRepetido = numeros.get(0);
        int maxRepeticiones = 0;
        for (Map.Entry<Integer, Integer> entry : frecuencia.entrySet()) {
            if (entry.getValue() > maxRepeticiones) {
                maxRepeticiones = entry.getValue();
                numMasRepetido = entry.getKey();
            }
        }

        System.out.println("La media es: " + media);
        System.out.println("EL número menor es: " + menor);
        System.out.println("El número mayor es: " + mayor);
        System.out.println("El segundo número más alto es: " + segundoMayor);
        System.out.println("El número más repetido es: " + numMasRepetido);
    }
}

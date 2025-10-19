package ejercicio1;

public class MiniCalc {
    public static void main(String[] args) {

        double resultado;
        double num1 = Double.parseDouble(args[0]);
        double num2 = Double.parseDouble(args[1]);
        String operador = args[2];


        switch (operador){
            case "+":
                resultado = num1 + num2;
                System.out.println(num1 + " + " + num2 + " = " + resultado);
                break;
            case "-":
                resultado = num1 - num2;
                System.out.println(num1 + " - " + num2 + " = " + resultado);
                break;
            case "*":
            case "x":
                resultado = num1 * num2;
                System.out.println(num1 + " x " + num2 + " = " + resultado);
                    break;
            case "/":
                if(num2 == 0){
                    System.out.println("Error, no se puede dividir entre 0");
                }else {
                    resultado = num1 / num2;
                    System.out.println(num1 + " / " + num2 + " = " + resultado);
                }
                break;
            default:
                System.out.println("Operador incorrecto, utiliza: + , - , / , * , x");

        }

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Eugenio Yepes
 */
import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int num1 = 5, num2 = 8, num3 = 3;
        float resul;

        if (num1 > num2 && num1 > num3) {
            System.out.println("El numero mayor es: " + num1);
        } else if (num2 > num1 && num2 > num3) {
            System.out.println("El numero mayor es: " + num2);
        } else {
            System.out.println("El numero mayor es: " + num3);
        }
        // ingresar para sumar, restar, multiplicar, dividir
        Scanner letra = new Scanner(System.in);
        System.out.println("Ingrese s para sumar\n\tr para restar\n\tm para multiplicar\n\td para dividir");
        String carac = letra.next();
        letra.close();
        if (1 == carac.length()) {
            switch (carac.charAt(0)) {
                case 's':
                    resul = num1 + num2;
                    System.out.println("Suma " + resul);
                    break;
                case 'r':
                    resul = num1 - num2;
                    System.out.println("Resta " + resul);
                    break;
                case 'm':
                    resul = num1 * num2;
                    System.out.println("Multiplicacion " + resul);
                    break;
                case 'd':
                    resul = num1 / num2;
                    System.out.println("Division " + resul);
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("Error, ingrese solo   letra");
        }
    }
}

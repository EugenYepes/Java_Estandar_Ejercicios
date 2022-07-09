/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Eugenio Yepes
 */
public class Main {
    public static void main(String[] args) {        
        int num1 = 15; 
        int num2 = 33;
        int num3 = 17, num4 = 23;
        int resultado;
        
        resultado = num1 + num2;
        System.out.println("suma " + resultado);
        
        resultado = num1 - num2;
        System.out.println("resta " + resultado);
        
        resultado = num1 / num2;
        System.out.println("division " + resultado);
        
        resultado = num1 * num2;
        System.out.println("multiplicacion " + resultado);
        
        //promedio 
        resultado = (num1 + num2 + num3 + num4)/4;
        System.out.println("El promedio de "+ num1 + ", " + num2 + ", " + num3 + ", " + num4 + " es: " + resultado);
    }
}

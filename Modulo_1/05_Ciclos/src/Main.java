import java.time.Clock;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese 1 para acertar numero, 2 para comprobar contrasena");
        int opcion = scan.nextInt();
        switch (opcion) {
            case 1:
                acertarNumero();
                break;
            case 2:
                comprobarContrasena();
                break;
            default:
                System.out.println("Opcion incorrecta");
                break;
        }
        System.out.println("FIN");
        scan.close();
    }

    public static void acertarNumero() {
        Clock horaInMs = Clock.systemDefaultZone();// obtener una semilla para generar el numero random
        long ms = horaInMs.millis();
        Random rand = new Random(ms);
        Scanner scan = new Scanner(System.in);
        int num, i = 0, intRand;

        do {
            System.out.println("Ingrese un numero del 1 al 10 para adivinar que numero random se genero");
            num = scan.nextInt();
            intRand = rand.nextInt(10) + 1;
            if (num == intRand)
                System.out.println(num + " == " + intRand + " OK");
            else
                System.out.println(num + " != " + intRand + " Intenta otra vez");
            i++;
        } while (intRand != num);
        scan.close();
        System.out.println("Tardo " + i + " intentos en adivinar");
    }

    public static void comprobarContrasena() {
        String usuario = "Eugenio";
        String contrasena = "lacontrasena";
        String auxUsuario = "";
        String auxContrasena = "";
        Scanner scan = new Scanner(System.in);
        boolean correcto = false;

        for (int i = 0; i < 3 && correcto == false; i++) {
            System.out.println("Ingrese su usuario:");
            auxUsuario = scan.nextLine();
            System.out.println("Ingrese su contraseña:");
            auxContrasena = scan.nextLine();
            if (usuario.equals(auxUsuario) && contrasena.equals(auxContrasena)) {
                correcto = true;
            } else if (i == 2) {
                System.out.println("Maximo de intentos alcanzado\nSaliendo...");
            } else {
                System.out.println("Usuario o contrasena incorrectos, volver a intentar");
            }
        }
        scan.close();
    }
}
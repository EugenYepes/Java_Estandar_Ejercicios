import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de persona");
        int cantPersonas = scan.nextInt();
        Persona[] personas = new Persona[cantPersonas];// objeto de la clase persona
        // Persona persona = new Persona();

        for (int i = 0; i < cantPersonas; i++) {
            Persona persona = new Persona();
            System.out.println("\nDatos de la persona: " + (i + 1));
            System.out.println("Ingrese el nombre");
            persona.nombre = scan.next();
            System.out.println("Ingrese el apellido");
            persona.apellido = scan.next();
            System.out.println("Ingrese el Tipo de documento");
            persona.tipoDocumento = scan.next();
            System.out.println("Ingrese el documento");
            persona.numeroDocumento = scan.next();
            System.out.println("Ingrese la edad");
            persona.edad = scan.nextInt();
            personas[i] = persona;
        }
        for (int i = 0; i < cantPersonas; i++) {
            System.out.println("\nPersona numero: " + (i + 1));
            System.out.println("Nombre:" + personas[i].nombre);
            System.out.println("Apellido: " + personas[i].apellido);
            System.out.println("Tipo de documento: " + personas[i].tipoDocumento);
            System.out.println("Numero de documento: " + personas[i].numeroDocumento);
            System.out.println("Edad: " + personas[i].edad);
            if (personas[i].edad >= 18) {
                System.out.println("Es mayor de edad");
            }
            System.out.print("\n");
        }
        scan.close();
    }
}

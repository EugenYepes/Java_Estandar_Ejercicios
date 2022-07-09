import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de personas cuyos datos va a cargar");
        int cantPersonas = scan.nextInt();
        System.out.println("Ingrese una opcion: \n\t1:usar constructores\n\t2:usar getters & setters");
        char opcion1 = scan.next().charAt(0);
        Persona[] personas = new Persona[cantPersonas];
        switch (opcion1) {
            case '1':
                for (int i = 0; i < cantPersonas; i++) {
                    System.out.println("\nPersona numero: " + (i + 1));
                    personas[i] = pedirDatosConstructores();
                }
                break;
            case '2':
                for (int i = 0; i < cantPersonas; i++) {
                    System.out.println("\nPersona numero: " + (i + 1));
                    personas[i] = pedirDatosGetters();
                }
                break;
            default:
                break;
        }
        Persona.mostrarDatos(personas);
        scan.close();
    }

    public static Persona pedirDatosConstructores() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el nombre:");
        String nombre = scan.next();
        System.out.println("Ingrese el apellido:");
        String apellido = scan.next();
        System.out.println("Ingrese el tipo de documento:");
        String tipoDocumento = scan.next();
        System.out.println("Ingrese el numero de documento:");
        String numDocumento = scan.next();
        Persona p = new Persona(nombre, apellido, tipoDocumento, numDocumento);
        return p;
    }

    public static Persona pedirDatosGetters() {
        Persona p = new Persona();
        Scanner scan = new Scanner(System.in);
        p.setId(Persona.contador);
        System.out.println("Ingrese el nombre:");
        p.setNombre(scan.next());
        System.out.println("Ingrese el apellido:");
        p.setApellido(scan.next());
        Documento doc = new Documento();
        System.out.println("Ingrese el tipo de documento:");
        doc.setTipo(scan.next());
        System.out.println("Ingrese el numero de documento:");
        doc.setNumero(scan.next());
        p.setDocumento(doc);
        p.randomEdad();
        return p;
    }
}
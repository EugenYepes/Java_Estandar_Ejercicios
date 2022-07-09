import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de personas cuyos datos va a cargar");
        int cantPersonas = scan.nextInt();
        System.out.println("Ingrese una opcion: \n\t1:datos con la edad\n\t2:datos sin la edad");
        char opcion = scan.next().charAt(0);
        System.out.println("Ingrese una opcion: \n\t1:usar constructores\n\t2:usar getters & setters");
        char opcion1 = scan.next().charAt(0);
        Persona[] personas = new Persona[cantPersonas];
        switch (opcion1) {
            case '1':
                for (int i = 0; i < cantPersonas; i++) {
                    System.out.println("\nPersona numero: " + (i + 1));
                    personas[i] = pedirDatosConstructores(opcion);
                }
                break;
            case '2':
                for (int i = 0; i < cantPersonas; i++) {
                    System.out.println("\nPersona numero: " + (i + 1));
                    personas[i] = pedirDatosGetters(opcion);
                }
                break;
            default:
                break;
        }
        for (int i = 0; i < cantPersonas; i++) {
            System.out.println("\nPersona numero: " + (i + 1));
            System.out.println("Nombre: " + personas[i].getNombre());
            System.out.println("Apellido: " + personas[i].getApellido());
            System.out.println("Tipo de documento: " + personas[i].getDocumento().getTipo());
            System.out.println("Numero de documento: " + personas[i].getDocumento().getNumero());
            System.out.print("Edad (Si no la invento): " + personas[i].getEdad());
            if (personas[i].getEdad() >= 18) {
                System.out.println(" y es mayor de edad");
            } else {
                System.out.println(" y es menor de edad");
            }
        }
        scan.close();
    }

    public static Persona pedirDatosConstructores(char opcion) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el nombre:");
        String nombre = scan.next();
        System.out.println("Ingrese el apellido:");
        String apellido = scan.next();
        System.out.println("Ingrese el tipo de documento:");
        String tipoDocumento = scan.next();
        System.out.println("Ingrese el numero de documento:");
        String numDocumento = scan.next();
        switch (opcion) {
            case '1':
                System.out.println("Ingrese la edad:");
                int edad = scan.nextInt();
                Persona p = new Persona(nombre, apellido, tipoDocumento, numDocumento, edad);
                return p;
            case '2':
                Persona p1 = new Persona(nombre, apellido, tipoDocumento, numDocumento);
                return p1;
            default:
                break;
        }
        return null;
    }

    public static Persona pedirDatosGetters(char opcion) {
        Persona p = new Persona();
        Scanner scan = new Scanner(System.in);
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
        switch (opcion) {
            case '1':
                System.out.println("Ingrese la edad:");
                p.setEdad(scan.nextInt());
                return p;
            case '2':
                p.randomEdad();
                return p;
            default:
                break;
        }
        return p;
    }
}
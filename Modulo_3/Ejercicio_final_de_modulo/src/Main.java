import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de personas cuyos datos va a cargar");
        int cantAlumnos = scan.nextInt();
        Alumno[] alum = new Alumno[cantAlumnos];
        System.out.println("Ingrese una opcion: \n\t1:usar constructores\n\t2:usar getters & setters");
        char opcion1 = scan.next().charAt(0);
        switch (opcion1) {
            case '1':
                for (int i = 0; i < cantAlumnos; i++) {
                    System.out.println("\nPersona numero: " + (i + 1));
                    alum[i] = pedirDatosConstructores();
                    System.out.println("Ingrese la cantidad de cursos y luego los cursos");
                    byte cantCursos = (byte) scan.nextInt();
                    String[] cursos = new String[cantCursos];
                    for (int j = 0; j < cantCursos; j++) {
                        String curso = scan.next();
                        cursos[j] = curso;
                    }
                    alum[i].setCursos(cursos);
                }
                break;
            case '2':
                for (int i = 0; i < cantAlumnos; i++) {
                    System.out.println("\nPersona numero: " + (i + 1));
                    alum[i] = pedirDatosGetters();
                    System.out.println("Ingrese la cantidad de cursos y luego los cursos");
                    byte cantCursos = (byte) scan.nextInt();
                    String[] cursos = new String[cantCursos];
                    for (int j = 0; j < cantCursos; j++) {
                        String curso = scan.next();
                        cursos[j] = curso;
                    }
                    alum[i].setCursos(cursos);
                }
                break;
            default:
                break;
        }
        System.out.println("Ingrese la cantidad de profesores");
        int cantProfes = scan.nextInt();
        Profesor[] profes = new Profesor[cantProfes];
        for (int i = 0; i < cantProfes; i++) {
            System.out.println("Ingrese un profesor");
            System.out.println("Ingrese el nombre:");
            String nombre = scan.next();
            System.out.println("Ingrese el apellido:");
            String apellido = scan.next();
            System.out.println("Ingrese el tipo de documento:");
            String tipoDocumento = scan.next();
            System.out.println("Ingrese el numero de documento:");
            String numDocumento = scan.next();
            System.out.println("Ingrese el sueldo:");
            int sueldo = scan.nextInt();
            Profesor profe = new Profesor(nombre, apellido, tipoDocumento, numDocumento, sueldo);
            profes[i] = profe;
        }
        Alumno.mostrarDatos(alum);
        Profesor.mostrarDatos(profes);
        scan.close();
    }

    public static Alumno pedirDatosConstructores() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el nombre:");
        String nombre = scan.next();
        System.out.println("Ingrese el apellido:");
        String apellido = scan.next();
        System.out.println("Ingrese el tipo de documento:");
        String tipoDocumento = scan.next();
        System.out.println("Ingrese el numero de documento:");
        String numDocumento = scan.next();
        Alumno a = new Alumno(nombre, apellido, tipoDocumento, numDocumento);
        return a;
    }

    public static Alumno pedirDatosGetters() {
        Alumno a = new Alumno();
        Scanner scan = new Scanner(System.in);
        a.setId(Persona.contador);
        System.out.println("Ingrese el nombre:");
        a.setNombre(scan.next());
        System.out.println("Ingrese el apellido:");
        a.setApellido(scan.next());
        Documento doc = new Documento();
        System.out.println("Ingrese el tipo de documento:");
        doc.setTipo(scan.next());
        System.out.println("Ingrese el numero de documento:");
        doc.setNumero(scan.next());
        a.setDocumento(doc);
        a.randomEdad();
        return a;
    }
}
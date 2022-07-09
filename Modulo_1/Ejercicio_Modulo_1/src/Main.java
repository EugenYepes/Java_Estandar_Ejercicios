
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de alumnos a ingresar");
        int cantAlum = scan.nextInt();
        Alumno[] alumnos = new Alumno[cantAlum];

        for (int i = 0; i < cantAlum; i++) {
            alumnos[i] = cargarNotasAlumno();
        }
        ordenarNotas(cantAlum, alumnos);
        int promedio = promediarNotas(cantAlum, alumnos);
        mostrarNotasAlumnos(cantAlum, alumnos, promedio);
        scan.close();
    }

    public static Alumno cargarNotasAlumno() {
        Alumno auxAlumno = new Alumno();
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el nombre");
        auxAlumno.setNombre(scan.nextLine());
        System.out.println("Ingrese la nota");
        auxAlumno.setNota(scan.nextInt());
        // scan.close();// si pongo este close me tira error
        return auxAlumno;
    }

    public static void ordenarNotas(int cantAlum, Alumno[] alumnos) {
        // bubble sort
        Alumno aux = new Alumno();
        for (int i = 0; i < cantAlum - 1; i++) {
            for (int j = 0; j < cantAlum - 1; j++) {
                if (alumnos[j].nota > alumnos[j + 1].nota) {
                    aux = alumnos[j];
                    alumnos[j] = alumnos[j + 1];
                    alumnos[j + 1] = aux;
                }
            }
        }
    }

    public static int promediarNotas(int cantAlum, Alumno[] alumnos) {
        int aux = 0;
        for (int i = 0; i < cantAlum; i++) {
            aux = aux + alumnos[i].nota;
        }
        return aux;
    }

    public static void mostrarNotasAlumnos(int cantAlum, Alumno[] alumnos, int promedio) {
        System.out.println("Alumno\t\tNota");
        for (int i = 0; i < cantAlum; i++)
            System.out.println(alumnos[i].nombre + "\t\t" + alumnos[i].nota);
        System.out.println("La menor nota es:" + alumnos[0].nota);
        System.out.println("La mayor nota es:" + alumnos[cantAlum - 1].nota);
    }
}

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// /*
// * @author Eugenio Yepes
// */
// public class Main {
// public static void main(String[] args){
// Scanner scan = new Scanner(System.in);
// System.out.println("Ingrese la cantidad de alumnos a ingresar");
// int cantNotas = scan.nextInt();

// List <Alumno> alumnos = new ArrayList<Alumno>();
// alumnos = cargarNotasAlumno(cantNotas);
// System.out.println(alumnos.get(0));
// // ordenarNotas();
// // promediarNotas();
// // mostrarNotasAlumnos();
// }
// public static List<Alumno> cargarNotasAlumno(int cantNotas){

// List <Alumno> auxAlumnos = new ArrayList<Alumno>();
// for (int i = 0; i < cantNotas; i++) {
// Alumno a = new Alumno();
// a.setNombre(this.scan);
// a.setNota();
// auxAlumnos.add(a);
// }

// return auxAlumnos;
// }
// }

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Director> directores = new ArrayList<Director>();
        List<Profesor> profesores = new ArrayList<Profesor>();
        List<Administrativo> administrativos = new ArrayList<Administrativo>();
        List<Alumno> alumnos = new ArrayList<Alumno>();
        Scanner scan = new Scanner(System.in);
        int opcion;
        do {
            System.out.println(
                    "Ingrese una opcion para cargar datos:\n\t1-Director\n\t2-Profesor\n\t3-Administrativo\n\t4-Alumno\n\t0-Salir");
            opcion = scan.nextInt();
            switch (opcion) {
                case 1:
                    Director dir = new Director();
                    directores.add(dir);
                    break;
                case 2:
                    Profesor prof = new Profesor();
                    profesores.add(prof);
                    break;
                case 3:
                    Administrativo adm = new Administrativo();
                    administrativos.add(adm);
                    break;
                case 4:
                    Alumno alum = new Alumno();
                    alumnos.add(alum);
                    break;
                default:
                    if (opcion != 0)
                        System.out.println("Opcion incorrecta");
                    break;
            }
        } while (opcion != 0);
        // Persona.quienSoy(directores.get(0));
        int contDir = 0, contProf = 0, contAdm = 0, contAlum = 0;
        do {
            System.out.println(
                    "Ingrese una opcion para mostrar datos:\n\t1-Director\n\t2-Profesor\n\t3-Administrativo\n\t4-Alumno\n\t0-Salir");
            opcion = scan.nextInt();
            switch (opcion) {
                case 1:
                    if (contDir < directores.size()) {
                        System.out.println(Director.mostrarDatos(
                                directores.get(contDir).getNombre(), directores.get(contDir).getApellido(),
                                directores.get(contDir).getDocumento().getTipoDocumento(),
                                directores.get(contDir).getDocumento().getNumDocumento(),
                                directores.get(contDir).getFechaNacimiento(),
                                directores.get(contDir).getFechaCargo(),
                                directores.get(contDir).getSueldo(),
                                directores.get(contDir).getCarrera()));
                        contDir++;
                    }
                    break;
                case 2:
                    if (contProf < profesores.size()) {
                        System.out.println(Profesor.mostrarDatos(
                                profesores.get(contProf).getNombre(), profesores.get(contProf).getApellido(),
                                profesores.get(contProf).getDocumento().getTipoDocumento(),
                                profesores.get(contProf).getDocumento().getNumDocumento(),
                                profesores.get(contProf).getFechaNacimiento(),
                                profesores.get(contProf).getFechaCargo(),
                                profesores.get(contProf).getSueldo(),
                                profesores.get(contProf).getListaCursos()));
                        contProf++;
                    }
                    break;
                case 3:
                    if (contAdm < administrativos.size()) {
                        System.out.println(Administrativo.mostrarDatos(
                                administrativos.get(contAdm).getNombre(), administrativos.get(contAdm).getApellido(),
                                administrativos.get(contAdm).getDocumento().getTipoDocumento(),
                                administrativos.get(contAdm).getDocumento().getNumDocumento(),
                                administrativos.get(contAdm).getFechaNacimiento(),
                                administrativos.get(contAdm).getFechaCargo(),
                                administrativos.get(contAdm).getSueldo()));
                        contAdm++;
                    }
                    break;
                case 4:
                    if (contAlum < alumnos.size()) {
                        System.out.println(Alumno.mostrarDatos(
                                alumnos.get(contAlum).getNombre(), alumnos.get(contAlum).getApellido(),
                                alumnos.get(contAlum).getDocumento().getTipoDocumento(),
                                alumnos.get(contAlum).getDocumento().getNumDocumento(),
                                alumnos.get(contAlum).getFechaNacimiento(), alumnos.get(contAlum).getFechaIngreso(),
                                alumnos.get(contAlum).getListaCursos()));
                        contAlum++;
                    }
                    break;
                default:
                    if (opcion != 0)
                        System.out.println("Opcion incorrecta");
                    break;
            }
        } while (opcion != 0);
        scan.close();
    }
}
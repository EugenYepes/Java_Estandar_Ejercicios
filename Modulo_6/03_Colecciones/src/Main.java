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
        int contDir = 0, contProf = 0, contAdm = 0, contAlum = 0;
        do {
            System.out.println(
                    "Ingrese una opcion para cargar datos:\n\t1-Director\n\t2-Profesor\n\t3-Administrativo\n\t4-Alumno\n\t0-Salir");
            opcion = scan.nextInt();
            switch (opcion) {
                case 1:
                    Director dir = new Director();
                    directores.add(dir);
                    contDir++;
                    break;
                case 2:
                    Profesor prof = new Profesor();
                    profesores.add(prof);
                    contProf++;
                    break;
                case 3:
                    Administrativo adm = new Administrativo();
                    administrativos.add(adm);
                    contAdm++;
                    break;
                case 4:
                    Alumno alum = new Alumno();
                    alumnos.add(alum);
                    contAlum++;
                    break;
                default:
                    if (opcion != 0)
                        System.out.println("Opcion incorrecta");
                    break;
            }
        } while (opcion != 0);
        mostrar(directores, profesores, administrativos, alumnos);
        contDir = 0;
        contProf = 0;
        contAdm = 0;
        contAlum = 0;
        System.out.println(
                "Ingrese el nombre, el apellido, o el dni para eliminar los datos de una persona, 0 para no hacer nada");
        String buscar = scan.next();
        if (buscar.charAt(0) != '0') {
            while (true) {
                if (contDir < directores.size()) {
                    if (directores.get(contDir).getNombre().equals(buscar)
                            || directores.get(contDir).getApellido().equals(buscar)
                            || directores.get(contDir).getDocumento().getNumDocumento().equals(buscar)) {
                        System.out.println("Encontrado\n" + Director.mostrarDatos(
                                directores.get(contDir).getNombre(), directores.get(contDir).getApellido(),
                                directores.get(contDir).getDocumento().getTipoDocumento(),
                                directores.get(contDir).getDocumento().getNumDocumento(),
                                directores.get(contDir).getFechaNacimiento(),
                                directores.get(contDir).getFechaCargo(),
                                directores.get(contDir).getSueldo(),
                                directores.get(contDir).getCarrera()));
                        System.out.println("Desea: \n\t1-Modificar\n\t2-Eliminar\n\t0-No hacer nada");
                        opcion = scan.nextInt();
                        switch (opcion) {
                            case 1:
                                directores.set(contDir, Director.modificar(directores.get(contDir)));
                                break;
                            case 2:
                                directores.remove(contDir);
                            default:
                                break;
                        }
                        break;
                    }
                    contDir++;
                } else if (contProf < profesores.size()) {
                    if (profesores.get(contProf).getNombre().equals(buscar)
                            || profesores.get(contProf).getApellido().equals(buscar)
                            || profesores.get(contProf).getDocumento().getNumDocumento().equals(buscar)) {
                        System.out.println("Encontrado\n" + Profesor.mostrarDatos(
                                profesores.get(contProf).getNombre(), profesores.get(contProf).getApellido(),
                                profesores.get(contProf).getDocumento().getTipoDocumento(),
                                profesores.get(contProf).getDocumento().getNumDocumento(),
                                profesores.get(contProf).getFechaNacimiento(),
                                profesores.get(contProf).getFechaCargo(),
                                profesores.get(contProf).getSueldo(),
                                profesores.get(contProf).getListaCursos()));
                        System.out.println("Desea: \n\t1-Modificar\n\t2-Eliminar\n\t0-No hacer nada");
                        opcion = scan.nextInt();
                        switch (opcion) {
                            case 1:
                                profesores.set(contProf, Profesor.modificar(profesores.get(contProf)));
                                break;
                            case 2:
                                profesores.remove(contProf);
                            default:
                                break;
                        }
                        break;
                    }
                    contProf++;
                } else if (contAdm < administrativos.size()) {
                    if (profesores.get(contAdm).getNombre().equals(buscar)
                            || profesores.get(contAdm).getApellido().equals(buscar)
                            || profesores.get(contAdm).getDocumento().getNumDocumento().equals(buscar)) {

                        System.out.println("Encontrado\n" + Administrativo.mostrarDatos(
                                administrativos.get(contAdm).getNombre(), administrativos.get(contAdm).getApellido(),
                                administrativos.get(contAdm).getDocumento().getTipoDocumento(),
                                administrativos.get(contAdm).getDocumento().getNumDocumento(),
                                administrativos.get(contAdm).getFechaNacimiento(),
                                administrativos.get(contAdm).getFechaCargo(),
                                administrativos.get(contAdm).getSueldo()));
                        System.out.println("Desea: \n\t1-Modificar\n\t2-Eliminar\n\t0-No hacer nada");
                        opcion = scan.nextInt();
                        switch (opcion) {
                            case 1:
                                administrativos.set(contAdm, Administrativo.modificar(administrativos.get(contAdm)));
                                break;
                            case 2:
                                administrativos.remove(contAdm);
                            default:
                                break;
                        }
                        break;

                    }
                    contAdm++;
                } else if (contAlum < alumnos.size()) {
                    if (profesores.get(contAlum).getNombre().equals(buscar)
                            || profesores.get(contAlum).getApellido().equals(buscar)
                            || profesores.get(contAlum).getDocumento().getNumDocumento().equals(buscar)) {
                        System.out.println("Encontrado\n" + Alumno.mostrarDatos(
                                alumnos.get(contAlum).getNombre(), alumnos.get(contAlum).getApellido(),
                                alumnos.get(contAlum).getDocumento().getTipoDocumento(),
                                alumnos.get(contAlum).getDocumento().getNumDocumento(),
                                alumnos.get(contAlum).getFechaNacimiento(), alumnos.get(contAlum).getFechaIngreso(),
                                alumnos.get(contAlum).getListaCursos()));
                        System.out.println("Desea: \n\t1-Modificar\n\t2-Eliminar\n\t0-No hacer nada");
                        opcion = scan.nextInt();
                        switch (opcion) {
                            case 1:
                                alumnos.set(contAlum, Alumno.modificar(alumnos.get(contAlum)));
                                break;
                            case 2:
                                alumnos.remove(contAlum);
                            default:
                                break;
                        }
                        break;
                    }
                    contAlum++;
                } else {
                    System.out.println("Ya se busco en todos los datos y no se encontro los buscado");
                    break;
                }
            }
        }
        mostrar(directores, profesores, administrativos, alumnos);
        scan.close();
    }

    public static void mostrar(List<Director> directores, List<Profesor> profesores,
            List<Administrativo> administrativos,
            List<Alumno> alumnos) {
        int contDir = 0, contProf = 0, contAdm = 0, contAlum = 0;
        int opcion;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println(
                    "Ingrese una opcion para mostrar datos de la lista:\n\t1-Director\n\t2-Profesor\n\t3-Administrativo\n\t4-Alumno\n\t0-Salir");
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
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (opcion != 0);
    }
}
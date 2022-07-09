import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Director[] directores = new Director[0];
        Profesor[] profesores = new Profesor[0];
        Administrativo[] administrativos = new Administrativo[0];
        Alumno[] alumnos = new Alumno[0];

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
                    directores = Director.add(directores, 1);
                    directores[contDir] = dir;
                    contDir++;
                    break;
                case 2:
                    Profesor prof = new Profesor();
                    profesores = Profesor.add(profesores, 1);
                    profesores[contProf] = prof;
                    contProf++;

                    break;
                case 3:
                    Administrativo adm = new Administrativo();
                    administrativos = Administrativo.add(administrativos, 1);
                    administrativos[contAdm] = adm;
                    contAdm++;

                    break;
                case 4:
                    Alumno alum = new Alumno();
                    alumnos = Alumno.add(alumnos, 1);
                    alumnos[contAlum] = alum;
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
                if (contDir < directores.length) {
                    if (directores[contDir].getNombre().equals(buscar)
                            || directores[contDir].getApellido().equals(buscar)
                            || directores[contDir].getDocumento().getNumDocumento().equals(buscar)) {
                        System.out.println("Encontrado\n" + Director.mostrarDatos(
                                directores[contDir].getNombre(), directores[contDir].getApellido(),
                                directores[contDir].getDocumento().getTipoDocumento(),
                                directores[contDir].getDocumento().getNumDocumento(),
                                directores[contDir].getFechaNacimiento(),
                                directores[contDir].getFechaCargo(),
                                directores[contDir].getSueldo(),
                                directores[contDir].getCarrera()));
                        System.out.println("Desea: \n\t1-Modificar\n\t2-Eliminar\n\t0-No hacer nada");
                        opcion = scan.nextInt();
                        switch (opcion) {
                            case 1:
                                directores[contDir] = Director.modificar(directores[contDir]);
                                break;
                            case 2:
                                directores = Director.delete(directores, contDir);
                            default:
                                break;
                        }
                        break;
                    }
                    contDir++;
                } else if (contProf < profesores.length) {
                    if (profesores[contProf].getNombre().equals(buscar)
                            || profesores[contProf].getApellido().equals(buscar)
                            || profesores[contProf].getDocumento().getNumDocumento().equals(buscar)) {
                        System.out.println("Encontrado\n" + Profesor.mostrarDatos(
                                profesores[contProf].getNombre(), profesores[contProf].getApellido(),
                                profesores[contProf].getDocumento().getTipoDocumento(),
                                profesores[contProf].getDocumento().getNumDocumento(),
                                profesores[contProf].getFechaNacimiento(),
                                profesores[contProf].getFechaCargo(),
                                profesores[contProf].getSueldo(),
                                profesores[contProf].getListaCursos()));
                        System.out.println("Desea: \n\t1-Modificar\n\t2-Eliminar\n\t0-No hacer nada");
                        opcion = scan.nextInt();
                        switch (opcion) {
                            case 1:
                                profesores[contProf] = Profesor.modificar(profesores[contProf]);
                                break;
                            case 2:
                                profesores = Profesor.delete(profesores, contProf);
                            default:
                                break;
                        }
                        break;
                    }
                    contProf++;
                } else if (contAdm < administrativos.length) {
                    if (profesores[contAdm].getNombre().equals(buscar)
                            || profesores[contAdm].getApellido().equals(buscar)
                            || profesores[contAdm].getDocumento().getNumDocumento().equals(buscar)) {
                        if (contAdm < administrativos.length) {
                            System.out.println("Encontrado\n" + Administrativo.mostrarDatos(
                                    administrativos[contAdm].getNombre(), administrativos[contAdm].getApellido(),
                                    administrativos[contAdm].getDocumento().getTipoDocumento(),
                                    administrativos[contAdm].getDocumento().getNumDocumento(),
                                    administrativos[contAdm].getFechaNacimiento(),
                                    administrativos[contAdm].getFechaCargo(),
                                    administrativos[contAdm].getSueldo()));
                            System.out.println("Desea: \n\t1-Modificar\n\t2-Eliminar\n\t0-No hacer nada");
                            opcion = scan.nextInt();
                            switch (opcion) {
                                case 1:
                                    administrativos[contAdm] = Administrativo.modificar(administrativos[contAdm]);
                                    break;
                                case 2:
                                    administrativos = Administrativo.delete(administrativos, contAdm);
                                default:
                                    break;
                            }
                            break;
                        }
                    }
                    contAdm++;
                } else if (contAlum < alumnos.length) {
                    if (profesores[contAlum].getNombre().equals(buscar)
                            || profesores[contAlum].getApellido().equals(buscar)
                            || profesores[contAlum].getDocumento().getNumDocumento().equals(buscar)) {
                        if (contAlum < administrativos.length) {
                            System.out.println("Encontrado\n" + Alumno.mostrarDatos(
                                    alumnos[contAlum].getNombre(), alumnos[contAlum].getApellido(),
                                    alumnos[contAlum].getDocumento().getTipoDocumento(),
                                    alumnos[contAlum].getDocumento().getNumDocumento(),
                                    alumnos[contAlum].getFechaNacimiento(), alumnos[contAlum].getFechaIngreso(),
                                    alumnos[contAlum].getListaCursos()));
                            System.out.println("Desea: \n\t1-Modificar\n\t2-Eliminar\n\t0-No hacer nada");
                            opcion = scan.nextInt();
                            switch (opcion) {
                                case 1:
                                    alumnos[contAdm] = Alumno.modificar(alumnos[contAdm]);
                                    break;
                                case 2:
                                    alumnos = Alumno.delete(alumnos, contAlum);
                                default:
                                    break;
                            }
                            break;
                        }
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

    public static void mostrar(Director[] directores, Profesor[] profesores, Administrativo[] administrativos,
            Alumno[] alumnos) {
        int contDir = 0, contProf = 0, contAdm = 0, contAlum = 0;
        int opcion;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println(
                    "Ingrese una opcion para mostrar datos de la lista:\n\t1-Director\n\t2-Profesor\n\t3-Administrativo\n\t4-Alumno\n\t0-Salir");
            opcion = scan.nextInt();
            switch (opcion) {
                case 1:
                    if (contDir < directores.length) {
                        System.out.println(Director.mostrarDatos(
                                directores[contDir].getNombre(), directores[contDir].getApellido(),
                                directores[contDir].getDocumento().getTipoDocumento(),
                                directores[contDir].getDocumento().getNumDocumento(),
                                directores[contDir].getFechaNacimiento(),
                                directores[contDir].getFechaCargo(),
                                directores[contDir].getSueldo(),
                                directores[contDir].getCarrera()));
                        contDir++;
                    }
                    break;
                case 2:
                    if (contProf < profesores.length) {
                        System.out.println(Profesor.mostrarDatos(
                                profesores[contProf].getNombre(), profesores[contProf].getApellido(),
                                profesores[contProf].getDocumento().getTipoDocumento(),
                                profesores[contProf].getDocumento().getNumDocumento(),
                                profesores[contProf].getFechaNacimiento(),
                                profesores[contProf].getFechaCargo(),
                                profesores[contProf].getSueldo(),
                                profesores[contProf].getListaCursos()));
                        contProf++;
                    }
                    break;
                case 3:
                    if (contAdm < administrativos.length) {
                        System.out.println(Administrativo.mostrarDatos(
                                administrativos[contAdm].getNombre(), administrativos[contAdm].getApellido(),
                                administrativos[contAdm].getDocumento().getTipoDocumento(),
                                administrativos[contAdm].getDocumento().getNumDocumento(),
                                administrativos[contAdm].getFechaNacimiento(),
                                administrativos[contAdm].getFechaCargo(),
                                administrativos[contAdm].getSueldo()));
                        contAdm++;
                    }
                    break;
                case 4:
                    if (contAlum < alumnos.length) {
                        System.out.println(Alumno.mostrarDatos(
                                alumnos[contAlum].getNombre(), alumnos[contAlum].getApellido(),
                                alumnos[contAlum].getDocumento().getTipoDocumento(),
                                alumnos[contAlum].getDocumento().getNumDocumento(),
                                alumnos[contAlum].getFechaNacimiento(), alumnos[contAlum].getFechaIngreso(),
                                alumnos[contAlum].getListaCursos()));
                        contAlum++;
                    }
                    break;
                default:
                    if (opcion != 0)
                        System.out.println("Opcion incorrecta");
                    break;
            }
        } while (opcion != 0);
    }
}

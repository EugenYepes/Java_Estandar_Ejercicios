import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import enumerados.TiposDocumento;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        List<Director> directores = new ArrayList<Director>();
        List<Profesor> profesores = new ArrayList<Profesor>();
        List<Administrativo> administrativos = new ArrayList<Administrativo>();
        List<Alumno> alumnos = new ArrayList<Alumno>();

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
        ordenarEdad(directores, profesores, administrativos, alumnos);
        ordenarDocumento(directores, profesores, administrativos, alumnos);
        mostrar(directores, profesores, administrativos, alumnos);
        // modificar los datos de alguna de las personas
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
                        System.out.println("Encontrado\n" + directores.get(contDir).toString());
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
                        System.out.println("Encontrado\n" + profesores.get(contProf).toString());
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
                    if (administrativos.get(contAdm).getNombre().equals(buscar)
                            || administrativos.get(contAdm).getApellido().equals(buscar)
                            || administrativos.get(contAdm).getDocumento().getNumDocumento().equals(buscar)) {
                        System.out.println("Encontrado\n" + administrativos.get(contAdm).toString());
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
                    if (alumnos.get(contAlum).getNombre().equals(buscar)
                            || alumnos.get(contAlum).getApellido().equals(buscar)
                            || alumnos.get(contAlum).getDocumento().getNumDocumento().equals(buscar)) {
                        System.out.println("Encontrado\n" + alumnos.get(contAlum).toString());
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
        do {
            System.out.println(
                    "Ingrese una opcion para mostrar datos de la lista:\n\t1-Director\n\t2-Profesor\n\t3-Administrativo\n\t4-Alumno\n\t0-Salir");
            opcion = scan.nextInt();
            switch (opcion) {
                case 1:
                    if (contDir < directores.size()) {
                        System.out.println(directores.get(contDir).toString());
                        contDir++;
                    }
                    break;
                case 2:
                    if (contProf < profesores.size()) {
                        System.out.println(profesores.get(contProf).toString());
                        contProf++;
                    }
                    break;
                case 3:
                    if (contAdm < administrativos.size()) {
                        System.out.println(administrativos.get(contAdm).toString());
                        contAdm++;
                    }
                    break;
                case 4:
                    if (contAlum < alumnos.size()) {
                        System.out.println(alumnos.get(contAlum).toString());
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

    public static void ordenarEdad(List<Director> directores, List<Profesor> profesores,
            List<Administrativo> administrativos,
            List<Alumno> alumnos) {
        // ordenar por fecha nacimiento
        List<Persona> personas = new ArrayList<Persona>();
        Persona aux;
        personas.addAll(directores);
        personas.addAll(profesores);
        personas.addAll(administrativos);
        personas.addAll(alumnos);
        for (int i = 0; i < personas.size() - 1; i++) {
            for (int j = 0; j < personas.size() - 1; j++) {
                if (personas.get(j).getEdad() < personas.get(j + 1).getEdad()) {
                    aux = personas.get(j);
                    personas.set(j, personas.get(j + 1));
                    personas.set(j + 1, aux);
                }

            }
        }
        System.out.println(
                "****************************************La lista de personas ordenadas por edad es:****************************************");
        for (Persona todos : personas) {
            System.out.println(todos.toString());
            System.out.println("****************************************");
        }
    }

    public static void ordenarDocumento(List<Director> directores, List<Profesor> profesores,
            List<Administrativo> administrativos,
            List<Alumno> alumnos) {
        // ordenar por documento
        List<Persona> personas = new ArrayList<Persona>();
        List<Persona> personas_DNI = new ArrayList<Persona>();
        List<Persona> personas_PAS = new ArrayList<Persona>();
        List<Persona> personas_LE = new ArrayList<Persona>();
        List<Persona> personas_CI = new ArrayList<Persona>();
        Persona aux;

        personas.addAll(directores);
        personas.addAll(profesores);
        personas.addAll(administrativos);
        personas.addAll(alumnos);

        for (int i = 0; i < personas.size() - 1; i++) {
            for (int j = 0; j < personas.size() - 1; j++) {
                if (Integer.parseInt(personas.get(j).getDocumento().getNumDocumento()) < Integer
                        .parseInt(personas.get(j + 1).getDocumento().getNumDocumento())) {// pasarlo a entero
                    aux = personas.get(j);
                    personas.set(j, personas.get(j + 1));
                    personas.set(j + 1, aux);
                }

            }
        }

        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getDocumento().getTipoDocumento().equals(TiposDocumento.valueOf("DNI")))
                personas_DNI.add(personas.get(i));
            else if (personas.get(i).getDocumento().getTipoDocumento().equals(TiposDocumento.valueOf("PAS")))
                personas_PAS.add(personas.get(i));
            else if (personas.get(i).getDocumento().getTipoDocumento().equals(TiposDocumento.valueOf("LE")))
                personas_LE.add(personas.get(i));
            else if (personas.get(i).getDocumento().getTipoDocumento().equals(TiposDocumento.valueOf("CI")))
                personas_CI.add(personas.get(i));
        }
        System.out.println(
                "****************************************La lista de personas ordenadas por Documento es:****************************************");
        System.out.println("DNI:");
        for (Persona todos : personas_DNI) {
            System.out.println(todos.toString());
            System.out.println("****************************************");
        }
        System.out.println("PAS:");
        for (Persona todos : personas_PAS) {
            System.out.println(todos.toString());
            System.out.println("****************************************");
        }
        System.out.println("LE:");
        for (Persona todos : personas_LE) {
            System.out.println(todos.toString());
            System.out.println("****************************************");
        }
        System.out.println("CI:");
        for (Persona todos : personas_CI) {
            System.out.println(todos.toString());
            System.out.println("****************************************");
        }
    }
}
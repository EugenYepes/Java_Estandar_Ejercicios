package Principales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import base_datos.AdministrativoDAO;
import base_datos.AlumnoDAO;
import base_datos.DirectorDAO;
import base_datos.DocumentoDAO;
import base_datos.ProfesorDAO;
import enumerados.TiposDocumento;

public class Main {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        // cargar todos los documentos de la base de datos, para que no se ingresen
        // repetidos
        Persona.setDocumentos(DocumentoDAO.obtenerDocumentos());
        int opcion;
        do {
            System.out.println(
                    "Ingrese una opcion para cargar datos:\n\t1-Director\n\t2-Profesor\n\t3-Administrativo\n\t4-Alumno\n\t0-Salir");
            opcion = scan.nextInt();
            switch (opcion) {
                case 1:
                    Director dir = new Director();
                    DirectorDAO.guardarDirector(dir);
                    break;
                case 2:
                    Profesor prof = new Profesor();
                    ProfesorDAO.guardarProfesor(prof);
                    break;
                case 3:
                    Administrativo adm = new Administrativo();
                    AdministrativoDAO.guardarAdministrativo(adm);
                    break;
                case 4:
                    Alumno alum = new Alumno();
                    AlumnoDAO.guardarAlumno(alum);
                    break;
                default:
                    if (opcion != 0)
                        System.out.println("Opcion incorrecta");
                    break;
            }
        } while (opcion != 0);
        mostrar();
        // modificar los datos de alguna de las personas
        System.out.println("Ingrese una opcion: \n\t1-Eliminar\n\t2-Modificar\n\t0-no hacer nada");
        opcion = scan.nextInt();
        if (opcion != 0) {
            System.out.println("Ingrese el documento para eliminar o modificar los datos de una persona");
            System.out.println("tipo:");
            String aux = scan.next();
            System.out.println("numero:");
            Documento doc = new Documento(TiposDocumento.valueOf(aux.toUpperCase()), scan.next());

            switch (opcion) {
                case 1:
                    if (DirectorDAO.obtenerDirector(doc) != null) {
                        DirectorDAO.eliminarDirector(doc);
                        break;
                    } else if (ProfesorDAO.obtenerProfesor(doc) != null) {
                        ProfesorDAO.eliminarProfesor(doc);
                        break;
                    } else if (AlumnoDAO.obtenerAlumno(doc) != null) {
                        AlumnoDAO.eliminarAlumno(doc);
                        break;
                    } else if (AdministrativoDAO.obtenerAdministrativo(doc) != null) {
                        AdministrativoDAO.eliminarAdministrativo(doc);
                        break;
                    }
                    break;
                case 2:
                    if (DirectorDAO.obtenerDirector(doc) != null) {
                        DirectorDAO.modificarDirector(doc);
                        break;
                    } else if (ProfesorDAO.obtenerProfesor(doc) != null) {
                        ProfesorDAO.modificarProfesor(doc);
                        break;
                    } else if (AlumnoDAO.obtenerAlumno(doc) != null) {
                        AlumnoDAO.modificarAlumno(doc);
                        break;
                    } else if (AdministrativoDAO.obtenerAdministrativo(doc) != null) {
                        AdministrativoDAO.modificarAdministrativo(doc);
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
        mostrar();
        scan.close();
    }

    public static void mostrar() {
        int opcion;
        Director dir;
        Profesor prof;
        Alumno alum;
        Administrativo adm;
        do {
            System.out.println(
                    "Ingrese una opcion para mostrar datos:\n\t1-Director\n\t2-Profesor\n\t3-Administrativo\n\t4-Alumno\n\t5-No sabe, buscar en toda la base de datos\n\t0-Salir");
            opcion = scan.nextInt();
            if (opcion != 0) {
                System.out.println("Ingrese el documento: \ntipo:");
                String aux = scan.next();
                System.out.println("numero:");
                Documento doc = new Documento(TiposDocumento.valueOf(aux.toUpperCase()), scan.next());
                switch (opcion) {
                    case 1:
                        dir = DirectorDAO.obtenerDirector(doc);
                        if (dir != null) {
                            System.out.println(dir);
                        } else {
                            System.out.println("No se encontro el director buscado");
                        }
                        break;
                    case 2:
                        prof = ProfesorDAO.obtenerProfesor(doc);
                        if (prof != null) {
                            System.out.println(prof);
                        } else {
                            System.out.println("No se encontro el profesor buscado");
                        }
                        break;
                    case 3:
                        adm = AdministrativoDAO.obtenerAdministrativo(doc);
                        if (adm != null) {
                            System.out.println(adm);
                        } else {
                            System.out.println("No se encontro el administrador buscado");
                        }
                        break;
                    case 4:
                        alum = AlumnoDAO.obtenerAlumno(doc);
                        if (alum != null) {
                            System.out.println(alum);
                        } else {
                            System.out.println("No se encontro el alumno buscado");
                        }
                        break;
                    case 5:
                        dir = DirectorDAO.obtenerDirector(doc);
                        prof = ProfesorDAO.obtenerProfesor(doc);
                        adm = AdministrativoDAO.obtenerAdministrativo(doc);
                        alum = AlumnoDAO.obtenerAlumno(doc);
                        if (dir != null)
                            System.out.println(dir);
                        else if (prof != null)
                            System.out.println(prof);
                        else if (adm != null)
                            System.out.println(adm);
                        else if (alum != null)
                            System.out.println(alum);
                        else
                            System.out.println("No se encontro en ninguna tabla");
                    default:
                        if (opcion != 0)
                            System.out.println("Opcion incorrecta");
                        break;
                }
            }
        } while (opcion != 0);
        ordenarEdad();
        ordenarDocumento();
    }

    public static void ordenarEdad() {
        // ordenar por fecha nacimiento
        List<Persona> personas = new ArrayList<Persona>();
        HashMap<Integer, Documento> documentos = new HashMap<Integer, Documento>();
        Persona aux;
        Director dir;
        Profesor prof;
        Administrativo adm;
        Alumno alum;
        documentos = Persona.getDocumentos();
        for (int i = 0; i < documentos.size(); i++) {
            dir = null;
            prof = null;
            adm = null;
            alum = null;
            Documento doc = documentos.get(i);
            if ((dir = DirectorDAO.obtenerDirector(doc)) != null)
                personas.add(dir);
            else if ((prof = ProfesorDAO.obtenerProfesor(doc)) != null)
                personas.add(prof);
            else if ((adm = AdministrativoDAO.obtenerAdministrativo(doc)) != null)
                personas.add(adm);
            else if ((alum = AlumnoDAO.obtenerAlumno(doc)) != null)
                personas.add(alum);
        }

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

    public static void ordenarDocumento() {// ordenar por documento
        List<Persona> personas = new ArrayList<Persona>();
        List<Persona> personas_DNI = new ArrayList<Persona>();
        List<Persona> personas_PAS = new ArrayList<Persona>();
        List<Persona> personas_LE = new ArrayList<Persona>();
        List<Persona> personas_CI = new ArrayList<Persona>();
        HashMap<Integer, Documento> documentos = new HashMap<Integer, Documento>();
        Persona aux;
        Director dir;
        Profesor prof;
        Administrativo adm;
        Alumno alum;
        documentos = Persona.getDocumentos();
        for (int i = 0; i < documentos.size(); i++) {
            dir = null;
            prof = null;
            adm = null;
            alum = null;
            Documento doc = documentos.get(i);
            if ((dir = DirectorDAO.obtenerDirector(doc)) != null)
                personas.add(dir);
            else if ((prof = ProfesorDAO.obtenerProfesor(doc)) != null)
                personas.add(prof);
            else if ((adm = AdministrativoDAO.obtenerAdministrativo(doc)) != null)
                personas.add(adm);
            else if ((alum = AlumnoDAO.obtenerAlumno(doc)) != null)
                personas.add(alum);
        }

        for (int i = 0; i < personas.size() - 1; i++) {
            for (int j = 0; j < personas.size() - 1; j++) {
                if (Integer.parseInt(personas.get(j).getDocumento().getNumDocumento()) < Integer
                        .parseInt(personas.get(j + 1).getDocumento().getNumDocumento())) {// pasarlo
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
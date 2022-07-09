package principales;

import java.util.Scanner;

import base_datos.*;
import comparadores.*;
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
        Mostrar.mostrar();
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
        Mostrar.mostrar();
        Ordenar.ordenarEdad();
        Ordenar.ordenarDocumento();
        System.out.println("Ingrese 1 para ordenar a los trabajadores por default\n\t2 para ordenar por sueldo");
        Ordenar.ordenarSueldo(scan.nextInt() == 1);
        scan.close();
    }
}
package comparadores;

import java.util.Scanner;
import principales.*;
import enumerados.TiposDocumento;
import base_datos.*;

public class Mostrar {
    static Scanner scan = new Scanner(System.in);

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
    }
    
    public void scanClose() {
        scan.close();
    }
}

package comparadores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import base_datos.*;
import enumerados.TiposDocumento;
import principales.*;

public class Ordenar {
    public static void ordenarSueldo(boolean porDefault) {
        List<Trabajador> trabajadores = new ArrayList<Trabajador>();
        HashMap<Integer, Documento> documentos = new HashMap<Integer, Documento>();
        Trabajador aux;
        Director dir;
        Profesor prof;
        Administrativo adm;
        documentos = Persona.getDocumentos();
        for (int i = 0; i < documentos.size(); i++) {
            dir = null;
            prof = null;
            adm = null;
            Documento doc = documentos.get(i);
            if ((dir = DirectorDAO.obtenerDirector(doc)) != null)
                trabajadores.add(dir);
            else if ((prof = ProfesorDAO.obtenerProfesor(doc)) != null)
                trabajadores.add(prof);
            else if ((adm = AdministrativoDAO.obtenerAdministrativo(doc)) != null)
                trabajadores.add(adm);
        }
        if (porDefault) {
            System.out.println(
                    "****************************************La lista de personas ordenadas por default****************************************");
            trabajadores.forEach(todos -> System.out.println(todos.toString() + "\n********************\n"));
        } else {
            for (int i = 0; i < trabajadores.size() - 1; i++) {
                for (int j = 0; j < trabajadores.size() - 1; j++) {
                    if (trabajadores.get(j).getSueldo() < trabajadores.get(j + 1).getSueldo()) {
                        aux = trabajadores.get(j);
                        trabajadores.set(j, trabajadores.get(j + 1));
                        trabajadores.set(j + 1, aux);
                    }
                }
            }
            System.out.println("La clase de la persona 1 es:");
            System.out.println(
                    "****************************************La lista de personas ordenadas por sueldo****************************************");
            trabajadores.forEach(todos -> System.out.println(todos.toString() + "\n********************\n"));
        }
    }

    public static void ordenarEdad() {
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
                "****************************************La lista de personas ordenadas por edad****************************************");
        personas.forEach(todos -> System.out.println(todos.toString() + "\n********************\n"));

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
        personas.forEach(todos -> System.out.println(todos.toString() + "\n********************\n"));

        System.out.println("PAS:");
        personas.forEach(todos -> System.out.println(todos.toString() + "\n********************\n"));

        System.out.println("LE:");
        personas.forEach(todos -> System.out.println(todos.toString() + "\n********************\n"));

        System.out.println("CI:");
        personas.forEach(todos -> System.out.println(todos.toString() + "\n********************\n"));
    }
}
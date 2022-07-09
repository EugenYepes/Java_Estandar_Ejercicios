package base_datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Principales.Curso;
import Principales.Documento;
import Principales.Alumno;

public class AlumnoDAO {
    public static void guardarAlumno(Alumno a) {
        String sentencia = "INSERT INTO Universidad.Alumnos";
        String columnas = "(" + "nombre, apellido, tipoDocumento, numDocumento, fechaNacimiento"
                + ", fechaIngreso, listaCursos" + ")";
        String values = "VALUES ('" + a.getNombre() + "', '" + a.getApellido() + "', '"
                + a.getDocumento().getTipoDocumento() + "', '" + a.getDocumento().getNumDocumento() + "', '"
                + a.getFechaNacimiento() + "', '" + a.getFechaIngreso() + "', '" + listaCursosString(a.getListaCursos())
                + "');";
        try {
            Connection conn = CreateConection.connectionToDataBase();
            Statement st = conn.createStatement();
            st.execute(sentencia + columnas + values);
            st.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static Alumno obtenerAlumno(Documento doc) {
        String nombre = "", apellido = "", fechaNacimiento = "", fechaIngreso = "", listaCursosS = "";
        List<Curso> listaCursos = new ArrayList<Curso>();

        String select = "SELECT nombre, apellido, fechaNacimiento" + ", fechaIngreso, listaCursos ";
        String from = "FROM Universidad.Alumnos ";
        String where = "WHERE tipoDocumento = " + "'" + doc.getTipoDocumento() + "'" + " AND " + "numDocumento = " + "'"
                + doc.getNumDocumento() + "';";
        try {
            Connection conn = CreateConection.connectionToDataBase();
            Statement st = conn.createStatement();
            ResultSet resultado = st.executeQuery(select + from + where);
            if (resultado.next()) {
                nombre = resultado.getString("nombre");
                apellido = resultado.getString("apellido");
                fechaNacimiento = resultado.getString("fechaNacimiento");
                fechaIngreso = resultado.getString("fechaIngreso");
                listaCursosS = resultado.getString("listaCursos");
                String[] auxCursos = listaCursosS.split(" - ");
                for (int i = 0; i < auxCursos.length; i++) {
                    Curso c = new Curso(auxCursos[i]);
                    listaCursos.add(c);
                }
                Alumno p = new Alumno(nombre, apellido, doc, fechaNacimiento, fechaIngreso, listaCursos);
                st.close();
                conn.close();
                return p;
            }
            st.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        System.out.println("No se encontro al alumno buscado");
        return null;
    }

    public static boolean eliminarAlumno(Documento doc) {// true si lo encontro y lo pudo eliminar
        boolean flag = false;
        String sentencia = "DELETE FROM Universidad.Alumnos ";
        String where = "WHERE tipoDocumento = " + "'" + doc.getTipoDocumento() + "'" + " AND " + "numDocumento = " + "'"
                + doc.getNumDocumento() + "';";
        try {
            Connection conn = CreateConection.connectionToDataBase();
            Statement st = conn.createStatement();
            flag = st.execute(sentencia + where);
            st.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return flag;
    }

    public static Alumno modificarAlumno(Documento doc) {// null si no lo encontro, retorna la persona modifica
        System.out.println("Ingrese los datos modificados, no se puede modificar el documento");
        Alumno p = new Alumno(doc);

        String sentencia = "UPDATE Universidad.Profesores ";
        String set = "SET nombre = " + "'" + p.getNombre() + "'," + " apellido = " + "'" + p.getApellido() + "', "
                + " fechaNacimiento = " + "'" + p.getFechaNacimiento() + "'," + " fechaIngreso = " + "'"
                + p.getFechaIngreso() + "'," + " listaCursos = " + "'" + listaCursosString(p.getListaCursos()) + "'";
        String where = "WHERE tipoDocumento = " + "'" + doc.getTipoDocumento() + "'" + " AND " + "numDocumento = " + "'"
                + doc.getNumDocumento() + "';";
        try {
            Connection conn = CreateConection.connectionToDataBase();
            Statement st = conn.createStatement();
            st.execute(sentencia + set + where);
            st.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    private static String listaCursosString(List<Curso> listaCursos) {
        String listaCursosS = "";
        for (int i = 0; i < listaCursos.size(); i++) {
            listaCursosS = listaCursosS + listaCursos.get(i).getCurso() + " - ";
        }
        return listaCursosS;
    }
}
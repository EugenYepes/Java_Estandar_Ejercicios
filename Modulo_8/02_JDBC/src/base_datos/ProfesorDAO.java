package base_datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Principales.Curso;
import Principales.Documento;
import Principales.Profesor;

public class ProfesorDAO {
    public static void guardarProfesor(Profesor p) {
        String sentencia = "INSERT INTO Universidad.Profesores";
        String columnas = "(" + "nombre, apellido, tipoDocumento, numDocumento, fechaNacimiento"
                + ", fechaCargo, sueldo, listaCursos" + ")";
        String values = "VALUES ('" + p.getNombre() + "', '" + p.getApellido() + "', '"
                + p.getDocumento().getTipoDocumento() + "', '" + p.getDocumento().getNumDocumento() + "', '"
                + p.getFechaNacimiento() + "', '" + p.getFechaCargo() + "', '" + p.getSueldo() + "', '"
                + listaCursosString(p.getListaCursos())
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

    public static Profesor obtenerProfesor(Documento doc) {
        String nombre = "", apellido = "", fechaNacimiento = "", fechaCargo = "", listaCursosS = "";
        int sueldo = 0;
        List<Curso> listaCursos = new ArrayList<Curso>();

        String select = "SELECT nombre, apellido, fechaNacimiento" + ", fechaCargo, sueldo, listaCursos ";
        String from = "FROM Universidad.Profesores ";
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
                fechaCargo = resultado.getString("fechaCargo");
                sueldo = resultado.getInt("sueldo");
                listaCursosS = resultado.getString("listaCursos");
                String[] auxCursos = listaCursosS.split(" - ");
                for (int i = 0; i < auxCursos.length; i++) {
                    Curso c = new Curso(auxCursos[i]);
                    listaCursos.add(c);
                }
                Profesor p = new Profesor(nombre, apellido, doc, fechaNacimiento, fechaCargo, sueldo, listaCursos);
                st.close();
                conn.close();
                return p;
            }
            st.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        System.out.println("No se encontro al profesor buscado");
        return null;
    }

    public static boolean eliminarProfesor(Documento doc) {// true si lo encontro y lo pudo eliminar
        boolean flag = false;
        String sentencia = "DELETE FROM Universidad.Profesores ";
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

    public static Profesor modificarProfesor(Documento doc) {// null si no lo encontro, retorna la persona modifica
        System.out.println("Ingrese los datos modificados, no se puede modificar el documento");
        Profesor p = new Profesor(doc);

        String sentencia = "UPDATE Universidad.Profesores ";
        String set = "SET nombre = " + "'" + p.getNombre() + "'," + " apellido = " + "'" + p.getApellido() + "', "
                + " fechaNacimiento = " + "'" + p.getFechaNacimiento() + "'," + " fechaCargo = " + "'"
                + p.getFechaCargo()
                + "'," + " sueldo = " + "'" + p.getSueldo() + "'," + " listaCursos = " + "'"
                + listaCursosString(p.getListaCursos()) + "'";
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
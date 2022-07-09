package base_datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import principales.Alumno;
import principales.Curso;
import principales.Documento;

public class AlumnoDAO {
    public static void guardarAlumno(Alumno a) {
        String sentencia = "INSERT INTO Universidad.Alumnos";
        String columnas = "(" + "nombre, apellido, tipoDocumento, numDocumento, fechaNacimiento"
                + ", fechaIngreso, listaCursos" + ")";
        String values = "VALUES (?, ?, ?, ?, ?, ?, ?);";
        try {
            Connection conn = CreateConection.connectionToDataBase();
            PreparedStatement pst = conn.prepareStatement(sentencia + columnas + values);
            pst.setString(1, a.getNombre());
            pst.setString(2, a.getApellido());
            pst.setString(3, a.getDocumento().getTipoDocumento().toString());
            pst.setString(4, a.getDocumento().getNumDocumento());
            pst.setString(5, a.getFechaNacimiento());
            pst.setString(6, a.getFechaIngreso());
            pst.setString(7, listaCursosString(a.getListaCursos()));
            pst.execute();
            pst.close();
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
        String where = "WHERE tipoDocumento = ? AND numDocumento = ?;";
        try {
            Connection conn = CreateConection.connectionToDataBase();
            PreparedStatement pst = conn.prepareStatement(select + from + where);
            pst.setString(1, doc.getTipoDocumento().toString());
            pst.setString(2, doc.getNumDocumento());
            ResultSet resultado = pst.executeQuery();
            if (resultado != null) {
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
                    Alumno a = new Alumno(nombre, apellido, doc, fechaNacimiento, fechaIngreso, listaCursos);
                    pst.close();
                    conn.close();
                    return a;
                }
            }
            pst.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public static boolean eliminarAlumno(Documento doc) {// true si lo encontro y lo pudo eliminar
        boolean flag = false;
        String sentencia = "DELETE FROM Universidad.Alumnos ";
        String where = "WHERE tipoDocumento = ? AND numDocumento = ?;";
        try {
            Connection conn = CreateConection.connectionToDataBase();
            PreparedStatement pst = conn.prepareStatement(sentencia + where);
            pst.setString(1, doc.getTipoDocumento().toString());
            pst.setString(2, doc.getNumDocumento());
            flag = pst.execute();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return flag;
    }

    public static Alumno modificarAlumno(Documento doc) {// null si no lo encontro, retorna la persona modifica
        System.out.println("El alumno encontrado es: \n" + obtenerAlumno(doc).toString());

        System.out.println("Ingrese los datos modificados, no se puede modificar el documento");
        Alumno a = new Alumno(doc);

        String sentencia = "UPDATE Universidad.Alumnos ";
        String set = "SET nombre = ?," + " apellido = ?, " + " fechaNacimiento = ?," + " fechaIngreso = ?,"
                + " listaCursos = ? ";
        String where = "WHERE tipoDocumento = ? AND numDocumento = ?;";
        try {
            Connection conn = CreateConection.connectionToDataBase();
            PreparedStatement pst = conn.prepareStatement(sentencia + set + where);
            pst.setString(1, a.getNombre());
            pst.setString(2, a.getApellido());
            pst.setString(3, a.getFechaNacimiento());
            pst.setString(4, a.getFechaIngreso());
            pst.setString(5, listaCursosString(a.getListaCursos()));
            pst.setString(6, doc.getTipoDocumento().toString());
            pst.setString(7, doc.getNumDocumento());
            pst.execute();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        System.out.println("El alumno modificado es: \n" + obtenerAlumno(doc).toString());
        return a;
    }

    private static String listaCursosString(List<Curso> listaCursos) {
        String listaCursosS = "";
        for (int i = 0; i < listaCursos.size(); i++) {
            listaCursosS = listaCursosS + listaCursos.get(i).getCurso() + " - ";
        }
        return listaCursosS;
    }
}
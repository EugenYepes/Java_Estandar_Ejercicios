package base_datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import principales.Curso;
import principales.Documento;
import principales.Profesor;

public class ProfesorDAO {
    public static void guardarProfesor(Profesor p) {
        String sentencia = "INSERT INTO Universidad.Profesores";
        String columnas = "(" + "nombre, apellido, tipoDocumento, numDocumento, fechaNacimiento"
                + ", fechaCargo, sueldo, listaCursos" + ")";
        String values = "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            Connection conn = CreateConection.connectionToDataBase();
            PreparedStatement pst = conn.prepareStatement(sentencia + columnas + values);
            pst.setString(1, p.getNombre());
            pst.setString(2, p.getApellido());
            pst.setString(3, p.getDocumento().getTipoDocumento().toString());
            pst.setString(4, p.getDocumento().getNumDocumento());
            pst.setString(5, p.getFechaNacimiento());
            pst.setString(6, p.getFechaCargo());
            pst.setInt(7, p.getSueldo());
            pst.setString(8, listaCursosString(p.getListaCursos()));
            pst.execute();
            pst.close();
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
                    fechaCargo = resultado.getString("fechaCargo");
                    sueldo = resultado.getInt("sueldo");
                    listaCursosS = resultado.getString("listaCursos");

                    String[] auxCursos = listaCursosS.split(" - ");
                    for (int i = 0; i < auxCursos.length; i++) {
                        Curso c = new Curso(auxCursos[i]);
                        listaCursos.add(c);
                    }
                    Profesor p = new Profesor(nombre, apellido, doc, fechaNacimiento, fechaCargo, sueldo, listaCursos);
                    pst.close();
                    conn.close();
                    return p;
                }
            }
            pst.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public static boolean eliminarProfesor(Documento doc) {// true si lo encontro y lo pudo eliminar
        boolean flag = false;
        String sentencia = "DELETE FROM Universidad.Profesores ";
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

    public static Profesor modificarProfesor(Documento doc) {// null si no lo encontro, retorna la persona modifica
        System.out.println("El profesor encontrado es: \n" + obtenerProfesor(doc).toString());

        System.out.println("Ingrese los datos modificados, no se puede modificar el documento");
        Profesor p = new Profesor(doc);

        String sentencia = "UPDATE Universidad.Profesores ";
        String set = "SET nombre = ?," + " apellido = ?, " + " fechaNacimiento = ?," + " fechaCargo = ?,"
                + " sueldo = ?," + " listaCursos = ? ";
        String where = "WHERE tipoDocumento = ? AND numDocumento = ?;";
        try {
            Connection conn = CreateConection.connectionToDataBase();
            PreparedStatement pst = conn.prepareStatement(sentencia + set + where);
            pst.setString(1, p.getNombre());
            pst.setString(2, p.getApellido());
            pst.setString(3, p.getFechaNacimiento());
            pst.setString(4, p.getFechaCargo());
            pst.setInt(5,p.getSueldo());
            pst.setString(6, listaCursosString(p.getListaCursos()));
            pst.setString(7, doc.getTipoDocumento().toString());
            pst.setString(8, doc.getNumDocumento());
            pst.execute();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        System.out.println("El profesor modificado es: \n" + obtenerProfesor(doc).toString());
        return p;
    }

    private static String listaCursosString(List<Curso> listaCursos) {
        String listaCursosS = "";
        for (int i = 0; i < listaCursos.size(); i++) {
            listaCursosS = listaCursosS + listaCursos.get(i).getCurso() + " - ";
        }
        return listaCursosS;
    }
}
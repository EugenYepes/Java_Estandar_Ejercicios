package base_datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import principales.Director;
import principales.Documento;

public class DirectorDAO {
    public static void guardarDirector(Director d) {
        String sentencia = "INSERT INTO Universidad.Directores";
        String columnas = "(" + "nombre, apellido, tipoDocumento, numDocumento, fechaNacimiento"
                + ", fechaCargo, carrera, sueldo" + ")";
        String values = "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            Connection conn = CreateConection.connectionToDataBase();
            PreparedStatement pst = conn.prepareStatement(sentencia + columnas + values);
            pst.setString(1, d.getNombre());
            pst.setString(2, d.getApellido());
            pst.setString(3, d.getDocumento().getTipoDocumento().toString());
            pst.setString(4, d.getDocumento().getNumDocumento());
            pst.setString(5, d.getFechaNacimiento());
            pst.setString(6, d.getFechaCargo());
            pst.setString(7, d.getCarrera());
            pst.setInt(8, d.getSueldo());
            pst.execute();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static Director obtenerDirector(Documento doc) {
        String nombre = "", apellido = "", fechaNacimiento = "", fechaCargo = "", carrera = "";
        int sueldo = 0;

        String select = "SELECT nombre, apellido, fechaNacimiento" + ", fechaCargo, carrera, sueldo ";
        String from = "FROM Universidad.Directores ";
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
                    carrera = resultado.getString("carrera");
                    sueldo = resultado.getInt("sueldo");
                    Director d = new Director(nombre, apellido, doc, fechaNacimiento, fechaCargo, carrera, sueldo);
                    pst.close();
                    conn.close();
                    return d;
                }
            }
            pst.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public static boolean eliminarDirector(Documento doc) {// true si lo encontro y lo pudo eliminar
        boolean flag = false;
        String sentencia = "DELETE FROM Universidad.Directores ";
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

    public static Director modificarDirector(Documento doc) {
        System.out.println("El director encontrado es: \n" + obtenerDirector(doc).toString());
        System.out.println("Ingrese los datos modificados, no se puede modificar el documento");
        Director d = new Director(doc);

        String sentencia = "UPDATE Universidad.Directores ";
        String set = "SET nombre = ?," + " apellido = ?, " + " fechaNacimiento = ?," + " fechaCargo = ?,"
                + " carrera = ?," + " sueldo = ? ";
                String where = "WHERE tipoDocumento = ? AND numDocumento = ?;";
        try {
            Connection conn = CreateConection.connectionToDataBase();
            PreparedStatement pst = conn.prepareStatement(sentencia + set + where);
            pst.setString(1, d.getNombre());
            pst.setString(2, d.getApellido());
            pst.setString(3, d.getFechaNacimiento());
            pst.setString(4, d.getFechaCargo());
            pst.setString(5, d.getCarrera());
            pst.setInt(6, d.getSueldo());
            pst.setString(7, doc.getTipoDocumento().toString());
            pst.setString(8, doc.getNumDocumento());
            pst.execute();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        System.out.println("El director modificado es: \n" + obtenerDirector(doc).toString());
        return d;
    }
}
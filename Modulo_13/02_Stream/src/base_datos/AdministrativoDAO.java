package base_datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import principales.Administrativo;
import principales.Documento;

public class AdministrativoDAO {
    public static void guardarAdministrativo(Administrativo a) {
        String sentencia = "INSERT INTO Universidad.Administrativos";
        String columnas = "(" + "nombre, apellido, tipoDocumento, numDocumento, fechaNacimiento"
                + ", fechaCargo, sueldo" + ")";
        String values = "VALUES (?, ?, ?, ?, ?, ?, ?);";
        try {
            Connection conn = CreateConection.connectionToDataBase();
            PreparedStatement pst = conn.prepareStatement(sentencia + columnas + values);
            pst.setString(1, a.getNombre());
            pst.setString(2, a.getApellido());
            pst.setString(3, a.getDocumento().getTipoDocumento().toString());
            pst.setString(4, a.getDocumento().getNumDocumento());
            pst.setString(5, a.getFechaNacimiento());
            pst.setString(6, a.getFechaCargo());
            pst.setInt(7, a.getSueldo());
            pst.execute();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static Administrativo obtenerAdministrativo(Documento doc) {
        String nombre = "", apellido = "", fechaNacimiento = "", fechaCargo = "";
        int sueldo = 0;

        String select = "SELECT nombre, apellido, fechaNacimiento" + ", fechaCargo, sueldo ";
        String from = "FROM Universidad.Administrativos ";
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
                    Administrativo a = new Administrativo(nombre, apellido, doc, fechaNacimiento, fechaCargo, sueldo);
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

    public static boolean eliminarAdministrativo(Documento doc) {// true si lo encontro y lo pudo eliminar
        boolean flag = false;
        String sentencia = "DELETE FROM Universidad.Administrativos ";
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

    public static Administrativo modificarAdministrativo(Documento doc) {
        System.out.println("El administrativo encontrado es: \n" + obtenerAdministrativo(doc).toString());
        System.out.println("Ingrese los datos modificados, no se puede modificar el documento");
        Administrativo a = new Administrativo(doc);

        String sentencia = "UPDATE Universidad.Administrativos ";
        String set = "SET nombre = ?," + " apellido = ?, " + " fechaNacimiento = ?," + " fechaCargo = ?,"
                + " sueldo = ? ";
        String where = "WHERE tipoDocumento = ? AND numDocumento = ?;";
        try {
            Connection conn = CreateConection.connectionToDataBase();
            PreparedStatement pst = conn.prepareStatement(sentencia + set + where);
            pst.setString(1, a.getNombre());
            pst.setString(2, a.getApellido());
            pst.setString(3, a.getFechaNacimiento());
            pst.setString(4, a.getFechaCargo());
            pst.setInt(5, a.getSueldo());
            pst.setString(6, doc.getTipoDocumento().toString());
            pst.setString(7, doc.getNumDocumento());
            pst.execute();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        System.out.println("El administrativo modificado es: \n" + obtenerAdministrativo(doc).toString());
        return a;
    }
}
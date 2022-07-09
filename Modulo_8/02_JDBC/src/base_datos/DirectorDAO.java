package base_datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Principales.Documento;
import Principales.Director;

public class DirectorDAO {
    public static void guardarDirector(Director d) {
        String sentencia = "INSERT INTO Universidad.Directores";
        String columnas = "(" + "nombre, apellido, tipoDocumento, numDocumento, fechaNacimiento"
                + ", fechaCargo, carrera, sueldo" + ")";
        String values = "VALUES ('" + d.getNombre() + "', '" + d.getApellido() + "', '"
                + d.getDocumento().getTipoDocumento() + "', '" + d.getDocumento().getNumDocumento() + "', '"
                + d.getFechaNacimiento() + "', '" + d.getFechaCargo() + "', '" + d.getCarrera() + "', '" + d.getSueldo()
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

    public static Director obtenerDirector(Documento doc) {
        String nombre = "", apellido = "", fechaNacimiento = "", fechaCargo = "", carrera = "";
        int sueldo = 0;

        String select = "SELECT nombre, apellido, fechaNacimiento" + ", fechaCargo, carrera, sueldo ";
        String from = "FROM Universidad.Directores ";
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
                carrera = resultado.getString("carrera");
                sueldo = resultado.getInt("sueldo");
                Director d = new Director(nombre, apellido, doc, fechaNacimiento, fechaCargo, carrera, sueldo);
                st.close();
                conn.close();
                return d;

            }
            st.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        System.out.println("No se encontro al director buscado");
        return null;
    }

    public static boolean eliminarDirector(Documento doc) {// true si lo encontro y lo pudo eliminar
        boolean flag = false;
        String sentencia = "DELETE FROM Universidad.Directores ";
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

    public static Director modificarDirector(Documento doc) {// null si no lo encontro, retorna la persona modifica
        System.out.println("Ingrese los datos modificados, no se puede modificar el documento");
        Director d = new Director(doc);

        String sentencia = "UPDATE Universidad.Directores ";
        String set = "SET nombre = " + "'" + d.getNombre() + "'," + " apellido = " + "'" + d.getApellido() + "', "
                + " fechaNacimiento = " + "'" + d.getFechaNacimiento() + "'," + " fechaCargo = " + "'"
                + d.getFechaCargo() + "'," + " carrera = " + "'" + d.getCarrera() + "'," + " sueldo = " + "'"
                + d.getSueldo() + "'";
        String where = "WHERE tipoDocumento = " + "'" + doc.getTipoDocumento() + "'" + " AND " + "numDocumento = " + "'"
                + doc.getNumDocumento() + "';";
        try {
            Connection conn = CreateConection.connectionToDataBase();
            Statement st = conn.createStatement();
            st.execute(sentencia + set + where);
            st.close();
            conn.close();
            return d;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }
}
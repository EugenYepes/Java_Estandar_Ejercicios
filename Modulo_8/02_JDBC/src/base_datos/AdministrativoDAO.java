package base_datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Principales.Documento;
import Principales.Administrativo;

public class AdministrativoDAO {
    public static void guardarAdministrativo(Administrativo d) {
        String sentencia = "INSERT INTO Universidad.Administrativos";
        String columnas = "(" + "nombre, apellido, tipoDocumento, numDocumento, fechaNacimiento"
                + ", fechaCargo, sueldo" + ")";
        String values = "VALUES ('" + d.getNombre() + "', '" + d.getApellido() + "', '"
                + d.getDocumento().getTipoDocumento() + "', '" + d.getDocumento().getNumDocumento() + "', '"
                + d.getFechaNacimiento() + "', '" + d.getFechaCargo() + "', '" + d.getSueldo() + "');";
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

    public static Administrativo obtenerAdministrativo(Documento doc) {
        String nombre = "", apellido = "", fechaNacimiento = "", fechaCargo = "";
        int sueldo = 0;

        String select = "SELECT nombre, apellido, fechaNacimiento" + ", fechaCargo, sueldo ";
        String from = "FROM Universidad.Administrativos ";
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
                Administrativo p = new Administrativo(nombre, apellido, doc, fechaNacimiento, fechaCargo, sueldo);
                st.close();
                conn.close();
                return p;
            }
            st.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        System.out.println("No se encontro al administrativo buscado");
        return null;
    }

    public static boolean eliminarAdministrativo(Documento doc) {// true si lo encontro y lo pudo eliminar
        boolean flag = false;
        String sentencia = "DELETE FROM Universidad.Administrativos ";
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

    public static Administrativo modificarAdministrativo(Documento doc) {
        System.out.println("Ingrese los datos modificados, no se puede modificar el documento");
        Administrativo p = new Administrativo(doc);

        String sentencia = "UPDATE Universidad.Administrativos ";
        String set = "SET nombre = " + "'" + p.getNombre() + "'," + " apellido = " + "'" + p.getApellido() + "', "
                + " fechaNacimiento = " + "'" + p.getFechaNacimiento() + "'," + " fechaCargo = " + "'"
                + p.getFechaCargo() + "'," + " sueldo = " + "'"
                + p.getSueldo() + "'";
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
}
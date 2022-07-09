package base_datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Principales.Documento;
import Principales.Persona;

public class PersonaDAO {
    public static void guardarPersona(Persona p) {
        String sentencia = "INSERT INTO Universidad.Personaes";
        String columnas = "(" + "nombre, apellido, tipoDocumento, numDocumento, fechaNacimiento" + ")";
        String values = "VALUES ('" + p.getNombre() + "', '" + p.getApellido() + "', '"
                + p.getDocumento().getTipoDocumento() + "', '" + p.getDocumento().getNumDocumento() + "', '"
                + p.getFechaNacimiento() + "', '" + "');";
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

    public static Persona obtenerPersona(Documento doc) {
        String nombre = "", apellido = "", fechaNacimiento = "";

        String select = "SELECT nombre, apellido, fechaNacimiento ";
        String from = "FROM Universidad.Personaes ";
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
                Persona p = new Persona(nombre, apellido, doc, fechaNacimiento);
                st.close();
                conn.close();
                return p;
            }
            st.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        System.out.println("No se encontro la persona buscada");
        return null;
    }

    public static boolean eliminarPersona(Documento doc) {// true si lo encontro y lo pudo eliminar
        boolean flag = false;
        String sentencia = "DELETE FROM Universidad.Personas ";
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

    public static Persona modificarPersona(Documento doc) {// null si no lo encontro, retorna la persona modifica
        System.out.println("Ingrese los datos modificados, no se puede modificar el documento");
        Persona p = new Persona(doc);

        String sentencia = "UPDATE Universidad.Personaes ";
        String set = "SET nombre = " + "'" + p.getNombre() + "'," + " apellido = " + "'" + p.getApellido() + "', "
                + " fechaNacimiento = " + "'" + p.getFechaNacimiento() + "'";
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
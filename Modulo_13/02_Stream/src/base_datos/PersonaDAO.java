package base_datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import principales.Documento;
import principales.Persona;

public class PersonaDAO {
    public static void guardarPersona(Persona p) {
        String sentencia = "INSERT INTO Universidad.Personaes";
        String columnas = "(" + "nombre, apellido, tipoDocumento, numDocumento, fechaNacimiento" + ")";
        String values = "VALUES (?, ?, ?, ?, ?);";
        try {
            Connection conn = CreateConection.connectionToDataBase();
            PreparedStatement pst = conn.prepareStatement(sentencia + columnas + values);
            pst.setString(1, p.getNombre());
            pst.setString(2, p.getApellido());
            pst.setString(3, p.getDocumento().getTipoDocumento().toString());
            pst.setString(4, p.getDocumento().getNumDocumento());
            pst.setString(5, p.getFechaNacimiento());
            pst.execute();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static Persona obtenerPersona(Documento doc) {
        String nombre = "", apellido = "", fechaNacimiento = "";

        String select = "SELECT nombre, apellido, fechaNacimiento ";
        String from = "FROM Universidad.Personaes ";
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
                    Persona p = new Persona(nombre, apellido, doc, fechaNacimiento);
                    pst.close();
                    conn.close();
                    return p;
                }
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public static boolean eliminarPersona(Documento doc) {// true si lo encontro y lo pudo eliminar
        boolean flag = false;
        String sentencia = "DELETE FROM Universidad.Personas ";
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

    public static Persona modificarPersona(Documento doc) {// null si no lo encontro, retorna la persona modifica
        System.out.println("La persona encontrada es: \n" + obtenerPersona(doc).toString());
        System.out.println("Ingrese los datos modificados, no se puede modificar el documento");
        Persona p = new Persona(doc);
        String sentencia = "UPDATE Universidad.Personaes ";
        String set = "SET nombre = ?," + " apellido = ?, " + " fechaNacimiento = ? ";
        String where = "WHERE tipoDocumento = ? AND numDocumento = ?;";
        try {
            Connection conn = CreateConection.connectionToDataBase();
            PreparedStatement pst = conn.prepareStatement(sentencia + set + where);
            pst.setString(1, p.getNombre());
            pst.setString(2, p.getApellido());
            pst.setString(3, p.getFechaNacimiento());
            pst.setString(4, doc.getTipoDocumento().toString());
            pst.setString(5, doc.getNumDocumento());
            pst.execute();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        System.out.println("La persona modificada es: \n" + obtenerPersona(doc).toString());
        return p;
    }
}
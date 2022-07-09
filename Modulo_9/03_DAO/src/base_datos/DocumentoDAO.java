package base_datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import Principales.Documento;
import enumerados.TiposDocumento;

public class DocumentoDAO {
    public static HashMap<Integer, Documento> obtenerDocumentos() {
        HashMap<Integer, Documento> documentos = new HashMap<Integer, Documento>();
        String tipoDocumento = "", numDocumento = "";
        String[] tablas = { "Personas", "Profesores", "Directores", "Alumnos", "Administrativos" };
        String select = "SELECT tipoDocumento, numDocumento ";
        for (int i = 0; i < tablas.length; i++) {
            String from = "FROM Universidad." + tablas[i];
            try {
                Connection conn = CreateConection.connectionToDataBase();
                Statement st = conn.createStatement();
                ResultSet resultado = st.executeQuery(select + from);
                while (resultado.next()) {
                    tipoDocumento = resultado.getString("tipoDocumento");
                    numDocumento = resultado.getString("numDocumento");
                    Documento doc = new Documento(TiposDocumento.valueOf(tipoDocumento.toUpperCase()), numDocumento);
                    documentos.put(doc.hashCode(), doc);
                }
                st.close();
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return documentos;
    }
}

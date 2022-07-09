package base_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// import java.sql.Statement;

public class CreateConection {
    public static Connection connectionToDataBase()  {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String pass = "";

        try{
            Connection conn = DriverManager.getConnection(url, user, pass);
            return conn;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}

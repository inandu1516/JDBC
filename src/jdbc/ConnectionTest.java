package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionTest {
    
    public static Connection getConnection() {
        Properties props = new Properties();
        FileInputStream fis = null;
        Connection con = null;
        try {
            fis = new FileInputStream("src\\jdbc\\ConnectionProperties.properties");
            props.load(fis);
 
            // load the Driver Class
            Class.forName(props.getProperty("DB_DRIVER_CLASS"));
 
            // create the connection now
            con = DriverManager.getConnection(props.getProperty("DB_URL"),
                    props.getProperty("DB_USERNAME"),
                    props.getProperty("DB_PASSWORD"));
        } catch (IOException | ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;
    }
     
    private static final String QUERY = "select * from estudiants";
 
    public static void main(String[] args) {
                 
        //using try-with-resources to avoid closing resources (boiler plate code)
        try(Connection con = getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY)) {  
             
            while(rs.next()){
                String dni = rs.getString("dni");
                String nom = rs.getString("nom");
                String any = rs.getString("any_inici");
                System.out.println("dni: " + dni + " - nom: " + nom + " - any_inici: " + any);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         
    }
 
}

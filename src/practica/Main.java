package practica;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Main {
    
    public static void main(String[] args) {
           
        try {
            crearTaula();
        } catch (SQLException ex) {
            for (Throwable t : ex)
                t.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Administrador Morote = new Administrador();
        
        Morote.crearJugador("NewPlayer","NewPass","NewLema");
        Morote.crearJugador("NewPlayer2","NewPass2","NewLema2");
        Morote.crearJugador("NewPlayer3","NewPass3","NewLema4");
        Morote.eliminarJugador("NewPlayer");
        Morote.cercarJugador("NewPlayer2");
        Morote.llistarJugador();

        /*Inge.setLema("Kill them all");
        Morote.modificarNomJugador(Inge, "Ingemar");
        Jugador Marta = Morote.creaJugador("Marta","123");
        
        System.out.println(Inge + "\n" + Marta);*/
        
    }
    
    public static void crearTaula() throws SQLException, IOException {
        Connection conn = obtenirConnexio();

        try {
            Statement stat = conn.createStatement();
            stat.executeUpdate("DROP TABLE Criatura");
            stat.executeUpdate("DROP TABLE Equip");
            stat.executeUpdate("DROP TABLE Jugador");

            
             stat.executeUpdate("CREATE TABLE Jugador ("
                    + "nom VARCHAR(20),"
                    + "pass VARCHAR(20),"
                    + "lema VARCHAR(20),"
                    + "victories INT," 
                    + "derrotes INT," 
                    + "empats INT," 
                    + "PRIMARY KEY(nom))");
            
            stat.executeUpdate("CREATE TABLE Criatura ("
                    + "nom VARCHAR(20),"
                    + "atac INT,"
                    + "defensa INT,"
                    + "raça VARCHAR(10),"
                    + "medi VARCHAR(10),"
                    + "habilitat_esp VARCHAR(20),"
                    + "imatge VARCHAR(20),"
                    + "propietari VARCHAR(20),"
                    + "ready BOOLEAN DEFAULT '0',"
                    + "equip INT,"
                    + "PRIMARY KEY(nom),"
                    + "FOREIGN KEY (propietari) REFERENCES Jugador(nom))");

           
           
            stat.executeUpdate("CREATE TABLE Equip ("
                    + "id INT AUTO_INCREMENT,"
                    + "nomEquip VARCHAR(20),"
                    + "propietari VARCHAR(20),"
                    + "ready BOOLEAN DEFAULT '0',"
                    + "PRIMARY KEY(id),"
                    + "FOREIGN KEY (propietari) REFERENCES Jugador(nom))");

            
//            stat.executeUpdate("DROP TABLE Criatura");
//            stat.executeUpdate("DROP TABLE Jugador");
//            stat.executeUpdate("DROP TABLE Equip");
        } finally {
            conn.close();
        }
    }

    
    public static Connection obtenirConnexio() throws SQLException, IOException {
        Properties props = new Properties();
        FileInputStream in = new FileInputStream("/home/randeth/NetBeansProjects/JavaDB/database.properties");
        props.load(in);
        in.close();

        String drivers = props.getProperty("jdbc.drivers");
        if (drivers != null) {
            System.setProperty("jdbc.drivers", drivers);
        }
        String url = props.getProperty("jdbc.url");
        String usuari = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        return DriverManager.getConnection(url, usuari, password);
    }
    
}

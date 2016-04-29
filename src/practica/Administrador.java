package practica;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Administrador extends Usuari {
    
    public Administrador() {
        this.nom = "Admin";
        this.pass = "nolose";
    }

    public void crearJugador(String nom, String pass, String lema){
        
        try {
            Connection conn = obtenirConnexio();
            Statement stat = conn.createStatement();
            stat.executeUpdate("INSERT INTO Jugador VALUES('"+nom+"','"+pass+"','"+lema+"',0,0,0)");
            conn.close();
        } catch (SQLException ex) {
            for (Throwable t : ex)
                t.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void modificarJugador(String nom, String camp, String val){
        
        //UPDATE jugadors...
    }
   
   
    public void eliminarJugador(String nom){
        try {
            Connection conn = obtenirConnexio();
            Statement stat = conn.createStatement();
            stat.executeUpdate("DELETE FROM Jugador WHERE nom = '"+nom+"'");
            conn.close();
        } catch (SQLException ex) {
            for (Throwable t : ex)
                t.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //delete user from usuaris where nom = nom;
    }
    
    public void cercarJugador(String nom){
        
        try {
            Connection conn = obtenirConnexio();
            Statement stat = conn.createStatement();
            ResultSet resultat = stat.executeQuery("SELECT nom, pass, lema, victories, derrotes, empats FROM Jugador WHERE nom = '"+nom+"'");
            while (resultat.next()) {
                    System.out.println(resultat.getString(1)
                            + "-" + resultat.getString(2)
                            + "-" + resultat.getString(3)
                            + "-" + resultat.getInt(4)
                            + "-" + resultat.getInt(5)
                            + "-" + resultat.getInt(6));
                }

      
            
            resultat.close();
            conn.close();
        } catch (SQLException ex) {
            for (Throwable t : ex)
                t.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //SELECT * FROM jugadors WHERE nom = nom;
    }
    public void llistarJugador(){
        //SELECT * FROM jugadors ;
        try {
            Connection conn = obtenirConnexio();
            Statement stat = conn.createStatement();
            ResultSet resultat = stat.executeQuery("SELECT nom, pass, lema, victories, derrotes, empats FROM Jugador");
            while (resultat.next()) {
               
                    System.out.println(resultat.getString(1)
                            + "-" + resultat.getString(2)
                            + "-" + resultat.getString(3)
                            + "-" + resultat.getInt(4)
                            + "-" + resultat.getInt(5)
                            + "-" + resultat.getInt(6));
                }
            resultat.close();
            conn.close();
        } catch (SQLException ex) {
            for (Throwable t : ex)
                t.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
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

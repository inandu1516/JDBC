/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import static practica.Main.crearTaula;

/**
 *
 * @author randeth
 */
public class FXML_CrearCriaturaController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void crearCriatura(ActionEvent event) {
        try {
            crearCriatura();
        } catch (SQLException ex) {
            for (Throwable t : ex)
                t.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void crearCriatura() throws SQLException, IOException {
        Connection conn = obtenirConnexio();

        try {
            Statement stat = conn.createStatement();

            stat.executeUpdate("INSERT INTO Criatura (nom, atac, defensa, rasa, medi, habilitat_esp, imatge, propietari) VALUES ('Drraco asuls', 5, 5, 'Dragon', 'aire', NULL, 'img/draco.jpg','Albert');");
            System.out.println("Insert criatura!");
//            ResultSet resultat = stat.executeQuery("SELECT * FROM prova");
//            if (resultat.next()) {
//                System.out.println(resultat.getString(1));
//            }
//            resultat.close();
           
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static practica.Main.crearTaula;

/**
 *
 * @author randeth
 */
public class FXML_CrearCriaturaController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private TextField crearNomCText;
    @FXML
    private TextField crearAtacCText;
    @FXML
    private TextField crearDefensaCText;
    @FXML
    private TextField crearRazaCText;
    @FXML
    private TextField crearMediCText;
    @FXML
    private TextField crearHabilitatCText;
    @FXML
    private TextField crearImatgeCText;
    
    
    
    @FXML
    private void tornarHomeButton(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXML_Home.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    
    
    @FXML
    private void crearCriatura(ActionEvent event) {
        //try {
                    String nom = crearNomCText.getText();
                    String atac = crearAtacCText.getText();
                    String defensa = crearDefensaCText.getText();
                    String raza = crearRazaCText.getText();
                    String medi = crearMediCText.getText();
                    String habilitat = crearHabilitatCText.getText();
                    String imatge = crearImatgeCText.getText();

                    System.out.println(nom);
                    System.out.println(atac);
                    System.out.println(defensa);
                    System.out.println(raza);
                    System.out.println(medi);
                    System.out.println(habilitat);
                    System.out.println(imatge);
                    

            //crearCriatura();
//        } catch (SQLException ex) {
//            for (Throwable t : ex)
//                t.printStackTrace();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
    }
    
    public static void crearCriatura() throws SQLException, IOException {
        
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

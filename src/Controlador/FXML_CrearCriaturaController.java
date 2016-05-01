/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.Jugador;
import Model.JugadorImpl;
import interfaces.DAOJugador;
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
    
    DAOJugador jugadorSQL = new JugadorImpl();
    private static Jugador player;
    public void setJugador(Jugador player){
        this.player = player;
    }
    
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
                    int atac = Integer.parseInt(crearAtacCText.getText());
                    int defensa = Integer.parseInt(crearDefensaCText.getText());
                    String rasa = crearRazaCText.getText();
                    String medi = crearMediCText.getText();
                    String habilitat = crearHabilitatCText.getText();

                    try {
            jugadorSQL.sqlCrearCriatura(nom, atac, defensa, rasa, medi, habilitat, player.getNom());
        } catch (Exception e) {
            System.out.println(e);
        }
                    

        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}

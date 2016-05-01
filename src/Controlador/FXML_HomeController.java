/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.Jugador;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author randeth
 */
public class FXML_HomeController implements Initializable {

    ObservableList<String> campList = FXCollections.observableArrayList("nom","atac","defensa","raça","medi","habilitat");
    @FXML
    private TextField valorModificarCText;
    @FXML
    private TextField eliminarCText;
    @FXML
    private TextField modificarNomCText;
    @FXML
    private ChoiceBox modificarCampCChoice;
    
    Jugador player;
    public void setJugador(Jugador player){
        this.player = player;
        System.out.println(player.getNom());
    }
    @FXML
    private void crearCButton(ActionEvent event) throws IOException{
        System.out.println("Crear Criatura");
        Parent crearCriatura_page_parent = FXMLLoader.load(getClass().getResource("FXML_CrearCriatura.fxml"));
        Scene crearCriatura_page_scene = new Scene(crearCriatura_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(crearCriatura_page_scene);
        app_stage.show();
        
    }
    @FXML
    private void eliminarCButton(ActionEvent event) throws IOException{
        System.out.println(eliminarCText.getCharacters()+" eliminada");
        
    }
    
    @FXML
    private void modificarCButton(ActionEvent event) throws IOException{
        
       /* String camp=String.valueOf(modificarCampCChoice.getSelectionModel().selectedItemProperty().getValue());
        
        try {
            Connection conn = obtenirConnexio();
            Statement stat = conn.createStatement();

            stat.executeUpdate("UPDATE Criatura SET "+camp+"='"+valorModificarCText.getCharacters()+"' WHERE nom='"+modificarNomCText.getCharacters()+"'");
            conn.close();
        } catch (SQLException ex) {
            for (Throwable t : ex)
                t.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Criatura "+modificarNomCText.getCharacters()+" ha cambiat "+camp+" pel valor "+valorModificarCText.getCharacters());
        */
    }
    @FXML
    private void llistarCButton(ActionEvent event) throws IOException{
        System.out.println("Llistar Criatura");
        
    }
    @FXML
    private void crearEButton(ActionEvent event) throws IOException{
        System.out.println("Crear Equip");
        
    }
   
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modificarCampCChoice.setItems(campList);
    }    
    
}
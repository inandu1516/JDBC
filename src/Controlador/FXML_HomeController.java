package Controlador;

import Model.Jugador;
import Model.JugadorImpl;
import Model.LluitaImpl;
import interfaces.DAOJugador;
import interfaces.DAOLluita;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author randeth
 */
public class FXML_HomeController implements Initializable {

    ObservableList<String> campList = FXCollections.observableArrayList("nom","atac","defensa","rasa","medi","habilitat_esp");
    ObservableList<String> campList2 = FXCollections.observableArrayList("nom","atac","defensa","rasa","medi","habilitat_esp");
    ObservableList<String> campListEquip = FXCollections.observableArrayList("nom","potencial");
@FXML
    private TextField valorModificarCText;
    @FXML
    private TextField eliminarCText;
    @FXML
    private TextField modificarNomCText;
    @FXML
    private ChoiceBox modificarCampCChoice;
    @FXML
    private TextField valorCercarCText;
    @FXML
    private ChoiceBox cercarCampCChoice;
    @FXML
    private Label cercarCLabel1;
    @FXML
    private Label llistaCLabel;
    @FXML
    private Label errorLabel;
    
    @FXML
    private TextField crearNomEText;
    @FXML
    private TextField nomModificarEText;
    @FXML
    private TextField valorModificarEText;
    @FXML
    private TextField eliminarNomEText;
    @FXML
    private ChoiceBox cercarCampEChoice;
    @FXML
    private TextField cercarNomEText;
    @FXML
    private Label cercarELabel;
    @FXML
    private Label llistaELabel;
    @FXML
    private Label llistaCELabel;
    @FXML
    private TextField criaturaAfegirEText;
    @FXML
    private TextField equipAfegirEText;
    @FXML
    private TextField criaturaModificarEText;
    @FXML
    private TextField equipModificarEText;
    @FXML
    private TextField equipLlistarEText;
    
//    -------- lluita --------
    @FXML
    private TextField nomJug1;
    @FXML
    private TextField nomJug2;
    @FXML
    private TextField nomCriatura_1;
    @FXML
    private TextField nomCriatura_2;
    @FXML
    private Label Criatura_1_inicial;
    @FXML
    private Label Criatura_2_inicial;
    @FXML
    private Label medi;
    
    //-------- lluita --------
    
    DAOLluita lluitaSQL = new LluitaImpl();
    DAOJugador jugadorSQL = new JugadorImpl();
    private static Jugador player;
    public void setJugador(Jugador player){
        this.player = player;
    }
    
    @FXML
    private void crearCButton(ActionEvent event) throws IOException{
        FXML_CrearCriaturaController crear = new FXML_CrearCriaturaController();
        crear.setJugador(player);
        Parent crearCriatura_page_parent = FXMLLoader.load(getClass().getResource("FXML_CrearCriatura.fxml"));
        Scene crearCriatura_page_scene = new Scene(crearCriatura_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(crearCriatura_page_scene);
        app_stage.show();
        
    }
    @FXML
    private void eliminarCButton(ActionEvent event) throws IOException{
        try {
            jugadorSQL.sqlEliminarCriatura(eliminarCText.getText(), player.getNom());
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
    }
    
    @FXML
    private void modificarCButton(ActionEvent event) throws IOException{
        
        String camp=String.valueOf(modificarCampCChoice.getSelectionModel().selectedItemProperty().getValue());
        try {
            jugadorSQL.sqlModificarCriatura(modificarNomCText.getText(), camp, valorModificarCText.getText(), player.getNom());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @FXML
    private void cercarCButton(ActionEvent event) throws IOException{
        String camp=String.valueOf(cercarCampCChoice.getSelectionModel().selectedItemProperty().getValue());
        try {
            String content = jugadorSQL.sqlCercarCriatura(camp, valorCercarCText.getText(), player.getNom());
            cercarCLabel1.setText(content);
            System.out.println(content);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    private void llistarCButton(ActionEvent event) throws IOException{
        try {
            String content = jugadorSQL.sqlLlistarCriatura(player.getNom());
            llistaCLabel.setText(content);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    @FXML
    private void crearEButton(ActionEvent event) throws IOException{
        try {
            jugadorSQL.sqlCrearEquip(crearNomEText.getText(), player.getNom());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    private void modificarEButton(ActionEvent event) throws IOException{
        try {
            jugadorSQL.sqlModificarEquip(nomModificarEText.getText(), valorModificarEText.getText(), player.getNom());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
     @FXML
    private void eliminarEButton(ActionEvent event) throws IOException{
        try {
            jugadorSQL.sqlEliminarEquip(eliminarNomEText.getText(), player.getNom());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
     @FXML
    private void cercarEButton(ActionEvent event) throws IOException{
        String camp=String.valueOf(cercarCampEChoice.getSelectionModel().selectedItemProperty().getValue());
        try {
            String content = jugadorSQL.sqlCercarEquip(camp, cercarNomEText.getText(), player.getNom());
            cercarELabel.setText(content);
            System.out.println(content);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @FXML
    private void llistarEButton(ActionEvent event) throws IOException{
        try {
            String content = jugadorSQL.sqlLlistarEquip(player.getNom());
            llistaELabel.setText(content);
            System.out.println(content);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @FXML
    private void afegirEButton(ActionEvent event) throws IOException{
        try {
            jugadorSQL.sqlAfegirCriaturaEquip(criaturaAfegirEText.getText(), equipAfegirEText.getText(), player.getNom());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @FXML
    private void modificarCEButton(ActionEvent event) throws IOException{
        try {
            jugadorSQL.sqlModificarCriaturaEquip(criaturaModificarEText.getText(), equipModificarEText.getText(), player.getNom());        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @FXML
    private void llistarCEButton(ActionEvent event) throws IOException{
        try {
            String content = jugadorSQL.sqlLlistarCriaturesEquip(equipLlistarEText.getText(),player.getNom());
            llistaCELabel.setText(content);
            System.out.println(content);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
   
//    --------------- LLUITA ----------------------
    @FXML
    private void cercarCriaturaJugador_1(ActionEvent event) throws IOException{
        try {
            String nomJugador = nomJug1.getText();
            String nomCriatura = nomCriatura_1.getText();
            String content = lluitaSQL.sqlCercarCriatura(nomJugador, nomCriatura);
            Criatura_1_inicial.setText(content);
            System.out.println(nomCriatura_1.getText());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @FXML
    private void cercarCriaturaJugador_2(ActionEvent event) throws IOException{
        try {
            String nomJugador = nomJug2.getText();
            String nomCriatura = nomCriatura_2.getText();
            String content = lluitaSQL.sqlCercarCriatura(nomJugador, nomCriatura);
            Criatura_2_inicial.setText(content);
            System.out.println(nomCriatura_2.getText());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @FXML
    private void Lluita(ActionEvent event) throws IOException{
        try {
            String combat = lluitaSQL.sqlCombatIndividual(nomJug1.getText(),nomCriatura_1.getText(),nomJug2.getText(),nomCriatura_2.getText());
            medi.setText(combat);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modificarCampCChoice.setItems(campList);
        cercarCampCChoice.setItems(campList2);
        cercarCampEChoice.setItems(campListEquip);


    }    
    
}

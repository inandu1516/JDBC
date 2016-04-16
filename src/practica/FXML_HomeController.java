/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author randeth
 */
public class FXML_HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
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
        System.out.println("Eliminar Criatura");
        
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
        // TODO
    }    
    
}

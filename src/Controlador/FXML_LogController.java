/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author randeth
 */
public class FXML_LogController implements Initializable {

    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private Label textError;
    
    @FXML
    private void loginButton(ActionEvent event) throws IOException{
        
        try {

                    boolean loginValid = validacioLogin(userName, password);
                    if (loginValid){
                        System.out.println("Validacio correcte !");
                        if(loginValid){
                            Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXML_Home.fxml"));
                            Scene home_page_scene = new Scene(home_page_parent);
                            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            app_stage.setScene(home_page_scene);
                            app_stage.show();
                        }
                       
                    }else{
                        System.out.println("Validacio incorrecte !");
                        textError.setText("Validacio incorrecte !");
                    }

                } catch (ExcepcioCampTextUsuari ex) {
                    textError.setText(ex.getMissatge());
                    System.err.println(ex.getMissatge());
                } catch (ExcepcioCampTextPassword ex) {
                    textError.setText(ex.getMissatge());
                    System.err.println(ex.getMissatge());
                }
        
    }
    
    public static boolean validacioLogin(TextField user, PasswordField password) throws ExcepcioCampTextUsuari, ExcepcioCampTextPassword {
        boolean valid = true;
        String nom = user.getText();
        String pass = password.getText();
        
        //IF user = select username from jugador...
        if (nom.length() == 0) {
            valid = false;
            throw new ExcepcioCampTextUsuari();
        }
        //IF user = select paswword from jugador...
        if (pass.length() == 0) {
            valid = false;
            throw new ExcepcioCampTextPassword();
        }
        
        if(pass.equals("admin")){
            valid = true;
        }else {
            valid = false;
        }
        
        return valid;
    }
    
    private static class ExcepcioCampTextUsuari extends Exception {
        String missatge = "El camp Usuari no pot estar buit!";
        public String getMissatge() {
            return missatge;
        }
    }
    
    private static class ExcepcioCampTextPassword extends Exception {
        String missatge = "El camp Password no pot estar buit!";
        public String getMissatge() {
            return missatge;
        }
   }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

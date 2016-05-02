/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Model.AdministrdorImpl;
import Model.JugadorImpl;
import interfaces.DAOAdministrador;
import interfaces.DAOJugador;
import Controlador.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author randeth
 */
public class JavaFXApplication7 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        try{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Controlador/FXML_Log.fxml"));
        
        Scene scene = new Scene(root);
        
        
        stage.setScene(scene);
        stage.show();
        } catch (Exception e){
            System.out.println(e);
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        DAOAdministrador dao = new AdministrdorImpl();
        dao.sqlCrearEstructura();
        } catch (Exception e){
            System.out.println(e);
        }
        launch(args);
    }
    
}

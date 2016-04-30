/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author randeth
 */
public class Conexion {
    protected Connection conexion;
    
    private final String JDBC_DRIVER ="com.mysql.jdbc.Driver"; 
    private final String DB_URL ="jdbc:mysql://localhost:3306/jdbc"; 
    private final String USER ="root"; 
    private final String PASS ="rnd33";
    public void conectar() throws Exception{
        try{
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);
            Class.forName(JDBC_DRIVER);
        } catch (Exception e){
            throw e;
        }
    }
    
    public void cerrar() throws SQLException{
        if(conexion != null){
            if(!conexion.isClosed()){
                conexion.close();
            }
        }
    }
}

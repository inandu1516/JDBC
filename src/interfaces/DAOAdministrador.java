/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;


/**
 *
 * @author randeth
 */
public interface DAOAdministrador {
    
    public void sqlCrearJugador(String nom, String pass, String lema) throws Exception;
    public void sqlModificarJugador(String nom, String camp, String val) throws Exception;
    public void sqlEliminarJugador(String nom) throws Exception;
    public void sqlCercarJugador(String nom) throws Exception;
    public void sqlLlistarJugador() throws Exception;
    public void sqlCrearEstructura() throws Exception;
}

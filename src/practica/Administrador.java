package practica;

public class Administrador extends Usuari {
    
    public Administrador() {
        this.nom = "Admin";
        this.pass = "nolose";
    }

    public void crearJugador(String nom, String pass){
        
        //INSERT INTO Table VALUES...
    }
    
    public void modificarJugador(String nom, String camp, String val){
        //UPDATE jugadors...
    }
   
   
    public void eliminarJugador(String nom){
        //delete user from usuaris where nom = nom;
    }
    
    public void cercarJugador(String nom){
        //SELECT * FROM jugadors WHERE nom = nom;
    }
    public void llistarJugador(){
        //SELECT * FROM jugadors ;
    }
    
    
}

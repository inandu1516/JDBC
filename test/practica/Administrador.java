package practica;

public class Administrador extends Usuari {
    
    public Administrador() {
        this.nom = "Admin";
        this.pass = "nolose";
    }

    public Jugador creaJugador(String nom, String pass){
        Jugador usr = new Jugador(nom, pass);
        
        //UPDATE table INSERT INTO Table (usr)...
        return usr;
    }
    
    public void modificarNomJugador(Jugador jugador, String nom){
        jugador.nom = nom;
        //UPDATE jugadors...
    }
    
    public void modificarPassJugador(Jugador jugador, String pass){
        jugador.pass = pass;
        //UPDATE jugadors...
    }
    
    public void eliminarJugador(Jugador jugador, String pass){
        //delete user from usuaris where nom = nom;
    }
    
    public void cercarJugador(String nom){
        //SELECT * FROM jugadors WHERE nom = nom;
    }
    
}

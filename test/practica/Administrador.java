package practica;

public class Administrador extends Usuari {
    
    public Administrador() {
        this.nom = "Admin";
        this.pass = "nolose";
    }

    public Jugador creaJugador(String nom, String pass){
        Jugador usr = new Jugador(nom, pass);
        return usr;
    }
    
    public void modificarNomJugador(Jugador jugador, String nom){
        jugador.nom = nom;
    }
    
    public void modificarPassJugador(Jugador jugador, String pass){
        jugador.pass = pass;
    }
    
    //metodes creacio, modificacio i eliminacio usuaris...
    //metode de cerca d'usuaris...
    
}

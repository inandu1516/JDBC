package practica;

public class Administrador extends Usuari {
    
    public Administrador() {
        this.nom = "Admin";
        this.pass = "nolose";
    }

    public static Usuari creaJugador(String nom, String pass){
        Usuari usr = new Usuari(nom, pass);
        return usr;
    }
    
    //metodes creacio, modificacio i eliminacio usuaris...
    //metode de cerca d'usuaris...
    
}

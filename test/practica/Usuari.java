package practica;

public class Usuari {
    
    String nom = null;
    String pass = null;

    public Usuari(String nom, String pass) {
        this.nom = nom;
        this.pass = pass;
    }
    
    //constructor Admin
    public Usuari() {
    }

    @Override
    public String toString() {
        return "Usuari{" + "nom=" + nom + ", pass=" + pass + '}';
    }
   
}

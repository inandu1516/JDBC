package practica;

public class Usuari {
    
    protected String nom = null;
    protected String pass = null;

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

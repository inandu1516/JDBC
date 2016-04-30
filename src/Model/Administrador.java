package Model;

public class Administrador extends Usuari {
    
    public Administrador() {
        this.nom = "Admin";
        this.pass = "nolose";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    

    
    
}

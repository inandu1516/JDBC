package Model;

public class Criatura {
    
    private String nom;
    private int atac;
    private int defensa;
    private String raça;
    private String medi;
    private String habilitat_esp;
    private String imatge; 
    private boolean ready = false;

    
    /* ---- Getters & Setters (fer UPDATES a la BD!)*/
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAtac() {
        return atac;
    }

    public void setAtac(int atac) {
        this.atac = atac;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public String getRaça() {
        return raça;
    }

    public void setRaça(String raça) {
        this.raça = raça;
    }

    public String getMedi() {
        return medi;
    }

    public void setMedi(String medi) {
        this.medi = medi;
    }

    public String getHabilitat_esp() {
        return habilitat_esp;
    }

    public void setHabilitat_esp(String habilitat_esp) {
        this.habilitat_esp = habilitat_esp;
    }

    public String getImatge() {
        return imatge;
    }

    public void setImatge(String imatge) {
        this.imatge = imatge;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }
    
    
    
}

package Model;

public class Jugador extends Usuari {
    
    protected String lema = null;
    protected int victories;
    protected int derrotes;
    protected int empats;

    public Jugador(String nom, String pass) {
        super(nom, pass);
    }
   
   
    public void afegirCriaturaEquip(String nomCriatura, String nomEquip){
        //String id = SELECT id from Equips WHERE nomEquip=nomEquip;
        //UPDATE Criatures SET equip = id where nomCriatura = nomCriatura
        //UPDATE Equips SET potencial = Avg potencial FROM Criaturas WHERE Equip NATURAL JOIN 
    }
    
    public void cambiarCriaturaEquip(String nomCriatura, String nomEquip){
        //String id = SELECT id from Equips WHERE nomEquip=nomEquip
        //UPDATE Criatures SET equip = id....
    }
    
  
    
    /**
     *  Getters & Setters (fer UPDATES a la BD!)  
     */
    
    public void setVictories(int victories) {
        this.victories = victories;
    }

    public int getDerrotes() {
        return derrotes;
    }

    public void setDerrotes(int derrotes) {
        this.derrotes = derrotes;
    }

    public int getEmpats() {
        return empats;
    }

    public void setEmpats(int empats) {
        this.empats = empats;
    }
    
    public void setLema(String lema) {
        this.lema = lema;
    }

    public String getLema() {
        return lema;
    }
    
    public int getVictories() {
        return victories;
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


    @Override
    public String toString() {
        return "Jugador{" + super.toString() + "lema=" + lema + '}';
    }
    
}

package practica;

public class Jugador extends Usuari {
    
    protected String lema = null;
    protected int victories;
    protected int derrotes;
    protected int empats;

    public Jugador(String nom, String pass) {
        super(nom, pass);
    }
    
    
    /**
     * CONSULTEES BD  
     */
    
    public void crearCriatura(String nom, int atac, int defensa, String raça,
            String medi, String habilitat_esp, String imatge){
        String nomJugador = this.getNom();
        //INSERT INTO Criaturas(values)......
    }
    
    public void modificarCriatura(String nom, String camp, String val){
        String nomJugador = this.getNom();
        if(camp == "atac" || camp == "defensa"){
            int valor = Integer.parseInt(val);
        }
        //UPDATE Criatura SET camp = valor where nom = NOM....
    }
    
    public void eliminarCriatura(String nom){
        String nomJugador = this.getNom();
        //DELETE FROM Criatura WHERE nom = NOM....
    }
    
    public void cercaCriatura(String camp, String val){
        String nomJugador = this.getNom();
        if(camp == "atac" || camp == "defensa"){
            int valor = Integer.parseInt(val);
        }
        //SELECT * FROM Cruatures WHERE camp = val AND nomJugador == propietari;
    }
    
    public void llistarCriatura(){
        String nomJugador = this.getNom();
        //SELECT * FROM Criatura WHERE nom = NOM...
    }
    
   
    public void crearEquip(String nomEquip){
        String nomJugador = this.getNom();
        //INSERT INTO Equips VALUES nomEquip, nomJugador
    }
    
    public void modificarEquip(String nomEquip){
        //UPDATE Equips VALUES nomEquip = nomEquip....
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
    
    public void eliminarEquip(String nomEquip){
        String nomJugador = this.getNom();
        //DELETE FROM Equip WHERE nomEquip = "nomEquip"...
    }
    
    public void cercarEquip(String nomEquip){
        String nomJugador = this.getNom();
        //SELECT * FROM Equip WHERE nomJugador = "nomJugador"...
    }
    
    public void llistarEquip(){
        String nomJugador = this.getNom();
        //SELECT * FROM Equip WHERE nomJugador = "nomJugador"...
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
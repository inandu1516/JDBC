package practica;

public class Jugador extends Usuari {
    
    protected String lema = null;
    
    public Jugador(String nom, String pass) {
        super(nom, pass);
    }

    public void setLema(String lema) {
        this.lema = lema;
    }

    @Override
    public String toString() {
        return "Jugador{" + super.toString() + "lema=" + lema + '}';
    }
    
}

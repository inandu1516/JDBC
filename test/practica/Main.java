package practica;

public class Main {
    
    public static void main(String[] args) {
        
        Administrador Morote = new Administrador();
        
        Usuari Inge = Morote.creaJugador("Inge","nolose");
        Usuari Marta = Morote.creaJugador("Marta","123");
        
        System.out.println(Inge + "\n" + Marta);
        
    }
    
}

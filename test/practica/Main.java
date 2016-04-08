package practica;

public class Main {
    
    public static void main(String[] args) {
        
        Administrador Morote = new Administrador();
        
        Jugador Inge = Morote.creaJugador("Inge","nolose");
        Inge.setLema("Kill them all");
        Morote.modificarNomJugador(Inge, "Ingemar");
        Jugador Marta = Morote.creaJugador("Marta","123");
        
        System.out.println(Inge + "\n" + Marta);
        
    }
    
}

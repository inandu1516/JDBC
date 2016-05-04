package interfaces;

public interface DAOLluita {
    
    public String sqlCercarCriatura(String nomJugador, String nomCriatura) throws Exception;
    public String sqlCombatIndividual(String nomJug1,String nomCriatura_1,String nomJug2,String nomCriatura_2) throws Exception; //retorna el medi aleatori
    
}

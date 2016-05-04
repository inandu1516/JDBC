package interfaces;

public interface DAOLluita {
    public String sqlCercarCriatura(String nomJugador, String nomCriatura) throws Exception;
    public String sqlCombatIndividual(String nomJug1,String nomCriatura_1,String nomJug2,String nomCriatura_2) throws Exception; //retorna el medi aleatori
    public String sqlGetGuanyador() throws Exception;
    public void sqlUpdateGuanyador() throws Exception;
    public void sqlUpdatePerdedor() throws Exception;
    public void sqlUpdateEmpat() throws Exception;
    public String sqlC1final() throws Exception;
    public String sqlC2final() throws Exception;
    public String sqlTreuC1random(String nomEquip) throws Exception;
    public String sqlTreuC2random(String nomEquip) throws Exception;
    public String sqlCercarCrandom(String nomCriatura) throws Exception;
}

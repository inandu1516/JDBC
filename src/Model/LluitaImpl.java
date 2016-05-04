package Model;

import dao.Conexion;
import interfaces.DAOLluita;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

/**
 *
 * @author inge
 */
public class LluitaImpl extends Conexion implements DAOLluita{

    @Override
    public String sqlCercarCriatura(String nomJugador, String nomCriatura) throws Exception {
        String content="";
        try{
            this.conectar();
            Statement stat = conexion.createStatement();
            ResultSet resultat = stat.executeQuery("SELECT nom, atac, defensa FROM Criatura "
                    + "WHERE propietari = '"+nomJugador+"' AND nom = '"+nomCriatura+"'");
                
                while (resultat.next()) {
                    content+=
                            resultat.getString(1)
                            + "-" + resultat.getInt(2)
                            + "-" + resultat.getInt(3)+"\n";
                }
            return content;
        } catch (Exception e){
            throw e;
        } finally{
            this.cerrar();
        }  
    }

    @Override
    public String sqlCombatIndividual(String nomJug1,String nomCriatura_1,String nomJug2, String nomCriatura_2) throws Exception {
        String[] medis = {"acuatico","montaña","aire","jungla"};
        Random rand = new Random();
        int index = rand.nextInt(3 - 0 + 1) + 0;
        String medi = medis[index];
        int atac1 = 0,atac2 = 0,def1 = 0,def2 = 0;
        String medi1 = null, medi2 = null;
        try{
             this.conectar();
             
             Statement stat1 = conexion.createStatement();
             ResultSet Criatura_1 = stat1.executeQuery("SELECT atac,defensa,medi FROM Criatura "
                     + "WHERE propietari = '"+nomJug1+"' AND nom = '"+nomCriatura_1+"'");

            while (Criatura_1.next()) {
                atac1 = Criatura_1.getInt("atac");
                def1 =  Criatura_1.getInt("defensa");
                medi1 = Criatura_1.getString("medi");
            }
            
            Statement stat2 = conexion.createStatement();
             ResultSet Criatura_2 = stat2.executeQuery("SELECT atac,defensa,medi FROM Criatura "
                     + "WHERE propietari = '"+nomJug2+"' AND nom = '"+nomCriatura_2+"'");

            while (Criatura_2.next()) {
                atac2 = Criatura_2.getInt("atac");
                def2 =  Criatura_2.getInt("defensa");
                medi2 = Criatura_2.getString("medi");
            }
            
         } catch (Exception e){
             throw e;
         } finally{
             this.cerrar();
         } 
        
        
        if(medi1.equals(medi)){
            atac1++;
        }else if(medi2.equals(medi)){
            atac2++;
        }
        
        System.out.println(atac1+" "+def1+" "+medi1+"\n"+atac2+" "+def2+" "+medi2+"\n");
        
        def1 = def1 - atac2;
        def2 = def2 - atac1;
        
        if(def1 <= 0 && def2 <= 0){
            System.out.println("HAN MORT ELS 2");
        }else if(def1 <= 0){
            System.out.println(nomCriatura_1 + " HA MORT");
        }else if(def2 <= 0){
            System.out.println(nomCriatura_2 + " HA MORT");
        }
        
        System.out.println(atac1+" "+def1+" "+medi1+"\n"+atac2+" "+def2+" "+medi2+"\n");
        return "Medi combat: "+medis[index];
    }
}
        
Req01. Ha de tenir mode individual i grupal

Req02. Cada usuari té nom i contrasenya que d'escriu al login

Req03. Usuari pot editar els personatges

Req04. El equip de combat no és visible als altres jugadors fins que s'inicii la partida

Req05. El lema de l'usuari es mostra a l'inici del combat.

Req06. Un usuari administrador s'encarrega de crear, modificar i/o eliminar els altres jugadors

Req07. De les criatures s'emmagatzema nom, potència d'atac, defensa, raça, medi natural, si té o no habilitat especial, imatge i si estàn llestos per lluitar.

Req08. OPCIONALMENT, les criatures poden tenir armes o armadures que beneficien el seu estat

Req09. Atac oscila entre 0 i 10

Req10. Defensa oscila entre 1 i 10

Req11. Si la criatura no té habilitat especial, la suma màxima entre atac i defensa és 11. Si en té, no pot ser més gran que 9

Req12: Per veure si un pj mata a un altre caldra analitza si l'atac del primer és més gran que la defensa del segon.

Req13: Els duels tindran 3 casuístiques, els dos pj moren, un mor i l'altre sobreviu o sobreviuen els dos.

Req14: Cada combat té lloc en un terreny, si coincideix amb el medi natural d'algun dels jugadors aquest es veure afavorit.

Req15: Cada jugador tindra una habilitat especial.

Req16: Hi hauran dos habilitats especials: velocitat extrema,la potencia d'atac s'aplicara sobre els punts de defensa primer aixi si el venç l'altre jugador ja no atacara, i l'atac d'en kaito, quan un jugador té aquesta habilitat la potència d'atac se li incrementarà en un valor aleatori entre 1 i 3.

Req17: Als combats en grup, cal fer lluitar equips amb el mateix número d'integrants.

Req18: En el moment que un dels equips quedi amb una inferioritat evident (>1 o >2) perdra automaticament.

Req19: El potencial del equip es calcualara fent servir la potència d'atac i dedefensa, i les armes si existeixen.

Req20: El potencial s'ha de representar de manera visual per cada equip.

Req21. El medi especialista d'un equip és aquell medi que més integrants té.

Req22. De cada equip guardarem a la BBDD: el nom, potencial, integrants i medi especilista.

Req23. Un PJ, durant el combat, només pot pertanyer a un equip o a cap.

Req24. Cada PJ té un rànquing del total de victories/derrotes.

Req25. S'ha de poder consultar els rànquins de tots els PJ.

  ----------OPERACIONS USUARIS-----------

Alta / Modificació / Eliminació / Llistat / 

Cerca per nom de criatura, raça, filtrat per potència d'atac i/o defensa, medi natural, i habilitat especial.

Cerca per codi de sistema de seguretat. 

L'alta d'un equip de combat comporta assignar-li els personatges / criatures que el conformen.

Cerca de l'historial de combats entre personatges / criatures.

Dur un personatge / criatura a combatre. (se li assignarà un PJ oponent automàticament de la llista de PJ's dels demés usuaris).

Dur un personatge / criatura a combatre. (se li assignarà un grup oponent automàticament de la llista de PJ's dels demés usuaris)
	
----------OPERACIONS ADMINISTRADOR-----------

Operacions d'usuaris + cerca d'usuaris
	

try {
            Connection conn = obtenirConnexio();
            Statement stat = conn.createStatement();
            stat.executeUpdate("INSERT INTO Jugador VALUES('"+nom+"','"+pass+"','"+lema+"',0,0,0)");
            conn.close();
        } catch (SQLException ex) {
            for (Throwable t : ex)
                t.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

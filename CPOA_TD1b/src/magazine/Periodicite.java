package magazine;
import java.sql.*;

public class Periodicite extends Connexion {
	
	public void inserePeriode(){
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		PreparedStatement req;
		try {
			req = laConnexion.prepareStatement("insert into periodicite (id_periodicite, libelle) values(?, ?)",
					 Statement.RETURN_GENERATED_KEYS);
			
			req.setInt(1, 6);
			req.setString(2, "Annuel");
			

			req.executeQuery();
			
			
		} catch (SQLException sqle) {
			System.out.println("Pas connecté" + sqle.getMessage());
			
		
		}
		
		
		}
	
}

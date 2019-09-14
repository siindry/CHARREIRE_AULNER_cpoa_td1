package periodicite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion {
	

	public Connection creeConnexion() {
		String url = 
				"jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/charreir2u_bd_cpoa1";
		
		
		
		url += "?serverTimezone=Europe/Paris";
		
		
		String login = "charreir2u_appli";
		String pwd = "31806933"; 
		Connection maConnexion = null;
		
		try { 
			maConnexion = DriverManager.getConnection(url, login, pwd);
			} catch (SQLException sqle) {
				System.out.println("Erreur connexion!" + sqle.getMessage());
				}
		return maConnexion;
		
		
		}
	
	public void inserePeriode() {
		try {
			Connection laConnexion = creeConnexion();
			Statement modif = laConnexion.createStatement();
			modif.executeUpdate("INSERT INTO Periodicite" + "VALUES (6, 'Annuel')");
			
			} catch (SQLException sqle) {
				System.out.println("Pb select" + sqle.getMessage());
				}
		}
}

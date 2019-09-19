package magazine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Client {
	
	public void choixClient() {
		
		
		System.out.println("Que souhaitez-vous faire sur la table Client: \n 1.Ajouter \n 2.Modifier "
				+ "\n 3.Supprimer \n 4.Sélectionner");
		
		Scanner sc = new Scanner(System.in);
		
		String choix = sc.nextLine();
		switch(choix) {
		case "1": this.insereClient();
			break;
		case "2": this.modifClient();
			break;
		case "3": this.suppClient();
			break;
		case "4": this.selectClient();
			break;
		default: System.out.println("Entrée inconnue");
		
		}
		
		
	}
	
	/*public int rechIdPeriode(String a) {
		
		int sauv = 0;
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select id_periodicite from Periodicite where libelle=?");
					requete.setString(1, a);
					ResultSet res = requete.executeQuery();
					
			
	
			while(res.next()) {

			    int id  = res.getInt("id_periodicite");
			    sauv = id;
			    System.out.println("id : " + id );
				
		    }

					

			
		if (laConnexion != null) {
			System.out.println("Fermeture de la co réussie! ");
			laConnexion.close();
			
		}	
		} catch (SQLException sqle) {
			System.out.println("Pas connecté" + sqle.getMessage());
			
		
		}
		
		return sauv;
	}*/
	
	public void tableClient() {
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select * from Client");
					ResultSet res = requete.executeQuery();
					
			
	
			while(res.next()) {

				String id  = res.getString("id_client");
			    System.out.println("id : " + id );
			    
			    String nom  = res.getString("nom");
			    System.out.println("nom : " + nom );
			    
			    String pre  = res.getString("prenom");
			    System.out.println("prenom : " + pre );
			    
			    String nrue  = res.getString("no_rue");
			    System.out.println("no_rue : " + nrue );
			    
			    String voie  = res.getString("voie");
			    System.out.println("voie : " + voie );
			    
			    String code_p  = res.getString("code_postal");
			    System.out.println("code_postal : " + code_p);
			    
			    String ville  = res.getString("ville");
			    System.out.println("ville : " + ville);
			    
			    String pays  = res.getString("pays");
			    System.out.println("pays : " + pays);
			    
				
		    }

					

			
		if (laConnexion != null) {
			System.out.println("Fermeture de la co réussie! ");
			laConnexion.close();
			
		}	
		} catch (SQLException sqle) {
			System.out.println("Pas connecté" + sqle.getMessage());
			
		
		}
		
	}
	
	
	
	
	
	public void insereClient(){
		
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		System.out.println("Entrez une information par ligne ces informations suivantes : nom, prenom, no de rue\n , voie, code postal, ville, pays dans l'ordre et en commencant par une maj :");
		
		Scanner sc = new Scanner(System.in);
		
		String nom = sc.nextLine();
		String prenom = sc.nextLine();
		String no_rue = sc.nextLine();
		String voie = sc.nextLine();
		String code_p = sc.nextLine();
		String ville = sc.nextLine();
		String pays = sc.nextLine();
		
		
		try {
			
			
			
    
		    PreparedStatement req = laConnexion.prepareStatement("insert into Client (nom, prenom, no_rue, voie, code_postal, ville, pays) values(?,?,?,?,?,?,?)",
					 Statement.RETURN_GENERATED_KEYS);
			
			req.setString(1, nom);
			req.setString(2, prenom);
			req.setString(3, no_rue);
			req.setString(4, voie);
			req.setString(5, code_p);
			req.setString(6, ville);
			req.setString(7, pays);

			int i = req.executeUpdate();
			System.out.println("ligne touché : " + i);
			
			if (laConnexion != null) {
				System.out.println("Fermeture réussie! ");
				laConnexion.close();
			}

		
				
		} catch (SQLException sqle) {
			System.out.println("Pas connecté" + sqle.getMessage());
			
		
		}
		
		System.out.println("done");
		
		
			} 
		
		
		
	
	public void suppClient(){
		
		this.tableClient();
		
		System.out.println("Mettez le numéro de la Client que vous souhaitez supprimer?");
		
		Scanner sc = new Scanner(System.in);
		
		String id = sc.nextLine();
		
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement req = laConnexion.prepareStatement("delete from Client where id_Client=?");
				
			req.setString(1, id); // 1 correspond au 1er para du where

			int i = req.executeUpdate();
			System.out.println("ligne touché : " + i);
			
		if (laConnexion != null) {
			System.out.println("Fermeture réussie! ");
			laConnexion.close();
			
		}	
		} catch (SQLException sqle) {
			System.out.println("Pas connecté" + sqle.getMessage());
			
		
		}
		
		System.out.println("done");
		
		
		}
	
	
	
	public void selectClient() {
		
		System.out.println("Voici le tableau des Clients :");
		this.tableClient();
		
		System.out.println("Mettez le numéro pour le titre que vous voulez choisir ?");
		
		Scanner sc = new Scanner(System.in);
		
		String titre = sc.nextLine();
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select * from Client where titre=?");
					requete.setString(1, titre);
					ResultSet res = requete.executeQuery();
					
			
					
		    while(res.next()) {
		    	
		    	String id  = res.getString("id_Client");
			    System.out.println("id : " + id );
			    
			    String tit  = res.getString("titre");
			    System.out.println("titre : " + tit );
			    
			    String desc  = res.getString("description");
			    System.out.println("description : " + desc );
			    
			    String tar  = res.getString("tarif_numero");
			    System.out.println("tarif : " + tar );
			    
			    String visu  = res.getString("visuel");
			    System.out.println("visuel : " + visu );
			    
			    String id_p  = res.getString("id_periodicite");
			    System.out.println("id_periodicite : " + id_p + "\n");
		    }
		    
		    
		    
		    
			
		if (laConnexion != null) {
			System.out.println("Fermeture de la co réussie! ");
			laConnexion.close();
			
		}	
		} catch (SQLException sqle) {
			System.out.println("Pas connecté" + sqle.getMessage());
			
		
		}
		
		
	}
	
	
	
	
	public void modifClient(){
			
			System.out.println("Quel donnée de Client souhaitez-vous modifier ? \n Entrer son titre puis sa description");
			
			Scanner sc = new Scanner(System.in);
			
			String titre = sc.nextLine();
			String desc = sc.nextLine();
			
			
			System.out.println("Avec quel mot souhaiter vous remplacer le titre :'" + titre + "' et la description : '" + desc + "' ?");
			
			String titre_ap = sc.nextLine();
			String desc_ap = sc.nextLine();
			
			Connexion connection = new Connexion();
			Connection laConnexion = connection.creeConnexion();
			
			try {
				PreparedStatement req = laConnexion.prepareStatement("update Client set titre=?, description=? where titre=? and description=?");
					
				req.setString(1, titre_ap); // 1 correspond au 1er para du where
				req.setString(2, desc_ap);
				req.setString(3, titre);
				req.setString(4, desc);
	
				int i = req.executeUpdate();
				System.out.println("ligne touché : " + i);
				
			if (laConnexion != null) {
				System.out.println("Fermeture réussie! ");
				laConnexion.close();
				
			}	
			} catch (SQLException sqle) {
				System.out.println("Pas connecté" + sqle.getMessage());
				
			
			}
			
			System.out.println("done");
			
			
	
}
}

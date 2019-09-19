package magazine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import magazine.Revue;

public class Revue {

	//doit contenir les fonctions : insérer, supprimer, selectionner
	
		private String titre;
		private String description;
		private String visuel;
		private int id_Revue;
		private float tarif_num;
		private int sauv;
		
		
		public Revue(String titre, String description, float tarif_num, String visuel, int id_Revue) {
			this.titre = titre;
			this.description = description;
			this.tarif_num = tarif_num;
			this.visuel = visuel;
			this.id_Revue = id_Revue;
			
		}
		
		public void choixRevue() {
			
			
			System.out.println("Que souhaitez-vous faire sur la table Revue: \n 1.Ajouter \n 2.Modifier "
					+ "\n 3.Supprimer \n 4.Sélectionner");
			
			Scanner sc = new Scanner(System.in);
			
			String choix = sc.nextLine();
			switch(choix) {
			case "1": this.insereRevue();
				break;
			case "2": this.modifRevue();
				break;
			case "3": this.suppRevue();
				break;
			case "4": this.selectRevue();
				break;
			default: System.out.println("Entrée inconnue");
			
			}
			
			
		}
		
		public int rechIdPeriode(String a) {
			
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
		}
		
		public void tableRevue() {
			
			Connexion connection = new Connexion();
			Connection laConnexion = connection.creeConnexion();
			
			try {
				PreparedStatement requete = laConnexion.prepareStatement("select * from Revue");
						ResultSet res = requete.executeQuery();
						
				
		
				while(res.next()) {
	
					String id  = res.getString("id_revue");
				    System.out.println("id : " + id );
				    
				    String titre  = res.getString("titre");
				    System.out.println("titre : " + titre );
				    
				    String desc  = res.getString("description");
				    System.out.println("description : " + desc );
				    
				    String tar  = res.getString("tarif_numero");
				    System.out.println("tarif : " + tar );
				    
				    String visu  = res.getString("visuel");
				    System.out.println("visuel : " + visu );
				    
				    String id_p  = res.getString("id_periodicite");
				    System.out.println("id_periodicite : " + visu + "\n");
					
			    }

						

				
			if (laConnexion != null) {
				System.out.println("Fermeture de la co réussie! ");
				laConnexion.close();
				
			}	
			} catch (SQLException sqle) {
				System.out.println("Pas connecté" + sqle.getMessage());
				
			
			}
			
		}
		
		
		
		
		
		public void insereRevue(){
			
			
			Connexion connection = new Connexion();
			Connection laConnexion = connection.creeConnexion();
			
			System.out.println("Entrez une information par ligne ces informations suivantes : titre, description, tarif du nemoro, visuel, son type periodicite commencant par une maj :");
			
			Scanner sc = new Scanner(System.in);
			
			String titre = sc.nextLine();
			String desc = sc.nextLine();
			String tar = sc.nextLine();
			String vis = sc.nextLine();
			String type_p = sc.nextLine();
			
			double tarif = Float.parseFloat(tar);
			
			try {
				
				
				
	    
			    PreparedStatement req = laConnexion.prepareStatement("insert into Revue (titre, description, tarif_numero, visuel, id_periodicite) values(?,?,?,?,?)",
						 Statement.RETURN_GENERATED_KEYS);
				
				req.setString(1, titre);
				req.setString(2, desc);
				req.setDouble(3, tarif);
				req.setString(4, vis);
				req.setInt(5, this.rechIdPeriode(type_p));

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
			
			
			
		
		public void suppRevue(){
			
			this.tableRevue();
			
			System.out.println("Mettez le numéro de la revue que vous souhaitez supprimer?");
			
			Scanner sc = new Scanner(System.in);
			
			String id = sc.nextLine();
			
			
			Connexion connection = new Connexion();
			Connection laConnexion = connection.creeConnexion();
			
			try {
				PreparedStatement req = laConnexion.prepareStatement("delete from Revue where id_revue=?");
					
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
		
		
		
		public void selectRevue() {
			
			System.out.println("Voici le tableau des revues :");
			this.tableRevue();
			
			System.out.println("Mettez le numéro pour le titre que vous voulez choisir ?");
			
			Scanner sc = new Scanner(System.in);
			
			String titre = sc.nextLine();
			
			Connexion connection = new Connexion();
			Connection laConnexion = connection.creeConnexion();
			
			try {
				PreparedStatement requete = laConnexion.prepareStatement("select * from Revue where titre=?");
						requete.setString(1, titre);
						ResultSet res = requete.executeQuery();
						
				
						
			    while(res.next()) {
			    	
			    	String id  = res.getString("id_revue");
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
		
		
		
		
		public void modifRevue(){
				
				System.out.println("Quel donnée de Revue souhaitez-vous modifier ? \n Entrer son titre puis sa description");
				
				Scanner sc = new Scanner(System.in);
				
				String titre = sc.nextLine();
				String desc = sc.nextLine();
				
				
				System.out.println("Avec quel mot souhaiter vous remplacer le titre :'" + titre + "' et la description : '" + desc + "' ?");
				
				String titre_ap = sc.nextLine();
				String desc_ap = sc.nextLine();
				
				Connexion connection = new Connexion();
				Connection laConnexion = connection.creeConnexion();
				
				try {
					PreparedStatement req = laConnexion.prepareStatement("update Revue set titre=?, description=? where titre=? and description=?");
						
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

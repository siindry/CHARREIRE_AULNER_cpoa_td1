package magazine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Revue extends Connexion {
	

	
	String nom_revue;
	
	public Revue(String nom_revue) {
		this.nom_revue = nom_revue;
	}
	

	public String getNom_periodicite() {
		return nom_revue;
	}

	public void setNom_periodicite(String nom_revue) {
		this.nom_revue = nom_revue;
	}
	
	
	public void choixRevue() {
		
		System.out.println("Que souhaitez-vous faire sur la table Revue: \n 1.Ajouter \n 2.Modifier "
				+ "\n 3.Supprimer \n 4.Sélectionner");
		
		Scanner sc = new Scanner(System.in);
		
		String choix = sc.nextLine();
		switch(choix) {
		case "1": this.insereRevue();
			break;
		//case 2: this.modifRevue();
			//break;
		case "3": this.suppRevue();
			break;
		//case 4: this.selectRevue();
			//break;
		default: System.out.println("Entrée inconnue");
		
		}
}
		
		public void insereRevue() {
			
			Connexion connection = new Connexion();
			Connection laConnexion = connection.creeConnexion();
			
			System.out.println("Quelle Revue souhaitez-vous ajouter ?");
			
			Scanner sc = new Scanner(System.in);
			
			String nom = sc.nextLine();
			String descrip = sc.nextLine();
			float tarif = sc.nextFloat();
			
			
			try {
				PreparedStatement req = laConnexion.prepareStatement("insert into Revue (titre, description, tarif_numero) value(?,?,?)",
						 Statement.RETURN_GENERATED_KEYS);
				
				req.setString(1, nom);
				req.setString(2, descrip);
				req.setFloat(3, tarif);
				//visuel
				//id_periodicite ! 
				
				

				int i = req.executeUpdate();
				System.out.println("ligne touché : " + i);
				
				
			} catch (SQLException sqle) {
				System.out.println("Pas connecté" + sqle.getMessage());
				
			
			}
			
			System.out.println("done");
			
			
		}
		
		public void suppRevue(){
			
			System.out.println("Quelle Revue souhaitez-vous supprimer ?");
			
			Scanner sc = new Scanner(System.in);
			
			String nom = sc.nextLine();
			
			Connexion connection = new Connexion();
			Connection laConnexion = connection.creeConnexion();
			
			try {
				PreparedStatement req = laConnexion.prepareStatement("delete from Revue where titre=?");
					
				req.setString(1, nom); // 1 correspond au 1er para du where
				

				int i = req.executeUpdate();
				System.out.println("ligne touché : " + i);
				
				
			} catch (SQLException sqle) {
				System.out.println("Pas connecté" + sqle.getMessage());
				
			
			}
			
			System.out.println("done");
			
			
			}
		

}

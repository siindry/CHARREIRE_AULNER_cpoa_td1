package magazine;
import java.sql.*;
import java.util.Scanner;

public class Periodicite extends Connexion {
	
	//doit contenir les fonctions : insérer, supprimer, selectionner
	
	private String nom_periodicite;
	
	
	public Periodicite(String nom_periodicite) {
		this.nom_periodicite = nom_periodicite;
	}
	

	public String getNom_periodicite() {
		return nom_periodicite;
	}

	public void setNom_periodicite(String nom_periodicite) {
		this.nom_periodicite = nom_periodicite;
	}




	public void choixPeriode() {
		
		
		System.out.println("Que souhaitez-vous faire sur la table Periodicité: \n 1.Ajouter \n 2.Modifier "
				+ "\n 3.Supprimer \n 4.Sélectionner");
		
		Scanner sc = new Scanner(System.in);
		
		String choix = sc.nextLine();
		switch(choix) {
		case "1": this.inserePeriode();
			break;
		//case 2: this.modifPeriode();
			//break;
		case "3": this.suppPeriode();
			break;
		//case 4: this.selectPeriode();
			//break;
		default: System.out.println("Entrée inconnue");
		
		}
		
		
	}
	
	public void inserePeriode(){
		
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		System.out.println("Quel type de periodicité souhaitez-vous ajouter ?");
		
		Scanner sc = new Scanner(System.in);
		
		String nom = sc.nextLine();
		
		try {
			PreparedStatement req = laConnexion.prepareStatement("insert into Periodicite (libelle) value(?)",
					 Statement.RETURN_GENERATED_KEYS);
			
			req.setString(1, nom);
			

			int i = req.executeUpdate();
			System.out.println("ligne touché : " + i);
			
			
		} catch (SQLException sqle) {
			System.out.println("Pas connecté" + sqle.getMessage());
			
		
		}
		
		System.out.println("done");
		
		
		}
	
	public void suppPeriode(){
		
		System.out.println("Quel type de periodicité souhaitez-vous supprimer ?");
		
		Scanner sc = new Scanner(System.in);
		
		String nom = sc.nextLine();
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement req = laConnexion.prepareStatement("delete from Periodicite where libelle=?");
				
			req.setString(1, nom); // 1 correspond au 1er para du where
			

			int i = req.executeUpdate();
			System.out.println("ligne touché : " + i);
			
			
		} catch (SQLException sqle) {
			System.out.println("Pas connecté" + sqle.getMessage());
			
		
		}
		
		System.out.println("done");
		
		
		}
	
}

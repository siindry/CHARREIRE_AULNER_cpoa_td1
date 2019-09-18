package magazine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Abonnement extends Connexion{

	
	
	//fonctions:
		public void choixAbo() {
			
			
			System.out.println("Que souhaitez-vous faire sur la table Abonnement: \n 1.Ajouter \n 2.Modifier "
					+ "\n 3.Supprimer \n 4.Sélectionner");
			
			Scanner sc = new Scanner(System.in);
			
			String choix = sc.nextLine();
			switch(choix) {
			case "1": this.insereAbo();
				break;
			//case 2: this.modifPeriode();
				//break;
			case "3": this.suppAbo();
				break;
			//case 4: this.selectPeriode();
				//break;
			default: System.out.println("Entrée inconnue");
			
			}
			
			
		}
		
		public void insereAbo(){
			
			
			Connexion connection = new Connexion();
			Connection laConnexion = connection.creeConnexion();
			
			System.out.println("Quel type de periodicité souhaitez-vous ajouter ?");
			
			Scanner sc = new Scanner(System.in);
			
			int idCl = sc.nextInt();
			int idRev = sc.nextInt();
			int dateDeb = sc.nextInt(); //chercher type!!!
			int dateFin = sc.nextInt();
			
			try {
				PreparedStatement req = laConnexion.prepareStatement("insert into Abonnement (id_client, id_revue, date_debut, date_fin) value(?,?,?,?)",
						 Statement.RETURN_GENERATED_KEYS);
				
				req.setInt(1, idCl);
				req.setInt(1, idRev);
				req.setInt(1, dateDeb);
				req.setInt(1, dateFin);
				
				

				int i = req.executeUpdate();
				System.out.println("ligne touché : " + i);
				
				
			} catch (SQLException sqle) {
				System.out.println("Pas connecté" + sqle.getMessage());
				
			
			}
			
			System.out.println("done");
			
			
			}
		
		public void suppAbo(){
			
			System.out.println("Quel type de Abonnement (avec id_client) souhaitez-vous supprimer ?");
			
			Scanner sc = new Scanner(System.in);
			
			String idCl = sc.nextLine();
			
			Connexion connection = new Connexion();
			Connection laConnexion = connection.creeConnexion();
			
			try {
				PreparedStatement req = laConnexion.prepareStatement("delete from  where id_client=?");
					
				req.setString(1, idCl); // 1 correspond au 1er para du where
				

				int i = req.executeUpdate();
				System.out.println("ligne touché : " + i);
				
				
			} catch (SQLException sqle) {
				System.out.println("Pas connecté" + sqle.getMessage());
				
			
			}
			
			System.out.println("done");
			
			
			}
}

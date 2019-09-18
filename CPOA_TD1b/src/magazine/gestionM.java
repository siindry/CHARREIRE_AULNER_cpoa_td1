package magazine;

import java.util.Scanner;

public class gestionM {

	public static void main(String[] args) {
		System.out.println("Choisissez une table à éditer : \n 1. Periodicité \n 2.Revue \n "
				+ "3.Client \n 4.Abonnement");
		
		Scanner sc = new Scanner(System.in);
		
		String choix = sc.nextLine();
		
		switch(choix) {
		case "1": Periodicite p1 = new Periodicite ("");
								p1.choixPeriode();
			break;
		case "2": Revue r1 = new Revue("");
							r1.choixRevue();
			break;
		/*case 3: choixClient();
			break;
		case 4: choixAbo();
			break;*/
		default: System.out.println("Entrée inconnue");
		
		}
		
		
		
		System.out.println("Bonsoir");
	}

}

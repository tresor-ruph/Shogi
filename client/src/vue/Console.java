/**
 * @author Tekadam Tresor
 * @author Joachim Sanglier
 * @author Fantuzzi Sebastien
 */
package vue;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import controller.Controller;
import modele.Partie;
import modele.Plateau;

public class Console extends Vue implements Observer {

	protected Scanner sc;
	// Plateau pat = new Plateau();

	public Console(Partie model, Controller control) {
		super(model, control);
		sc = new Scanner(System.in);
		// this.afficher(modele.Plateau.tableau);
		model.setjouer(true);
	}

	public void afficher(char[][] tab) {

		for (int i = 0; i < 9; i++) {
			System.out.print("   " + i);
		}
		System.out.println();
		System.out.println();
		System.out.println(" -------------------------------------");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				System.out.print(" | " + tab[i][j]);
			}
			System.out.print(" | ");
			System.out.println(" " + i);
			System.out.println(" -------------------------------------");
		}
		System.out.println();
	}

	/*
	 * La methode update mettra notre tableau a jour apres chaque deplacement
	 * 
	 */
	@Override
	public void update(Observable o, Object arg) {

		if (model.getjouer() == true) {
			this.afficher(Plateau.tableau);
			if (Partie.getPlayer() % 2 == 1) {
				new Thread(new ReadInput()).start();
			} else {
				System.out.println("En attente de reponse du joueur 1");
			}
		}
	}

	private class ReadInput implements Runnable {

		/*
		 * x , y, x2 ,y2 sont des intergers entre 0 et 8 x et yelle represente les
		 * coordonnées de la piece que nous voulons deplacer x2 et y2 represente les
		 * coordonnées de la casse de destination
		 */

		public void run() {
			try {
				// model.setjouer(false);
				// try {
				do {
					System.out.println("Deplacer De :");
					System.out.print("Y :");
					int x = sc.nextInt();
					control.fixX(x);
				} while (control.verif(model.getX()) == false);
				do {
					System.out.print("X :");
					int y = sc.nextInt();
					control.fixY(y);
					System.out.println();
				} while (control.verif(model.getY()) == false);
				do {
					System.out.println("Deplacer A :");
					System.out.print("Y :");
					int x2 = sc.nextInt();
					control.fixX2(x2);
				} while (control.verif(model.getX2()) == false);
				do {
					System.out.print("X :");
					int y2 = sc.nextInt();
					control.fixY2(y2);
					System.out.println();
					model.jouer();
					//model.setjouer(true);
				} while (control.verif(model.getY2()) == false);
				// model.setjouer(true);
				/*
				 * }catch(Exception e) { System.out.println("tableau a jour"); }
				 */
			} catch (Exception e) {
				System.out.println();
			}
		}
	}
}
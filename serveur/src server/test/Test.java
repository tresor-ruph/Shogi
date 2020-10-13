/**
 * @author Tekadam Tresor
 * @author Joachim Sanglier
 * @author Fantuzzi Sebastien
 */
package test;
import modele.Partie;
import modele.Plateau;
import socket.Serveur;

import java.io.IOException;

import controller.Controller;
import vue.Console;
import vue.Echequier;

public class Test{
	

	public static void main(String args[]) {
		new Plateau();
		Partie model = new Partie();
		Controller controllConsole = new Controller(model);
		Console vueConsole = new Console(model,controllConsole);
		Echequier vueInterface = new Echequier(model,controllConsole);

		Serveur serv = new Serveur();
			try {
				serv.serveur();
			} 
			catch (InterruptedException | IOException e1) {
				System.out.println("une erreur c'est produit lors de la connexion");
			}
		model.jouer();
	}
}
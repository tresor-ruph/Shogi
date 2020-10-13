/**
 * @author Tekadam Tresor
 * @author Joachim Sanglier
 * @author Fantuzzi Sebastien
 */
package modele;

import java.util.Scanner;

import socket.Client;
import socket.Serveur;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Observable;

public class Partie extends Observable {

	/*
	 * x et Y sont des interger >= 0 et < 9; Elle represente les coordonnÃ©es des
	 * pieces que on veut deplacer x2 et Y2 sont des >=0 et <9 Elle represente les
	 * coordonneÃ©s de destination
	 *
	 */

	int x, y, x2, y2;
	boolean jouer;
	String joueur1;
	String joueur2;
	public static int player = 11;
	static String messErreur = " ";
	static String message = " ";
	public static int test = 0;

	/**
	 * utilisé pour avoir le message
	 * 
	 * @return message : String
	 */
	public static String getMessage() {
		return message;
	}

	/**
	 * utilisé pour ecrire un message
	 * 
	 * @param message : String
	 */
	public static void setMessage(String message) {
		Partie.message = message;
	}

	/**
	 * utilisé pour avoir le message d'erreur
	 * 
	 * @return mssErreur : String
	 */
	public static String getMessErreur() {
		return messErreur;
	}

	/**
	 * utilisé pour ecrire un message d'erreur
	 * 
	 * @param messErreur String
	 */
	public static void setMessErreur(String messErreur) {
		Partie.messErreur = messErreur;
	}

	/*
	 * player est un int qui peut etre soit paire ou impaire permet de passer le
	 * tour d'un joueur a lautre en fonction de ci elle est paire ou impaire
	 *
	 */

	/**
	 * utilisé pour récuperer le x (coordonnée de depart)
	 * 
	 * @return x : int
	 */
	public int getX() {
		return x;
	}

	/**
	 * utilisé pour mettre le x (coordonnée de depart)
	 * 
	 * @param x : int
	 */
	@SuppressWarnings("deprecation")
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * utilisé pour mettre jouer a bol notifie les observer
	 * 
	 * @param bol : boolean
	 */
	@SuppressWarnings("deprecation")
	public void setjouer(boolean bol) {
		this.jouer = bol;
		setChanged();
		notifyObservers();
	}

	/**
	 * utilisé pour récuperer le y (coordonnée de depart)
	 * 
	 * @erturn y : int
	 */
	public int getY() {
		return y;
	}

	/**
	 * utilisé pour avoir la valeur de jouer
	 * 
	 * @return jouer : boolean
	 */
	public boolean getjouer() {
		return jouer;
	}

	/**
	 * utilisé pour mettre le y (coordonnée de depart)
	 * 
	 * @param y : int
	 */
	@SuppressWarnings("deprecation")
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * utilisé pour récuperer le x2 (coordonnée d'arrivée)
	 * 
	 * @return x2 : int
	 */
	public int getX2() {
		return x2;
	}

	/**
	 * utilisé pour mettre le x2 (coordonnée d'arrivée)
	 * 
	 * @param x2 : int
	 */
	@SuppressWarnings("deprecation")
	public void setX2(int x2) {
		this.x2 = x2;
	}

	/**
	 * utilisé pour récuperer le y2 (coordonnée d'arrivée)
	 * 
	 * @return y2 : int
	 */
	public int getY2() {
		return y2;
	}

	/**
	 * utilisé pour mettre le y2 (coordonnée d'arrivée)
	 * 
	 * @param : y2 : int
	 */
	@SuppressWarnings("deprecation")
	public void setY2(int y2) {
		this.y2 = y2;
	}

	/**
	 * utilisé pour avoir la valeur de joueur1
	 * 
	 * @return joueur1 : String
	 */
	public String getJoueur1() {
		return joueur1;
	}

	/**
	 * utilisé pour modifier la valeur de joueur1
	 * 
	 * @param joueur1 : String
	 */
	@SuppressWarnings("deprecation")
	public void setJoueur1(String joueur1) {
		this.joueur1 = joueur1;
		setChanged();
		notifyObservers();
	}

	/**
	 * utilisé pour avoir la valeur de joueur2
	 * 
	 * @return joueur2 : String
	 */
	public String getJoueur2() {
		return joueur2;
	}

	/**
	 * utilisé pour modifier la valeur de joueur1
	 * 
	 * @param joueur2 : String
	 */
	@SuppressWarnings("deprecation")
	public void setJoueur2(String joueur2) {
		this.joueur2 = joueur2;
		setChanged();
		notifyObservers();
	}

	/**
	 * utilisé pour avoir la valeur de player
	 * 
	 * @return player : int
	 */
	public static int getPlayer() {
		return player;
	}

	/**
	 * utilisé pour modifier la valeur de player
	 * 
	 * @param a : int
	 */
	@SuppressWarnings("deprecation")
	public void setPlayer(int a) {
		Partie.player = player - a;
	}

	/**
	 * fonction qui va appeler le méthode de la pièce selectionnée permettant de
	 * bouger la pièce. Le systeme serveur client est aussi utilisé ici verifie
	 * aussi si la partie est finie
	 * 
	 * 
	 */
	public void jouer() {

		Rois king = new Rois();
		Pion pawn = new Pion();
		Silver argent = new Silver();
		Gold or = new Gold();
		Lance spear = new Lance();
		Fou bishop = new Fou();
		Tour rook = new Tour();
		Cavalier knight = new Cavalier();
		Dragon dragon = new Dragon();
		Cheval cheval = new Cheval();

		if (player % 2 == 1) {

			switch (Plateau.tableau[x][y]) {
			case 'P':
				pawn.pion(x, y, x2, y2);
				break;
			case 'R':
				king.rois(x, y, x2, y2);
				break;
			case 'S':
				argent.silver(x, y, x2, y2);
				break;
			case 'G':
				or.gold(x, y, x2, y2);
				break;
			case 'L':
				spear.lance(x, y, x2, y2);
				break;
			case 'F':
				bishop.fou(x, y, x2, y2);
				break;
			case 'T':
				rook.tour(x, y, x2, y2);
				break;
			case 'C':
				knight.cavalier(x, y, x2, y2);
				break;
			case 'D':
				dragon.dragon(x, y, x2, y2);
				break;
			case 'V':
				cheval.cheval(x, y, x2, y2);
				break;
			case 0:
				Partie.setMessErreur("Aucune piece n'a ete choisie !");
				--player;
				break;
			default:
				Partie.setMessErreur("la piece choisie ne vous appartiens pas veuillez reesayer !");
				--player;
			}
			
			if (Partie.messErreur == " ") {
				new Thread(new server()).start();

				Client cl = new Client();
				String mess = " " + this.getX() + " " + this.getY() + " " + this.getX2() + " " + this.getY2();

				try {
					cl.client(mess);
					System.out.println("message envoye");
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("-----------------------------");
				this.setPlayer(-1);

			} else {
				this.setPlayer(-1);

				System.out.println(Partie.getPlayer());
				System.out.println("le message d'erreur n'est pas null");
				System.out.println(Partie.messErreur);
				Partie.setMessErreur(" ");
			}

			outerloop: for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (Plateau.tableau[i][j] == 'r') {
						break outerloop;
					} else if ((i == 8) && (j == 8)) {
						x = 9;
						Partie.setMessErreur("****Partie Termine !****");
						Partie.setMessErreur("Le Joueur 1 a gagner ");
						test = 1;
						break outerloop;
					}
				}
			}
			this.setjouer(true);

			
		} else {
			System.out.println(Partie.getPlayer());
			Serveur serv = new Serveur();

			int a = Character.getNumericValue(serv.getReponse().charAt(1));
			int b = Character.getNumericValue(serv.getReponse().charAt(3));
			int c = Character.getNumericValue(serv.getReponse().charAt(5));
			int d = Character.getNumericValue(serv.getReponse().charAt(7));
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
			System.out.println(d);

			this.setX(a);
			this.setY(b);
			this.setX2(c);
			this.setY2(d);

			switch (Plateau.tableau[x][y]) {
			case 'r':
				king.rois(x, y, x2, y2);
				break;
			case 'g':
				or.gold(x, y, x2, y2);
				break;
			case 's':
				argent.silver(x, y, x2, y2);
				break;
			case 'l':
				spear.lance(x, y, x2, y2);
				break;
			case 'f':
				bishop.fou(x, y, x2, y2);
				break;
			case 't':
				rook.tour(x, y, x2, y2);
				break;
			case 'x':
				pawn.pion(x, y, x2, y2);
				break;
			case 'c':
				knight.cavalier(x, y, x2, y2);
				break;
			case 'd':
				dragon.dragon(x, y, x2, y2);
				break;
			case 'v':
				cheval.cheval(x, y, x2, y2);
				break;
			case 0:
				Partie.setMessErreur("Aucune piece n'a ete choisie !");
				break;
			default:
				Partie.setMessErreur("la piece choisie ne vous appartiens pas veuillez reesayer !");
				--player;
			}
			outerloop: for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (Plateau.tableau[i][j] == 'R') {
						break outerloop;
					} else {
						if ((i == 8) && (j == 8)) {
							x = 9;
							Partie.setMessErreur("****Partie Termine !****");
							Partie.setMessErreur("Le Joueur 2 a gagner ");
							test=1;
							break outerloop;
						}
					}
				}
			}
			this.setPlayer(-1);
		}
	}

	/**
	 * 
	 */
	private class server implements Runnable {

		Partie model = new Partie();

		/**
		 * 
		 */
		public void run() {

			Serveur serv = new Serveur();
			System.out.println("serveur2 en attende de connexion");
			try {
				serv.serveur();
				System.out.println("serveur 2 connexion etablie");
				System.out.println(serv.getReponse());

				model.jouer();
				setChanged();
				notifyObservers();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
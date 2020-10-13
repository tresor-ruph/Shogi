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

/**
 * @author Tekadam Tresor
 * @author Joachim Sanglier
 * @author Fantuzzi Sebastien
 *
 */
/**
 * @author Tresor
 *
 */
public class Partie extends Observable {
	/*
	 * x et Y sont des interger >= 0 et < 9; Elle represente les coordonnées des
	 * pieces que on veut deplacer x2 et Y2 sont des >=0 et <9 Elle represente les
	 * coordonneés de destination
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
	 * utilis� pour avoir le message
	 * 
	 * @return message : String
	 */
	public static String getMessage() {
		return message;
	}

	public static void setMessage(String message) {
		Partie.message = message;
	}

	public static String getMessErreur() {
		return messErreur;
	}

	public static void setMessErreur(String messErreur) {
		Partie.messErreur = messErreur;
	}

	/**
	 * player est un int qui peut etre soit paire ou impaire permet de passer le
	 * tour d'un joueur a lautre en fonction de ci elle est paire ou impaire
	 *
	 */

	public int getX() {
		return x;
	}

	@SuppressWarnings("deprecation")
	public void setX(int x) {
		this.x = x;
	}

	@SuppressWarnings("deprecation")
	public void setjouer(boolean bol) {
		this.jouer = bol;
		setChanged();
		notifyObservers();
	}

	public int getY() {
		return y;
	}

	public boolean getjouer() {
		return jouer;
	}

	@SuppressWarnings("deprecation")
	public void setY(int y) {
		this.y = y;
	}

	public int getX2() {
		return x2;
	}

	@SuppressWarnings("deprecation")
	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	@SuppressWarnings("deprecation")
	public void setY2(int y2) {
		this.y2 = y2;
		// setChanged();
		// notifyObservers();
	}

	public String getJoueur1() {
		return joueur1;
	}

	@SuppressWarnings("deprecation")
	public void setJoueur1(String joueur1) {
		this.joueur1 = joueur1;
		setChanged();
		notifyObservers();
	}

	public String getJoueur2() {
		return joueur2;
	}

	@SuppressWarnings("deprecation")
	public void setJoueur2(String joueur2) {
		this.joueur2 = joueur2;
		setChanged();
		notifyObservers();
	}

	public static int getPlayer() {
		return player;
	}

	public void setPlayer(int a) {
		Partie.player = player - a;
	}

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
			System.out.println(Partie.getPlayer());

			Serveur serv = new Serveur();
			int a = Character.getNumericValue(serv.getReponse().charAt(1));
			int b = Character.getNumericValue(serv.getReponse().charAt(3));
			int c = Character.getNumericValue(serv.getReponse().charAt(5));
			int d = Character.getNumericValue(serv.getReponse().charAt(7));

			this.setX(a);
			this.setY(b);
			this.setX2(c);
			this.setY2(d);

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
				Partie.setMessErreur("Aucune piece n'a ete choisit !");
				--player;
				break;
			default:
				Partie.setMessErreur("la piece choisis ne vous appartiens pas veiuller reesayer !");
				--player;
			}
			outerloop: for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (Plateau.tableau[i][j] == 'r') {
						break outerloop;
					} else if ((i == 8) && (j == 8)) {
						x = 9;
						Partie.setMessErreur("***Partie Termine !****");
						Partie.setMessErreur("Le Joueur 1 a gagner ");
						test=1;
						break outerloop;
					}
				}
			}
			this.setPlayer(-1);
			this.setjouer(true);
		} else {
			System.out.println(Partie.getPlayer());

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
				Partie.setMessErreur("Aucune piece n'a ete choisit !");
				break;
			default:
				Partie.setMessErreur("la piece choisis ne vous appartiens pas veiuller reesayer !");
				--player;
			}
			
			if (Partie.messErreur == " ") {
				new Thread(new server()).start();

				Client cl = new Client();
				String mess = " " + this.getX() + " " + this.getY() + " " + this.getX2() + " " + this.getY2();
				try {
					cl.client(mess);
					System.out.println("message envoyé");
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.setPlayer(-1);
			} else {
				this.setPlayer(-1);
				System.out.println("le message d'erreur n'est pas null");
				System.out.println(Partie.messErreur);
				Partie.setMessErreur(" ");
			}
			outerloop: for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (Plateau.tableau[i][j] == 'R') {
						break outerloop;
					} else {
						if ((i == 8) && (j == 8)) {
							x = 9;
							Partie.setMessErreur("***Partie Termine !****");
							Partie.setMessErreur("Le Joueur 2 a gagner ");
							test=1;
							break outerloop;
						}
					}
				}
			}
			this.setjouer(true);
			

		}
	}

	private class server implements Runnable {

		Partie model = new Partie();

		public void run() {
			Serveur serv = new Serveur();
			System.out.println("serveur lancé");

			try {
				serv.serveur();
				model.jouer();
				setChanged();
				notifyObservers();

			} catch (InterruptedException e) {
				System.out.println("connextion 1 toujours en cours");
			} catch (IOException e) {
				System.out.println("connextion 1 toujours en cours2");
			}
		}
	}
}
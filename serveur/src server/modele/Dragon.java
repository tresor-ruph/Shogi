/**
 * @author Tekadam Tresor
 * @author Joachim Sanglier
 * @author Fantuzzi Sebastien
 */
package modele;

public class Dragon {

	/**
	 * Est appelle par dragon() et verifie si il y a une piece adverse ou alliee � la destination voulue puis la deplace si c'est bien une piece adverse
	 * 
	 * @param x : int : coordonnee y (depart) entre 0 et 8 inclus
	 * @param y : int : coordonnee x (depart) entre 0 et 8 inclus
	 * @param x2 : int : coordonnee y2 (destination) entre 0 et 8 inclus
	 * @param y2 : int : coordonnee x2 (destination) entre 0 et 8 inclus
	 */
	public boolean bouffer(int x, int y, int x2, int y2) {
		Partie part = new Partie();
		int def = Partie.player;
		if (Plateau.tableau[x2][y2] == 0) {
			Plateau.setTableau(x, y, x2, y2);
		} 
		else {
			if (Partie.player % 2 == 1) {
				for (int i = 0; i < 8; i++) {
					if (Plateau.tableau[x2][y2] == Plateau.piece[i]) {
						Partie.setMessErreur("vous avez deja une piece a cette position !");
						--Partie.player;
						break;
					} 
					else {
						if (Plateau.tableau[x2][y2] == Plateau.piece2[i]) {
							Plateau.setTableau(x, y, x2, y2);
							break;
						}
					}
				}
			} 
			else {
				for (int i = 0; i < 8; i++) {
					if (Plateau.tableau[x2][y2] == Plateau.piece2[i]) {
						Partie.setMessErreur("vous avez deja une piece a cette position !");
						--Partie.player;
						break;
					} 
					else {
						if (Plateau.tableau[x2][y2] == Plateau.piece[i]) {
							Plateau.setTableau(x, y, x2, y2);
							break;
						}
					}
				}
			}
		}
		if (def == Partie.player) {
			return true;
		} 
		else {
			return false;
		}
	}

	/**
	 * Verifie que les coordonnees voulues soient accesibles
	 * 
	 * @param x : int : coordonnee y (depart) entre 0 et 8 inclus
	 * @param y : int : coordonnee x (depart) entre 0 et 8 inclus
	 * @param x2 : int : coordonnee y2 (destination) entre 0 et 8 inclus
	 * @param y2 : int : coordonnee x2 (destination) entre 0 et 8 inclus
	 */
	public void dragon(int x, int y, int x2, int y2) {

		int def = Partie.player;

		/*
		 * coord est un tableau qui contient tout les deplacement possible du roi
		 */

		int[][] coord = { { x - 1, y + 1 }, { x + 1, y + 1 }, { x - 1, y - 1 }, { x + 1, y - 1 } };
		/*
		 * verifie Si la casse de destination est vide sinon on verfie si la piece a
		 * cette casse est un piece alliee dans ce cas un message d'erreur est renvoye
		 * au cas contraire cette piece est bouffé
		 */
		if (Plateau.tableau[x2][y2] == 0) {
			for (int i = 0; i < 4; i++) {
				if ((x2 == coord[i][0]) && (y2 == coord[i][1])) {
					Plateau.setTableau(x, y, x2, y2);
					break;
				} 
				else {
					if (i == 7) {
						Partie.setMessErreur("deplacement non autorisé");
						--Partie.player;
					}
				}
			}
		} else {
			for (int i = 0; i < 8; i++) {
				if (Partie.player % 2 == 1) {
					if (Plateau.tableau[x2][y2] == Plateau.piece[i]) {
						Partie.setMessErreur("vous avez deja une piece a cette position !");
						--Partie.player;
						break;
					} 
					else if (Plateau.tableau[x2][y2] == Plateau.piece2[i]) {
						Plateau.setTableau(x, y, x2, y2);
						break;
					}
				} 
				else {
					/*
					 * Si cest au joueur 2 de jouer
					 */
					if (Partie.player % 2 == 0) {
						if (Plateau.tableau[x2][y2] == Plateau.piece2[i]) {
							Partie.setMessErreur("vous avez deja une piece a cette position !");
							--Partie.player;
							break;
						} 
						else if (Plateau.tableau[x2][y2] == Plateau.piece[i]) {
							Plateau.setTableau(x, y, x2, y2);
							break;
						}
					}
				}
			}
		}
		if (def == Partie.player && (Plateau.tableau[x][y] == 'D' || Plateau.tableau[x][y] == 'd')) {
			System.out.println(Plateau.tableau[x][y - 1]);
			if ((x2 > x) && (y2 == y)) {
				outerloop: for (int i = x + 1; i <= x2; i++) {
							System.out.println("test," + Plateau.tableau[x][i] + "fin");
							if (testP(Plateau.tableau[i][y], i, x2)) {
								System.out.println(Plateau.tableau[i][y]);
								if (x2 == i) {
									bouffer(x, y, x2, y2);
								} 
								else {
									Partie.setMessErreur("deplacement non autoris�");
									--Partie.player;
									break;
								}
							}
						}
			} 
			else if ((x2 < x) && (y2 == y)) {
				outerloop: for (int i = x - 1; i >= x2; i--) {
							System.out.println("test," + Plateau.tableau[x][i] + "fin");
							if (testP(Plateau.tableau[i][y], i, x2)) {
								System.out.println(Plateau.tableau[i][y]);
								if (x2 == i) {
									bouffer(x, y, x2, y2);
								} 
								else {
									Partie.setMessErreur("deplacement non autoris�");
									--Partie.player;
									break;
								}
							}
						}

			} 
			else if ((x2 == x) && (y2 > y)) {
				outerloop: for (int i = y + 1; i <= y2 + 1; i++) {
							System.out.println("test," + Plateau.tableau[x][i] + "fin");
							if (testP(Plateau.tableau[x][i], i, y2)) {
								if (y2 == i) {
									bouffer(x, y, x2, y2);
								} 
								else {
									Partie.setMessErreur("deplacement non autoris�");
									--Partie.player;
									break;
								}
							}
						}

			} 
			else if ((x2 == x) && (y2 < y)) {
				System.out.println(Plateau.tableau[x2][y2]);
				outerloop: for (int i = y - 1; i >= y2; i--) {
							System.out.println("test," + Plateau.tableau[x][i] + "fine");
							char t = (char) ' ';
							if (testP(Plateau.tableau[x][i], i, y2)) {
								System.out.println(Plateau.tableau[x][i]);
								if (y2 == i) {
									bouffer(x, y, x2, y2);
									break;
								} 
								else {
									Partie.setMessErreur("deplacement non autoris�");
									Partie.setMessErreur("tteesstt");
									--Partie.player;
									break;
								}
							}
						}
			}
		}
		if (def == Partie.player && (Plateau.tableau[x][y] == 'D' || Plateau.tableau[x][y] == 'd')) {
			--Partie.player;
		}
		/*
		 * if(Partie.player==def) { if(def%2==1) { if(x2>8) {
		 * Plateau.tableau[x2][y2]='d'; } }else { if(x2<2) {
		 * Plateau.tableau[x2][y2]='D'; } } }
		 */
	}

	/**
	 * @param c : char
	 * @param f : int
	 * @param a : int
	 */
	public boolean testP(char c, int f, int a) {
		boolean b = false;
		for (int i = 0; i < Plateau.piece.length; i++) {
			if (Plateau.piece[i] == c) {
				b = true;
			}
		}
		for (int i = 0; i < Plateau.piece2.length; i++) {
			if (Plateau.piece2[i] == c) {
				b = true;
			}
		}
		if (f == a) {
			b = true;
		}
		return b;
	}
}
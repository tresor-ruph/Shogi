/**
 * @author Tekadam Tresor
 * @author Joachim Sanglier
 * @author Fantuzzi Sebastien
 */
package modele;

/**
 * 
 */
public class Cheval {

	/**
	 * Est appelle par cheval() et verifie si il y a une piece adverse ou alliee à la destination voulue puis la deplace si c'est bien une piece adverse
	 * 
	 * @param x : int : coordonnee y (depart) entre 0 et 8 inclus
	 * @param y : int : coordonnee x (depart) entre 0 et 8 inclus
	 * @param x2 : int : coordonnee y2 (destination) entre 0 et 8 inclus
	 * @param y2 : int : coordonnee x2 (destination) entre 0 et 8 inclus
	 */
	public void bouffer(int x, int y, int x2, int y2) {

		if (Plateau.tableau[x2][y2] == 0) {
			Partie.setMessage(" ");
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
	}

	/**
	 * Verifie que les coordonnees voulues soient accesibles
	 * 
	 * @param x : int : coordonnee y (depart) entre 0 et 8 inclus
	 * @param y : int : coordonnee x (depart) entre 0 et 8 inclus
	 * @param x2 : int : coordonnee y2 (destination) entre 0 et 8 inclus
	 * @param y2 : int : coordonnee x2 (destination) entre 0 et 8 inclus
	 */
	public void cheval(int x, int y, int x2, int y2) {
		
		int[][] coord = { { x, y + 1 }, { x, y - 1 }, { x + 1, y }, { x - 1, y }, };
		int def = Partie.player;

		if (Plateau.tableau[x2][y2] == 0) {
			for (int i = 0; i < 4; i++) {
				if ((x2 == coord[i][0]) && (y2 == coord[i][1])) {
					Plateau.setTableau(x, y, x2, y2);
					break;
				} 
				else {
					if (i == 7) {
						Partie.setMessErreur("deplacement non autorisÃ©");
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
				} else {
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

		if (def == Partie.player && (Plateau.tableau[x][y] == 'V' || Plateau.tableau[x][y] == 'v')) {
			if ((x2 > x) && (y2 > y)) {
				outerloop: for (int i = x + 1, j = y + 1; i <= x2 && j <= y2; i++, j++) {
							System.out.println("test," + Plateau.tableau[i][j] + "fin");
							if (testP(Plateau.tableau[i][j], i, j, x2, y2)) {
								System.out.println(Plateau.tableau[i][y]);
								if (x2 == i && y2 == j) {
									bouffer(x, y, x2, y2);
								} 
								else {
									Partie.setMessErreur("deplacement non autorisé");
									--Partie.player;
									break;
								}
							}
						}
			} 
			else if ((x2 > x) && (y2 < y)) {
				outerloop: for (int i = x + 1, j = y - 1; i <= x2 && j >= y2; i++, j--) {
							System.out.println("test," + Plateau.tableau[i][j] + "fin");
							if (testP(Plateau.tableau[i][j], i, j, x2, y2)) {
								System.out.println(Plateau.tableau[i][y]);
								if (x2 == i && y2 == j) {
									bouffer(x, y, x2, y2);
								} 
								else {
									Partie.setMessErreur("deplacement non autorisé");
									--Partie.player;
									break;
								}
							}
						}
			} 
			else if ((x2 < x) && (y2 < y)) {
				outerloop: for (int i = x - 1, j = y - 1; i >= x2 && j >= y2; i--, j--) {
							System.out.println("test," + Plateau.tableau[i][j] + "fin");
							if (testP(Plateau.tableau[i][j], i, j, x2, y2)) {
								System.out.println(Plateau.tableau[i][y]);
								if (x2 == i && y2 == j) {
									bouffer(x, y, x2, y2);
								} 
								else {
									Partie.setMessErreur("deplacement non autorisé");
									--Partie.player;
									break;
								}
							}
						}
			} 
			else if ((x2 < x) && (y2 > y)) {
				outerloop: for (int i = x - 1, j = y + 1; i >= x2 && j <= y2; i--, j++) {
							System.out.println("test," + Plateau.tableau[i][j] + "fin");
							if (testP(Plateau.tableau[i][j], i, j, x2, y2)) {
								System.out.println(Plateau.tableau[i][y]);
								if (x2 == i && y2 == j) {
									bouffer(x, y, x2, y2);
								} 
								else {
									Partie.setMessErreur("deplacement non autorisé");
									--Partie.player;
									break;
								}
							}
						}
			} 
			else {
				Partie.setMessErreur("deplacement non autorisé");
				--Partie.player;
			}
		}
		if (def == Partie.player && (Plateau.tableau[x][y] == 'V' || Plateau.tableau[x][y] == 'v')) {
			--Partie.player;
		}
	}

	/**
	 * regarde si le char c est vide (alors renvoie false) et si la case correspond au coordonées de destination(alors renvoie true)
	 * 
	 * @param c : char : piece a l'endroit f,a du tableau
	 * @param f int : coordonnées y du tableau
	 * @param fa int : coordonnes y2 du tableau
	 * @param a int : coordonnées x du tableau
	 * @param ya int : coordonnées x2 du tableau
	 */
	public boolean testP(char c, int f, int fa, int a, int ya) {
		
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
		if (f == a && fa == ya) {
			b = true;
		}
		return b;
	}
}
/**
 * @author Tekadam Tresor
 * @author Joachim Sanglier
 * @author Fantuzzi Sebastien
 */
package modele;

public class Lance {

	/**
	 * Est appelle par lance() et verifie si il y a une piece adverse ou alliee � la destination voulue puis la deplace si c'est bien une piece adverse
	 * 
	 * @param x : int : coordonnee y (depart) entre 0 et 8 inclus
	 * @param y : int : coordonnee x (depart) entre 0 et 8 inclus
	 * @param x2 : int : coordonnee y2 (destination) entre 0 et 8 inclus
	 * @param y2 : int : coordonnee x2 (destination) entre 0 et 8 inclus
	 */
	public void bouffer(int x, int y, int x2, int y2) {

		// Plateau tab = new Plateau();

		if (Plateau.tableau[x2][y2] == 0) {
			Plateau.setTableau(x, y, x2, y2);
			/*
			 * Plateau.tableau[x2][y2] = Plateau.tableau[x][y]; Plateau.tableau[x][y] = 0;
			 */
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
		/*
		 * else { for (int i = 0; i < 8; i++) { if (Plateau.tableau[x2][y2] ==
		 * Plateau.piece[i]) {
		 * Partie.setMessErreur("vous avez deja une piece a cette position !");
		 * --Partie.player; break;
		 * 
		 * } else if (Plateau.tableau[x2][y2] == Plateau.piece[i]) {
		 * 
		 * Plateau.setTableau(x, y, x2, y2);
		 * 
		 * break;
		 * 
		 * } } }
		 */
	}

	/**
	 * Verifie que les coordonnees voulues soient accesibles
	 * 
	 * @param x : int : coordonnee y (depart) entre 0 et 8 inclus
	 * @param y : int : coordonnee x (depart) entre 0 et 8 inclus
	 * @param x2 : int : coordonnee y2 (destination) entre 0 et 8 inclus
	 * @param y2 : int : coordonnee x2 (destination) entre 0 et 8 inclus
	 */
	public void lance(int x, int y, int x2, int y2) {

		int def = Partie.player;
		System.out.println(y);
		if (Partie.player % 2 == 1) {
			if ((x2 > x) && (y2 == y)) {// si le deplacement est vertical et vers le bas
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
		} 
		else {
			if ((x2 < x) && (y2 == y)) {// si le deplacement est vertical et vers le bas
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
		}
		if (def == Partie.player && (Plateau.tableau[x][y] == 'L' || Plateau.tableau[x][y] == 'l')) {
			--Partie.player;
		}
		if (Partie.player == def) {
			if (def % 2 == 1) {
				if (x2 > 7) {
					Plateau.tableau[x2][y2] = 'G';
				}
			} 
			else {
				if (x2 < 1) {
					Plateau.tableau[x2][y2] = 'g';
				}
			}
		}
		/*
		 * if (Partie.player % 2 == 1) { for (int i = x + 1; i < x2 + 1; i++) {
		 * 
		 * if ((Plateau.tableau[i][0] != 0)&&(Plateau.tableau[i][0] !=
		 * Plateau.tableau[x2][y2])) {
		 * Partie.setMessErreur("deplacement non autorise !"); --Partie.player; break; }
		 * else if (i == x2) {
		 * 
		 * if ((y2 == 0) && (x2 > x)) { this.bouffer(x, y, x2, y2); break; } else {
		 * Partie.setMessErreur("deplacement non autorisé"); } }
		 * 
		 * }
		 * 
		 * } else {
		 * 
		 * for (int i = x - 1; i > x2 - 1; i++) { if (Plateau.tableau[i][0] != 0) {
		 * Partie.setMessErreur("deplacement non autorisé"); --Partie.player; break; }
		 * else if (i == x2) {
		 * 
		 * if ((y2 == 0) && (x2 < x)) { this.bouffer(x, y, x2, y2);
		 * 
		 * break; } else { Partie.setMessErreur("deplacement non autorisé"); } }
		 * 
		 * }
		 * 
		 * }
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
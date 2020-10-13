/**
 * @author Tekadam Tresor
 * @author Joachim Sanglier
 * @author Fantuzzi Sebastien
 */
package modele;

/**
 * @author Tekadam Tresor Ruphin
 *
 */
public class Plateau {

	/*
	 * variable tablength represente la longeur de notre tableau variable tabWidth
	 * represente la largeur de notre tableau variable tableau est un tableau a 2
	 * dimensions et represente notre echequier variable piece contient les piece du
	 * joueur 1 variable piece 2 contient les piece du joueur 2
	 */
	public static char[][] tableau = new char[9][9];
	public static final char[] piece = { 'L', 'C', 'S', 'G', 'R', 'F', 'T', 'P', 'D', 'V' };
	public static final char[] piece2 = { 'l', 'c', 's', 'g', 'r', 'f', 't', 'x', 'd', 'v' };
	
	public char[] getPiece() {
		return piece;
	}

	public static char[][] getTableau() {
		return tableau;
	}

	public static void setTableau(int x, int y, int x2, int y2) {
		Plateau.tableau[x2][y2] = Plateau.tableau[x][y];
		Plateau.tableau[x][y] = 0;
	}

	public char[] getPiece2() {
		return piece2;
	}

	/*
	 * cette methode va disposer les pieces dans les cases met chaque element de
	 * notre table piece et piece2 dans une case
	 */
	public Plateau() {

		for (int i = 2; i < 9; i += 4) {
			for (int j = 0; j < 9; j++) {
				if (i == 2) {
					tableau[i][j] = piece[7];
				} 
				else if (i == 6) {
					tableau[i][j] = piece2[7];
				} 
				else {
					tableau[i][j] = ' ';
				}
			}
		}
		for (int i = 0; i < 9; i += 8) {
			int k = 9;
			for (int j = 0; j < 9; j++) {
				if (i == 0) {
					k--;
					if (j < 5) {
						tableau[i][j] = piece[j];
					} 
					else if ((j >= 5) && (j < 9)) {
						tableau[i][j] = piece[k];
					} 
					else {
						tableau[i][j] = piece[2];
					}
				}
				else {
					k--;
					if (j < 5) {
						tableau[i][j] = piece2[j];
					} 
					else if ((j >= 5) && (j < 9)) {
						tableau[i][j] = piece2[k];
					} 
					else {
						tableau[i][j] = piece2[2];
					}
				}
			}
		}
		tableau[1][1] = piece[5];
		tableau[1][7] = piece[6];

		tableau[7][1] = piece2[5];
		tableau[7][7] = piece2[6];
	}
}
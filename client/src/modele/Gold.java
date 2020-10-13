/**
 * @author Tekadam Tresor
 * @author Joachim Sanglier
 * @author Fantuzzi Sebastien
 */
package modele;


public class Gold {

	/**
	 * Deplace le gold selon les coordonnees de depart (x,y) vers les coordonnes voulues (x2,y2)
	 * Verifie que les coordonnees voulues soient accesibles
	 * remplace la piece de l'adversaire si ce dernier etait sur la destination voulue
	 * 
	 * @param x : int : coordonnee y (depart) entre 0 et 8 inclus
	 * @param y : int : coordonnee x (depart) entre 0 et 8 inclus
	 * @param x2 : int : coordonnee y2 (destination) entre 0 et 8 inclus
	 * @param y2 : int : coordonnee x2 (destination) entre 0 et 8 inclus
	 */
	public void gold(int x, int y, int x2, int y2) {
		
		/*
		 * coord est un tableau qui contient tout les deplacement possible du Gold
		 */
		int def = Partie.player;
		int[][] coord = { { x, y + 1 }, { x, y - 1 }, { x + 1, y }, { x - 1, y }, { x + 1, y + 1 }, { x + 1, y - 1 } };
		int[][] coord2 = { { x, y + 1 }, { x - 1, y + 1 }, { x, y - 1 }, { x + 1, y }, { x - 1, y }, { x - 1, y - 1 } };
		
		if (Plateau.tableau[x2][y2] == 0) {
			for (int i = 0; i < 6; i++) {
				/*
				 * on parcoure le tableau des movements possible et on verifie ci les
				 * coordonnees de destination appartiennent a ce tableau si oui on fait le
				 * deplacement si non un message d'erreur est renvoyé
				 */
				if (((x2 == coord[i][0]) && (y2 == coord[i][1])) || ((x2 == coord2[i][0]) && (y2 == coord2[i][1]))) {
					Plateau.setTableau(x, y, x2, y2);
					break;
				} /*
					 * else { if (i == 7) { Partie.setMessErreur("deplacement non autorisé");
					 * --Partie.player; } }
					 */
			}
		} 
		else {
			for (int i = 0; i < Plateau.piece.length; i++) {
				/*
				 * Si cest au joueur 1 de jouer
				 */
				if (Partie.player % 2 == 1) {
					// new Plateau();
					if (Plateau.tableau[x2][y2] == Plateau.piece[i]) {
						Partie.setMessErreur("vous avez deja une piece a cette position !");
						--Partie.player;
						break;
					} 
					else {
						// new Plateau();
						if (Plateau.tableau[x2][y2] == Plateau.piece2[i]) {
							Partie.setMessage(" ");
							Plateau.setTableau(x, y, x2, y2);
						}
					}
				} 
				else {
					// new Plateau();
					/*
					 * Si cest au joueur 2 de jouer
					 */
					if (Plateau.tableau[x2][y2] == Plateau.piece2[i]) {
						Partie.setMessErreur("vous avez deja une piece a cette position !");
						--Partie.player;
						break;
					} 
					else {
						// new Plateau();
						if (Plateau.tableau[x2][y2] == Plateau.piece[i]) {
							Partie.setMessage(" ");
							Plateau.setTableau(x, y, x2, y2);
						}
					}
				}
			}
		}
		if (def == Partie.player && (Plateau.tableau[x][y] == 'G' || Plateau.tableau[x][y] == 'g')) {
			--Partie.player;
		}
	}
}
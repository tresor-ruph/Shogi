/**
 * @author Tekadam Tresor
 * @author Joachim Sanglier
 * @author Fantuzzi Sebastien
 */
package modele;

public class Silver {

	/**
	 * Deplace le silver selon les coordonnees de depart (x,y) vers les coordonnes voulues (x2,y2)
	 * Verifie que les coordonnees voulues soient accesibles
	 * remplace la piece de l'adversaire si ce dernier etait sur la destination voulue
	 * 
	 * @param x : int : coordonnee y (depart) entre 0 et 8 inclus
	 * @param y : int : coordonnee x (depart) entre 0 et 8 inclus
	 * @param x2 : int : coordonnee y2 (destination) entre 0 et 8 inclus
	 * @param y2 : int : coordonnee x2 (destination) entre 0 et 8 inclus
	 */
	public void silver(int x, int y, int x2, int y2) {
		
		// Plateau tab = new Plateau();
		Partie part = new Partie();
		int def = Partie.player;
		/*
		 * coord est un tableau qui contient tout les deplacement possible du silver
		 */
		int[][] coord = { { x - 1, y + 1 }, { x + 1, y }, { x + 1, y + 1 }, { x - 1, y - 1 }, { x + 1, y - 1 } };
		int[][] coord2 = { { x - 1, y + 1 }, { x - 1, y }, { x + 1, y + 1 }, { x - 1, y - 1 }, { x + 1, y - 1 } };
		
		if (Plateau.tableau[x2][y2] == 0) {
			for (int i = 0; i < 5; i++) {
				/*
				 * on parcoure le tableau des movements possible et on verifie ci les
				 * coordonnees de destination appartiennent a ce tableau si oui on fait le
				 * deplacement si non un message d'erreur est renvoyé
				 */
				if (((x2 == coord[i][0]) && (y2 == coord[i][1])) || ((x2 == coord2[i][0]) && (y2 == coord2[i][1]))) {
					Plateau.setTableau(x, y, x2, y2);
					break;
				} /*
					 * else { if (i == 4) { Partie.setMessErreur("deplacement non autorisé");
					 * --Partie.player; } }
					 */
			}
		} 
		else {
			for (int i = 0; i < Plateau.piece.length; i++) {
				if (Partie.player % 2 == 1) {
					// new Plateau();
					/*
					 * Si cest au joueur 1 de jouer
					 */
					if (Plateau.tableau[x2][y2] == Plateau.piece[i]) {
						Partie.setMessErreur("vous avez deja une piece a cette position !");
						--Partie.player;
						break;
					} 
					else if (Plateau.tableau[x2][y2] == Plateau.piece2[i]) {
						Plateau.setTableau(x, y, x2, y2);
						/*
						 * Plateau.tableau[x2][y2] = Plateau.tableau[x][y]; Plateau.tableau[x][y] = 0;
						 */
					}
				} else {
					/*
					 * Si cest au joueur 2 de jouer
					 */
					if (Plateau.tableau[x2][y2] == Plateau.piece2[i]) {
						Partie.setMessErreur("vous avez deja une piece a cette position !");
						--Partie.player;
						break;
					} 
					else if (Plateau.tableau[x2][y2] == Plateau.piece[i]) {
						Plateau.setTableau(x, y, x2, y2);
					}
				}
			}
		}
		if (def == Partie.player && (Plateau.tableau[x][y] == 'S' || Plateau.tableau[x][y] == 's')) {
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
	}
}
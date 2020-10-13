/**
 * @author Tekadam Tresor
 * @author Joachim Sanglier
 * @author Fantuzzi Sebastien
 */
package modele;

public class Pion {

	/**
	 * Deplace le pion selon les coordonnees de depart (x,y) vers les coordonnes voulues (x2,y2)
	 * Verifie que les coordonnees voulues soient accesibles
	 * remplace la piece de l'adversaire si ce dernier etait sur la destination voulue
	 * 
	 * @param x : int : coordonnee y (depart) entre 0 et 8 inclus
	 * @param y : int : coordonnee x (depart) entre 0 et 8 inclus
	 * @param x2 : int : coordonnee y2 (destination) entre 0 et 8 inclus
	 * @param y2 : int : coordonnee x2 (destination) entre 0 et 8 inclus
	 */
	public void pion(int x, int y, int x2, int y2) {
		
		int def = Partie.player;
		
		if (Plateau.tableau[x2][y2] == 0) {
			if (((y2 == y) && (x2 == x + 1)) && (Partie.player % 2 == 1)
					|| ((y2 == y) && (x2 == x - 1)) && (Partie.player % 2 == 0)) {
				Partie.setMessage(" ");
				Plateau.setTableau(x, y, x2, y2);
			} 
			else {
				Partie.setMessErreur("Deplacement non autorisé !");
				--Partie.player;
			}
		} 
		else {
			for (int i = 0; i < Plateau.piece.length; i++) {
				if (Partie.player % 2 == 1) {
					if (Plateau.tableau[x2][y2] == Plateau.piece[i]) {
						Partie.setMessErreur("vous avez deja une piece a cette position !");
						--Partie.player;
						break;
					}
				} 
				else {
					if (Plateau.tableau[x2][y2] == Plateau.piece2[i]) {
						Partie.setMessErreur("Deplacement non autorisé !");
						--Partie.player;
						break;
					}
				}
			}
			if (((y2 == y) && (x2 == x + 1)) && (Partie.player % 2 == 1)
					|| ((y2 == y) && (x2 == x - 1)) && (Partie.player % 2 == 0)) {
				Partie.setMessage(" ");
				Plateau.setTableau(x, y, x2, y2);
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
}
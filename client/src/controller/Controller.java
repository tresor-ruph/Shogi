/**
 * @author Tekadam Tresor
 * @author Joachim Sanglier
 * @author Fantuzzi Sebastien
 */
package controller;
import modele.Partie;
import vue.Console;

/**
 *  Est appellé par la vue pour modifier les classes du modele
 */
public class Controller {

	private Partie model;
	private Console vueConsole = null;
	
	/**
	 * Constructeur
	 * @param model : Partie
	 */
	public Controller(Partie model){
		this.model = model;
	}
	
	/**
	 * La vue utilise fixX() en lui envoyant un int entre 0 et 8 inclus et modifie la variable model selon le param
	 * @param x : int
	 */
	public void fixX(int x) {
		model.setX(x);
		this.verif(x);	
	}
	
	/**
	 * La vue utilise fixX2() en lui envoyant un int entre 0 et 8 inclus et modifie la variable model selon le param
	 * @param x2 : int
	 */
	public void fixX2(int x2) {
		model.setX2(x2);
		this.verif(x2);
	}
	
	/**
	 * La vue utilise fixY() en lui envoyant un int entre 0 et 8 inclus et modifie la variable model selon le param
	 * @param  y : int
	 */
	public void fixY(int y) {
		model.setY(y);
		this.verif(y);
	}
	
	/**
	 * La vue utilise fixY2() en lui envoyant un int entre 0 et 8 inclus et modifie la variable model selon le param
	 * @param  y2 : int
	 */
	public void fixY2(int y2) {
		model.setY2(y2);
		this.verif(y2);
	}
	
	/**
	 * Verifie que le int choisi par l'utilisateur est compris entre 0 et 8 inclus
	 * @param x : int
	 */
	public boolean verif(int x) {
		if((x > 8) || (x <0)) {
			System.out.println("Le nombre entrÃ© doit etre entre 0 et 8 inclus !");
			model.setPlayer(-1);
			return false;
		}
		return true;
	}
}
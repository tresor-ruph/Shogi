/**
 * @author Tekadam Tresor
 * @author Joachim Sanglier
 * @author Fantuzzi Sebastien
 */
package controller;
import modele.Partie;
import vue.Console;

public class Controller {

	private Partie model;
	private Console vueConsole = null;
	
	
	public Controller(Partie model) {
		this.model = model;
	}
	
	public void fixX(int x) {
		model.setX(x);
		this.verif(x);	
	}
	
	public void fixX2(int x2) {
		model.setX2(x2);
		this.verif(x2);
	}
	
	public void fixY(int y) {
		model.setY(y);
		this.verif(y);
	}
	
	public void fixY2(int y2) {
		model.setY2(y2);
		this.verif(y2);
	}
	
	public boolean verif(int x) {
		if((x > 8) || (x <0)) {
			System.out.println("Le nombre entré doit être entre 0 et 8 inclus !");
			model.setPlayer(-1);
			return false;
		}
		return true;
		
	}
}

/**
 * @author Tekadam Tresor
 * @author Joachim Sanglier
 * @author Fantuzzi Sebastien
 */
package test;
import controller.Controller;
import modele.Partie;
import modele.Plateau;
import vue.Console;
import vue.Echequier;

public class Test{
	

	public static void main(String args[]) {
	
		Plateau pat = new Plateau();
		Partie model = new Partie();
		Controller controllConsole = new Controller(model);
		Console vueConsole = new Console(model,controllConsole);
		Echequier vueInterface = new Echequier(model,controllConsole);
	}
}

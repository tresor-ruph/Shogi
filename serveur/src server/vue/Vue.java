/**
 * @author Tekadam Tresor
 * @author Joachim Sanglier
 * @author Fantuzzi Sebastien
 */
package vue;
import java.util.Scanner;

import controller.Controller;
import modele.Partie;

import java.util.Observable;
import java.util.Observer;


public abstract class Vue implements Observer{
	protected Partie model;
	protected Controller control;

	
	public Vue(Partie model,Controller control) {
		this.model = model;
		this.control = control;
		model.addObserver(this);
	}
}
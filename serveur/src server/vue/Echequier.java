/**
 * @author Tekadam Tresor
 * @author Joachim Sanglier
 * @author Fantuzzi Sebastien
 */
package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.*;
import modele.Partie;
import socket.Serveur;
import modele.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import modele.*;

public class Echequier extends Vue implements Observer, MouseListener {

	int compteurClick = 1;
	JFrame f = new JFrame();
	Panneau pan = new Panneau();

	public Echequier(Partie model, Controller control) {
		super(model, control);
		// TODO Auto-generated constructor stub
		this.fenetre();
		this.change();
	}

	public void fenetre() {
		f.setTitle("serveur par defaut");
		f.setSize(750, 550);
		// f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(pan);
		f.setResizable(false);
		f.setContentPane(new Panneau());
		f.setVisible(true);
	}

	public void change() {

		/*
		 * Serveur serv = new Serveur(); try { serv.serveur();
		 * 
		 * } catch (InterruptedException | IOException e1) { // TODO Auto-generated
		 * catch block
		 * System.out.println("une erreur c'est produit lors de la connexion"); }
		 * model.jouer();
		 */
		// model.setjouer(true);
		// TODO Auto-generated method stub
		f.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Partie.getPlayer() % 2 == 0) {
					super.mouseClicked(e);
					int x = e.getX();
					int y = e.getY();
					int a = ((x - 59) / 50);
					int b = ((y - 81) / 50);
					Graphics gr = f.getGraphics();
					if (compteurClick % 2 == 1) {
						control.fixX(b);
						Color mycolor = new Color(0, 255, 0, 127);
						gr.setColor(mycolor);
						gr.fill3DRect(57 + (a * 50), 80 + (b * 50), 50, 50, true);
						control.fixY(a);
						++compteurClick;
					} 
					else {
						control.fixX2(b);
						control.fixY2(a);
						--compteurClick;
						model.jouer();
					}
				}
			}
		});
	}

	@Override
	public void update(Observable o, Object arg) {
		if (model.getjouer() == true) {
			this.fenetre();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
/**
 * @author Tekadam Tresor
 * @author Joachim Sanglier
 * @author Fantuzzi Sebastien
 */
package vue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import modele.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Panneau extends JPanel {// dessin de l'echiquier

	int ligne;
	int col;

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		try {
			Image img = ImageIO.read(new File("download3.jpg"));
			g.drawImage(img, 0, 0, 750, 550, this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Aucune image n'a ete retrouvee !");
		}

		g.setColor(Color.gray);

		g.fill3DRect(47, 47, 456, 456, true);
		//if (modele.Partie.getMessErreur() == "****Partie Termine !****") {
		if (modele.Partie.test==1) {	
		g.setColor(Color.white);
			g.fillRect(47, 47, 500, 500);
			g.setColor(Color.black);
			g.drawString("FIN DE PARTIE", 300, 300);
		
			try {
				Image imgg = ImageIO.read(new File("gameover.jpg"));
				g.drawImage(imgg, 50, 50, 500, 500, this);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			g.drawString(modele.Partie.getMessErreur(), 200, 200);
			Partie.setMessErreur(" ");
		} else {
			int compteur = 0;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {

					if (compteur % 2 != 1) {
						g.setColor(Color.DARK_GRAY);

						g.fill3DRect((j + 1) * 50, (i + 1) * 50, 50, 50, true);

					} else {
						g.setColor(Color.LIGHT_GRAY);
						g.fill3DRect((j + 1) * 50, (i + 1) * 50, 50, 50, true);
					}
					switch (Plateau.tableau[i][j]) {
					case 'L':
						this.dessin("lanceN.png", j + 1, i + 1, g);
						break;
					case 'C':
						this.dessin("cavalierN.png", j + 1, i + 1, g);
						break;
					case 'D':
						this.dessin("dragonN.png", j + 1, i + 1, g);
						break;
					case 'S':
						this.dessin("silverN.png", j + 1, i + 1, g);
						break;
					case 'G':
						this.dessin("goldN.png", j + 1, i + 1, g);
						break;
					case 'R':
						this.dessin("roiN.png", j + 1, i + 1, g);
						break;
					case 'T':
						this.dessin("tourN.png", j + 1, i + 1, g);
						break;
					case 'F':
						this.dessin("evequeN.png", j + 1, i + 1, g);
						break;
					case 'P':
						this.dessin("pionN.png", j + 1, i + 1, g);
						break;
					case 'V':
						this.dessin("chevalN.png", j + 1, i + 1, g);
						break;
					case 'l':
						this.dessin("lance.png", j + 1, i + 1, g);
						break;
					case 'c':
						this.dessin("cavalier.png", j + 1, i + 1, g);
						break;
					case 's':
						this.dessin("silver.png", j + 1, i + 1, g);
						break;
					case 'g':
						this.dessin("gold.png", j + 1, i + 1, g);
						break;
					case 'r':
						this.dessin("roi.png", j + 1, i + 1, g);
						break;
					case 't':
						this.dessin("tour.png", j + 1, i + 1, g);
						break;
					case 'f':
						this.dessin("eveque.png", j + 1, i + 1, g);
						break;
					case 'x':
						this.dessin("pion.png", j + 1, i + 1, g);
						break;
					case 'd':
						this.dessin("dragon.png", j + 1, i + 1, g);
						break;
					case 'v':
						this.dessin("cheval.png", j + 1, i + 1, g);
						break;
					}

					compteur++;

				}
			}

		}

	}

	public void dessin(String image, int col, int ligne, Graphics dess) {
		try {
			Image img = ImageIO.read(new File(image));
			dess.drawImage(img, ((col) * 50), ((ligne) * 50), 50, 50, this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

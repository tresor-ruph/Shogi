/**
 * @author Tekadam Tresor
 * @author Joachim Sanglier
 * @author Fantuzzi Sebastien
 */
package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class Serveur {
	
	static String reponse ="yo";

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		Serveur.reponse = reponse;
	}

	public  void serveur() throws InterruptedException, IOException {
		
	System.out.println("serveur 1 en attente de connexion");
			ServerSocket s = new ServerSocket(9000);
			Socket soc = s.accept();
			System.out.println("serveur 1connexion etablie");
			System.out.println(s);
			BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())));
			
				String str = in.readLine();
				this.setReponse(str);
				System.out.println("ECHO = " + str);
			
			in.close();
			out.close();
			s.close();
			soc.close();
			System.out.println("connexion 1 ferme");
	}
}
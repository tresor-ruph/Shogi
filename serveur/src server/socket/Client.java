/**
 * @author Tekadam Tresor
 * @author Joachim Sanglier
 * @author Fantuzzi Sebastien
 */
package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import modele.Partie;

public class Client {
	
	Partie model = new Partie();
	static final int port = 9876;
	String mess =" ";

	   public  void client(String x) throws Exception {
			
	        Socket socket = new Socket("127.0.0.1", port);
	        System.out.println("SOCKET = " + socket);

	        BufferedReader plec = new BufferedReader(new InputStreamReader(socket.getInputStream()));

	        PrintWriter pred = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);

	      mess += model.getX()+" "+model.getY()+" "+model.getX2()+" "+model.getY2();
	        
	      pred.println(x);
	  
	        plec.close();
	        pred.close();
	        socket.close();
	   }
}

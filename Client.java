import java.io.BufferedReader;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static String host = "localhost";
    private static Integer port = 8080;

    private static String msgW = "\n*****Welcome to Rock Paper Scissors Game***** \n";
    private static String msgR = "\nRules:\n - Rock beats Scissors\n - Scissors beats Paper\n - Paper beats Rock\n";

    public static void main(String args[]) throws Exception {

   	String input = "";
  	String response;
  	System.out.println(Client.msgW);

  	BufferedReader inputFromUser = new BufferedReader(new InputStreamReader(System.in));
  	Socket clientSocket = new Socket(host, port);
  	DataOutputStream outputToServer = new DataOutputStream(clientSocket.getOutputStream());
  	BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

  	do {
	    if (input.equals("rules")) {
		  System.out.println(Client.msgR);
	    }
	    System.out.println("Start the game by selecting (1)Rock, (2)Paper, (3)Scissors");
	    System.out.print("or type \"rules\" to see the rules: ");
	    input = inputFromUser.readLine();

  	} while (!input.equals("1") && !input.equals("2") && !input.equals("3"));

  	 outputToServer.writeBytes(input + "\n");
  	 System.out.println("\nYour input ("+ input +") was successfully transmitted to the server. Wait for the result...");
     response = inputFromServer.readLine();

  	 System.out.println("Response from server: " + response);
  	 clientSocket.close();
    }
}

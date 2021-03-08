import java.io.BufferedReader;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class RockPaperScissorsServer {

	private static Integer port = 8080;
	private static String wMsg = "\n---Welcome to Rock Paper Scissors Game Server---";

	  public static void main(String args[]) throws Exception {

		String resCl_1 = "";
		String resCl_2 = "";
		String inputCl_1;
		String inputCl_2;
		System.out.println(RockPaperScissorsServer.wMsg);

		ServerSocket Socket = new ServerSocket(port);
		System.out.println("Successfully we're up and running on port " + Socket.getLocalPort() + "...");

		while (!Socket.isClosed()) {

			Socket cl_1 = Socket.accept();
			if (cl_1.isConnected()) {
				System.out.println("\nPlayer one has joined. waiting for player two...");
			}
			DataOutputStream outCl_1 = new DataOutputStream(cl_1.getOutputStream());
			BufferedReader inCl_1 = new BufferedReader(new InputStreamReader(cl_1.getInputStream()));

			Socket cl_2 = Socket.accept();
			if (cl_2.isConnected()) {
				System.out.println("Player two has joined. lets start the game...");
			}
			DataOutputStream outCl_2 = new DataOutputStream(cl_2.getOutputStream());
			BufferedReader inCl_2 = new BufferedReader(new InputStreamReader(cl_2.getInputStream()));

			inputCl_1 = inCl_1.readLine();
			inputCl_2 = inCl_2.readLine();

			if (inputCl_1.equals(inputCl_2)) {
				resCl_1 = "Draw";
				resCl_2 = "Draw";
				System.out.println("It's a draw.");
			}

			else if (inputCl_1.equals("1") && inputCl_2.equals("3")) {
				resCl_1 = "You win";
				resCl_2 = "You lose";
				System.out.println("Player one wins.");

			}

			else if (inputCl_1.equals("3") && inputCl_2.equals("1")) {
				resCl_1 = "You lose";
				resCl_2 = "You win";
				System.out.println("Player two wins.");
			}

			else if (inputCl_1.equals("1") && inputCl_2.equals("2")) {
				resCl_1 = "You lose";
				resCl_2 = "You win";
				System.out.println("Player two wins.");
			}

			else if (inputCl_1.equals("2") && inputCl_2.equals("1")) {
				resCl_1 = "You win";
				resCl_2 = "You lose";
				System.out.println("Player one wins.");
			}

			else if (inputCl_1.equals("3") && inputCl_2.equals("2")) {
				resCl_1 = "You win";
				resCl_2 = "You lose";
				System.out.println("Player one wins.");
			}

			else if (inputCl_1.equals("2") && inputCl_2.equals("3")) {
				resCl_1 = "You lose";
				resCl_2 = "You win";
				System.out.println("Player two wins.");
			}

			outCl_1.writeBytes(resCl_1.toUpperCase());
			outCl_2.writeBytes(resCl_2.toUpperCase());
			cl_1.close();
			cl_2.close();

			System.out.println("\nWaiting for new players...\n");

		}
	}
}

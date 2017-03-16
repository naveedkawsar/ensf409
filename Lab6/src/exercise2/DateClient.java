package exercise2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Naveed Kawsar
 *
 */
public class DateClient {
	private PrintWriter socketOut;
	private Socket aSocket;
	private BufferedReader stdIn;
	private BufferedReader socketIn;

	public DateClient(String serverName, int portNumber) {
		try {
			aSocket = new Socket(serverName, portNumber);
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			socketIn = new BufferedReader(new InputStreamReader(
					aSocket.getInputStream()));
			socketOut = new PrintWriter((aSocket.getOutputStream()), true);
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
	}
	
	public void communicate() {
		String line, response;
		while (true) {
			try {
				System.out.println("Please select an option (DATE/TIME) ");
				line = stdIn.readLine();
				
				/* Accept lower and upper case inputs*/
				socketOut.println(line.toUpperCase());
				response = socketIn.readLine();
				System.out.println(response);
				if (line.toUpperCase().equals("QUIT")) {
					break;
				}
			} catch (IOException e) {
					System.out.printf("%s\n", e.getMessage());
			}
		}
		try {
			stdIn.close();
			socketIn.close();
			socketOut.close();
		} catch (IOException e) {
			System.out.printf("%s\n", e.getMessage());
		}
	}
	
	public static void main(String[] args) throws IOException  {
		DateClient aClient = new DateClient("localhost", 9090);
		aClient.communicate();
	}

}

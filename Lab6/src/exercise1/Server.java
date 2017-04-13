package exercise1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Naveed Kawsar
 *
 */
public class Server {
	PrintWriter socketOut; 
	Socket palinSocket; 
	ServerSocket serverSocket; 
	BufferedReader socketIn;
	
	public Server() throws IOException { 
		serverSocket = new ServerSocket(8099); 
		System.out.println("Server is now running."); 
	    palinSocket = serverSocket.accept(); 
	    socketIn = new BufferedReader(new InputStreamReader(palinSocket.getInputStream())); 
	    socketOut = new PrintWriter((palinSocket.getOutputStream()), true);
	}
	//public boolean isPalindrome(StringBuffer line){
	public boolean isPalindrome(String line){
		//char[] word = line.toString().toCharArray();
		char[] word = line.toCharArray();
	    int first = 0;
	    int last = word.length - 1;
	    while (last > first) {
	        if (word[first++] != word[last--]) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public void communicate() {
		//StringBuffer line;
		String line;
		boolean running = true;
		while (running) {
			try {
				//line = new StringBuffer(socketIn.readLine());
				line = socketIn.readLine();
				
				/* Code never gets to this QUIT condition since
				 * Client closes its socket connections 
				 * immediately upon reading QUIT, hence
				 * the QUIT message never gets read
				 * by the Server, which keeps reading NULL
				 */
				if (line.equals("QUIT")) {
					running = false;
					socketOut.printf("Server stopping.\n");
					break;
				}
				else if (!isPalindrome(line)) {
					socketOut.printf("%s is not a palindrome.\n", line);
				}
				else {
					socketOut.printf("%s is a palindrome.\n", line);
				}
			} catch(IOException e) {
				System.out.println("Unexpected exception: " + e.getMessage()); 
			}
		}
		/* As the Server never breaks out of the while loop
		 * due to the Client shutting down immediately upon 
		 * reading QUIT and the Server not being able to read it
		 * from its input socket input stream, the server
		 * is not able to close its connections properly.
		 * The client connection is provided by the instructor,
		 * and is not tampered with.
		 */
		try{ 
			// CLOSE ALL OPPENED STREAMS
			socketOut.close();
			socketIn.close();
			serverSocket.close();
			palinSocket.close();
			} catch (IOException e) { 
				System.out.println("Unexpected exception: " + e.getMessage()); 
		    } 
		
	}
	
	public static void main(String[] args) throws IOException{
		Server s = new Server();
		s.communicate();
	}

}
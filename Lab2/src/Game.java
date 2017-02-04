package src;

import java.io.*;

public class Game implements Constants {

	private Board theBoard;
	private Referee theRef;
	
	/**
	 * Constructor initializes a new Board object (composition)
	 */
    public Game( ) {
        theBoard  = new Board();
	}
    
    /**
     * Passes in instance of referee
     * Calls runTheGame method to initialize the game
     * by setting opponents and letting current player play their turn
     * @param r		Instance of referee 
     * @throws IOException
     */
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
    	theRef.runTheGame();
    }
	
    /**
     * Initializes new game
     * Initializes two instances of players
     * Designates player 1 to be the X- player
     * Designates player 2 to be the O- player
     * Initializes referee
     * 
     * @param args
     * @throws IOException
     */
	public static void main(String[] args) throws IOException {
		Referee theRef;
		Player xPlayer, oPlayer;
		BufferedReader stdin;
		Game theGame = new Game();
		stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nPlease enter the name of the \'X\' player: ");
		String name= stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}

		xPlayer = new Player(name, LETTER_X);
		xPlayer.setBoard(theGame.theBoard);
		
		System.out.print("\nPlease enter the name of the \'O\' player: ");
		name = stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}
		
		oPlayer = new Player(name, LETTER_O);
		oPlayer.setBoard(theGame.theBoard);
		
		theRef = new Referee();
		theRef.setBoard(theGame.theBoard);
		theRef.setoPlayer(oPlayer);
		theRef.setxPlayer(xPlayer);
        
        theGame.appointReferee(theRef);
	}
	

}

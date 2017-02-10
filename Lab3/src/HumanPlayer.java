import java.util.Scanner;

public class HumanPlayer extends Player{

	HumanPlayer(String name, char mark)
	{
		super(name, mark);
	}
	
	/**
	 * Calls method makeMove(), as long as methods 
	 * xWin() and oWin(), and isFull() 
	 * in class Board returns false. 
	 * (If any of these conditions change (turns true), 
	 * it announces that the game is over and either 
	 * - displays the name of the winner of the game or
	 * - indicates that the game ended in a ‘tie’). 
	 * Then, displays the board after each move, 
	 * checks for the winner and 
	 * then passes the turn to the other player. 
	 */
	protected void play()
	{
		if (board.isFull())
		{
			System.out.printf("THE GAME IS OVER: It is a tie!\nGame ended...");
			return;
		}
		else if (board.xWins() | board.oWins())
		{
			System.out.printf("THE GAME IS OVER: %s is the winner!\nGame ended...", this.opponent.name);
			return;
		}
		else
		{
			this.makeMove();
			this.board.display();
			this.opponent.play();
		}
	}
	
	/**
	 * Asks the player to make a move by 
	 * entering the row and column numbers,
	 * and puts a ‘X’ or ‘O’ mark on the board, 
	 * by calling method addMark in class Board.
	 */
	protected void makeMove()
	{
		Scanner scan = new Scanner(System.in);
		System.out.printf("%s, what row should your next %s be placed in?  ", this.name, this.mark);
		int row = scan.nextInt();
		System.out.printf("%s, what column should your next %s be placed in?  ", this.name, this.mark);
		int col = scan.nextInt();
		
		board.addMark(row, col, this.mark);
	}
}

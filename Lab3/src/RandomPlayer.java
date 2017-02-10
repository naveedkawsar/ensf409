/**
 * 
 */

/**
 * @author Naveed Kawsar
 *
 */
public class RandomPlayer extends Player{
	
	RandomPlayer(String name, char mark)
	{
		super(name, mark);
	}
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
	
	protected void makeMove()
	{
		RandomGenerator rand_num = new RandomGenerator();
		int row, col;
		do
		{
			row = rand_num.discrete(0, 2);
			col = rand_num.discrete(0, 2);
		} while (this.board.getMark(row, col) != Constants.SPACE_CHAR);
		
		this.board.addMark(row, col, mark);
	}

}

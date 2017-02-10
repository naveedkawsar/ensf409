
/**
 * @author Naveed Kawsar
 *
 */
public class BlockingPlayer extends RandomPlayer{

	public BlockingPlayer(String name, char mark) 
	{
		super(name, mark);
	}
	
	protected void makeMove()
	{
		int row, col;
		Boolean can_block;
		
		/* Test for blocking on each square */
		for (row = 0; row <3; row ++) {
			for (col = 0; col <3; col++) {
				can_block = testForBlocking(row, col);
				if (can_block) {
					this.board.addMark(row, col, mark);
					return;
				}
			}
		}
		super.makeMove(); // else or if (!can_block), call RandomPlayer's makeMove
		
	}

	protected Boolean testForBlocking(int row, int col)
	{
		/* Non-empty square */
		if (board.getMark(row, col) != Constants.SPACE_CHAR)
			return false;
		
		/* Block horizontal win */
		int row_block = 0;
		for (int j = 0; j < 2; j++)
		{
			if (board.getMark(row, j) == opponent.mark) {
				row_block++;
			}
		}
		/* Block vertical win */
		int col_block = 0;
		for (int i = 0; i < 2; i++)
		{
			if (board.getMark(i, col) == opponent.mark) {
				col_block++;
			}
		}
		/* Block backslash (\) diagonal win*/
		int diag_block = 0;
		if (row == col) {
			for (int b = 0; b < 2; b++) {
				if (board.getMark(b, b) == opponent.mark)
					diag_block++;
			}
		}
		/* Block forward slash (/) diagonal win */
		if (row == (2 - col)) {
			for (int f = 2 ; f > 0; f--) {
				if(board.getMark(f, 2-f) == opponent.mark)
					diag_block++;
			}			
		}

		if (row_block == 2 | col_block == 2 | diag_block >= 2 )
			return true;
		
		return false;		// Default return value
	}
}

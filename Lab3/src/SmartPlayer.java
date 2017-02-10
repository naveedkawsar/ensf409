
/**
 * @author Naveed Kawsar
 *
 */
public class SmartPlayer extends BlockingPlayer{
	
	public SmartPlayer(String name, char mark)
	{
		super(name, mark);
	}

	protected void makeMove()
	{
		super.makeMove();	// Call BlockingPlayer's (superclass) makeMove method 
	}
	
	/* Appends BlockingPlayer's testForBlocking method to test for winning chances */
	public Boolean testForBlocking(int row, int col) {
		/* Non-empty square */
		if (board.getMark(row, col) != Constants.SPACE_CHAR)
			return false;
		
		/* Horizontal win */
		int row_win = 0;
		for (int j = 0; j < 2; j++)
		{
			if (board.getMark(row, j) == this.mark) {
				row_win++;
			}
		}
		
		/* Vertical win */
		int col_win = 0;
		for (int i = 0; i < 2; i++)
		{
			if (board.getMark(i, col) == this.mark) {
				col_win++;
			}
		}
		
		/* Backslash (\) diagonal win*/
		int diag_win = 0;
		if (row == col) {
			for (int b = 0; b < 2; b++) {
				if (board.getMark(b, b) == this.mark)
					diag_win++;
			}
		}
		
		/* Forward slash (/) diagonal win */
		if (row == (2 - col)) {
			for (int f = 2 ; f > 0; f--) {
				if(board.getMark(f, 2-f) == this.mark)
					diag_win++;
			}			
		}

		if (row_win == 2 | col_win == 2 | diag_win >= 2 )
			return true;
		
		return super.testForBlocking(row, col);		// Calls super's testForBlocking otherwise
	}
}

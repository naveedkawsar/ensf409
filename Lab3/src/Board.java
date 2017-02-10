
public class Board implements Constants {
	private char theBoard[][];
	private int markCount;
	
	/**
	 * Constructs a 3x3 char array
	 * Puts spaces in every element
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}

	/**
	 * Retrieves mark made in board index
	 * @param row	row number on board
	 * @param col	column number on board
	 * @return		element (X or O) at the specified index of theBoard
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}

	/** 
	 * @return 		true if 9 marks have been made on board, else false
	 */
	public boolean isFull() {
		return markCount == 9;
	}

	/**
	 * @return		true if checkWinner returns 1 for xPlayer, else false
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/**
	 * @return 		true if checkWinner returns 1 for oPlayer, else false
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Displays the 3x3 char array board
	 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	/**
	 * Adds mark to board index
	 * @param row	row number on board
	 * @param col	column number on board
	 * @param mark	X or O mark to be made in theBoard element
	 */
	public void addMark(int row, int col, char mark) {
		
		theBoard[row][col] = mark;
		markCount++;
	}

	/**
	 * Fills all elements of theBoard with the space character
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/**
	 * Checks if for a given mark, three-in-row exists
	 * Checks first for rows, then columns, then diagonals
	 * @param mark		Mark (X or O) of current player to checked if winner
	 * @return			1 if three-in-a-row exists, 0 otherwise
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		/**
		 * Checks if a three-in-a-row exists in the rows
		 * Cycles through all the columns for all the rows
		 * Return value set to 1 if three-in-a-row
		 * 0 otherwise
		 */
		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		/**
		 * Checks if a three-in-a-row exists in the columns
		 * Cycles through all the rows for all the columns
		 * Return value set to 1 if three-in-a-row
		 * 0 otherwise
		 */
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		/* Check if diagonal three-in-a-row exists */
		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}

	/**
	 * Prints column headers on top of boards
	 * Prints vertical lines, followed by column numbers
	 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	/**
	 * Prints horizontal lines to separate to separate rows 
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}

	/**
	 * Prints spaces between the different columns 
	 * to display empty box elements
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}

//package src;

import java.util.Scanner;

/**
 * @author Naveed Kawsar
 *
 */
abstract class Player {
	protected String name;
	protected Board board;
	protected Player opponent;
	protected char mark;
	
	Player(String _name, char _mark)
	{
		this.name = _name;
		this.mark = _mark;
	}
	protected abstract void play();
	protected abstract void makeMove();

	/* Setter methods */
	
	/**
	 * Connects the other player to this player
	 * @param _opponent	Player opponent
	 */
	protected void setOpponent(Player _opponent)
	{
		this.opponent = _opponent;
	}
	
	/**
	 * @param _board	Tic-Tac-Toe board
	 */
	protected void setBoard(Board _board)
	{
		this.board = _board;
	}
	
}


/**
 * @author Naveed Kawsar
 *
 */
public class Referee {

	private Player xPlayer;
	private Player oPlayer;
	private Board board;
	
	/**
	 * Calls the setOpponent method of class Player 
	 * to set the opponents of the  X-  and  O-  players.
	 * Then, initiates  the  game  by  displaying  the  board,
	 * and calling the  play method for the X-Player, 
	 * who is always the first player.  
	 */
	public void runTheGame()
	{
		this.xPlayer.setOpponent(oPlayer);
		this.oPlayer.setOpponent(xPlayer);
		
		System.out.print("\nReferee started the game...\n\n");
		this.board.display();
		this.xPlayer.play();
	}
	
	/* Setter methods */
	
	/**
	 * @param _board	Tic-Tac-Toe board
	 */
	public void setBoard(Board _board)
	{
		this.board = _board;
	}
	
	/**
	 * @param _oPlayer	Player 2 (with mark O)
	 */
	public void setoPlayer(Player _oPlayer)
	{
		this.oPlayer = _oPlayer;
	}
	
	/**
	 * @param _xPlayer	Player 1 (with mark X)
	 */
	public void setxPlayer(Player _xPlayer)
	{
		this.xPlayer = _xPlayer;
	}

}

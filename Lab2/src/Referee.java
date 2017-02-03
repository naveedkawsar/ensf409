/**
 * 
 */
package src;

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
	
	public void setBoard(Board _board)
	{
		this.board = _board;
	}
	
	public void setoPlayer(Player _oPlayer)
	{
		this.oPlayer = _oPlayer;
	}
	
	public void setxPlayer(Player _xPlayer)
	{
		this.xPlayer = _xPlayer;
	}
	/**

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

}

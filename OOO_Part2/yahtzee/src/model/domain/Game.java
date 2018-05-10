package model.domain;

public abstract class Game
{	
	PlayerListing players;
	
	public Game(PlayerListing players)
	{
		this.players = players;
	}
	public abstract Player activePlayer();
}

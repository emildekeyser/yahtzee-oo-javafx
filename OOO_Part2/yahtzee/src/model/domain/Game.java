package model.domain;

public abstract class Game
{	
	PlayerListing players;
	
	public Game(PlayerListing players)
	{
		if (players.isEmpty())
		{
			throw new DomainException("Need At least 1 player");
		}
		this.players = players;
	}
	public Player activePlayer()
	{
		return players.activePlayer();
	}
}

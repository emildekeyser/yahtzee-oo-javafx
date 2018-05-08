package model.domain;

public class GameSuite
{
	PlayerListing players;
	
	public GameSuite()
	{
		this.players = new PlayerListing();
	}
	
	public void registerPlayer(String name) throws DomainException
	{
		this.players.register(name);
	}
}

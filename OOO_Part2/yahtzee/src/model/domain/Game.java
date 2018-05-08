package model.domain;

public class Game
{
	PlayerListing players;
	
	public Game()
	{
		this.players = new PlayerListing();
	}
	
	public void registerPlayer(String name) throws DomainException
	{
		this.players.register(name);
	}
}

package model.domain;

import java.util.Iterator;

public class GameSuite implements Iterable<Player>
{
	PlayerListing players;
	Game game;
	
	public GameSuite()
	{
		this.players = new PlayerListing();
	}
	
	public void registerPlayer(String name)
	{
		this.players.register(name);
	}

	@Override
	public Iterator<Player> iterator()
	{
		return this.players.iterator();
	}

	public Game game()
	{
		return this.game;
	}
	
	public void chooseGame()
	{
		this.game = new Yahtzee(this.players);
	}
	
}

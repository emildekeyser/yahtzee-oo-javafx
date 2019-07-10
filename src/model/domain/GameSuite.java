package model.domain;

import java.util.Iterator;

public class GameSuite implements Iterable<String>
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
	public Iterator<String> iterator()
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

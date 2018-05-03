package model.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayersListing
{
	private List<Player> players;
	
	public PlayersListing()
	{
		this.players = new ArrayList<Player>();
	}
	
	public void register(String playerName) throws DomainException
	{
		if (this.playerExists(playerName))
		{
			throw new DomainException(playerName + " already exists!");
		}
		this.players.add(new Player(playerName));
	}

	private boolean playerExists(String playerName)
	{
		for (Player player : this.players)
		{
			if(player.getName().equals(playerName))
			{
				return true;
			}
		}
		return false;
	}
	
}

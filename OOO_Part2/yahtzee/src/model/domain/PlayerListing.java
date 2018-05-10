package model.domain;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PlayerListing implements Iterable<Player>
{
	private List<Player> players;
	
	public PlayerListing()
	{
		this.players = new LinkedList<Player>();
	}
	
	public void register(String playerName)
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

	@Override
	public Iterator<Player> iterator()
	{
		return this.players.iterator();
	}

	public Player activePlayer()
	{
		return this.players.get(0);
	}
	
}

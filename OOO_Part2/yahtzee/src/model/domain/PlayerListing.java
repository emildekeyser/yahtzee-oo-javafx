package model.domain;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PlayerListing implements Iterable<Player>
{
	private LinkedList<Player> players;
	
	public PlayerListing()
	{
		this.players = new LinkedList<Player>();
	}
	
	public void register(String playerName)
	{
//		if (this.playerExists(playerName))
//		{
//			throw new DomainException(playerName + " already exists!");
//		}
		// dit mag want we identificeren spelers niet op naam
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

	public void rotate()
	{
		Player first = this.players.pop();
		this.players.addLast(first);
	}

	public boolean isEmpty()
	{
		return this.players.isEmpty();
	}
	
}

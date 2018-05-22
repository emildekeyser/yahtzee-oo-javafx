package model.domain;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class PlayerListing implements Iterable<String>
{
	private LinkedList<Player> players;
	
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
	
	public Player getPlayerByName(String name) {
		//
		for(Player player: this.players) {
			if (player.getName().equals(name)) {
				return player;
			}
		}
		return null;
	}

	@Override
	public Iterator<String> iterator()
	{
		return new PlayerNameIterator();
		
	}
	
	private class PlayerNameIterator implements Iterator<String>
	{
		private int index;
		
		public PlayerNameIterator()
		{
			this.index = 0;
		}
		
		@Override
		public boolean hasNext()
		{
			return this.index < players.size();
		}

		@Override
		public String next()
		{
			if (this.hasNext())
			{
				int i = this.index;
				this.index++;
				return players.get(i).getName();
			}
			throw new NoSuchElementException();
		}
		
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

	public Player find(String playerName)
	{
		for (Player player : this.players)
		{
			if (player.getName().equals(playerName))
			{
				return player;
			}
		}
		throw new DomainException("Tried to start the game with a non existent player!");
	}
	
	public void removePlayer(Player player) {
		this.players.remove(player);
	}
	
}

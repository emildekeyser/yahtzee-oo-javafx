package model.domain;

public class Yahtzee extends Game
{
	public Yahtzee(PlayerListing players)
	{
		super(players);
	}

	@Override
	public Player activePlayer()
	{
		return super.players.activePlayer();
	}

}

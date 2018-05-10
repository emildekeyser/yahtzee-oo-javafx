package model.domain;

public class Yahtzee extends Game
{
	Dice currentDice;
	int rollCounter;
	
	public Yahtzee(PlayerListing players)
	{
		super(players);
		this.currentDice = new Dice();
		this.rollCounter = 0;
	}

	@Override
	public Player activePlayer()
	{
		return super.players.activePlayer();
	}
	
	public void roll(boolean[] rerolFlags)
	{
		if(this.rollCounter > 3)
		{
			throw new DomainException("Men mag maar driemaal rollen.");
		}
		else if(this.rollCounter < 1)
		{
			this.currentDice.roll();
		}
		else 
		{
			this.currentDice.roll(rerolFlags);
			this.rollCounter++;
		}
	}
	
	

}

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
		if(!canRoll())
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
	
	public boolean canRoll()
	{
		if(this.rollCounter > 3)
		{
			return false;
		}
		return true;
	}
	
	public boolean canChooseCategory()
	{
		if (this.rollCounter == 0)
		{
			return false;
		}
		return true;
	}
	
	

}

package model.domain;

import java.util.ArrayList;

public class Yahtzee extends Game
{
	private Dice currentDice;
	private int rollCounter;
	private ScoreCard scoreCard;
	
	public Yahtzee(PlayerListing players)
	{
		super(players);
		this.currentDice = new Dice();
		this.rollCounter = 0;
		this.scoreCard = new ScoreCard();
	}

	@Override
	public Player activePlayer()
	{
		return super.activePlayer();
	}
	
	public void roll(boolean[] rerolFlags)
	{
//		if(!canRoll())
//		{
//			throw new DomainException("Men mag maar driemaal rollen.");
//		}
//		else if(this.rollCounter < 1)
//		{
//			this.currentDice.roll();
//		}
//		else 
//		{
//			this.currentDice.roll(rerolFlags);
//			this.rollCounter++;
//		}
		
		this.currentDice.roll(rerolFlags);
	}
	
	public boolean canRoll()
	{
		if(this.rollCounter >= 3)
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

	public int[] getDiceValues()
	{
		return this.currentDice.getValues();
	}

	public void ready(CategoryType type)
	{
		this.scoreCard.save(this.activePlayer(), type, this.currentDice);
		this.players.rotate();
		this.rollCounter = 0;
	}

}

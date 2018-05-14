package model.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.List;

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
		this.scoreCard = new ScoreCard(super.players);
	}

	@Override
	public Player activePlayer()
	{
		return super.activePlayer();
	}
	
	public void roll(boolean[] rerolFlags)
	{
		if(this.canRoll())
		{
			if(this.rollCounter < 1)
			{
				this.currentDice.roll();
			}
			else 
			{
				this.currentDice.roll(rerolFlags);
			}
			this.rollCounter++;
		}
	}
	
	public boolean canRoll()
	{
		return this.rollCounter < 3;
	}
	
	public boolean canChooseCategory()
	{
		return this.rollCounter > 0;
	}

	public int[] getDiceValues()
	{
		return this.currentDice.getValues();
	}

	public void ready(CategoryType type)
	{
		if (type == null){throw new DomainException("No Category chosen!");}
		else
		{
			this.scoreCard.save(this.activePlayer(), type, this.currentDice);
			this.players.rotate();
			this.rollCounter = 0;
		}
	}

	public LinkedHashMap<Player, EnumMap<CategoryType, Integer>> getScoreCard()
	{
		return this.scoreCard.getAllScoreData();
	}

	public List<CategoryType> getAllowedCategories()
	{
		return this.scoreCard.getAllowedCategories(this.activePlayer());
	}
	
	

}

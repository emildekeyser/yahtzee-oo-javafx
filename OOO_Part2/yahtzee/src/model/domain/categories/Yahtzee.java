package model.domain.categories;

import model.domain.Dice;
import model.domain.DomainException;

public class Yahtzee implements Category
{

	@Override
	public boolean validDice(Dice dice)
	{
		int[] values = dice.getValues();
		for (int i = 1; i < 5; i++)
		{
			if (values[0] != values[i])
			{
				return false;
			}
		}
		return true;
	}

	@Override
	public int calculate(Dice dice)
	{
		if (!validDice(dice))
		{
			throw new DomainException("Dice aren't a yahtzee.");
		}
		return 50;
	}

}

package model.domain.categories;

import model.domain.Dice;
import model.domain.DomainException;

public class Aces implements Category
{

	@Override
	public boolean validDice(Dice dice)
	{
		for (int value : dice.getValues())
		{
			if (value == 1)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public int calculate(Dice dice)
	{
		int output = 0;
		if (validDice(dice))
		{
			for (int value : dice.getValues())
			{
				if (value == 1)
				{
					output += value;
				}
			}
		}
		else 
		{
			throw new DomainException("Dice don't contain an ace.");
		}
		return output;
	}

}

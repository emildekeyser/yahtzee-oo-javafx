package model.domain.categories;

import model.domain.Dice;
import model.domain.DomainException;

public class ThreeKind implements Category
{

	@Override
	public boolean validDice(Dice dice)
	{
		int[] values = dice.getValues();
		for (int i = 0; i < 3; i++)
		{
			int found = 1;
			for (int j = i + 1; j < 5; j++)
			{
				if (values[i] == values[j])
				{
					found++;
				}
				if (found >= 3)
				{
					return true;
				}
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
				output += value;
			}
		}
		else 
		{
			throw new DomainException("Dice don't have three of a kind.");
		}
		return output;
	}

}
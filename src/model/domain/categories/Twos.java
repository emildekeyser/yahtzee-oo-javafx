package model.domain.categories;

import model.domain.CategoryType;
import model.domain.Dice;
import model.domain.DomainException;

public class Twos implements Category
{
	
	CategoryType categoryType = CategoryType.TWOS;

	@Override
	public boolean validDice(Dice dice)
	{
		for (int value : dice.getValues())
		{
			if (value == 2)
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
				if (value == 2)
				{
					output += value;
				}
			}
		}
		else 
		{
			throw new DomainException("Dice don't contain a two.");
		}
		return output;
	}

	@Override
	public CategoryType getCategoryType()
	{
		return this.categoryType;
	}

}

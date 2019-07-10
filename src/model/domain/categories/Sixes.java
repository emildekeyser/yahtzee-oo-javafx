package model.domain.categories;

import model.domain.CategoryType;
import model.domain.Dice;
import model.domain.DomainException;

public class Sixes implements Category
{
	
	CategoryType categoryType = CategoryType.SIXES;

	@Override
	public boolean validDice(Dice dice)
	{
		for (int value : dice.getValues())
		{
			if (value == 6)
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
				if (value == 6)
				{
					output += value;
				}
			}
		}
		else 
		{
			throw new DomainException("Dice don't contain a six.");
		}
		return output;
	}

	@Override
	public CategoryType getCategoryType()
	{
		return this.categoryType;
	}

}

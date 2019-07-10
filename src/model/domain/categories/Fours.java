package model.domain.categories;

import model.domain.CategoryType;
import model.domain.Dice;
import model.domain.DomainException;

public class Fours implements Category
{
	CategoryType categoryType = CategoryType.FOURS;

	@Override
	public boolean validDice(Dice dice)
	{
		for (int value : dice.getValues())
		{
			if (value == 4)
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
				if (value == 4)
				{
					output += value;
				}
			}
		}
		else 
		{
			throw new DomainException("Dice don't contain a four.");
		}
		return output;
	}

	@Override
	public CategoryType getCategoryType()
	{
		return this.categoryType;
	}

}

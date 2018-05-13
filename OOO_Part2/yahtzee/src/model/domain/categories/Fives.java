package model.domain.categories;

import model.domain.CategoryType;
import model.domain.Dice;
import model.domain.DomainException;

public class Fives implements Category
{
	
	CategoryType categoryType = CategoryType.FIVES;

	@Override
	public boolean validDice(Dice dice)
	{
		for (int value : dice.getValues())
		{
			if (value == 5)
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
				if (value == 5)
				{
					output += value;
				}
			}
		}
		else 
		{
			throw new DomainException("Dice don't contain a five.");
		}
		return output;
	}

	@Override
	public CategoryType getCategoryType()
	{
		return this.categoryType;
	}

}

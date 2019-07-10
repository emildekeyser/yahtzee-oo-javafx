package model.domain.categories;

import model.domain.CategoryType;
import model.domain.Dice;
import model.domain.DomainException;

public class FourKind implements Category
{
	
	CategoryType categoryType = CategoryType.FOURKIND;

	@Override
	public boolean validDice(Dice dice)
	{
		int[] values = dice.getValues();
		for (int i = 0; i < 4; i++)
		{
			int found = 1;
			for (int j = i + 1; j < 5; j++)
			{
				if (values[i] == values[j])
				{
					found++;
				}
				if (found >= 4)
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
			throw new DomainException("Dice don't have four of a kind.");
		}
		return output;
	}

	@Override
	public CategoryType getCategoryType()
	{
		return this.categoryType;
	}

}

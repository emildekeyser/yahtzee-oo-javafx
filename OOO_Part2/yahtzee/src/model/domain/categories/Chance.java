package model.domain.categories;

import model.domain.CategoryType;
import model.domain.Dice;

public class Chance implements Category
{
	
	CategoryType categoryType = CategoryType.CHANCE;

	@Override
	public boolean validDice(Dice dice)
	{
		return true;
	}

	@Override
	public int calculate(Dice dice)
	{
		int output = 0;
		for (int value : dice.getValues())
		{
			output += value;
		}
		return output;
	}

	@Override
	public CategoryType getCategoryType()
	{
		return this.categoryType;
	}

}

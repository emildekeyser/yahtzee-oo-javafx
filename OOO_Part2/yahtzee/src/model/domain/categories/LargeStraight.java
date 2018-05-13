package model.domain.categories;

import model.domain.CategoryType;
import model.domain.Dice;
import model.domain.DomainException;

public class LargeStraight implements Category
{
	
	CategoryType categoryType = CategoryType.LARGESTRAIGHT;

	@Override
	public boolean validDice(Dice dice)
	{
		int[] v = dice.getValues().clone();
		java.util.Arrays.sort(v);
		
		boolean ret = v[4] == v[3] + 1 		// v[4] tot v [0] is een large straight
				   && v[3] == v[2] + 1
				   && v[2] == v[1] + 1
				   && v[1] == v[0] + 1;
				
		return ret;
	}

	@Override
	public int calculate(Dice dice)
	{
		if (!validDice(dice))
		{
			throw new DomainException("Dice aren't a small straight.");
		}
		return 40;
	}

	@Override
	public CategoryType getCategoryType()
	{
		return this.categoryType;
	}

}

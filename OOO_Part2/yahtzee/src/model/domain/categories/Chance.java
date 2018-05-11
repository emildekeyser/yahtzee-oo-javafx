package model.domain.categories;

import model.domain.Dice;

public class Chance implements Category
{

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

}

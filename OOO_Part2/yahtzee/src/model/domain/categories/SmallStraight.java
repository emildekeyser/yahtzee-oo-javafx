package model.domain.categories;

import model.domain.Dice;
import model.domain.DomainException;

public class SmallStraight implements Category
{

	@Override
	public boolean validDice(Dice dice) //Dit kan waarschijnlijk beter geschreven worden.
	{
		int[] values = dice.getValues();
		int een = 0;
		int twee = 0;
		int drie = 0;
		int vier = 0;
		int vijf = 0;
		int zes = 0;
		for (int i = 0; i < 5; i++)
		{
			switch (values[i])
			{
				case 1:
					een++;
					break;
	
				case 2:
					twee++;
					break;
	
				case 3:
					drie++;
					break;
	
				case 4:
					vier++;
					break;
	
				case 5:
					vijf++;
					break;
	
				case 6:
					zes++;
					break;

				default:
					break;
			}
		}
		if (een >= 1 && twee >= 1 && drie >= 1 && vier >= 1)
		{
			return true;
		}
		if (twee >= 1 && drie >= 1 && vier >= 1 && vijf >= 1)
		{
			return true;
		}
		if (drie >= 1 && vier >= 1 && vijf >= 1 && zes >= 1)
		{
			return true;
		}
		return false;
	}

	@Override
	public int calculate(Dice dice)
	{
		if (!validDice(dice))
		{
			throw new DomainException("Dice aren't a small straight.");
		}
		return 30;
	}

}

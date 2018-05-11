package model.domain.categories;

import model.domain.Dice;
import model.domain.DomainException;

public class FullHouse implements Category
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
		if (een == 3 || twee == 3 || drie == 3 || vier == 3 || vijf == 3 || zes == 3)
		{
			if (een == 2 || twee == 2 || drie == 2 || vier == 2 || vijf == 2 || zes == 2)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public int calculate(Dice dice)
	{
		if (!validDice(dice))
		{
			throw new DomainException("Dice aren't a full house.");
		}
		return 25;
	}

}

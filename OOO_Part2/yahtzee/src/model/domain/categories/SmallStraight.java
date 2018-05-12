package model.domain.categories;

import model.domain.Dice;
import model.domain.DomainException;

public class SmallStraight implements Category
{

	@Override
	public boolean validDice(Dice dice)
	{
		int[] v = dice.getValues().clone();
		java.util.Arrays.sort(v);
		
		boolean ret = v[4] == v[3] + 1 		// v[4] tot v [1] is een small straight
				   && v[3] == v[2] + 1
				   && v[2] == v[1] + 1;
		
				ret |= v[3] == v[2] + 1		// v[3] tot v[0] is een small straight
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
		return 30;
	}

}

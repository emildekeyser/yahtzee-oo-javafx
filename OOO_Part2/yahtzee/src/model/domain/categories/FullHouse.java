package model.domain.categories;

import model.domain.Dice;
import model.domain.DomainException;

public class FullHouse implements Category
{

	@Override
	public boolean validDice(Dice dice)
	{
		int[] v = dice.getValues().clone();
		java.util.Arrays.sort(v);
		
		boolean ret = (v[0] == v[1] && v[0] == v[2]) 		// eerste 3 gelijk en laatste twee 2 gelijk 
					   && v[3] == v[4];
		
				ret |= v[0] == v[1]
					   && (v[2] == v[3] && v[2] == v[4]);	// 2 en 3
				
//		return ret && v[0] != v[4]; // 5 of a kind is geen full house
		return ret; // Sommige mensen zeggen wel blijkbaar.
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

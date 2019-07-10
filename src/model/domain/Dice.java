package model.domain;

import java.util.concurrent.ThreadLocalRandom;

public class Dice
{
	private int values[];
	
	// package visible
	Dice()
	{
		this.values = new int[] {0,0,0,0,0};
	}
	
	// package visible
	void roll(boolean[] flags)
	{
//		if(flags.length != values.length || flags == null)
//		{
//			this.roll();
//		}
//		else
//		{
			for (int i = 0; i < values.length; i++)
			{
				if (flags[i])
				{
					this.values[i] = ThreadLocalRandom.current().nextInt(1, 7); // 1 t.e.m. 6
				}
			}
//		}
	}

	public int[] getValues()
	{
		final int[] immutableClone = this.values.clone(); 
		return immutableClone;
	}
	
	// package visible
	void roll()
	{
		 this.roll(new boolean[]{true, true, true, true, true});
	}
}
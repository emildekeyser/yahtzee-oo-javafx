package model.domain;

import java.util.concurrent.ThreadLocalRandom;

public class Dice
{
	private int values[];
	
	public Dice()
	{
		this.values = new int[] {0,0,0,0,0};
	}
	
	public void roll(boolean[] flags)
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
		return this.values;
	}

	public void roll()
	{
		 this.roll(new boolean[]{true, true, true, true, true});
	}
}
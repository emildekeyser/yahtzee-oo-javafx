package model.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class ScoreCard
{
	private LinkedHashMap<Player, EnumMap<CategoryType, Integer>> data;
	
	public ScoreCard(PlayerListing players)
	{
		this.data = new LinkedHashMap<>();
		for (Player player : players)
		{
			this.data.put(player, new EnumMap<CategoryType, Integer>(CategoryType.class));
			
			for (CategoryType type : CategoryType.values())
			{
				this.data.get(player.getName()).put(type, 0);
			}
		}
	}
	
	public void save(Player player, CategoryType type, Dice dice)
	{
		//this.data.add(new ScoreData(player, type, 100)); // TODO parse score
		this.data.get(player).put(type, 100);
	}

	public LinkedHashMap<Player, EnumMap<CategoryType, Integer>> getAllScoreData()
	{
		return this.data;
	}
	
	public LinkedHashMap<Player, EnumMap<BonusType, Integer>> getAllBonusData()
	{
		LinkedHashMap<Player, EnumMap<BonusType, Integer>> ret = new LinkedHashMap<>();
		for (Player p : this.data.keySet())
		{
			ret.put(p, calculateBonuses(p));
		}
		return ret;
	}

	private EnumMap<BonusType, Integer> calculateBonuses(Player p)
	{
		EnumMap<BonusType, Integer> bonuses = new EnumMap<BonusType, Integer>(BonusType.class);
		
		int upperScore = calculate(p, "upper");
		int bonus = upperScore >= 63 ? 35 : 0;
		int lowerScore = calculate(p, "lower"); 
		
		bonuses.put(BonusType.UPPERSCORE, upperScore );
		bonuses.put(BonusType.UPPERBONUS, bonus );
		bonuses.put(BonusType.UPPERTOTAL, bonus + upperScore );
		bonuses.put(BonusType.LOWERSCORE, lowerScore);
		bonuses.put(BonusType.GRANDTOTAL, lowerScore + upperScore + bonus);
		
		return bonuses;
	}

	private int calculate(Player p, String region)
	{
		int a = 0;
		for (CategoryType type : CategoryType.values())
		{
			if (type.location() == region)
			{
				a += this.data.get(p).get(type);
			}
		}
		return a;
	}
}

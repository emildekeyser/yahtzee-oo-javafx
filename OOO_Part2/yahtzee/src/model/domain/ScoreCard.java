package model.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import model.domain.categories.CategoryParser;

public class ScoreCard
{
	private LinkedHashMap<Player, EnumMap<CategoryType, Integer>> data;
	private CategoryParser parser;
	
	public ScoreCard(PlayerListing players)
	{
		this.parser = new CategoryParser();
		this.data = new LinkedHashMap<>();
		for (Player player : players)
		{
			this.data.put(player, new EnumMap<CategoryType, Integer>(CategoryType.class));
			
			for (CategoryType type : CategoryType.values())
			{
				this.data.get(player).put(type, 0);
			}
		}
	}
	
	public void save(Player player, CategoryType type, Dice dice)
	{
		if (this.data.get(player).get(type) > 0)
		{
			this.data.get(player).put(type, -1);
		}
		else
		{
			int score = this.parser.CalculateCategory(type, dice);
			this.data.get(player).put(type, score);
		}
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

	 // dice mag null zijn wanneer er nog niet gerold is
	public List<CategoryType> getAllowedCategories(Player activePlayer, Dice dice)
	{
		List<CategoryType> values;
		if (dice != null && this.parser.validCategories(dice).size() > 0) // Dit zou beter moeten met een aparte ui voor score suggesties
		{
			values = this.parser.validCategories(dice);
		}
		else
		{
			values = Arrays.asList(CategoryType.values());
		}
		
		ArrayList<CategoryType> allowed = new ArrayList<>(13); 
		for (CategoryType type : values)
		{
			if (this.data.get(activePlayer).get(type) == 0)
			{
				allowed.add(type);
			}
		}
		return allowed;
	}

	public boolean allFilled()
	{
		boolean ret = true;
		for (Player player : this.data.keySet())
		{
			ret &= this.getAllowedCategories(player, null).size() == 0;
		}
		return ret;
	}

	public String winner()
	{
		if (this.allFilled())
		{
			Player winner = this.data.keySet().iterator().next(); // heeft geen get ?
			for (Player player : this.data.keySet())
			{
				if (calculateBonuses(player).get(BonusType.GRANDTOTAL) > calculateBonuses(winner).get(BonusType.GRANDTOTAL))
				{
					winner = player;
				}
			}
			return winner.getName();
		}
		else
		{
			return "";
		}
	}
}

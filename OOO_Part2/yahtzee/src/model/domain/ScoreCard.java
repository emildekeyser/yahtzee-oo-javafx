package model.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import model.domain.categories.CategoryParser;

public class ScoreCard
{
	private LinkedHashMap<Player, EnumMap<CategoryType, Integer>> data;
	private CategoryParser parser;

	public ScoreCard(PlayerListing players)
	{
		this.parser = new CategoryParser();
		this.data = new LinkedHashMap<>();
		for (String playerName : players)
		{
			this.data.put(players.find(playerName), new EnumMap<CategoryType, Integer>(CategoryType.class));

			for (CategoryType type : CategoryType.values())
			{
				for (Player player : this.data.keySet())
				{
					this.data.get(player).put(type, 0);
				}
			}
		}
	}

	public void save(Player player, CategoryType type, Dice dice)
	{
		if (this.parser.validCategories(dice).contains(type))
		{
			if (this.data.get(player).get(type).equals(0))
			{
				int score = this.parser.CalculateCategory(type, dice);
				this.data.get(player).put(type, score);
			}
			else
			{
				this.data.get(player).put(type, -2);
				throw new DomainException("Cheating");
			}
		}
		else
		{
			if (this.data.get(player).get(type).equals(0))
			{
				this.data.get(player).put(type, -1);
			}
			else
			{
				this.data.get(player).put(type, -2);
				throw new DomainException("Cheating");
			}
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

		bonuses.put(BonusType.UPPERSCORE, upperScore);
		bonuses.put(BonusType.UPPERBONUS, bonus);
		bonuses.put(BonusType.UPPERTOTAL, bonus + upperScore);
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
	
	// Dit zou een ui voor score suggesties moeten voorzien
	public List<CategoryType> getAllowedCategories(Player activePlayer, Dice dice)
	{
		ArrayList<CategoryType> notFilledIn = new ArrayList<>();
		for (CategoryType type : CategoryType.values())
		{
			if (this.data.get(activePlayer).get(type).equals(0))
			{
				notFilledIn.add(type);
			}
		}
		
		List<CategoryType> valid = this.parser.validCategories(dice); 
		
		ArrayList<CategoryType> allowed = new ArrayList<>();
		for (CategoryType type : notFilledIn)
		{
			if (valid.contains(type))
			{
				allowed.add(type);
			}
		}
		
		return allowed.isEmpty() ? notFilledIn : allowed;
	}

	public boolean allFilled()
	{
		for (Player player : this.data.keySet())
		{
			for (Integer score : this.data.get(player).values())
			{
				if (score.equals(0))
				{
					return false;
				}
			}
		}
		return true;
	}

	public String winner()
	{
		if (this.allFilled())
		{
			Player winner = this.data.keySet().iterator().next(); // heeft geen
																	// get ?
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

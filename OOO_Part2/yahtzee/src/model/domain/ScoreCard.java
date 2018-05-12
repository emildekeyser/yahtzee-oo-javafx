package model.domain;

import java.util.ArrayList;

public class ScoreCard
{
	private ArrayList<ScoreData> data;
	
	public ScoreCard()
	{
		this.data = new ArrayList<>(13 * 3);
	}
	
	public void save(Player player, CategoryType type, Dice dice)
	{
		this.data.add(new ScoreData(player, type, 100)); // TODO parse score
	}
}

package view.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.domain.BonusType;
import model.domain.CategoryType;
import model.domain.Player;

public class ScoreCardView
{
	private HBox hbox;
	private GridPane grid;
	LinkedHashMap<Player, EnumMap<CategoryType, Label>> scoreLabels;
	LinkedHashMap<Player, EnumMap<BonusType, Label>> bonusLabels;

	public ScoreCardView()
	{
		hbox = new HBox();
		grid = new GridPane();
		scoreLabels = new LinkedHashMap<>();
		bonusLabels = new LinkedHashMap<>();
	}

	public HBox getHbox()
	{
		return hbox;
	}

	public void setScores(LinkedHashMap<Player, EnumMap<CategoryType, Integer>> scores)
	{
		if (hbox.getChildren().isEmpty())
		{
			this.initScores(scores.keySet());
			
		}
		this.updateScores(scores);
	}

	public void setBonuses(LinkedHashMap<Player, EnumMap<BonusType, Integer>> bonuses)
	{
		if (!this.hbox.getChildren().isEmpty())
		{
			for (Player player : bonuses.keySet())
			{
				for (BonusType bonus : BonusType.values())
				{
					String value = bonuses.get(player).get(bonus).toString();
					this.bonusLabels.get(player).get(bonus).setText(value);
				}
			}
		}
	}

	private void updateScores(LinkedHashMap<Player, EnumMap<CategoryType, Integer>> scores)
	{
		for (Player player : scoreLabels.keySet())
		{
			for (CategoryType type : CategoryType.values())
			{
				String value = scores.get(player).get(type).toString();
				scoreLabels.get(player).get(type).setText(value);
			}
		}
	}

//	private void initScores(LinkedHashMap<Player, EnumMap<CategoryType, Integer>> scores)
//	{
//		// Make a first column of Category and Bonus names
//		int row = 1;
//		// Upper categories
//		for (CategoryType type : CategoryType.values())
//		{
//			grid.add(new Label(type.toString()), 0, row);
//			row++;
//		}
//
//		// Make a header row of player names
//		int column = 1;
//		for (Player player : scores.keySet())
//		{
//			row = 0;
//			this.scoreLabels.put(player, new EnumMap<>(CategoryType.class)); 
//			grid.add(new Label(player.getName()), column, row);
//			row++;
//
//			// Make score holding columns, populate local map with empty the
//			// labels
//			for (CategoryType type : CategoryType.values())
//			{
//				Label l = new Label();
//				this.scoreLabels.get(player).put(type, l);
//				grid.add(l, column, row);
//				row++;
//			}
//			column++;
//		}
//		// setting the labels values is updateScore's responsibility
//		updateScores(scores);
//
//		grid.setPadding(new Insets(0, 5, 0, 5));
//		hbox.getChildren().add(grid);
//	}

	private void initScores(Collection<Player> players)
	{
		ArrayList<CategoryType> upper = new ArrayList<>(), lower = new ArrayList<>();
		for (CategoryType type : CategoryType.values())
		{
			if (type.location().equals("upper"))
			{
				upper.add(type);
			}
			else
			{
				lower.add(type);
			}

		}
		
		int column = 0, row = 1;
		
		for (CategoryType type : upper)
		{
			grid.add(new Label(type.toString()), column, row);
			row++;
		}
		
		grid.add(new Label(BonusType.UPPERSCORE.toString()), column, row); row++;
		grid.add(new Label(BonusType.UPPERBONUS.toString()), column, row); row++;
		grid.add(new Label(BonusType.UPPERTOTAL.toString()), column, row); row++;
		
		for (CategoryType type : lower)
		{
			grid.add(new Label(type.toString()), column, row);
			row++;
		}
		
		grid.add(new Label(BonusType.LOWERSCORE.toString()), column, row); row++;
		grid.add(new Label(BonusType.GRANDTOTAL.toString()), column, row);

		column = 1;
		for (Player player : players)
		{
			row = 0;
			this.scoreLabels.put(player, new EnumMap<>(CategoryType.class));
			this.bonusLabels.put(player, new EnumMap<>(BonusType.class));
			grid.add(new Label(player.getName()), column, row);
			row++;

			Label l;
			for (CategoryType type : upper)
			{
				l = new Label();
				this.scoreLabels.get(player).put(type, l);
				grid.add(l, column, row);
				row++;
			}
			
			l = new Label();
			this.bonusLabels.get(player).put(BonusType.UPPERSCORE, l);
			grid.add(l, column, row); row++;
			l = new Label();
			this.bonusLabels.get(player).put(BonusType.UPPERBONUS, l);
			grid.add(l, column, row); row++;
			l = new Label();
			this.bonusLabels.get(player).put(BonusType.UPPERTOTAL, l);
			grid.add(l, column, row); row++;
			
			for (CategoryType type : lower)
			{
				l = new Label();
				this.scoreLabels.get(player).put(type, l);
				grid.add(l, column, row);
				row++;
			}
			
			l = new Label();
			this.bonusLabels.get(player).put(BonusType.LOWERSCORE, l);
			grid.add(l, column, row); row++;
			l = new Label();
			this.bonusLabels.get(player).put(BonusType.GRANDTOTAL, l);
			grid.add(l, column, row); row++;
			
			column++;
		}

		grid.setPadding(new Insets(0, 5, 0, 5));
		hbox.getChildren().add(grid);
	}
}

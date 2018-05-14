package view.ui;

import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.domain.CategoryType;
import model.domain.Player;

public class ScoreCardView
{
	private HBox hbox;
	private GridPane grid;
	LinkedHashMap<Player, EnumMap<CategoryType, Label>> scoreLabels;
	LinkedHashMap<Player, EnumMap<CategoryType, Label>> bonusLabels;

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
			initScores(scores);
		}
		else
		{
			updateScores(scores);
		}
	}

	private void updateScores(LinkedHashMap<Player, EnumMap<CategoryType, Integer>> scores)
	{
		for (Player player : scoreLabels.keySet())
		{
			for (CategoryType type : CategoryType.values())
			{
				String value = scores.get(player).get(type).toString();
				scoreLabels.get(player).get(type).setText(value );
			}
		}
	}

	private void initScores(LinkedHashMap<Player, EnumMap<CategoryType, Integer>> scores)
	{
		// Make a first column of Category Type names
		int row = 1;
		for (CategoryType type : CategoryType.values())
		{
			grid.add(new Label(type.toString()), 0, row);
			row++;
		}
		
		// Make a header row of player names
		int column = 1;
		for (Player player : scores.keySet())
		{	
			row = 0;
			this.scoreLabels.put(player, new EnumMap<>(CategoryType.class)); // Populate local Map with player keys
			grid.add(new Label(player.getName()), column, row);
			row++;
			
			// Make score holding columns, populate local map with empty the labels
			for (CategoryType type : CategoryType.values())
			{
				Label l = new Label();
				this.scoreLabels.get(player).put(type, l);
				grid.add(l , column , row);
				row++;
			}
			column++;
		}
		//setting the labels values is updateScore's responsibility
		updateScores(scores);
		
		grid.setPadding(new Insets(0, 5, 0, 5));
		hbox.getChildren().add(grid);
	}
}

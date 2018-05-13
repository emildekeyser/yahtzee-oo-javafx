package view.ui;

import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.domain.CategoryType;
import model.domain.Player;

public class ScoreCardView
{
	private HBox hbox;
	private GridPane scoreBoard;
	private GridPane scoreBoardScores;
	private List<Label> scoresLabelList;

	public ScoreCardView()
	{

	}

	public void setScores(LinkedHashMap<Player, EnumMap<CategoryType, Integer>> scores)
	{

	}

	private void updateScores(LinkedHashMap<Player, EnumMap<CategoryType, Integer>> scores)
	{

	}

	private void initScores(LinkedHashMap<Player, EnumMap<CategoryType, Integer>> scores)
	{
		int row = 0;
		for (CategoryType t : CategoryType.values())
		{
			Label l = new Label();
			l.setText(t.toString());
			scoreBoard.add(l, 0, row);
			row++;
		}

		scoreBoard.add(total, 0, 13);
		row = 0;
		for (int i = 0; i < 13; i++)
		{
			Label l = new Label("test");
			scoreBoardScores.add(l, 0, row);
			scoresLabelList.add(l);
			row++;
		}
		scoreBoardScores.setPadding(new Insets(0, 5, 0, 5));
		hbox.getChildren().addAll(scoreBoard, scoreBoardScores);
	}
}

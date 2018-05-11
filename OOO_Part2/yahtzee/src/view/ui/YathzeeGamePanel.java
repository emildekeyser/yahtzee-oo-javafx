package view.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.CategoryType;

public class YathzeeGamePanel extends BorderPane {

	private Label playerText;
	private Label currentPlayerText;
	private List<Integer> scores;
	private List<Label> scoresLabelList;
	private Button throwDice;
	private HBox diceUi;
	private HBox categoryAndNext;
	private GridPane mainBoard;
	private GridPane scoreBoard;
	private GridPane scoreBoardScores;
	private ComboBox<String> categories;
	private Button select;
	private Label total;
	private ToggleButton die1;
	private ToggleButton die2;
	private ToggleButton die3;
	private ToggleButton die4;
	private ToggleButton die5;
	private List<Integer> diceValues;

	public YathzeeGamePanel() {
		createBoard();
	}

	public String getPlayerName() {
		return playerText.getText();
	}

	private void addUi() {
		setTop(playerText);
		setCenter(mainBoard);
		setBottom(currentPlayerText);
		setRight(createScoreBoard());
	}

	private void addMainBoard() {
		diceUi.setSpacing(5);
		diceUi.getChildren().addAll(die1, die2, die3, die4, die5, throwDice);

		categoryAndNext.setSpacing(5);
		categoryAndNext.setPadding(new Insets(10, 0, 0, 0));
		categoryAndNext.getChildren().addAll(categories, select);
		createCategoriesCombo();

	}

	private void createBoard() {
		initVariables();
		createDice();
		createMainField();
		setActions();
		addUi();
	}

	private void initVariables() {
		playerText = new Label("Player:");
		currentPlayerText = new Label("Current Player:");
		throwDice = new Button("Throw Dice");
		diceUi = new HBox();
		categoryAndNext = new HBox();
		categories = new ComboBox<String>();
		select = new Button("Select");
		scoreBoard = new GridPane();
		mainBoard = new GridPane();
		scores = new ArrayList<Integer>();
		scoreBoardScores = new GridPane();
		scoresLabelList = new ArrayList<Label>();
		total = new Label("TOTAL: ");
		diceValues = new ArrayList<Integer>();
		for (int i = 1; i<6; i++) {
			diceValues.add(i);
		}
	}

	private HBox createScoreBoard() {
		HBox hbox = new HBox();
		int row = 0;
		for (CategoryType t : CategoryType.values()) {
			Label l = new Label();
			l.setText(t.toString());
			scoreBoard.add(l, 0, row);
			row++;
		}
		scoreBoard.add(total, 0, 13);
		row = 0;
		for (int i = 0; i < 13; i++) {
			Label l = new Label("test");
			scoreBoardScores.add(l, 0, row);
			scoresLabelList.add(l);
			row++;
		}
		scoreBoardScores.setPadding(new Insets(0, 5, 0, 5));
		hbox.getChildren().addAll(scoreBoard, scoreBoardScores);
		return hbox;
	}

	private void createMainField() {
		addMainBoard();
		mainBoard.setConstraints(diceUi, 0, 1);
		mainBoard.setConstraints(categoryAndNext, 0, 2);

		mainBoard.setPadding(new Insets(100, 0, 0, 10));
		mainBoard.getChildren().addAll(diceUi, categoryAndNext);
	}

	private void createDice() {
		die1 = new ToggleButton();
		die2 = new ToggleButton();
		die3 = new ToggleButton();
		die4 = new ToggleButton();
		die5 = new ToggleButton();
	}

	private void createCategoriesCombo() {
		for (CategoryType t : CategoryType.values()) {
			categories.getItems().add(t.toString());
		}
	}

	public void setPlayerName(String playerName) {
		playerText.setText("Player: " + playerName);
	}

	public void setCurrentPlayerText(String playerName) {
		this.currentPlayerText.setText("Current player: " + playerName);
	}

	public void setScores(ArrayList<Integer> scores) {
		int i = 0;
		for (Label l : scoresLabelList) {
			l.setText(scores.get(i).toString());
			i++;
		}
	}

	public void setDice(ArrayList<Integer> diceValues) {
		this.diceValues = diceValues;
	}

	public void setTotal(int total) {
		this.total.setText("TOTAL: " + total);
	}

	public String getCategoryValue() {
		return categories.getValue();
	}

	public void update() {
		die1.setText(diceValues.get(0).toString());
		die2.setText(diceValues.get(1).toString());
		die3.setText(diceValues.get(2).toString());
		die4.setText(diceValues.get(3).toString());
		die5.setText(diceValues.get(4).toString());
	}

	public void setActions() {
		// throwDice.setOnAction(value);
		// select.setOnAction(value);
	}

}

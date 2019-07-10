package view.ui;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.domain.BonusType;
import model.domain.CategoryType;
import model.domain.Player;

public class YahtzeeGamePanel extends BorderPane {

	private Label playerText;
	private Label currentPlayerText;
	private Button throwDice;
	private Button stopGame;
	private HBox diceUi;
	private HBox categoryAndNext;
	private GridPane mainBoard;
	private ComboBox<CategoryType> categories;
	private Button select;
	private Label total;
	private List<ToggleButton> toggleDice;
	private List<Integer> diceValues;
	
	private boolean justActivated;
	private ScoreCardView scoreCard;

	public YahtzeeGamePanel() {
		createBoard();
		this.justActivated = false;
		this.deactivate();
	}

	public String getPlayerName() {
		//deze moet alleen de naam terug geven
		return playerText.getText().substring(8);
	}

	private void addUi() {
		setTop(playerText);
		setCenter(mainBoard);
		setBottom(currentPlayerText);
		setRight(createScoreBoard());
	}

	private void addMainBoard() {
		diceUi.setSpacing(5);
		diceUi.getChildren().addAll(toggleDice);
		diceUi.getChildren().add(throwDice);

		categoryAndNext.setSpacing(5);
		categoryAndNext.setPadding(new Insets(10, 0, 0, 0));
		categoryAndNext.getChildren().addAll(categories, select);
		//createCategoriesCombo();
		
	}

	private void createBoard() {
		initVariables();
		createDice();
		createMainField();
		addUi();
	}

	private void initVariables() {
		playerText = new Label("Player:");
		currentPlayerText = new Label("Current Player:");
		throwDice = new Button("Throw Dice");
		diceUi = new HBox();
		categoryAndNext = new HBox();
		categories = new ComboBox<CategoryType>();
		select = new Button("Select");
		mainBoard = new GridPane();
		total = new Label("TOTAL: ");
		diceValues = new ArrayList<Integer>();
		stopGame = new Button("Stop playing");
		for (int i = 1; i<6; i++) {
			diceValues.add(i);
		}
		
		scoreCard = new ScoreCardView();
	}

	private HBox createScoreBoard() {
		return scoreCard.getHbox();
	}
	
	public void setScores(LinkedHashMap<Player, EnumMap<CategoryType, Integer>> scores) {
		scoreCard.setScores(scores);
	}
	
	public void setBonuses(LinkedHashMap<Player, EnumMap<BonusType, Integer>> bonuses)
	{
		 this.scoreCard.setBonuses(bonuses);
	}

	private void createMainField() {
		addMainBoard();
		//mainBoard.setConstraints(diceUi, 0, 1);
		//mainBoard.setConstraints(categoryAndNext, 0, 2);
		
		GridPane.setConstraints(diceUi, 0, 1);
		GridPane.setConstraints(categoryAndNext, 0, 2);
		GridPane.setConstraints(stopGame, 0,3);
		
		mainBoard.setPadding(new Insets(100, 0, 0, 10));
		mainBoard.getChildren().addAll(diceUi, categoryAndNext, stopGame);
	}

	private void createDice() {
		toggleDice = new ArrayList<ToggleButton>(5);
		for (int i = 0; i < 5; i++)
		{
			toggleDice.add(new ToggleButton());
		}
	}

	public void setPlayerName(String playerName) {
		playerText.setText("Player: " + playerName);
	}

	public void setActivePlayerName(String playerName) {
		this.currentPlayerText.setText("Current player: " + playerName);
	}

	public void setDice(ArrayList<Integer> diceValues) {
		this.diceValues = diceValues;
		for (int i = 0; i < toggleDice.size(); i++)
		{
			toggleDice.get(i).setText(diceValues.get(i).toString());
		}
	}

	public void setTotal(int total) {
		this.total.setText("TOTAL: " + total);
	}

	public CategoryType getCategoryValue() {
		return categories.getValue();
	}

	public void setRollButtonHandler(EventHandler<ActionEvent> rollButtonHandler)
	{
		this.throwDice.setOnAction(rollButtonHandler);
	}

	public void setCategoryChoiceHandler(EventHandler<ActionEvent> categoryChoiceHandler)
	{
		this.select.setOnAction(categoryChoiceHandler);
	}
	
	public void setStopGameHandler(EventHandler<ActionEvent> stopGameHandler) {
		this.stopGame.setOnAction(stopGameHandler);
	}
	
	public boolean[] getRerollFlags()
	{
		boolean[] flags = new boolean[] {true, true, true, true, true};
		if (justActivated)
		{
			justActivated = false;
			return flags;
		}
		else
		{
			flags = new boolean[] {false, false, false, false, false};
			for (int i = 0; i < 5; i++)
			{
				flags[i] = toggleDice.get(i).isSelected();
			}
			return flags;
		}
	}

	public void activate()
	{
		 justActivated = true;
		 this.canRoll(true);
	}
	
	public void deactivate()
	{
		this.canChooseCategory(false);
		this.canRoll(false);
	}
	
	// The !! are important we want to work with true = enable and false = disable
	// but since the node method is 'setDisabled' we have to flip the boolean values
	public void canChooseCategory(boolean canChooseCategory)
	{
		this.categories.setDisable(!canChooseCategory);
		this.select.setDisable(!canChooseCategory);
	}
	
	// see canChooseCategory comment
	public void canRoll(boolean canRoll)
	{
		for (ToggleButton btn : this.toggleDice)
		{
			btn.setDisable(!canRoll);
		}
		this.throwDice.setDisable(!canRoll);
	}

	public void setCategoryCoices(List<CategoryType> allowedCategories)
	{
		this.categories.getItems().clear();
		this.categories.getItems().addAll(allowedCategories);
		this.categories.getSelectionModel().select(0);
	}

}

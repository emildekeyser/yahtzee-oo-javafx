package view.ui;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.domain.BonusType;
import model.domain.CategoryType;
import model.domain.Player;
import model.domain.ScoreData;

public class YahtzeeGameView extends Stage{

	private YahtzeeGamePanel yathzeeGamePanel;
	private Stage stage;

	private YahtzeeGameView(Stage stage, YahtzeeGamePanel pane) {
		setStage(stage);
		setYathzeeGamePanel(pane);

		Scene mainScene = new Scene(pane, 500, 350);
		getStage().setTitle("Yathzee");
		getStage().setScene(mainScene);
		sizeToScene();
	}

	public YahtzeeGameView(String playerName)
	{
		this(new Stage(), new YahtzeeGamePanel());
		this.setPlayerName(playerName);
	}

	public YahtzeeGamePanel getYathzeeGamePanel() {
		return yathzeeGamePanel;
	}

	public void setYathzeeGamePanel(YahtzeeGamePanel yathzeeGamePanel) {
		this.yathzeeGamePanel = yathzeeGamePanel;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public void setPlayerName(String playerName) {
		getYathzeeGamePanel().setPlayerName(playerName);
	}

	public void setScores(LinkedHashMap<Player, EnumMap<CategoryType, Integer>> scores) {
		getYathzeeGamePanel().setScores(scores);
	}

	public void setTotal(int total) {
		getYathzeeGamePanel().setTotal(total);
	}

	public CategoryType getCategoryValue() {
		return getYathzeeGamePanel().getCategoryValue();
	}
	
	public void setDice(ArrayList<Integer> diceValues) {
		getYathzeeGamePanel().setDice(diceValues);
	}
	
	public void start() {
		getStage().show();
	}

	public void setActivePlayerName(String playerName)
	{
		getYathzeeGamePanel().setActivePlayerName(playerName);
	}

	public void setRollButtonHandler(EventHandler<ActionEvent> RollButtonHandler)
	{
		this.getYathzeeGamePanel().setRollButtonHandler(RollButtonHandler);
	}
	
	public void setCategoryChoiceHandler(EventHandler<ActionEvent> CategoryChoiceHandler)
	{
		this.getYathzeeGamePanel().setCategoryChoiceHandler(CategoryChoiceHandler);
	}
	
	public void setStopGameHandler(EventHandler<ActionEvent> stopGameHandler) {
		this.getYathzeeGamePanel().setStopGameHandler(stopGameHandler);
	}

	public boolean[] getRerollFlags()
	{
		return yathzeeGamePanel.getRerollFlags();
	}

	public void activate()
	{
		this.yathzeeGamePanel.activate();
	}

	public void canChooseCategory(boolean canChooseCategory)
	{
		this.yathzeeGamePanel.canChooseCategory(canChooseCategory);
	}

	public void canRoll(boolean canRoll)
	{
		this.yathzeeGamePanel.canRoll(canRoll);
	}

	public void deactivate()
	{
		this.yathzeeGamePanel.deactivate();
	}

	public void setCategoryCoices(List<CategoryType> allowedCategories)
	{
		this.yathzeeGamePanel.setCategoryCoices(allowedCategories);
	}

	public void stop()
	{
		this.stage.close();
		this.close(); // is dit nodig ?
	}

	public void setBonuses(LinkedHashMap<Player, EnumMap<BonusType, Integer>> bonuses)
	{
		this.yathzeeGamePanel.setBonuses(bonuses);
	}
	
	public String getPlayerName() {
		return this.yathzeeGamePanel.getPlayerName();
	}

}
package view.ui;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class YahtzeeGameView extends Stage implements View{

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

	public void setScores(ArrayList<Integer> scores) {
		getYathzeeGamePanel().setScores(scores);
	}

	public void setTotal(int total) {
		getYathzeeGamePanel().setTotal(total);
	}

	public String getCategoryValue() {
		return getYathzeeGamePanel().getCategoryValue();
	}
	
	public void setDice(ArrayList<Integer> diceValues) {
		getYathzeeGamePanel().setDice(diceValues);
	}
	
	public void start() {
		getStage().show();
	}

	@Override
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

	public boolean[] getRerollFlags()
	{
		return yathzeeGamePanel.getRerollFlags();
	}

	public void activate()
	{
		this.yathzeeGamePanel.activate();
	}


}
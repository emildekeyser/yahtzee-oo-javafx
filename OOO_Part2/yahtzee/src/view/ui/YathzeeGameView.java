package view.ui;

import java.util.ArrayList;
import java.util.Observable;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class YathzeeGameView extends Stage implements View {

	private YathzeeGamePanel yathzeeGamePanel;
	private Stage stage;

	public YathzeeGameView(Stage stage, YathzeeGamePanel pane) {
		setStage(stage);
		setYathzeeGamePanel(pane);

		Scene mainScene = new Scene(pane, 500, 350);
		getStage().setTitle("Yathzee");
		getStage().setScene(mainScene);
		sizeToScene();
	}

	public YathzeeGamePanel getYathzeeGamePanel() {
		return yathzeeGamePanel;
	}

	public void setYathzeeGamePanel(YathzeeGamePanel yathzeeGamePanel) {
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

	public void setCurrentPlayerText(String playerName) {
		getYathzeeGamePanel().setCurrentPlayerText(playerName);
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
	
	public void update() {
		getYathzeeGamePanel().update();
	}
	
	public void start() {
		getStage().show();
	}



}
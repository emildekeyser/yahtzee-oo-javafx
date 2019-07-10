package view.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class GameSetupPanel extends GridPane {

	private Label playerNameText;
	private Button next;
	private TextField nameUserInput;
	private Button startGame;
	private Label playerNameList;

	public GameSetupPanel() {
		playerNameText = new Label("What is your name?");
		nameUserInput = new TextField();
		next = new Button("Add");
		startGame = new Button("Start");
		playerNameList = new Label();
		
		add(playerNameText, 0, 1);
		add(nameUserInput, 0, 2);
		add(next, 0, 3);
		add(startGame, 0, 4);
		add(playerNameList, 1, 1);
		
		setPadding(new Insets(10,10,10,10));
	}

	public String getPlayerName() {
		return nameUserInput.getText();
	}

	public void setRegisterButtonHandler(EventHandler<ActionEvent> registerButtonHandler)
	{
		next.setOnAction(registerButtonHandler);
	}

	public void setStartGameButtonHandler(EventHandler<ActionEvent> startGameButtonHandler)
	{
		startGame.setOnAction(startGameButtonHandler);
	}

	public void addPlayerName(String playerName)
	{
		 playerNameList.setText(playerNameList.getText() + playerName + "\n");
	}
}

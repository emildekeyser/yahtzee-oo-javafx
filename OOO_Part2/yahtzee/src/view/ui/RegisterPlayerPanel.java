package view.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RegisterPlayerPanel extends GridPane {

	private Label playerNameText;
	private Button next;
	private TextField nameUserInput;
	private Button startGame;

	public RegisterPlayerPanel() {
		playerNameText = new Label("What is your name?");
		nameUserInput = new TextField();
		next = new Button("Next");
		startGame = new Button("Start");
		//next.setOnAction(value);
		//startGame.setOnAction(value);
		
		add(playerNameText, 0, 1);
		add(nameUserInput, 0, 2);
		add(next, 0, 3);
		add(startGame, 0, 4);
		
		setPadding(new Insets(10,10,10,10));
	}

	public String getPlayerName() {
		return nameUserInput.getText();
	}
}

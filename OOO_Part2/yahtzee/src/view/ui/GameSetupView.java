package view.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameSetupView extends Stage {

	private GameSetupPanel registerPlayerPanel;
	private Stage stage;

	public GameSetupView(Stage stage) {
		setStage(stage);
		setRegisterPlayerPanel(new GameSetupPanel());

		Scene mainScene = new Scene(this.getRegisterPlayerPanel(), 400, 200);
		getStage().setTitle("Registreer Speler");
		getStage().setScene(mainScene);
		sizeToScene();
	}

	public GameSetupPanel getRegisterPlayerPanel() {
		return registerPlayerPanel;
	}

	public void setRegisterPlayerPanel(GameSetupPanel registerPlayerPanel) {
		this.registerPlayerPanel = registerPlayerPanel;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public String getPlayerName() {
		return getRegisterPlayerPanel().getPlayerName();
	}

	public void start() {
		getStage().show();
	}

	public void setRegisterButtonHandler(EventHandler<ActionEvent> registerButtonHandler)
	{
		this.getRegisterPlayerPanel().setRegisterButtonHandler(registerButtonHandler);
	}

	public void setStartGameButtonHandler(EventHandler<ActionEvent> startGameButtonHandler)
	{
		this.getRegisterPlayerPanel().setStartGameButtonHandler(startGameButtonHandler);
	}

	public void addPlayerName(String playerName)
	{
		this.getRegisterPlayerPanel().addPlayerName(playerName);
	}

}

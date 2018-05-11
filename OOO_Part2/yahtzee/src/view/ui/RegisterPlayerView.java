package view.ui;

import java.util.Observable;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegisterPlayerView extends Stage {

	private RegisterPlayerPanel registerPlayerPanel;
	private Stage stage;

	public RegisterPlayerView(Stage stage, RegisterPlayerPanel pane) {
		setStage(stage);
		setRegisterPlayerPanel(pane);

		Scene mainScene = new Scene(pane, 400, 200);
		getStage().setTitle("Registreer Speler");
		getStage().setScene(mainScene);
		sizeToScene();
	}

	public RegisterPlayerPanel getRegisterPlayerPanel() {
		return registerPlayerPanel;
	}

	public void setRegisterPlayerPanel(RegisterPlayerPanel registerPlayerPanel) {
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

}

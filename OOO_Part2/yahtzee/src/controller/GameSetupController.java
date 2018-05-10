package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import model.domain.GameSuite;
import model.domain.Player;
import view.ui.GameSetupWindow;

public class GameSetupController
{	
	GameSuite suite;
	GameSetupWindow setupWindow;
	
	public GameSetupController(Stage primaryStage)
	{
		this.suite = new GameSuite();
		this.setupWindow = new GameSetupWindow(primaryStage);
		this.setupWindow.setRegisterButtonHnadler(new RegisterButtonHandler());
		this.setupWindow.setStartGameButtonHandler(new StartGameButtonHandler());
	}
	
	private class RegisterButtonHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent arg0)
		{
			suite.registerPlayer(setupWindow.getPlayerNameInput());
		}	
	}
	
	private class StartGameButtonHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent arg0)
		{
			for (Player player : suite)
			{
				new PlayerController(player, suite.game());
			}
			
			setupWindow.close();
		}	
	}
}

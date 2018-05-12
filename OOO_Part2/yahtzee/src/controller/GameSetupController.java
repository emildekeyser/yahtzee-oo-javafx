package controller;

import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import model.domain.GameSuite;
import view.ui.GameSetupView;

public class GameSetupController
{	
	GameSuite suite;
	GameSetupView setupWindow;
	
	public GameSetupController(Stage primaryStage)
	{
		this.suite = new GameSuite();
		this.setupWindow = new GameSetupView(primaryStage);
		this.setupWindow.setRegisterButtonHandler(new RegisterButtonHandler());
		this.setupWindow.setStartGameButtonHandler(new StartGameButtonHandler());
		this.setupWindow.start();
	}
	
	private class RegisterButtonHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent arg0)
		{
			suite.registerPlayer(setupWindow.getPlayerName());
			setupWindow.addPlayerName(setupWindow.getPlayerName());
		}	
	}
	
	private class StartGameButtonHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent arg0)
		{
			try
			{
				suite.chooseGame();
				new MainController(suite);
				setupWindow.stop();
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
			}
		}	
	}
}

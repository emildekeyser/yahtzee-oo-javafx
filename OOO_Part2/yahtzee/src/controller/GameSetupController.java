package controller;

import java.util.ArrayList;
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
			try
			{
				suite.registerPlayer(setupWindow.getPlayerName());
				setupWindow.addPlayerName(setupWindow.getPlayerName());
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(), "Setup error", 0);
				e.printStackTrace();
			}
		}	
	}
	
	private class StartGameButtonHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent arg0)
		{
			try
			{
				suite.chooseGame();// Whenever more games are added this needs a parameter, also factory behind the scenes ?
				
				// Whenever more games are added this needs to be a factory ?
				// maybe the can be refactored to just suite.start(gameType)
				// with suite having acces through an interface to the ControllerFactory.Make(GameType)
				for (String playerName : suite)
				{
					new YahtzeeController(playerName, suite.game());
				}
				
				suite.game().start();
				
				setupWindow.stop();
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(), "Game error", 0);
				e.printStackTrace();
			}
		}	
	}
}

package controller;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.domain.Game;
import model.domain.Yahtzee;
import view.ui.YahtzeeGameView;

public class PlayerController
{
	private Yahtzee game;
	private YahtzeeGameView window;
	private MainController mainController;

	public PlayerController(String playerName, Game game, MainController mainController)
	{
		this.mainController = mainController;
		this.game = (Yahtzee) game;
		this.window = new YahtzeeGameView(playerName);
		this.window.setActivePlayerName(this.game.activePlayer().getName());
		this.window.start();
		
		this.window.setRollButtonHandler(new RollButtonHandler());
		this.window.setCategoryChoiceHandler(new CategoryChoiceHandler());
		
//		this.window.setScoreCard(this.game.getScoreCard());
	}
	
	private class RollButtonHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			game.roll(window.getRerollFlags());
//			window.canChooseEndCategory(game.canChooseEndCategory());
//			window.canRoll(game.canRoll());
//			mainController.globalGameStateUpdate();
		}	
	}
	
	private class CategoryChoiceHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
//			game.ready(window.getChosenCategory());
//			window.deactivate();
//			mainController.playerReady();
		}
	}
	
	public void GameStateUpdate()
	{
		window.setDice(ArrayList<Integer>(Arrays.asList(game.getDiceValues())));
//		window.setScoreCard(game.getScoreCard);
//		this.window.setActivePlayer(this.game.activePlayer().getName());
	}
	
	public void Activate()
	{
		//this.window.canRoll(true);
	}
	
}
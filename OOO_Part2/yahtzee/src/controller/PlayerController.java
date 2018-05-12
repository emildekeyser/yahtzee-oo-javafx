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
			window.canChooseCategory(game.canChooseCategory());
			window.canRoll(game.canRoll());
			mainController.globalGameStateUpdate();
		}	
	}
	
	private class CategoryChoiceHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			game.ready(window.getCategoryValue());
			window.deactivate();
			mainController.playerReady();
		}
	}
	
	public void GameStateUpdate()
	{	
		ArrayList<Integer> l = new ArrayList<Integer>(5);
		for (Integer integer : game.getDiceValues())
		{
			l.add(integer);
		}
		window.setDice(l);
		
//		window.setScoreCard(game.getScoreCard);
		this.window.setActivePlayerName(this.game.activePlayer().getName());
	}
	
	public void Activate()
	{
		this.window.activate();
	}
	
}
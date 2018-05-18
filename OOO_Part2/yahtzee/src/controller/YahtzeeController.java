package controller;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.domain.Game;
import model.domain.Yahtzee;
import view.ui.YahtzeeGameView;

public class YahtzeeController implements PlayerController
{
	private Yahtzee game;
	private YahtzeeGameView window;

	public YahtzeeController(String playerName, Game game)
	{
		this.game = (Yahtzee) game;
		
		this.window = new YahtzeeGameView(playerName);
		this.window.setActivePlayerName(this.game.activePlayer().getName());
		this.window.setCategoryCoices(this.game.getAllowedCategories());
		
		this.window.setRollButtonHandler(new RollButtonHandler());
		this.window.setCategoryChoiceHandler(new CategoryChoiceHandler());

		this.window.start();
		
		this.game.registerController(playerName, this);
	}
	
	private class RollButtonHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			game.roll(window.getRerollFlags());
			window.setCategoryCoices(game.getAllowedCategories());
			window.canChooseCategory(game.canChooseCategory());
			window.canRoll(game.canRoll());
			game.globalGameStateUpdate();
		}	
	}
	
	private class CategoryChoiceHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			game.ready(window.getCategoryValue());
			window.deactivate();
			game.playerReady();
		}
	}
	
	@Override
	public void gameStateUpdate()
	{	
		ArrayList<Integer> l = new ArrayList<Integer>(5);
		for (Integer integer : game.getDiceValues())
		{
			l.add(integer);
		}
		window.setDice(l);
		
		window.setScores(game.getScoreCard());
		window.setBonuses(game.getBonuses());
		this.window.setActivePlayerName(this.game.activePlayer().getName());
	}
	
	@Override
	public void activate()
	{
		this.window.activate();
	}
	
	@Override
	public void kill()
	{
		this.window.stop();
	}
	
}
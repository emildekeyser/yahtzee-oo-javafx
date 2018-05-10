package controller;

import model.domain.Game;
import model.domain.Player;

public class PlayerController
{

	private Player player;
	private Game game;
	private YahtzeeWindow window;

	public PlayerController(Player player, Game game)
	{
		this.player = player;
		this.game = game;
		this.window = new YahtzeeWindow();
		this.window.setPlayerName(this.player.getName());
		this.window.setActivePlayer(this.game.activePlayer().getName());
	}
	
}

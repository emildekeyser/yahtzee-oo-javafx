package controller;

import java.util.HashMap;

import model.domain.Game;
import model.domain.GameSuite;
import model.domain.Player;

public class MainController
{
	private HashMap<Player, PlayerController> playerMap;
	private Game game;
	
	public MainController(GameSuite suite)
	{
		this.game = suite.game();
		this.playerMap = new HashMap<Player, PlayerController>();
		
		for (Player player : suite)
		{
			playerMap.put(player, new PlayerController(player.getName(), this.game, this));
		}
	}

	public void globalGameStateUpdate()
	{
		for (PlayerController player : playerMap.values())
		{
			player.GameStateUpdate();
		}
	}
	
	public void playerReady()
	{
		playerMap.get(this.game.activePlayer()).Activate();
		this.globalGameStateUpdate();
	}
}

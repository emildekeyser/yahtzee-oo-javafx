package controller;

import java.util.HashMap;

import javax.swing.JOptionPane;

import javafx.stage.Stage;
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
		this.playerReady();
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
		if (this.game.winner().isEmpty())
		{
			playerMap.get(this.game.activePlayer()).Activate();
			this.globalGameStateUpdate();
		}
		else
		{
			this.globalGameStateUpdate();
			String msg = "Winner: " + this.game.winner();	
			int opt = JOptionPane.showConfirmDialog(null, msg, "Game Over!", JOptionPane.YES_NO_OPTION);
			if (opt == JOptionPane.YES_OPTION)
			{
				new GameSetupController(new Stage());
			}
			this.killPlayers();
		}
	}

	private void killPlayers()
	{
		for (PlayerController player : this.playerMap.values())
		{
			player.kill();
		}
	}
}

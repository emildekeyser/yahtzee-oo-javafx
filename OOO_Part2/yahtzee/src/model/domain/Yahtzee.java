package model.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.swing.JOptionPane;

import controller.GameSetupController;
import controller.PlayerController;
import javafx.stage.Stage;

public class Yahtzee extends Game
{
	private Dice currentDice;
	private int rollCounter;
	private ScoreCard scoreCard;
	private HashMap<Player, PlayerController> playerControllerMap;

	public Yahtzee(PlayerListing players)
	{
		super(players);
		this.currentDice = new Dice();
		this.rollCounter = 0;
		this.scoreCard = new ScoreCard(super.players);
		this.playerControllerMap = new HashMap<>();
	}

	@Override
	public Player activePlayer()
	{
		return super.activePlayer();
	}

	public void roll(boolean[] rerolFlags)
	{
		if (this.canRoll())
		{
			if (this.rollCounter < 1)
			{
				this.currentDice.roll();
			}
			else
			{
				this.currentDice.roll(rerolFlags);
			}
			this.rollCounter++;
		}
	}

	public boolean canRoll()
	{
		return this.rollCounter < 3;
	}

	public boolean canChooseCategory()
	{
		return this.rollCounter > 0;
	}

	public int[] getDiceValues()
	{
		return this.currentDice.getValues();
	}

	public void ready(CategoryType type)
	{
		if (type == null)
		{
			throw new DomainException("No Category chosen!");
		}
		else
		{
			this.scoreCard.save(this.activePlayer(), type, this.currentDice);
			this.players.rotate();
			this.rollCounter = 0;
		}
	}

	public LinkedHashMap<Player, EnumMap<CategoryType, Integer>> getScoreCard()
	{
		return this.scoreCard.getAllScoreData();
	}

	public List<CategoryType> getAllowedCategories()
	{
		return this.scoreCard.getAllowedCategories(this.activePlayer(), this.currentDice);
	}

	@Override
	public String winner()
	{
		return this.scoreCard.winner();
	}

	public void registerController(String playerName, PlayerController playerCtrl)
	{
		this.playerControllerMap.put(this.players.find(playerName), playerCtrl);
	}

	public void globalGameStateUpdate()
	{
		for (PlayerController player : playerControllerMap.values())
		{
			player.gameStateUpdate();
		}
	}

	public void playerReady()
	{
		if (this.winner().isEmpty())
		{
			playerControllerMap.get(this.activePlayer()).activate();
			this.globalGameStateUpdate();
		}
		else
		{
			this.globalGameStateUpdate();

			// Dit moet weg !!! naar een 'end game' controller ?
			String msg = "Winner: " + this.winner();
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
		for (PlayerController player : this.playerControllerMap.values())
		{
			player.kill();
		}
	}

	@Override
	public void start()
	{
		this.playerReady();
	}

	public LinkedHashMap<Player, EnumMap<BonusType, Integer>> getBonuses()
	{
		return this.scoreCard.getAllBonusData();
	}
}

package view.ui;

import java.util.ArrayList;

public interface View {
	public void start();

	public void setPlayerName(String playerName);

	public void setActivePlayerName(String playerName);

	public void setScores(ArrayList<Integer> scores);

	public void setTotal(int total);

	public void setDice(ArrayList<Integer> diceValues);
}

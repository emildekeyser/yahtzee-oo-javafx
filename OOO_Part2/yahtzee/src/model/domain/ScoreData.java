package model.domain;

import java.util.Hashtable;
import java.util.Map;

public class ScoreData {
	private Player player;
	private String category;
	private int score;

	public ScoreData(Player player, String category, int score) {
		setCategory(category);
		setPlayer(player);
		setScore(score);
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		if (player == null) {
			throw new DomainException("Invalid Player");
		}
		this.player = player;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		if (category.isEmpty()) {
			throw new DomainException("Invalid category");
		}
		this.category = category;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		if (score < 0) {
			throw new DomainException("Invalid Score");
		}
		this.score = score;
	}

}

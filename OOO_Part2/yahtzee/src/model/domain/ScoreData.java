package model.domain;

public class ScoreData {
	private Player player;
	private CategoryType category;
	private int score;

	public ScoreData(Player player, CategoryType type, int score)
	{
		setCategory(type);
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

	public CategoryType getCategory() {
		return category;
	}

	public void setCategory(CategoryType type) {
		this.category = type;
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

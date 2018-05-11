package model.domain.categories;

import model.domain.Dice;

public interface Category {
	
	public boolean validDice(Dice dice);
	public int calculate(Dice dice);

}

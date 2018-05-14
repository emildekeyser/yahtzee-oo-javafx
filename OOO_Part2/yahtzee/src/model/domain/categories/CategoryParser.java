package model.domain.categories;

import java.util.ArrayList;
import java.util.HashMap;

import model.domain.CategoryType;
import model.domain.Dice;

public class CategoryParser
{
	
	private HashMap<CategoryType, Category> categoryStrategies;
	
	public CategoryParser()
	{ // Ik wist niet hoe ik het moest automatiseren dus ik heb het semi handmatig gedaan.
		categoryStrategies = new HashMap<>();
		categoryStrategies.put(CategoryType.ACES, new Aces());
		categoryStrategies.put(CategoryType.CHANCE, new Chance());
		categoryStrategies.put(CategoryType.FIVES, new Fives());
		categoryStrategies.put(CategoryType.FOURKIND, new FourKind());
		categoryStrategies.put(CategoryType.FOURS, new Fours());
		categoryStrategies.put(CategoryType.FULLHOUSE, new FullHouse());
		categoryStrategies.put(CategoryType.LARGESTRAIGHT, new LargeStraight());
		categoryStrategies.put(CategoryType.SIXES, new Sixes());
		categoryStrategies.put(CategoryType.SMALLSTRAIGHT, new SmallStraight());
		categoryStrategies.put(CategoryType.THREEKIND, new ThreeKind());
		categoryStrategies.put(CategoryType.THREES, new Threes());
		categoryStrategies.put(CategoryType.TWOS, new Twos());
		categoryStrategies.put(CategoryType.YAHTZEE, new Yahtzee());
	}
	
	public ArrayList<CategoryType> validCategories(Dice dice)
	{
		ArrayList<CategoryType> output = new ArrayList<CategoryType>();
		for (CategoryType categoryType : CategoryType.values()) {
			if (categoryStrategies.get(categoryType).validDice(dice)) {
				output.add(categoryType);
			}
		}
		return output;
	}
	
	public int CalculateCategory(CategoryType category, Dice dice)
	{
		return categoryStrategies.get(category).calculate(dice);
	}

}

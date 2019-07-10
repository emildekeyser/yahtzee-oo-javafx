package model.domain.categories;



import model.domain.CategoryType;
import model.domain.DomainException;

public class CategoryFactory
{
	
	public CategoryFactory()
	{
		
	}
	
	public Category createCategory(CategoryType categoryType)
	{
		Category category;
		switch (categoryType)
		{
		case ACES:
			category = new Aces();
			break;

		case TWOS:
			category = new Twos();
			break;

		case THREES:
			category = new Threes();
			break;

		case FOURS:
			category = new Fours();
			break;

		case FIVES:
			category = new Fives();
			break;

		case SIXES:
			category = new Sixes();
			break;

		case THREEKIND:
			category = new ThreeKind();
			break;

		case FOURKIND:
			category = new FourKind();
			break;

		case SMALLSTRAIGHT:
			category = new SmallStraight();
			break;

		case LARGESTRAIGHT:
			category = new LargeStraight();
			break;

		case FULLHOUSE:
			category = new FullHouse();
			break;

		case YAHTZEE:
			category = new Yahtzee();
			break;

		case CHANCE:
			category = new Chance();
			break;

		default:
			throw new DomainException("Category in factory doesn't exist");
		}
		return category;
	}
	
}

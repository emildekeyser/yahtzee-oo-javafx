package model.domain.categories;

public enum CategoryType
{
	
	ACES("upper"),
	TWOS("upper"),
	THREES("upper"),
	FOURS("upper"),
	FIVES("upper"),
	SIXES("upper"),
	THREEKIND("lower"),
	FOURKIND("lower"),
	FULLHOUSE("lower"),
	SMALLSTRAIGHT("lower"),
	LARGESTRAIGHT("lower"),
	YAHTZEE("lower"),
	CHANCE("lower");
	
	private String location;
	
	private CategoryType(String location)
	{
		this.location = location;
	}
	
	public String location()
	{
		return this.location;
	}

}

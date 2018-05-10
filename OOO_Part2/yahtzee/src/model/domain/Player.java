package model.domain;

public class Player
{
	String name;
	
	Player(String name)
	{
		this.setName(name);
	}

	private void setName(String name)
	{
		if(name.isEmpty())
		{
			throw new DomainException("Invalid Name");
		}
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
}

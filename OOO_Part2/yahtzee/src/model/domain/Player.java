package model.domain;

public class Player
{
	String name;
	
	Player(String name) throws DomainException
	{
		this.setName(name);
	}

	private void setName(String name) throws DomainException
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

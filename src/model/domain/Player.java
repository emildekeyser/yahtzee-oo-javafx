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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Player other = (Player) obj;
		if (name == null)
		{
			if (other.name != null) return false;
		}
		else if (!name.equals(other.name)) return false;
		return true;
	}
	
	
}

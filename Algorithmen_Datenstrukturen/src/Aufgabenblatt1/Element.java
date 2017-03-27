
public class Element{
	int key;
	
	public Element() 
	{
		key = (int) (Math.random()*1_000_000);
	}
	
	public Element(int nummer)
	{
		this.key = key;
	}

	@Override
	public String toString() 
	{
		return "[" + key + "]";
	}
	
	@Override
	public int hashCode() 
	{
		return key;
	}	
	
	@Override
	public boolean equals(Object obj) 
	{
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		
		return key == other.key;
			
	}

}
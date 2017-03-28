package Aufgabenblatt1;

<<<<<<< HEAD
public class Element{
	private int key;
	
	public Element() 
	{
		key = (int) (Math.random()*1_000_000);
=======
public class Element {
	int key;

	public Element() {
		Aufwand.counter++;
		key = (int) (Math.random() * 1_000_000);
>>>>>>> branch 'master' of https://github.com/Bobbel0815/AD1.git
	}
<<<<<<< HEAD
	
	public Element(int nummer)
	{
=======

	public Element(int nummer) {
		Aufwand.counter++;
>>>>>>> branch 'master' of https://github.com/Bobbel0815/AD1.git
		key = nummer;
	}

	@Override
	public String toString() {
		Aufwand.counter++;
		return "[" + key + "]";
	}

	@Override
	public int hashCode() {
		Aufwand.counter++;
		return key;
	}

	@Override
	public boolean equals(Object obj) {
		Aufwand.counter++;

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;

		return key == other.key;

	}
	
	public int getKey(){
		return key;
	}

}
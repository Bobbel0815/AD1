package Aufgabenblatt1;

public class Element {
	int key;

	public Element() {
		Aufwandsanalyse.counter++;
		key = (int) (Math.random() * 1_000_000);

	}


	public Element(int nummer) {
		Aufwandsanalyse.counter++;
		key = nummer;
	}

	@Override
	public String toString() {
		Aufwandsanalyse.counter++;
		return "[" + key + "]";
	}

	@Override
	public int hashCode() {
		Aufwandsanalyse.counter++;
		return key;
	}

	@Override
	public boolean equals(Object obj) {
		Aufwandsanalyse.counter++;

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
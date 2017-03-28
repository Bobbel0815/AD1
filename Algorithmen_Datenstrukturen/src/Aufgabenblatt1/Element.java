package Aufgabenblatt1;

public class Element {
	int key;

	public Element() {
		Aufwand.counter++;
		key = (int) (Math.random() * 1_000_000);
	}

	public Element(int nummer) {
		Aufwand.counter++;
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

}
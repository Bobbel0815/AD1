package Aufgabenblatt1;

public class Person {
	private int key;
	private static int counter = 0;
	private Person nextPerson;
	
	public Person() {
		setKey(++counter);
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Person getNextPerson() {
		return nextPerson;
	}

	public void setNextPerson(Person nextPerson) {
		this.nextPerson = nextPerson;
	}

}

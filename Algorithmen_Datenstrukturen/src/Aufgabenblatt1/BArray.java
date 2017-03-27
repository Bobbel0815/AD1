package Aufgabenblatt1;

public class BArray {
	BArray next;
	BArray previous;
	private int key;
	private static int counter = 0;

	public BArray() {
		key = counter++;
	}

	public BArray getNext() {
		return next;
	}

	public void setNext(BArray next) {
		this.next = next;
	}

	public BArray getPrevious() {
		return previous;
	}

	public void setPrevious(BArray previous) {
		this.previous = previous;
	}

	public BArray getPos() {
		return this;
	}

	public void setKey(int key2) {

		key = key2;
	}

	public int getKey() {
		return key;
	}

}

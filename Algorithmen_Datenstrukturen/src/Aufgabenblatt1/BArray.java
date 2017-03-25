package Aufgabenblatt1;

public class BArray {
	BArray next;
	BArray previous;
	private int pos;
	private int key = this.hashCode();

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

	public int getPos() {
		return pos;
	}
	
	public void setKey(int key2){
		
		key = key2;
	}
	
	public int getKey(){
		return key;
	}

}

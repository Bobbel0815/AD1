package Aufgabenblatt1;

public class Student {

	private int key;
	private static int counter= 0;
	
	
	public Student(){
		key= ++counter;
	}
	
	 public int getKey(){
	    	return key;
	    }

	@Override
	public String toString() {
		return "Student [key=" + key + "]";
	}

	

}

package Aufgabenblatt1;

import java.util.Arrays;

public class a implements ListenInterface{

	
	private Student[] array;
	int max=10;
	
	
	@Override
	public void insert(int pos, Object element) {
		if(array.length>= max){
			 Arrays.copyOf(array, array.length * 2);
			 max*=2; 
		}
		
		
	}

	@Override
	public void deleteP(int pos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteK(Object key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object find(Object key) {
		
		for(int i =0;i<array.length;i++){
			if(key.equals(array[i].getKey())){
				return i;
			}
		}
		return null;
	}

	@Override
	public Object retrieve(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void concat(ListenInterface liste) {
		// TODO Auto-generated method stub
		
	}
   
}

package Aufgabenblatt1;

import java.util.Arrays;

public class A implements ListenInterface {

	private Student[] array;
	int groesse;

	public A(int groesse) {
		this.groesse = groesse;
		array = new Student[groesse];
	}

	@Override
	public void insert(int pos, Object element) {
		if (pos > groesse - 1) {
			listeVergrößern();
		}
		if (element instanceof Student && (array[pos] == null)) {
			array[pos] = (Student) element;
		} else {
			System.err.println("Fehler!");
		}

	}

	@Override
	public void deleteP(int pos) {
		if (pos >= 0 && pos <= groesse) {
			array[pos] = null;
			//System.out.println("Element an Stelle " + pos + " gelöscht.");
		} else {
			System.err.println("Fehler!");
		}
	}

	@Override
	public void deleteK(Object key) {
//		int i = 1;
//		while (i <= array.length) {
//			int pos = (int) this.find(key);
//			array[pos] = null;
//			i++;
//		}
		int p =(int) this.find(key);
		int i = 1;
		while (i <= array.length) {
	
		 p =(int) this.find(key);
		deleteP(p);
		i++;
		}
	}

	@Override
	public Object find(Object key) {

		for (int i = 0; i < array.length; i++) {
			if(array[i]!=null){
			if (key.equals(array[i].getKey())) {
				return i;
			}
			}
		}
		return key;
		
	}

	@Override
	public Object retrieve(int pos) {
		if (pos >= 0 && pos <= groesse) {
			return array[pos];

		} else {
			System.err.println("Kein Element!");
			return null;
		}
	}

	@Override
	public void concat(ListenInterface liste) {

		if (this.getClass().equals(liste.getClass())) {
			int i = 0;
			while (array[i] != null) {
				if (i == groesse) {
					listeVergrößern();
				}
				i++;

			}
			// array=System.arraycopy(liste, 0, array, i, liste.length);
		}

	}

	public void listeVergrößern() {
		array = Arrays.copyOf(array, array.length * 2);
		groesse *= 2;
	}

	public void ausgeben() {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public static void main(String[] args) {
		A a = new A(10);
		Student student1 = new Student();
		Student student2 = new Student();
		Student student3 = new Student();
		Student student4 = new Student();
		Student student5 = new Student();
		a.insert(0, student1);
		a.insert(1, student2);
		a.insert(2, student3);
		a.insert(3, student4);
		a.insert(4, student5);
		

		a.ausgeben();
		System.out.println();
		a.deleteK(1);
		a.deleteK(2);
		a.ausgeben();
	}
}

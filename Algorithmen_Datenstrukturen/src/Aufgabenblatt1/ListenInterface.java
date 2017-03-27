package Aufgabenblatt1;

public interface ListenInterface<T> {
	
	void insert(T pos, T element);
	void deleteP(T pos);
	void deleteK(int key);
	//aenderungsvorschlag mit alter implementierung 
	// U find(U key);
	T find(int key);
	T retrieve(T pos);
	void concat (ListenInterface<T> liste);
}

package Aufgabenblatt1;

public interface ListenInterface<T, U> {
	
	void insert(int pos, T element);
	void deleteP(int pos);
	void deleteK(U key);
	//aenderungsvorschlag mit alter implementierung 
	// U find(U key);
	int find(U key);
	T retrieve(int pos);
	void concat (ListenInterface liste);
}

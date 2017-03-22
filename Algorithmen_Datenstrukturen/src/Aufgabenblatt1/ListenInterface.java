package Aufgabenblatt1;

import java.util.List;

public interface ListenInterface<T, U> {

	void insert(int pos, T element);
	void deleteP(int pos);
	void deleteK(U key);
	U find(U key);
	T retrieve(int pos);
	void concat (ListenInterface liste);
}

package Aufgabenblatt1;

public class BList<T> implements ListenInterface<T> {
	private BArray startDummy;
	private BArray endDummy;

	public BList() {
		startDummy.next = endDummy;
		endDummy.previous = startDummy;
	}

	@Override
	public T find(int key) {

		int search = (int) key;
		startDummy.setKey(search);
		BArray previous = endDummy.previous;
		while (previous.getKey() != search) {
			previous = previous.previous;
		}
		if (previous.equals(startDummy)) {
			return null;
		}
		return (T) previous.getPos();
	}

	@Override
	public void insert(T pos, T element) {
		if (pos instanceof BArray && element instanceof BArray) {
			BArray position = (BArray) pos;
			BArray insertElement = (BArray) element;
			insertElement.setPrevious(position.getPrevious());
			insertElement.setNext(position);
			position.previous.setNext(insertElement);
			position.setPrevious(insertElement);
		}

	}

	@Override
	public void deleteP(T pos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteK(int key) {
		// TODO Auto-generated method stub

	}

	@Override
	public T retrieve(T pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void concat(ListenInterface<T> liste) {
		// TODO Auto-generated method stub

	}

}

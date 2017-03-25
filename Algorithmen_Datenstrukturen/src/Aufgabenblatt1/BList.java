package Aufgabenblatt1;

public class BList<T, U> implements ListenInterface<T, U> {
	private BArray startDummy;
	private BArray endDummy;
	
	public BList(){
		startDummy.next = endDummy;
		endDummy.previous = startDummy;
	}

	@Override
	public void insert(int pos, T element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteP(int pos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteK(U key) {
		// TODO Auto-generated method stub

	}

	@Override
	public int find(U key) {
		if (key.getClass().equals(int.class)) {
			int search = (int) key;
			startDummy.setKey(search);
			BArray next = endDummy.previous;
			while(next.getKey()!=search){
				next= next.previous;
			}
			if(next.equals(startDummy)){
				return 0;
			}
			return next.getPos();
		}
		
		return 0;
	}

	@Override
	public T retrieve(int pos) {
//			startDummy.setPos(pos);
//			BArray next = endDummy.previous;
//			while(next.getKey()!=search){
//				next= next.previous;
//			}
//			if(next.equals(startDummy)){
//				return 0;
//			}
//			return next.getPos();
		return null;
	}

	@Override
	public void concat(ListenInterface liste) {
		// TODO Auto-generated method stub

	}

}

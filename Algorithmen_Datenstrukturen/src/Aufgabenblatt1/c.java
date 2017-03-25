package Aufgabenblatt1;

public class c implements ListenInterface<Object, Object> {
	private Person Dummy;
	private Person DummyStop;
	private Person currentPerson;
	private int firstPosition = 1;

	public c() {
		Dummy.setNextPerson(DummyStop);
	}

	@Override
	public void insert(int pos, Object element) {
		currentPerson = Dummy;
		if (element instanceof Person) {
			for (int i = firstPosition; i < pos; i++) {
				currentPerson = currentPerson.getNextPerson();
				if (currentPerson == DummyStop) {
					return;
				}
			}
			Person afterInsert = currentPerson.getNextPerson();
			currentPerson.setNextPerson((Person) element);
			currentPerson.getNextPerson().setNextPerson(afterInsert);
		}
	}

	@Override
	public void deleteP(int pos) {
		currentPerson = Dummy;
		for (int i = firstPosition; i < pos; i++) {
			currentPerson = currentPerson.getNextPerson();
		}
		currentPerson.setNextPerson(currentPerson.getNextPerson().getNextPerson());

	}

	@Override
	public void deleteK(Object key) {
		currentPerson = Dummy;
		while (currentPerson.getNextPerson().getKey() != (int) key) {
			if (currentPerson == DummyStop) {
				return;
			}
			currentPerson = currentPerson.getNextPerson();
		}
		currentPerson.setNextPerson(currentPerson.getNextPerson().getNextPerson());
	}

	//return Type von Object geaendert, da Interface angepasst
	@Override
	public int find(Object key) {
		int position = 0;
		currentPerson = Dummy;
		while (currentPerson.getNextPerson().getKey() != (int) key) {
			if (currentPerson == DummyStop) {
				//return Type auf int geaendert und deshalb hier auf 0 und nicht Null
				return 0;
			}
			currentPerson = currentPerson.getNextPerson();
			position++;
		}
		return position;
	}

	@Override
	public Object retrieve(int pos) {
		currentPerson = Dummy;
		for (int i = firstPosition; i < pos; i++) {
			currentPerson = currentPerson.getNextPerson();
			if (currentPerson == DummyStop) {
				return null;
			}
		}
		return currentPerson.getNextPerson();
	}

	// Override entfernt
	public void concat(Object liste) {
		Person newListe = null;
		if (liste instanceof Person) {
			newListe = (Person) liste;
		} else {
			return;
		}
		currentPerson = Dummy;
		while (currentPerson.getNextPerson() != DummyStop) {
			currentPerson = currentPerson.getNextPerson();
		}
		currentPerson.setNextPerson(newListe.getNextPerson());
		newListe.setNextPerson(null);
	}

	@Override
	public void concat(ListenInterface liste) {

	}

}

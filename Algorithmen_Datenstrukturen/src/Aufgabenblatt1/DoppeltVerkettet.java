package Aufgabenblatt1;

public class DoppeltVerkettet implements Liste {

	private Knoten tail;
	private Knoten head;
	private int listenLaenge;

	public Knoten getHead() {
		Aufwandsanalyse.counter++;
		return head;
	}

	public Knoten getTail() {
		Aufwandsanalyse.counter++;
		return tail;
	}

	public void Clear() {
		head = new Knoten(null, null, null);
		tail = new Knoten(head, null, null);
		head.setNachfolger(tail);
		listenLaenge = 0;
	}

	public DoppeltVerkettet() {
		head = new Knoten(null, null, null);
		tail = new Knoten(head, null, null);
		head.setNachfolger(tail);
		listenLaenge = 0;
	}

	/*
	 * Insert-Methode Fügt einer Doppeltverketteten Liste ein Element hinzu
	 * 
	 */
	@Override
	public Knoten insert(Knoten pos, Element element) {
		Aufwandsanalyse.counter++;
		if (pos == null || pos == tail || pos == head) {
			throw new IndexOutOfBoundsException();
		}

		// Ueberpruefung ob es einen Vorgaenger gibt
		if (pos.getVorgaenger() != null) {
			// Knotensyntax = new Knoten(Vorgaenger, Nachfolger, Element)
			Knoten swap = new Knoten(pos, pos.getNachfolger(), pos.getElement());
			
			
			swap.getNachfolger().setVorgaenger(swap);
			pos.setNachfolger(swap);
			pos.setElement(element);
			listenLaenge++;
		} else { // Es kann mit Tail gearbeitet werden
			pos.setElement(element);
			pos.setNachfolger(tail);
			pos.setVorgaenger(tail.getVorgaenger());
			tail.getVorgaenger().setNachfolger(pos);
			tail.setVorgaenger(pos);
			listenLaenge++;
		}
		return pos;
	}

	@Override
	public boolean delete(Knoten pos) {
		Aufwandsanalyse.counter++;
		// Existiert der Knoten?
		if (pos == null || pos == tail || pos == head || pos.getElement() == null) {
			throw new IndexOutOfBoundsException();
		}

		// Zeiger umbiegen
		pos.getVorgaenger().setNachfolger(pos.getNachfolger());
		pos.getNachfolger().setVorgaenger(pos.getVorgaenger());

		// Den Knoten leeren
		pos.setNachfolger(null);
		pos.setVorgaenger(null);
		pos.setElement(null);
		listenLaenge--;
		return true;
	}

	@Override
	public Knoten find(Element key) {
		Aufwandsanalyse.counter++;
		Knoten swap = head.getNachfolger();
		tail.setElement(key);

		while (swap.getElement() != key) {
			swap = swap.getNachfolger();
		}
		if (swap == tail) {
			return null;
		}
		return swap;
	}

	@Override
	public Element retrieve(Knoten pos) {
		if (pos == null || pos == tail || pos == head) {
			throw new IndexOutOfBoundsException();
		}
		Aufwandsanalyse.counter++;
		// Anhand des Knotens kann man direkt das Element (Key) bekommen.
		return pos.getElement();
	}

	@Override
	public boolean concat(Liste liste2) {
		Aufwandsanalyse.counter++;
		if (liste2 instanceof DoppeltVerkettet) {
			DoppeltVerkettet tmp = (DoppeltVerkettet) liste2;
			// Zeiger umbiegen. Setzen des Nachfolgers des letzten Elementes der
			// ersten Liste, auf das erste Element der zweiten Liste
			tail.getVorgaenger().setNachfolger(tmp.getHead().getNachfolger());
			// Setzen des Vorgaengers des ersten Elementes der
			// zweiten Liste, auf das letzte Element der ersten Liste
			tmp.getHead().getNachfolger().setVorgaenger(tail.getVorgaenger());
			// Neues Tail ist Tail der zweiten Liste
			tail = tmp.getTail();
			listenLaenge += tmp.size();
			tmp.Clear();
		}
		return true;
	}

	@Override
	public int size() {
		Aufwandsanalyse.counter++;
		return listenLaenge;
	}

}
package Aufgabenblatt1;

public class EinfachVerkettet implements Liste {
	Knoten head;
	Knoten tail;
	int laenge;

	public EinfachVerkettet() {
		Aufwandsanalyse.counter++;
		head = new Knoten(null, tail, null);
		tail = new Knoten(null, head, null);
		head.setNachfolger(tail);
		laenge = 0;
	}

	@Override
	public Knoten insert(Knoten knoten, Element element) {
		Aufwandsanalyse.counter++;
		Knoten q;
		Knoten durchlaufKnoten = head;
		if (tail.getNachfolger() == head && knoten == null) { //Leere Liste
			q = new Knoten(null, tail, element); //neuer Knoten mit "element"
			head.setNachfolger(q);		
			tail.setNachfolger(q);
			knoten = head; //eingefügter neuer Knoten
			laenge++;
		} else if (knoten != null) {	//Knotenposition wo eingefügt wird
			while (durchlaufKnoten != tail) { //Durchlauf bis maximal "tail"
				if (durchlaufKnoten == knoten) { //Knoten gefunden
					q = new Knoten(null, knoten.getNachfolger(), element);	//neuer Knoten nach "knoten"
					knoten.setNachfolger(q);	//nach "knoten" wird der neue Knoten gebunden
					if (q.getNachfolger() == tail) {//Wenn neuer Knoten am Ende -> knoten <-> tail|
						tail.setNachfolger(q);
					}
					laenge++;
					break;
				}
				durchlaufKnoten = durchlaufKnoten.getNachfolger();
			}
		}
		return knoten;
	}


	@Override
	public boolean delete(Knoten knoten) {
		Aufwandsanalyse.counter++;
		boolean result = false;
		Knoten durchlaufKnoten = head;
		if (head.getNachfolger() != tail) { //Wenn Liste nicht leer
			while (durchlaufKnoten != tail) { //Ende nicht erreicht
				if (durchlaufKnoten == knoten) { //Position gefunden
					Knoten q = knoten.getNachfolger(); 
					knoten.setNachfolger(q.getNachfolger());
					q.setElement(null);
					q.setNachfolger(null);
					laenge--;
					result = true;
					break;
				}
				durchlaufKnoten = durchlaufKnoten.getNachfolger();
			}
		}
		return result;
	}

	@Override
	public Knoten find(Element element) {
		Aufwandsanalyse.counter++;
		tail.setElement(element); //Stopper "element" im tail
		Knoten posVor;
		Knoten pos = head; //Start position beim "head"
		do {
			posVor = pos;
			pos = pos.getNachfolger();
		} while (pos.getElement() != element); //Durchlauf bis "element" gefunden ist
		tail.setElement(null); //Stopper "tail" wird geleert
		return posVor;
	}

	@Override
	public Element retrieve(Knoten knoten) {
		Aufwandsanalyse.counter++;
		return knoten.getNachfolger().getElement();
	}

	@Override
	public boolean concat(Liste liste) {
		Aufwandsanalyse.counter++;
		boolean result = false;
		if (liste != null) {
			EinfachVerkettet tempListe = (EinfachVerkettet) liste;
			laenge += tempListe.size();
			Knoten anfangTempListe = tempListe.getHead().getNachfolger(); //Anfangsknoten 2.Liste
			Knoten endeTempListe = tempListe.getTail().getNachfolger(); //Endknoten 2.Liste
			Knoten endeListe = tail.getNachfolger(); //Endknoten 1.Liste
			endeListe.setNachfolger(anfangTempListe); //Endknoten 1.Liste -> Anfangsknoten 2.Liste
			endeTempListe.setNachfolger(tail); //Endknoten 2.Liste -> "tail" 1.Liste
			tail.setNachfolger(endeTempListe); //Endknoten 2.Liste <- "tail" 1.Liste
			result = true;
		}
		return result;
	}

	@Override
	public int size() {
		Aufwandsanalyse.counter++;
		return laenge;
	}

	public Knoten getHead() {
		Aufwandsanalyse.counter++;
		return head;
	}

	public Knoten getTail() {
		Aufwandsanalyse.counter++;
		return tail;
	}

}

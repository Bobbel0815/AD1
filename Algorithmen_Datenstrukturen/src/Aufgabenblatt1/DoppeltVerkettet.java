package Aufgabenblatt1;

public class DoppeltVerkettet implements Liste {
	private Knoten knotenliste[];
	private Knoten dummyStart;
	private Knoten dummyEnd;

	public DoppeltVerkettet() {
		knotenliste = new Knoten[10];
		knotenliste[0] = new Knoten(null, null, null);
		dummyStart = knotenliste[0];
		dummyEnd = knotenliste[0];
		knotenliste[0].setNachfolger(dummyStart);
		knotenliste[0].setVorgaenger(dummyEnd);
	}

	private Knoten insertFirstKnoten(Element element) {
		Knoten neuerKnoten = new Knoten(knotenliste[0], knotenliste[0], element);
		knotenliste[0].setVorgaenger(neuerKnoten);
		knotenliste[0].setNachfolger(neuerKnoten);
		knotenliste[1] = neuerKnoten;
		dummyStart = neuerKnoten;
		dummyEnd = neuerKnoten;
		return neuerKnoten;
	}

	@Override
	public Knoten insert(Knoten knoten, Element element) {
		Knoten erstellterKnoten = null;
		// this.size == 0 bedeutet liste noch leer also neues Element an den
		// Anfang einfuegen
		if (this.size() == 0 && knoten == null) {
			erstellterKnoten = insertFirstKnoten(element);
		} else if (this.size() > 0 && knoten != null) {
			Knoten durchlaufKnoten = dummyEnd;
			while (durchlaufKnoten != knotenliste[0]) {
				if (knoten.equals(durchlaufKnoten)) {
					Knoten neuerKnoten = new Knoten(durchlaufKnoten.getVorgaenger(), durchlaufKnoten, element);
					durchlaufKnoten.getVorgaenger().setNachfolger(neuerKnoten);
					durchlaufKnoten.setVorgaenger(neuerKnoten);
					erstellterKnoten = neuerKnoten;
					for (int i = 1; i <= knotenliste.length; i++) {
						if (i < knotenliste.length && knotenliste[i] == null) {
							knotenliste[i] = neuerKnoten;
							break;
						}
						if (i == knotenliste.length) {
							vergroesserArray();
							knotenliste[i] = neuerKnoten;
							break;
						}
					}
					if (durchlaufKnoten.equals(dummyStart)) {
						dummyStart = neuerKnoten;
						knotenliste[0].setNachfolger(dummyStart);
					}
					break;
				}
				durchlaufKnoten = durchlaufKnoten.getVorgaenger();
			}
		}
		return erstellterKnoten;
	}

	private void vergroesserArray() {
		Knoten tempknotenliste[] = new Knoten[knotenliste.length * 2];
		for (int i = 0; i < knotenliste.length; i++) {
			tempknotenliste[i] = knotenliste[i];
		}
		knotenliste = tempknotenliste;
	}

	@Override
	public boolean delete(Knoten knoten) {
		boolean result = false;

		if (knoten != null) {
			Knoten durchlaufKnoten = knotenliste[0];
			while (durchlaufKnoten.getNachfolger() != knotenliste[0]) {
				if (knoten.equals(durchlaufKnoten.getNachfolger())) {
					result = true;
					for (int i = 1; i < knotenliste.length; i++) {
						if (knotenliste[i] != null && knotenliste[i].equals(durchlaufKnoten.getNachfolger())) {
							knotenliste[i] = null;
							break;
						}
					}
					if (durchlaufKnoten.getNachfolger().equals(dummyEnd)
							&& durchlaufKnoten.getNachfolger().equals(dummyStart)) {
						dummyStart = knotenliste[0];
						dummyEnd = knotenliste[0];
						knotenliste[0].setNachfolger(dummyStart);
						knotenliste[0].setVorgaenger(dummyEnd);
					} else if (durchlaufKnoten.getNachfolger().equals(dummyEnd)) {
						dummyEnd = durchlaufKnoten;
						dummyEnd.setNachfolger(knotenliste[0]);
						knotenliste[0].setVorgaenger(dummyEnd);
					} else if (durchlaufKnoten.getNachfolger().equals(dummyStart)) {
						dummyStart = durchlaufKnoten.getNachfolger().getNachfolger();
						knotenliste[0].setNachfolger(dummyStart);
						durchlaufKnoten.getNachfolger().getNachfolger().setVorgaenger(durchlaufKnoten);
						durchlaufKnoten.setNachfolger(durchlaufKnoten.getNachfolger().getNachfolger());
					} else {
						durchlaufKnoten.getNachfolger().getNachfolger().setVorgaenger(durchlaufKnoten);
						durchlaufKnoten.setNachfolger(durchlaufKnoten.getNachfolger().getNachfolger());
					}
					break;
				}
				durchlaufKnoten = durchlaufKnoten.getNachfolger();
			}
		}
		return result;
	}

	@Override
	public Knoten find(Element element) {
		Knoten result = null;
		knotenliste[0].setElement(element);
		Knoten durchlaufKnoten = dummyEnd;
		while (durchlaufKnoten.getElement() != element) {
			durchlaufKnoten = durchlaufKnoten.getVorgaenger();
		}
		if (durchlaufKnoten.equals(dummyStart.getVorgaenger())) {
			result = null;
		} else {
			result = durchlaufKnoten;
		}
		knotenliste[0].setElement(null);
		return result;
	}

	@Override
	public Element retrieve(Knoten knoten) {
		Element result = null;
		Knoten durchlaufKnoten = dummyEnd;
		int groesse = this.size();
		while (!durchlaufKnoten.equals(knoten) && groesse > 0) {
			durchlaufKnoten = durchlaufKnoten.getVorgaenger();
			groesse--;
		}
		if (durchlaufKnoten.equals(knoten) && groesse > 0) {
			result = durchlaufKnoten.getElement();
		} else {
			result = null;
		}
		return result;
	}

	@Override
	public boolean concat(Liste liste) {
		boolean result = false;
		if (liste instanceof DoppeltVerkettet) {
			DoppeltVerkettet zweiteListe = (DoppeltVerkettet) liste;
			if (this.size() > 0 && zweiteListe.size() > 0) {
				result = true;

				Knoten tempknotenliste[] = new Knoten[(this.size() + zweiteListe.size()) * 2];

				dummyEnd.setNachfolger(zweiteListe.dummyStart);
				zweiteListe.dummyStart.setVorgaenger(dummyEnd);
				dummyEnd = zweiteListe.dummyEnd;

				int stelle = 0;
				for (int i = 0; i < knotenliste.length; i++) {
					if (knotenliste[i] != null) {
						tempknotenliste[stelle] = knotenliste[i];
						stelle++;
					}
				}

				for (int j = 1; j < zweiteListe.knotenliste.length; j++) {
					if (zweiteListe.knotenliste[j] != null) {
						tempknotenliste[stelle] = zweiteListe.knotenliste[j];
						stelle++;
					}
				}
				knotenliste = tempknotenliste;
				knotenliste[0].setVorgaenger(dummyEnd);
				dummyEnd.setNachfolger(knotenliste[0]);
			} else if (this.size() == 0 && zweiteListe.size() > 0) {
				result = true;

				knotenliste = zweiteListe.knotenliste;
				dummyStart = zweiteListe.dummyStart;
				dummyEnd = zweiteListe.dummyEnd;
			}
		}
		return result;
	}
	
	public Knoten getDummyEnd(){
		Aufwand.counter++;
		return dummyEnd;
	}

	@Override
	public int size() {
		int anzahl = 0;
		Knoten durchlaufKnoten = dummyEnd;
		while (durchlaufKnoten != knotenliste[0]) {
			anzahl++;
			durchlaufKnoten = durchlaufKnoten.getVorgaenger();
		}
		return anzahl;
	}
}

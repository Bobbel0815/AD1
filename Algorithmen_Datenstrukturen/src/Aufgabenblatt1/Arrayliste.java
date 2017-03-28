package Aufgabenblatt1;

public class Arrayliste implements Liste {
	private int groesse; // gesammt größe des Arrays
	private int gesammtindex; // der index des letzten belegten elemts
	private Knoten[] array; // array in dem die knoten gespeichert werden

	public Arrayliste() {
		this(1000);
	}

	public Arrayliste(int groesse) {
		Aufwandsanalyse.counter++;
		gesammtindex = 0;
		this.groesse = groesse;
		array = new Knoten[groesse];
	}

	public Knoten[] getArray() {
		Aufwandsanalyse.counter++;
		return array;
	}

	/**
	 * Fügt das Element an der Stelle der Liste ein an dem sich der Knoten
	 * befindet.
	 */
	@Override
	public Knoten insert(Knoten knoten, Element element) {
		Aufwandsanalyse.counter++;
		Knoten result = null;
		if (element != null) {
			if (gesammtindex + 1 >= groesse) // es ist nicht genug platz =>
												// array erweitern
			{
				arrayerweitern(2);
			}

			if (knoten == null && gesammtindex == 0) // kein knoten definiert
														// und listeleer knoten
														// einfügen
			{
				result = new Knoten(null, null, element);
				array[gesammtindex + 1] = result;
				gesammtindex++;

			} else // ein definierter Knoten => Knoten suchen und an diesem
					// Index einfügen
			{
				int index = findeindex(knoten);
				if (index > 0) // knoten vor dem übergebenen knoten einfügen
				{
					nachhintenschieben(index);
					result = new Knoten(null, null, element);
					array[index] = result;
					// _gesammtindex++; wird beim nach hinten schieben erweitert
				}
			}
		}
		return result;
	}

	/**
	 * Löscht den Knoten aus der Liste.
	 */
	@Override
	public boolean delete(Knoten knoten) {
		Aufwandsanalyse.counter++;
		boolean result = false;
		int index = findeindex(knoten);
		if (index > 0) {
			nachvorneschieben(index);
			gesammtindex--;
			result = true;
		}
		return result;
	}

	/**
	 * Liefert den Knoten für das übegebene Element.
	 */
	@Override
	public Knoten find(Element element) {
		Aufwandsanalyse.counter++;
		for (int i = gesammtindex; i > 0; i--) {
			if (array[i].getElement() == element) {
				Aufwandsanalyse.counter++;
				return array[i];
			}Aufwandsanalyse.counter++;
		}
		return null;
	}

	/**
	 * Liefert das am Knoten gebundene Element.
	 */
	@Override
	public Element retrieve(Knoten knoten) {
		Aufwandsanalyse.counter++;
		int index = findeindex(knoten);
		if (index != 0) {
			return array[index].getElement();
		} else {
			return null;
		}
	}

	/**
	 * Konkatiniert die gegebene mit der aktuellen Liste.
	 */
	@Override
	public boolean concat(Liste liste) {
		Aufwandsanalyse.counter++;
		boolean result = false;
		if (liste instanceof Arrayliste) {
			Arrayliste arrayliste = (Arrayliste) liste;

			int multipler = ((gesammtindex + arrayliste.size()) / groesse) + 1;
			if (multipler > 1) {
				arrayerweitern(multipler);
			}

			for (int i = 1; i <= arrayliste.size(); i++) {
				array[gesammtindex + 1] = arrayliste.array[i];
				gesammtindex++;
				Aufwandsanalyse.counter++;
			}
			result = true;

		}
		return result;
	}

	/**
	 * Gibt die Laenge der Liste zurueck.
	 */
	@Override
	public int size() {
		Aufwandsanalyse.counter++;
		return gesammtindex;
	}

	protected int listenlaenge() {
		Aufwandsanalyse.counter++;
		return groesse;
	}

	private int findeindex(Knoten knoten) {
		Aufwandsanalyse.counter++;
		for (int i = gesammtindex; i > 0; i--) {
			Aufwandsanalyse.counter++;
			if (array[i] == knoten) {
				return i;
			}
		}
		return 0;

	}

	// knoten an position index rutsch auf index+1 usw.
	private void nachhintenschieben(int index) {
		Aufwandsanalyse.counter++;
		for (int i = gesammtindex; i >= index; i--) {
			array[i + 1] = array[i];
			Aufwandsanalyse.counter++;
		}
		gesammtindex++;
	}

	// knoten an position index+1 rutsch auf index usw.
	private void nachvorneschieben(int index) {
		for (int i = index; i < gesammtindex; i++) {
			array[index] = array[index + 1];
			Aufwandsanalyse.counter++;
		}
	}

	private void arrayerweitern(int multipler) {
		Aufwandsanalyse.counter++;
		// Array sichern
		Knoten[] temparray = array;
		int tempindex = gesammtindex;
		groesse *= multipler;
		array = new Knoten[groesse];
		gesammtindex = 0;

		// in neuen array kopieren
		for (int i = gesammtindex; i < tempindex; i++) {
			array[gesammtindex + 1] = temparray[gesammtindex + 1];
			gesammtindex++;
			Aufwandsanalyse.counter++;
		}
	}
}

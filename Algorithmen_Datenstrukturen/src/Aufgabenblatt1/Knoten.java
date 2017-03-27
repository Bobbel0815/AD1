package Aufgabenblatt1;

/**
 * Diese Klasse modelliert doppelt verkettbare Knoten, die jeweils ein Element
 * vom Typ Object enthalten koennen.
 * 
 * @author Daniel von Drathen
 */
public class Knoten {

	Knoten vorgaenger;
	Knoten nachfolger;
	Element element;

	/**
	 * Erzeugt einen neuen Knoten ohne Element, Vorgaenger und Nachfolger.
	 */
	public Knoten() {
	}

	/**
	 * Erzeugt einen neuen Knoten und setzt Element, Vorgaenger und Nachfolger.
	 * 
	 * @param vorgaenger
	 * @param nachfolger
	 * @param element
	 */
	public Knoten(Knoten vorgaenger, Knoten nachfolger, Element element) {
		this.vorgaenger = vorgaenger;
		this.nachfolger = nachfolger;
		this.element = element;
	}

	public void setVorgaenger(Knoten vorgaenger) {
		this.vorgaenger = vorgaenger;
	}

	public void setNachfolger(Knoten nachfolger) {
		this.nachfolger = nachfolger;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public Knoten getVorgaenger() {
		return vorgaenger;
	}

	public Knoten getNachfolger() {
		return nachfolger;
	}

	public Element getElement() {
		return element;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((element == null) ? 0 : element.hashCode());
		result = prime * result + ((nachfolger == null) ? 0 : nachfolger.hashCode());
		result = prime * result + ((vorgaenger == null) ? 0 : vorgaenger.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		Knoten other = (Knoten) obj;

		boolean elementBool;
		if (element != null && other.element != null) {
			elementBool = element.equals(other.element);
		} else if (element == null && other.element == null) {
			elementBool = true;
		} else {
			elementBool = false;
		}

		return elementBool && (vorgaenger == other.vorgaenger) && (nachfolger == other.nachfolger);
	}
}
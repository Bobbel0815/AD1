/**
 * Eine Schnittstelle fuer Listen.
 * 
 * @author Dennis Schroeder1
 */
public interface Liste {
	
	/**
	 * Fuegt das Element vor dem gegebenen Knoten ein.
	 * Ein Aufruf bei dem der Parameter 'knoten' null ist, 
	 * fuehrt bei leerer Liste zum einfuegen an erster Stelle.
	 * 
	 * @param knoten vor dem eingef�gt werden soll
	 * @param element das einzuf�gende Element 
	 * @return der Knoten der in die liste eingef�gt und mit dem Element verkn�pf wurde.
	 * 			Null bedeutet keine Knoten erstellt element wurde nicht aufgenommen.
	 * 
	 * 
	 * @require element != Null
	 * @require (knoten == Null && size() == 0) | (retrieve(knoten) != null)
	 * 
	 * 
	 * @ensure find(Element element) =! null
	 * 
	 */
	Knoten insert(Knoten knoten, Element element);
	
	
	/**
	 * Loescht den Knoten aus der Liste.
	 * 
	 * @param knoten der Knoten der gel�scht werden soll
	 * @return ob der Knoten gel�scht wurde
	 * 
	 * @ensure retrieve(knoten) == null Knoten ist nicht in der Liste.
	 */
	boolean delete(Knoten knoten);

	/**
	 * Liefert den Knoten fuer das gegebene Element.
	 * 
	 * @param element das Element was gesucht werden soll
	 * @return der knoten der auf das Element verweist
	 * 
	 * @require element != null
	 * 
	 * @ensure retive(knoten) == element | knoten == null (wenn nicht in der liste)
	 */
	Knoten find(Element element);
	
	/**
	 * Liefert das am Knoten gebundene Element.
	 * 
	 * @param knoten der gesucht werden soll
	 * @return das Elemnt auf das der Knoten verweist
	 * 
	 * @require knoten != null
	 * 
	 * @ensure find(element) == knoten | element == null (wenn nicht in der liste)
	 */
	Element retrieve(Knoten knoten);
	
	/**
	 * Konkatiniert die gegebene(Liste vom eigenen Typ) mit der aktuellen Liste.
	 * 
	 * @param liste die liste die angef�gt werden soll
	 * @return ob das verbinden erfolgreich war
	 * 
	 * @require liste != Null
	 * @require this instanceof liste (die beiden sind vom gleichen typ
	 * 
	 * @ensure die zweite liste wurde an die erste angeh�ngt
	 */
	boolean concat(Liste liste);
	
	/**
	 * Gibt die Laenge der Liste zurueck.
	 * @return die Laenge der liste
	 */
	int size();	
	
}
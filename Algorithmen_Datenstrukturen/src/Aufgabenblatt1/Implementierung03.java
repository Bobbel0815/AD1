
public class Implementierung03 implements Liste
{
	Knoten head;
	Knoten tail;
	int laenge;

	public Implementierung03()
	{
		head = new Knoten(null, tail, null);
		tail = new Knoten(null, head, null);
		head.setNachfolger(tail);
		laenge = 0;
	}

	@Override

	public Knoten insert(Knoten knoten, Element element)
	{
		Knoten q;
		Knoten durchlaufKnoten = head;
		if(tail.getNachfolger() == head && knoten == null)
		{
			q = new Knoten(null, tail, element);
			head.setNachfolger(q);
			tail.setNachfolger(q);
			knoten = head;
			laenge++;
		}
		else if(knoten != null)
		{
			while(durchlaufKnoten != tail)
			{
				if(durchlaufKnoten == knoten)
				{
					q = new Knoten(null, knoten.getNachfolger(), element);
					knoten.setNachfolger(q);
					if(q.getNachfolger() == tail)
					{
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

	public void insertFirstKnoten(Element element)
	{
		this.insert(null, element);
	}

	@Override
	public boolean delete(Knoten knoten)
	{
		boolean result = false;
		Knoten durchlaufKnoten = head;
		if(head.getNachfolger() != tail)
		{
			while(durchlaufKnoten != tail)
			{
				if(durchlaufKnoten == knoten)
				{
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
	public Knoten find(Element element)
	{
		tail.setElement(element);
		Knoten posVor;
		Knoten pos = head;
		do
		{
			posVor = pos;
			pos = pos.getNachfolger();
		}
		while(pos.getElement() != element);
		tail.setElement(null);
		return posVor;
	}

	@Override
	public Element retrieve(Knoten knoten)
	{
		return knoten.getNachfolger().getElement();
	}

	@Override
	public boolean concat(Liste liste)
	{
		boolean result = false;
		if(liste != null)
		{
			Implementierung03 tempListe = (Implementierung03) liste;
			laenge += tempListe.size();
			Knoten anfangTempListe = tempListe.getHead().getNachfolger();
			Knoten endeTempListe = tempListe.getTail().getNachfolger();
			Knoten endeListe = tail.getNachfolger();
			endeListe.setNachfolger(anfangTempListe);
			endeTempListe.setNachfolger(tail);
			tail.setNachfolger(endeTempListe);
			result = true;
		}
		return result;
	}

	@Override
	public int size()
	{
		return laenge;
	}

	public Knoten getHead()
	{
		return head;
	}

	public Knoten getTail()
	{
		return tail;
	}

}

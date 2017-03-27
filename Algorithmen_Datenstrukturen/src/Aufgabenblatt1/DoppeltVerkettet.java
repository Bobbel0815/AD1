
public class DoppeltVerkettet implements Liste
{
	private Knoten _knotenliste[];
	private Knoten _ersterKnoten;
	private Knoten _letzterKnoten;

	public DoppeltVerkettet()
	{
		_knotenliste = new Knoten[10];
		_knotenliste[0] = new Knoten(null, null, null);
		_ersterKnoten = _knotenliste[0];
		_letzterKnoten = _knotenliste[0];
		_knotenliste[0].setNachfolger(_ersterKnoten);
		_knotenliste[0].setVorgaenger(_letzterKnoten);
	}

	private Knoten insertFirstKnoten(Element element)
	{
		Knoten neuerKnoten = new Knoten(_knotenliste[0], _knotenliste[0], element);
		_knotenliste[0].setVorgaenger(neuerKnoten);
		_knotenliste[0].setNachfolger(neuerKnoten);
		_knotenliste[1] = neuerKnoten;
		_ersterKnoten = neuerKnoten;
		_letzterKnoten = neuerKnoten;
		return neuerKnoten;
	}

	@Override
	public Knoten insert(Knoten knoten, Element element)
	{
		Knoten erstellterKnoten = null;
		if(this.size() == 0 && knoten == null)
		{
			erstellterKnoten = insertFirstKnoten(element);
		}
		else if(this.size() > 0 && knoten != null)
		{
			Knoten durchlaufKnoten = _letzterKnoten;
			while(durchlaufKnoten != _knotenliste[0])
			{
				if(knoten.equals(durchlaufKnoten))
				{
					Knoten neuerKnoten = new Knoten(durchlaufKnoten.getVorgaenger(), durchlaufKnoten, element);
					durchlaufKnoten.getVorgaenger().setNachfolger(neuerKnoten);
					durchlaufKnoten.setVorgaenger(neuerKnoten);
					erstellterKnoten = neuerKnoten;
					for(int i = 1; i <= _knotenliste.length; i++)
					{
						if(i < _knotenliste.length && _knotenliste[i] == null)
						{
							_knotenliste[i] = neuerKnoten;
							break;
						}
						if(i == _knotenliste.length)
						{
							vergroesserArray();
							_knotenliste[i] = neuerKnoten;
							break;
						}
					}
					if(durchlaufKnoten.equals(_ersterKnoten))
					{
						_ersterKnoten = neuerKnoten;
						_knotenliste[0].setNachfolger(_ersterKnoten);
					}
					break;
				}
				durchlaufKnoten = durchlaufKnoten.getVorgaenger();
			}
		}
		return erstellterKnoten;
	}

	private void vergroesserArray()
	{
		Knoten tempknotenliste[] = new Knoten[_knotenliste.length * 2];
		for(int i = 0; i < _knotenliste.length; i++)
		{
			tempknotenliste[i] = _knotenliste[i];
		}
		_knotenliste = tempknotenliste;
	}

	@Override
	public boolean delete(Knoten knoten)
	{
		boolean result = false;

		if(knoten != null)
		{
			Knoten durchlaufKnoten = _knotenliste[0];
			while(durchlaufKnoten.getNachfolger() != _knotenliste[0])
			{
				if(knoten.equals(durchlaufKnoten.getNachfolger()))
				{
					result = true;
					for(int i = 1; i < _knotenliste.length; i++)
					{
						if(_knotenliste[i] != null && _knotenliste[i].equals(durchlaufKnoten.getNachfolger()))
						{
							_knotenliste[i] = null;
							break;
						}
					}
					if(durchlaufKnoten.getNachfolger().equals(_letzterKnoten)
					        && durchlaufKnoten.getNachfolger().equals(_ersterKnoten))
					{
						_ersterKnoten = _knotenliste[0];
						_letzterKnoten = _knotenliste[0];
						_knotenliste[0].setNachfolger(_ersterKnoten);
						_knotenliste[0].setVorgaenger(_letzterKnoten);
					}
					else if(durchlaufKnoten.getNachfolger().equals(_letzterKnoten))
					{
						_letzterKnoten = durchlaufKnoten;
						_letzterKnoten.setNachfolger(_knotenliste[0]);
						_knotenliste[0].setVorgaenger(_letzterKnoten);
					}
					else if(durchlaufKnoten.getNachfolger().equals(_ersterKnoten))
					{
						_ersterKnoten = durchlaufKnoten.getNachfolger().getNachfolger();
						_knotenliste[0].setNachfolger(_ersterKnoten);
						durchlaufKnoten.getNachfolger().getNachfolger().setVorgaenger(durchlaufKnoten);
						durchlaufKnoten.setNachfolger(durchlaufKnoten.getNachfolger().getNachfolger());
					}
					else
					{
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
	public Knoten find(Element element)
	{
		Knoten result = null;
		_knotenliste[0].setElement(element);
		Knoten durchlaufKnoten = _letzterKnoten;
		while(durchlaufKnoten.getElement() != element)
		{
			durchlaufKnoten = durchlaufKnoten.getVorgaenger();
		}
		if(durchlaufKnoten.equals(_ersterKnoten.getVorgaenger()))
		{
			result = null;
		}
		else
		{
			result = durchlaufKnoten;
		}
		_knotenliste[0].setElement(null);
		return result;
	}

	@Override
	public Element retrieve(Knoten knoten)
	{
		Element result = null;
		Knoten durchlaufKnoten = _letzterKnoten;
		int groesse = this.size();
		while(!durchlaufKnoten.equals(knoten) && groesse > 0)
		{
			durchlaufKnoten = durchlaufKnoten.getVorgaenger();
			groesse--;
		}
		if(durchlaufKnoten.equals(knoten) && groesse > 0)
		{
			result = durchlaufKnoten.getElement();
		}
		else
		{
			result = null;
		}
		return result;
	}

	@Override
	public boolean concat(Liste liste)
	{
		boolean result = false;
		if(liste instanceof DoppeltVerkettet)
		{
			DoppeltVerkettet zweiteListe = (DoppeltVerkettet) liste;
			if(this.size() > 0 && zweiteListe.size() > 0)
			{
				result = true;

				Knoten tempknotenliste[] = new Knoten[(this.size() + zweiteListe.size()) * 2];

				_letzterKnoten.setNachfolger(zweiteListe._ersterKnoten);
				zweiteListe._ersterKnoten.setVorgaenger(_letzterKnoten);
				_letzterKnoten = zweiteListe._letzterKnoten;

				int stelle = 0;
				for(int i = 0; i < _knotenliste.length; i++)
				{
					if(_knotenliste[i] != null)
					{
						tempknotenliste[stelle] = _knotenliste[i];
						stelle++;
					}
				}

				for(int j = 1; j < zweiteListe._knotenliste.length; j++)
				{
					if(zweiteListe._knotenliste[j] != null)
					{
						tempknotenliste[stelle] = zweiteListe._knotenliste[j];
						stelle++;
					}
				}
				_knotenliste = tempknotenliste;
				_knotenliste[0].setVorgaenger(_letzterKnoten);
				_letzterKnoten.setNachfolger(_knotenliste[0]);
			}
			else if(this.size() == 0 && zweiteListe.size() > 0)
			{
				result = true;

				_knotenliste = zweiteListe._knotenliste;
				_ersterKnoten = zweiteListe._ersterKnoten;
				_letzterKnoten = zweiteListe._letzterKnoten;
			}
		}
		return result;
	}

	@Override
	public int size()
	{
		int anzahl = 0;
		Knoten durchlaufKnoten = _letzterKnoten;
		while(durchlaufKnoten != _knotenliste[0])
		{
			anzahl++;
			durchlaufKnoten = durchlaufKnoten.getVorgaenger();
		}
		return anzahl;
	}
}

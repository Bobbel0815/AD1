package Aufgabenblatt1;

public class Arrayliste implements Liste
{
	private int _groesse; //gesammt größe des Arrays
	private int _gesammtindex; //der index des letzten belegten elemts
	private Knoten[] _array; // array in dem die knoten gespeichert werden
	
	public Arrayliste ()
	{
		this(1000);
	}
	
	public Arrayliste (int groesse)
	{
		_gesammtindex=0;
		_groesse = groesse;
		_array = new Knoten[groesse];
	}

	/**
	 * Fügt das Element an der Stelle der Liste ein an dem sich der Knoten befindet.
	 */
	@Override
	public Knoten insert(Knoten knoten, Element element)
	{
		Knoten result=null;
		if( element!= null)
		{
			if (_gesammtindex+1>=_groesse) // es ist nicht genug platz => array erweitern
			{
				arrayerweitern(2);
			}
			
			if (knoten == null && _gesammtindex==0) // kein knoten definiert und listeleer knoten einfügen
			{
				result = new Knoten(null,null,element);
				_array[_gesammtindex+1]= result;
				_gesammtindex++;
	
			}
			else // ein definierter Knoten => Knoten suchen und an diesem Index einfügen
			{
				int index = findeindex(knoten);
				if (index>0) // knoten vor dem übergebenen knoten einfügen
				{
					nachhintenschieben(index);
					result = new Knoten(null,null,element);
					_array[index]= result;
					//_gesammtindex++; wird beim nach hinten schieben erweitert
				}
			}
		}
		return result;
	}

	/**
	 * Löscht den Knoten aus der Liste.
	 */
	@Override
	public boolean delete(Knoten knoten) 
	{
		boolean result=false;
		int index = findeindex(knoten);
		if (index>0)
		{
			nachvorneschieben(index);
			_gesammtindex--;
			result = true;
		}
		return result;
	}

	/**
	 * Liefert den Knoten für das übegebene Element.
	 */
	@Override
	public Knoten find(Element element) 
	{
		for(int i=_gesammtindex;i>0;i--)
		{
			if(_array[i].getElement()==element)
			{
					return _array[i];
			}
		}
		return null;
	}

	/**
	 * Liefert das am Knoten gebundene Element.
	 */
	@Override
	public Element retrieve(Knoten knoten)
	{
		int index = findeindex(knoten);
		if (index!=0)
		{
			return _array[index].getElement();
		}
		else
		{
			return null;
		}
	}

	/**
	 * Konkatiniert die gegebene mit der aktuellen Liste.
	 */
	@Override
	public boolean concat(Liste liste) 
	{
		boolean result= false;
		if (liste instanceof Arrayliste)
		{
			Arrayliste arrayliste = (Arrayliste) liste;
			
			
			int multipler = ((_gesammtindex + arrayliste.size()) / _groesse)+1 ;
			if (multipler>1)
			{
				arrayerweitern(multipler);
			}
			
			for (int i=1;i<=arrayliste.size();i++)
			{
				_array[_gesammtindex+1]=arrayliste._array[i];
				_gesammtindex++;
			}
			result = true;
			
		}
		return result;
	}

	/**
	 * Gibt die Laenge der Liste zurueck.
	 */
	@Override
	public int size() 
	{
		return _gesammtindex;
	}
	
	protected int listenlaenge()
	{
		return _groesse;
	}
	
	private int findeindex(Knoten knoten)
	{
		for(int i=_gesammtindex;i>0;i--)
		{
			if(_array[i]==knoten)
			{
				return i;
			}
		}
		return 0;
		
	}
	
	//knoten an position index rutsch auf index+1 usw.
	private void nachhintenschieben(int index)
	{		
		for(int i = _gesammtindex;i>=index;i--)
		{
			_array[i+1]=_array[i];
		}
		_gesammtindex++;
	}
	
	//knoten an position index+1 rutsch auf index usw.
	private void nachvorneschieben(int index)
	{
		for(int i= index;i<_gesammtindex;i++)
		{
			_array[index]=_array[index+1];
		}
	}
	
	private void arrayerweitern(int multipler)
	{
		// Array sichern
		Knoten[] temparray=_array;
		int tempindex = _gesammtindex;
		_groesse*=multipler;
		_array = new Knoten[_groesse];
		_gesammtindex=0;
		
		// in neuen array kopieren
		for (int i=_gesammtindex;i<tempindex;i++)
		{
			_array[_gesammtindex+1]=temparray[_gesammtindex+1];
			_gesammtindex++;
		}
	}
}

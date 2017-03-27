public class Aufwandsanalyse
{
	private static Element _e1 = new Element(-1);
	private static Element _e2 = new Element(-2);
	private static Element _e3 = new Element(-3);
	private static int ms = 1000;

	public static void main(String[] args)
	{
		insert();
	}

	public static void insert()
	{
		initialisiere(new Arrayliste(), new Arrayliste(), 1);	
		initialisiere(new DoppeltVerkettet(), new DoppeltVerkettet(), 2);
		initialisiere(new Implementierung03(), new Implementierung03(), 3);
	}
	
	private static void analysiere(Liste liste, Liste liste2, Knoten anfang, Knoten mitte, Knoten ende)
	{
		long zeit1;
		long zeit2;
		long zeit3;
		long diff1;
		long diff2;
		long diff3;
		long result;
		
		zeit1 = System.nanoTime();
		liste.insert(anfang, _e1);
		diff1 = (System.nanoTime() - zeit1);

		zeit2 = System.nanoTime();
		liste.insert(mitte, _e2);
		diff2 = (System.nanoTime() - zeit2);

		zeit3 = System.nanoTime();
		liste.insert(ende, _e3);
		diff3 = (System.nanoTime() - zeit3);
		result = (diff1 + diff2 + diff3)/3;
		
		if(result/ms == 0)
		{
			System.out.println("Insert(" + liste.getClass() + ") Durchschnitt: " + result + "NANOSEK");
		}
		else
		{
			System.out.println("Insert(" + liste.getClass() + ") Durchschnitt: " + result/ms + "ms");
		}

		zeit1 = System.nanoTime();
		Knoten k1 = liste.find(_e1);
		diff1 = (System.nanoTime() - zeit1);

		zeit2 = System.nanoTime();
		Knoten k2 = liste.find(_e2);
		diff2 = (System.nanoTime() - zeit2);

		zeit3 = System.nanoTime();
		Knoten k3 = liste.find(_e3);
		diff3 = (System.nanoTime() - zeit3);
		
		result = (diff1 + diff2 + diff3)/3;
		
		if(result/ms == 0)
		{
			System.out.println("Find(" + liste.getClass() + ") Durchschnitt: " + result + "NANOSEK");
		}
		else
		{
			System.out.println("Find(" + liste.getClass() + ") Durchschnitt: " + result/ms + "ms");
		}

		zeit1 = System.nanoTime();
		liste.retrieve(k1);
		diff1 = (System.nanoTime() - zeit1);

		zeit2 = System.nanoTime();
		liste.retrieve(k2);
		diff2 = (System.nanoTime() - zeit2);

		zeit3 = System.nanoTime();
		liste.retrieve(k3);
		diff3 = (System.nanoTime() - zeit3);
		
		result = (diff1 + diff2 + diff3)/3;
		
		if(result/ms == 0)
		{
			System.out.println("Retrieve(" + liste.getClass() + ") Durchschnitt: " + result + "NANOSEK");
		}
		else
		{
			System.out.println("Retrieve(" + liste.getClass() + ") Durchschnitt: " + result/ms + "ms");
		}

		zeit1 = System.nanoTime();
		liste.delete(k1);
		diff1 = (System.nanoTime() - zeit1);

		zeit2 = System.nanoTime();
		liste.delete(k2);
		diff2 = (System.nanoTime() - zeit2);

		zeit3 = System.nanoTime();
		liste.delete(k3);
		diff3 = (System.nanoTime() - zeit3);
		
		result = (diff1 + diff2 + diff3)/3;
		if(result/ms == 0)
		{
			System.out.println("Delete(" + liste.getClass() + ") Durchschnitt: " + result + "NANOSEK");
		}
		else
		{
			System.out.println("Delete(" + liste.getClass() + ") Durchschnitt: " + result/ms + "ms");
		}

		zeit1 = System.nanoTime();
		int groesse = liste.size();
		result = (System.nanoTime() - zeit1);
		if(result/ms == 0)
		{
			System.out.println("Size(" + liste.getClass() + "): " + result + "NANOSEK");
		}
		else
		{
			System.out.println("Size(" + liste.getClass() + "): " + result/ms + "ms");
		}

		erzeugeListe(liste2, groesse / 10, new Element(0));

		zeit1 = System.nanoTime();
		liste.concat(liste2);
		result = (System.nanoTime() - zeit1);
		if(result/ms == 0)
		{
			System.out.println("Concat(" + liste.getClass() + "): " + result + "NANOSEK");
		}
		else
		{
			System.out.println("Concat(" + liste.getClass() + "): " + result/ms + "ms");
		}
		System.out.println("Fertig!\n");
	}
	
	private static void initialisiere(Liste liste, Liste liste2, int listennummer)
	{
		int anzahlEle = 10;
		for (int j = 0; j < 4; j++)
		{
			long zeit = System.nanoTime();
			int i = 0;

			Knoten anfang;
			Knoten mitte;
			Knoten ende = liste.insert(null, new Element(i));

			Knoten temp = ende;
			for (i = 0; i < (anzahlEle / 2) - 1; i++)
			{
				temp = liste.insert(temp, new Element(i + 1));
			}

			mitte = liste.insert(temp, new Element(i + 1));
			temp = mitte;
			while (i < anzahlEle)
			{
				temp = liste.insert(temp, new Element(i + 1));
				i++;
			}
			anfang = temp;
			
			zeit = System.nanoTime() - zeit;
			System.out.println("Erstellen der Liste mit "+anzahlEle+" Elementen: "+zeit/ms+"ms");
			System.out.println("*********************");
			analysiere(liste, liste2, anfang, mitte, ende);
			
			anzahlEle *= 10;
			
			if(listennummer == 1)
			{
				liste = new Arrayliste();
				liste2 = new Arrayliste();
			}
			else if (listennummer == 2)
			{
				liste = new DoppeltVerkettet();
				liste2 = new DoppeltVerkettet();
			}
			else if(listennummer == 3)
			{
				liste = new Implementierung03();
				liste2 = new Implementierung03();
			}
		}
		
	}

	private static Liste erzeugeListe(Liste liste, int anzahlElemente,
	        Element startelement)
	{
		if (anzahlElemente > 0)
		{
			liste.insert(null, startelement);
			Knoten knoten = liste.find(startelement);

			for (int i = 1; i < anzahlElemente; i++)
			{
				liste.insert(knoten, new Element(i + 1));
			}
		}
		return liste;
	}
}

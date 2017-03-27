import static org.junit.Assert.*;

import org.junit.Test;

public class ListenTests {
	
	private Element _startelement = new Element(0);
	
	private Liste erzeugeLeereListe()
	{
		return new Implementierung03();
	}	
	
	@Test
	public void testInsert()
	{
		Liste liste;
		
		liste = erzeugeLeereListe();
		assertEquals(0, liste.size());

		liste = erzeugeListe(1, _startelement);
		assertEquals(1, liste.size());
		
		liste = erzeugeListe(3, _startelement);
		assertEquals(3, liste.size());
		
		//liste = erzeugeListe(100000, _startelement);
		//assertEquals(100000, liste.size());
		
		liste = erzeugeLeereListe();
		assertNotNull(liste.insert(null, _startelement));
	}	

	@Test
	public void testInsertUngueltigePos()
	{
		Liste liste = erzeugeLeereListe();
		
		liste.insert(new Knoten(), null);
		//assertEquals(0, liste.size());		
		
		liste = erzeugeListe(100, _startelement);
		liste.insert(new Knoten(), null);
		assertEquals(100, liste.size());
	}	

	@Test
	public void testInsertNull()
	{
		Liste liste = erzeugeLeereListe();
		assertEquals(0, liste.size());
		
		liste.insert(null, _startelement);
		assertEquals(1, liste.size());
		
		liste = erzeugeListe(10, _startelement);
		assertEquals(10, liste.size());
		
		liste.insert(null, null);
		assertEquals(10, liste.size());
		
		liste.insert(null, _startelement);
		assertEquals(10, liste.size());
	}	

	@Test
	public void testDelete()
	{
		Liste liste;

		liste = erzeugeListe(1, _startelement);
		assertEquals(1, liste.size());
		liste.delete(liste.find(_startelement));
		assertEquals(0, liste.size());		
	}
	
	@Test
	public void testDeleteNull()
	{
		Liste liste = erzeugeLeereListe();
		assertEquals(0, liste.size());
		
		liste.delete(null);
		assertEquals(0, liste.size());
	}
	
	@Test
	public void testDeleteMehrfachLoeschung()
	{		
		Liste liste = erzeugeLeereListe();
		
		Element e1 = new Element(11);
		Element e2 = new Element(42);
		
		liste.insert(null, e1);
		Knoten k1 = liste.find(e1);		
		liste.insert(k1, e2);
		Knoten k2 = liste.find(e2);
		
		assertEquals(2, liste.size());
		liste.delete(k1);
		assertEquals(1, liste.size());
		liste.delete(k2);
		assertEquals(0,liste.size());
		liste.delete(k1);
		assertEquals(0, liste.size());
	}
	
	@Test
	public void testDeleteUngueltigerKnoten()
	{
		Liste liste = erzeugeListe(30, _startelement);
		assertEquals(30, liste.size());
		
		for(int i = 0; i < 10; i++)
		{
			liste.delete(new Knoten(null, null, new Element(i)));
		}
		
		assertEquals(30, liste.size());
	}
	
	@Test
	public void testFind()
	{
		Liste liste = erzeugeLeereListe();
		Knoten knoten = liste.insert(null, _startelement);
		assertTrue(knoten.equals(liste.find(_startelement)));		
	}
	
	@Test
	public void testRetrieve()
	{
    	Liste liste = erzeugeListe(1, _startelement);
    	
    	Knoten knoten = liste.find(_startelement);
    	assertEquals(_startelement, liste.retrieve(knoten));
	}
	
	@Test
	public void testConcatNull()
	{
		Liste liste = erzeugeLeereListe();
		assertEquals(0, liste.size());		
		liste.concat(null);
		assertEquals(0, liste.size());
		
		liste = erzeugeListe(50, _startelement);
		assertEquals(50, liste.size());
		liste.concat(null);
		assertEquals(50, liste.size());
	}
	
	@Test
	public void testConcatLeer()
	{
		Liste l1 = erzeugeLeereListe();
		Liste l2 = erzeugeListe(10, _startelement);
		
		l1.concat(l2);
		assertEquals(10, l1.size());
		
		l1 = erzeugeLeereListe();
		l2 = erzeugeListe(10, _startelement);
		
		l2.concat(l1);
		assertEquals(10, l2.size());	
	}
	
	@Test
	public void testConcat()
	{
		Liste l1 = erzeugeListe(1000, _startelement);
		Liste l2 = erzeugeListe(10, _startelement);
		l1.concat(l2);		
		assertEquals(1010, l1.size());

		Element e1 = new Element(200);
		Element e2 = new Element(300);
		l1 = erzeugeListe(20, e1);
		l2 = erzeugeListe(15, e2);
		
		Knoten k1 = l1.find(e1);
		Knoten k2 = l2.find(e2);
		
		l1.concat(l2);
		
		assertTrue(e1.equals(l1.retrieve(k1)));
		assertTrue(e2.equals(l1.retrieve(k2)));
		
		assertTrue(k1.equals(l1.find(e1)));
		assertTrue(k2.equals(l1.find(e2)));
	}
	
	
	private Liste erzeugeListe(int anzahlElemente, Element startelement)
	{
		Liste liste = erzeugeLeereListe();
		if(anzahlElemente > 0)
		{			
			liste.insert(null, startelement);			
			Knoten knoten = liste.find(startelement);
			
			for(int i = 1; i < anzahlElemente; i++)
			{
				liste.insert(knoten, new Element(i+1));
			}
		}
		return liste;
	}
	
	
	
	
}

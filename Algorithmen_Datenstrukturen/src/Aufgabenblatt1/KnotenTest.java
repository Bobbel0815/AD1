package Aufgabenblatt1;

import static org.junit.Assert.*;

import org.junit.Test;

public class KnotenTest {

	@Test
	public void testEqualsKnoten() {
		Knoten k1 = new Knoten();
		Knoten k2 = new Knoten();
		Knoten k3 = new Knoten(k1, k2, new Element(40));
		Knoten k4 = new Knoten(k1, k2, new Element(40));
		Knoten k5 = new Knoten(k1, k2, new Element(42));
		Knoten k6 = new Knoten(k2, k1, new Element(40));

		assertTrue(k1.equals(k2));
		assertTrue(k3.equals(k4));
		assertTrue(k4.equals(k3));
		assertFalse(k4.equals(k5));
		assertFalse(k3.equals(k6));
		assertFalse(k6.equals(k4));
	}
	
	/*
	 * Einfuegen zweier Elemente in eine Liste
	 */
	@Test
	public void testDVInsert() {
		DoppeltVerkettet dv = new DoppeltVerkettet();
		Element ele = new Element(1);
		dv.insert(new Knoten(), ele);
		dv.insert(dv.find(ele), new Element(2));
		
		
		// Finden eines Elementes
		assertEquals(dv.find(ele).getElement(), ele);
		assertEquals(dv.find(ele).getVorgaenger().getElement().getKey(), 2);
	}
	
	/*
	 * Test fuer die Loeschung eines Elementes aus der Liste
	 */
	@Test
	public void testDVDelete(){
		DoppeltVerkettet dv = new DoppeltVerkettet();
		Element ele = new Element(1);
		Knoten k1 = new Knoten();
		dv.insert(k1, ele);
		dv.insert(dv.find(ele), new Element(2));
		
		assertNotNull(dv.find(ele));
		dv.delete(k1);
		assertNotEquals(k1, dv.find(ele));
	}
	
	/*
	 * Test fuer den Verbund zweier Listen
	 */
	@Test
	public void testDVConcat(){
		DoppeltVerkettet dv1 = new DoppeltVerkettet();
		Element ele = new Element(1);
		Knoten k1 = new Knoten();
		dv1.insert(k1, ele);
		dv1.insert(dv1.find(ele), new Element(2));
		
		DoppeltVerkettet dv2 = new DoppeltVerkettet();
		Element ele2 = new Element(3);
		Knoten k2 = new Knoten();
		dv2.insert(k2, ele2);
		dv2.insert(dv2.find(ele2), new Element(4));

		
		assertEquals(dv1.size(), 2);
		dv1.concat(dv2);
		assertEquals(dv1.size(), 4);
		assertEquals(dv1.getTail().getVorgaenger().getVorgaenger(), k2);
	}
	
}

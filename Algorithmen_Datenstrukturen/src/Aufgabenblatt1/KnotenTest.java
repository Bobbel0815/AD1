package Aufgabenblatt1;

import static org.junit.Assert.*;

import org.junit.Test;

public class KnotenTest {

	@Test
	public void testEqualsKnoten()
	{
		Knoten k1 = new Knoten();
		Knoten k2 = new Knoten();
		Knoten k3 = new Knoten(k1,k2,new Element(40));
		Knoten k4 = new Knoten(k1,k2,new Element(40));
		Knoten k5 = new Knoten(k1,k2,new Element(42));
		Knoten k6 = new Knoten(k2,k1,new Element(40));
		
		assertTrue(k1.equals(k2));
		assertTrue(k3.equals(k4));
		assertTrue(k4.equals(k3));
		assertFalse(k4.equals(k5));
		assertFalse(k3.equals(k6));
		assertFalse(k6.equals(k4));
	}
}

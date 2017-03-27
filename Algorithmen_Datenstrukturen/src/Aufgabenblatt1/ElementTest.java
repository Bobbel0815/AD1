import static org.junit.Assert.*;

import org.junit.Test;

public class ElementTest {

	@Test
	public void testEqualsElement()
	{
		Element e1 = new Element(0);
		Element e2 = new Element(0);
		Element e3 = new Element(42);
		Element e4 = new Element(42);
		
		assertTrue(e1.equals(e2));
		assertTrue(e2.equals(e1));
		assertTrue(e3.equals(e4));
		assertFalse(e1.equals(e3));
		assertFalse(e4.equals(e2));
	}
}
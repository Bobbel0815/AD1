import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class ArraylisteTest 
{
	Arrayliste _al;
	public ArraylisteTest()
	{
		_al = new Arrayliste(10);
	}
	
    @Test
    public void groessKonstruktorTest()
    {
        assertEquals(10, _al.listenlaenge());
    }

    @Test
    public void einfugenNulleinfachTest()
    {
    	assertEquals(0, _al.size());
    	_al.insert(null, new Element()); // weil erster knoten
    	assertEquals(1, _al.size());
    }
    
    @Test
    public void deleteeinfachTest()
    {
    	Element e = new Element();
    	_al.insert(null, e);
    	assertEquals(1, _al.size());
    	_al.delete(_al.find(e));
    	assertEquals(0, _al.size());
    }
    
    @Test
    public void findeinfachTest()
    {
    	Element o= new Element();
    	_al.insert(null, o);
    	assertNotNull(_al.find(o));
    	
    	assertNull(_al.find(new Element()));
    }
    
    @Test
    public void findUndGroeﬂeTest()
    {
    	ArrayList<Element> liste = new ArrayList<Element>();
    	
    	Knoten k=null;
		for(int i=0;i<15;i++)
    	{
			Element o= new Element();
			k=  _al.insert(k, o);
    		liste.add(o);
    	}
		
		assertNotEquals(10, _al.listenlaenge());

    	
		for(int i=0;i<liste.size();i++)
    	{
			Element o = liste.get(i);
			Knoten knoten = _al.find(o);
			assertEquals(liste.get(i), knoten.getElement());
			
    	}
    }
    
    
	//Liefert das am Knoten gebundene Element.
    @Test
    public void retrievTest()
    {
    	_al = new Arrayliste();
    	Element o= new Element();
    	_al.insert(null, o);
    	Knoten knoten = _al.find(o);
    	assertEquals(o, _al.retrieve(knoten));
    	
    }
    
    @Test
    public void concatTest()
    {
    	Knoten k=null;
    	
    	Arrayliste arrayliste1 = new Arrayliste(20);
    	ArrayList<Element> liste1 = new ArrayList<Element>();
		for(int i=0;i<15;i++)
    	{
			Element e1= new Element();
			k = arrayliste1.insert(k, e1);
    		liste1.add(e1);
    	}
		
		k=null;
		Arrayliste arrayliste2 = new Arrayliste(20);
    	ArrayList<Element> liste2 = new ArrayList<Element>();
		for(int i=0;i<15;i++)
    	{
			Element e1= new Element();
			k = arrayliste2.insert(k, e1);
    		liste2.add(e1);
    	}
		
    	
    	arrayliste1.concat(arrayliste2);
    	
    	assertNull(arrayliste1.find(new Element()));
    	for(int i=0;i<15;i++)
    	{
    		assertNotNull(arrayliste1.find(liste1.get(i)));  		
    	}
    	
    	assertNull(arrayliste1.find(new Element()));
    	for(int i=0;i<15;i++)
    	{
    		assertNotNull(arrayliste1.find(liste2.get(i)));  		
    	}
    	
    	assertEquals(30, arrayliste1.size());
    }

    
    @Test
    public void deletTest()
    {
    	_al = new Arrayliste();
    	
    	ArrayList<Knoten> liste = new ArrayList<Knoten>();
    	
    	Knoten k=null;
    	Element o= new Element();
		for(int i=0;i<5;i++)
    	{
			k = _al.insert(k,o);
    		liste.add(k);
    	}
		
		_al.delete(liste.get(3));
		
		assertEquals(o, _al.retrieve(liste.get(2)));
		assertNotEquals(o, _al.retrieve(liste.get(3)));
		assertEquals(o, _al.retrieve(liste.get(4)));
    }
    

}

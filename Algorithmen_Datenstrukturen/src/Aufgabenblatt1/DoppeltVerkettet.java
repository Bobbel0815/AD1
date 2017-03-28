package Aufgabenblatt1;


public class DoppeltVerkettet implements Liste {
	
	private Knoten tail;
	private Knoten head;
	private int listenLaenge;
	
	private double counter;
	public double getCounter(){
		double returnCounter = counter;
		counter = 0;
		return returnCounter;
	}
	
	public Knoten getHead(){
		return head;
	}
	public Knoten getTail(){
		return tail;
	}
	public void Clear(){
		head = new Knoten(null,null,null);
		tail = new Knoten(null,head,null);
		head.setNachfolger(tail);
		listenLaenge = 0;
	}
	
	public DoppeltVerkettet(){
		head = new Knoten(null,null,null);
		tail = new Knoten(null,head,null);
		head.setNachfolger(tail);
		listenLaenge = 0;
	}

	@Override
	public Knoten insert(Knoten pos, Element element) {
		
		if(pos == null || pos == tail || find(element) != null|| pos == head){
			throw new IndexOutOfBoundsException();
		}
		
		counter+=2;
		if(pos.getVorgaenger() != null){
			Knoten tmp = new Knoten(pos.getNachfolger(),pos,pos.getElement());
			tmp.getNachfolger().setVorgaenger(tmp);
			pos.setNachfolger(tmp);
			pos.setElement(element);
			listenLaenge++;
			counter+=9;
		}
		else{
			pos.setElement(element);
			pos.setNachfolger(tail);
			pos.setVorgaenger(tail.getVorgaenger());
			tail.getVorgaenger().setNachfolger(pos);
			tail.setVorgaenger(pos);
			listenLaenge++;
			counter+=8;
		}
		return pos;
	}

	@Override
	public boolean delete(Knoten pos) {
		counter+=5;
		if(pos == null || pos == tail || pos == head || pos.getElement() == null){
			throw new IndexOutOfBoundsException();
		}
		
		pos.getVorgaenger().setNachfolger(pos.getNachfolger());
		pos.getNachfolger().setVorgaenger(pos.getVorgaenger());
		pos.setNachfolger(null);
		pos.setVorgaenger(null);
		pos.setElement(null);
		listenLaenge--;
		return true;
	}

	@Override
	public Knoten find(Element key) {
		Knoten tmp = head.getNachfolger();
		tail.setElement(key);
		
		while(tmp.getElement() != key){
			tmp = tmp.getNachfolger();
		}
		if(tmp == tail){
			return null;
		}
		return tmp;
	}

	@Override
	public Element retrieve(Knoten pos) {
		counter+=3;
		if(pos == null || pos == tail || pos == head){
			throw new IndexOutOfBoundsException();
		}
		counter++;
		return pos.getElement();
	}

	@Override
	public boolean concat(Liste liste2) {
		if(liste2 instanceof DoppeltVerkettet){
			DoppeltVerkettet tmp = (DoppeltVerkettet)liste2;
			tail.getVorgaenger().setNachfolger(tmp.getHead().getNachfolger());
			tmp.getHead().getNachfolger().setVorgaenger(tail.getVorgaenger());
			tail = tmp.getTail();
			listenLaenge+= tmp.size();
			tmp.Clear();
		}
		return true;
	}
	
	public Knoten getDummyEnd(){
		Aufwand.counter++;
		return dummyEnd;
	}

	@Override
	public int size() {
		return listenLaenge;
	}	
	
}
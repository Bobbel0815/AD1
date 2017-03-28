package Aufgabenblatt1;

public class Aufwand {
	public static int counter;

	public static void main(String[] args) {
	Aufwand aufwand = new Aufwand();
//	aufwand.EinfachVerkettetAufwand();
//	aufwand.DoppeltVerkettetAufwand();
	aufwand.ArraylisteAufwand();

	}
	
	public void ArraylisteAufwand() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Elemente: " + (int) Math.pow(10, i));
			Arrayliste liste1 = arraybefüller(i);
			System.out.println("Aufwand Insert: \t" + counter + " Operationen.");
			Aufwand.counter = 0;

			liste1.find(liste1.getArray()[liste1.size()].getElement());
			System.out.println("Aufwand Finden: \t" + counter + " Operationen.");
			Aufwand.counter = 0;

			liste1.retrieve(liste1.getArray()[liste1.size()]);
			System.out.println("Aufwand Retrieve: \t" + counter + " Operationen.");
			Aufwand.counter = 0;

			liste1.delete(liste1.getArray()[liste1.size()]);
			System.out.println("Aufwand Delete: \t" + counter + " Operationen.");

			Liste liste2 = arraybefüller(i);
			Liste liste3 = arraybefüller(i);
			Aufwand.counter = 0;
			liste2.concat(liste3);
			System.out.println("Aufwand Concat: \t" + counter + " Operationen.\n");
			Aufwand.counter = 0;
		}
	}

	public Arrayliste arraybefüller(int multiplikator) {
		Arrayliste liste = new Arrayliste();
		Element startelement = new Element(0);

		liste.insert(null, startelement);
		Knoten knoten = liste.find(startelement);
		for (int i = 1; i < Math.pow(10, multiplikator); i++) {
			liste.insert(knoten, new Element(i+1));
		}
		return liste;
	}

	public void DoppeltVerkettetAufwand(){
		for (int i = 1; i <= 5; i++) {
			System.out.println("Elemente: " + (int) Math.pow(10, i));
			DoppeltVerkettet liste1 = doppelBefueller(i);
			System.out.println("Aufwand Insert: \t" + counter + " Operationen.");
			Aufwand.counter = 0;

			liste1.find(liste1.getDummyEnd().getElement());
			System.out.println("Aufwand Finden: \t" + counter + " Operationen.");
			Aufwand.counter = 0;

			liste1.retrieve(liste1.getDummyEnd().getVorgaenger());
			System.out.println("Aufwand Retrieve: \t" + counter + " Operationen.");
			Aufwand.counter = 0;

			liste1.delete(liste1.getDummyEnd().getVorgaenger());
			System.out.println("Aufwand Delete: \t" + counter + " Operationen.");

			Liste liste2 = doppelBefueller(i);
			Liste liste3 = doppelBefueller(i);
			Aufwand.counter = 0;
			liste2.concat(liste3);
			System.out.println("Aufwand Concat: \t" + counter + " Operationen.\n");
			Aufwand.counter = 0;
		}
	}

	public static DoppeltVerkettet doppelBefueller(int multiplikator) {
		DoppeltVerkettet liste = new DoppeltVerkettet();
		Element startelement = new Element(0);

		liste.insert(null, startelement);
		Knoten knoten = liste.find(startelement);
		for (int i = 1; i < Math.pow(10, multiplikator); i++) {
			liste.insert(knoten, new Element(i+1));
		}
		return liste;
	}
	
	public void EinfachVerkettetAufwand(){
		for (int i = 1; i <= 5; i++) {
			System.out.println("Elemente: " + (int) Math.pow(10, i));
			EinfachVerkettet liste1 = EinfachBefueller(i);
			System.out.println("Aufwand Insert: \t" + counter + " Operationen.");
			Aufwand.counter = 0;

			liste1.find(liste1.getTail().getNachfolger().getElement());
			System.out.println("Aufwand Finden: \t" + counter + " Operationen.");
			Aufwand.counter = 0;

			liste1.retrieve(liste1.getTail().getNachfolger());
			System.out.println("Aufwand Retrieve: \t" + counter + " Operationen.");
			Aufwand.counter = 0;

			liste1.delete(liste1.getTail().getNachfolger());
			System.out.println("Aufwand Delete: \t" + counter + " Operationen.");

			Liste liste2 = EinfachBefueller(i);
			Liste liste3 = EinfachBefueller(i);
			Aufwand.counter = 0;
			liste2.concat(liste3);
			System.out.println("Aufwand Concat: \t" + counter + " Operationen.\n");
			Aufwand.counter = 0;
		}
	}
	
	
	public static EinfachVerkettet EinfachBefueller(int multiplikator) {
		EinfachVerkettet liste = new EinfachVerkettet();
		Element startelement = new Element(0);

		liste.insert(null, startelement);
		Knoten knoten = liste.find(startelement);
		for (int i = 1; i < Math.pow(10, multiplikator); i++) {
			liste.insert(knoten, new Element(i+1));
		}
		return liste;
	}

}

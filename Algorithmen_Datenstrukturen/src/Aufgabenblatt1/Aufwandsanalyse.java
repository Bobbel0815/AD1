package Aufgabenblatt1;

public class Aufwandsanalyse {
	public static int counter;

	public static void main(String[] args) {
	Aufwandsanalyse aufwand = new Aufwandsanalyse();
	System.out.println("Einfache Verkettung:");
	aufwand.EinfachVerkettetAufwand();
	System.out.println("Doppelte Verkettung:");
	aufwand.DoppeltVerkettetAufwand();
	System.out.println("Array:");
	aufwand.ArraylisteAufwand();

	}
	
	public void ArraylisteAufwand() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Elemente: " + (int) Math.pow(10, i));
			Arrayliste liste1 = arraybefüller(i);
			System.out.println("Aufwand Insert: \t" + counter + " Operationen.");
			Aufwandsanalyse.counter = 0;

			liste1.find(liste1.getArray()[liste1.size()].getElement());
			System.out.println("Aufwand Finden: \t" + counter + " Operationen.");
			Aufwandsanalyse.counter = 0;

			liste1.retrieve(liste1.getArray()[liste1.size()]);
			System.out.println("Aufwand Retrieve: \t" + counter + " Operationen.");
			Aufwandsanalyse.counter = 0;

			liste1.delete(liste1.getArray()[liste1.size()]);
			System.out.println("Aufwand Delete: \t" + counter + " Operationen.");

			Liste liste2 = arraybefüller(i);
			Liste liste3 = arraybefüller(i);
			Aufwandsanalyse.counter = 0;
			liste2.concat(liste3);
			System.out.println("Aufwand Concat: \t" + counter + " Operationen.\n");
			Aufwandsanalyse.counter = 0;
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
			Aufwandsanalyse.counter = 0;

			liste1.find(liste1.getTail().getVorgaenger().getElement());
			System.out.println("Aufwand Finden: \t" + counter + " Operationen.");
			Aufwandsanalyse.counter = 0;

			liste1.retrieve(liste1.getTail().getVorgaenger());
			System.out.println("Aufwand Retrieve: \t" + counter + " Operationen.");
			Aufwandsanalyse.counter = 0;

			liste1.delete(liste1.getTail().getVorgaenger());
			System.out.println("Aufwand Delete: \t" + counter + " Operationen.");

			Liste liste2 = doppelBefueller(i);
			Liste liste3 = doppelBefueller(i);
			Aufwandsanalyse.counter = 0;
			liste2.concat(liste3);
			System.out.println("Aufwand Concat: \t" + counter + " Operationen.\n");
			Aufwandsanalyse.counter = 0;
		}
	}

	public static DoppeltVerkettet doppelBefueller(int multiplikator) {
		DoppeltVerkettet liste = new DoppeltVerkettet();
		Element startelement = new Element(0);

		liste.insert(new Knoten(), startelement);
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
			Aufwandsanalyse.counter = 0;

			liste1.find(liste1.getTail().getNachfolger().getElement());
			System.out.println("Aufwand Finden: \t" + counter + " Operationen.");
			Aufwandsanalyse.counter = 0;

			liste1.retrieve(liste1.getTail().getNachfolger());
			System.out.println("Aufwand Retrieve: \t" + counter + " Operationen.");
			Aufwandsanalyse.counter = 0;

			liste1.delete(liste1.getTail().getNachfolger());
			System.out.println("Aufwand Delete: \t" + counter + " Operationen.");

			Liste liste2 = EinfachBefueller(i);
			Liste liste3 = EinfachBefueller(i);
			Aufwandsanalyse.counter = 0;
			liste2.concat(liste3);
			System.out.println("Aufwand Concat: \t" + counter + " Operationen.\n");
			Aufwandsanalyse.counter = 0;
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

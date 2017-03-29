package Aufgabenblatt2;

public class Primzahlen {
	private final int mikro = 1000;

	public boolean[] langsam(int N) {
		int zaehler = 0;
		double zeit1 = System.nanoTime();
		boolean a[] = new boolean[N];

		for (int i = 0; i < N; i++) {
			zaehler++;
			a[i] = true;
		}
		for (int i = 2; i < N; i++) {
			for (int j = 2; j < N; j++) {
				zaehler++;
				if ((i % j == 0) && (j != i))
					a[i] = false;

			}
		}
		double zeit2 = System.nanoTime();
		System.out.println("Langsame Zeit: " + (zeit2 - zeit1) / mikro + " ms");
		System.out.println("Langsam: " + zaehler);
		return a;
	}

	public boolean[] verbessert(int N) {
		int zaehler = 0;
		double zeit1 = System.nanoTime();
		boolean a[] = new boolean[N];

		for (int i = 0; i < N; i++) {
			zaehler++;
			if (i % 2 == 0) {
				a[i] = false;
			} else {
				a[i] = true;
			}
		}
		for (int i = 3; i < N; i += 2) {
			for (int j = 2; j < Math.sqrt(i); j++) {
				zaehler++;
				if ((i % j == 0)) {
					a[i] = false;
					break;
				}

			}
		}
		double zeit2 = System.nanoTime();
		System.out.println("Verbesserte Zeit: " + (zeit2 - zeit1) / mikro + " ms");
		System.out.println("Verbessert: " + zaehler);
		return a;
	}

	public boolean[] sieb(int N) {
		double zeit1 = System.nanoTime();
		int zaehler = 0;
		boolean[] a = new boolean[N];
		for (int i = 0; i < N; i++) {
			zaehler++;
			a[i] = true;
		}
			for (int i = 2; i < Math.sqrt(N); i++) {
				if (a[i] == true)
					for (int j = 2; i * j < N; j++){
						zaehler++;
						a[i * j] = false;
					}
			}
		
		double zeit2 = System.nanoTime();
		System.out.println("Sieb Zeit: " + (zeit2 - zeit1) / mikro + " ms");
		System.out.println("Sieb: " + zaehler);
		return a;
	}

	public static void main(String[] args) {
		int N = 10000;
		Primzahlen p = new Primzahlen();
		boolean a[] = new boolean[N];
		a = p.langsam(N);

		boolean b[] = new boolean[N];

		b = p.verbessert(N);
		
		boolean c[] = new boolean[N];

		c = p.sieb(N);
//		for(int i = 0; i< N; i++){
//			System.out.println(i+ " " + c[i]);
//		}

	}
}

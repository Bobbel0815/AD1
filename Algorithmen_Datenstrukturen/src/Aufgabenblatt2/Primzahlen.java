package Aufgabenblatt2;

public class Primzahlen {
	private final int mikro = 1000;

	public boolean[] langsam(int N) {
		int zaehler = 1;
		double zeit1 = System.nanoTime();
		boolean a[] = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			a[i] = true;
		}
		for (int i = 2; i <= N; i++) {
			for (int j = 2; j <= N; j++) {
				zaehler++;
				if ((i % j == 0) && (j != i))
					a[i] = false;

			}
		}
		double zeit2 = System.nanoTime();
		System.out.println("Langsame Zeit: " + (zeit2 - zeit1) / mikro + " ms");
		System.out.println("Langsame Operationen8: " + zaehler);
		return a;
	}

	public boolean[] verbessert(int N) {
		int zaehler = 1;
		double zeit1 = System.nanoTime();
		boolean a[] = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			if (i % 2 == 0) {
				a[i] = false;
			} else {
				a[i] = true;
			}
		}
		for (int i = 3; i < N; i += 2) {
			for (int j = 2; j <= Math.sqrt(i); j++) {
				zaehler++;
				if ((i % j == 0)) {
					a[i] = false;
					break;
				}

			}
		}
		double zeit2 = System.nanoTime();
		System.out.println("Verbesserte Zeit: " + (zeit2 - zeit1) / mikro + " ms");
		System.out.println("Verbesserte Operationen: " + zaehler);
		return a;
	}

	public boolean[] sieb(int N) {
		double zeit1 = System.nanoTime();
		int zaehler = 1;
		boolean[] a = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			a[i] = true;
		}
		for (int i = 2; i < Math.sqrt(N); i++) {
			if (a[i] == true) {
				for (int j = 2; i * j <= N; j++) {
					zaehler++;
					a[i * j] = false;
				}
			}
		}

		double zeit2 = System.nanoTime();
		System.out.println("Sieb Zeit: " + (zeit2 - zeit1) / mikro + " ms");
		System.out.println("Sieb: " + zaehler);
		return a;
	}

	public boolean primTest(long N) {
		double zeit1 = System.nanoTime();
		int zaehler = 1;
		boolean a;

		if (N % 2 == 0 || N == 1) {
			zaehler++;
			a = false;
		} else {
			a = true;
			for (long i = 3; i < Math.sqrt(N); i += 2) {
				zaehler++;
				if (N % i == 0) {
					a = false;
					break;
				}
			}
		}

		double zeit2 = System.nanoTime();
		System.out.println("Einzel-Test Zeit: " + (zeit2 - zeit1) / mikro + " ms");
		System.out.println("Einzel-Test Operationen: " + zaehler);
		return a;
	}

	/**
	 * Primzahl prüfen (Primzahltest)
	 */
	public boolean isPrim(final long value) {
		double zeit1 = System.nanoTime();
		int zaehler = 1;
		if (value <= 16) {
			zaehler++;
			double zeit2 = System.nanoTime();
			System.out.println("IsPrim Zeit: " + (zeit2 - zeit1) / mikro + " ms");
			System.out.println("IsPrim Operationen: " + zaehler);
			return (value == 2 || value == 3 || value == 5 || value == 7 || value == 11 || value == 13);
		}
		if (value % 2 == 0 || value % 3 == 0 || value % 5 == 0 || value % 7 == 0) {
			zaehler++;
			double zeit2 = System.nanoTime();
			System.out.println("IsPrim Zeit: " + (zeit2 - zeit1) / mikro + " ms");
			System.out.println("IsPrim Operationen: " + zaehler);
			return false;
		}
		for (long i = 10; i * i <= value; i += 10) {
			zaehler++;
			if (value % (i + 1) == 0) { // 11, 21, 31, 41, 51, ...
				double zeit2 = System.nanoTime();
				System.out.println("IsPrim Zeit: " + (zeit2 - zeit1) / mikro + " ms");
				System.out.println("IsPrim Operationen: " + zaehler);
				return false;
			}
			if (value % (i + 3) == 0) { // 13, 23, 33, 43, 53, ...
				double zeit2 = System.nanoTime();
				System.out.println("IsPrim Zeit: " + (zeit2 - zeit1) / mikro + " ms");
				System.out.println("IsPrim Operationen: " + zaehler);
				return false;
			}
			if (value % (i + 7) == 0) { // 17, 27, 37, 47, 57, ...
				double zeit2 = System.nanoTime();
				System.out.println("IsPrim Zeit: " + (zeit2 - zeit1) / mikro + " ms");
				System.out.println("IsPrim Operationen: " + zaehler);
				return false;
			}
			if (value % (i + 9) == 0) { // 19, 29, 39, 49, 59, ...
				double zeit2 = System.nanoTime();
				System.out.println("IsPrim Zeit: " + (zeit2 - zeit1) / mikro + " ms");
				System.out.println("IsPrim Operationen: " + zaehler);
				return false;
			}
		}
		double zeit2 = System.nanoTime();
		System.out.println("IsPrim Zeit: " + (zeit2 - zeit1) / mikro + " ms");
		System.out.println("IsPrim Operationen: " + zaehler);
		return true;
	}

	public static void main(String[] args) {
		int N = 100000000;
		Primzahlen p = new Primzahlen();
		boolean a[] = new boolean[N + 1];
		// a = p.langsam(N);

		boolean b[] = new boolean[N + 1];

		b = p.verbessert(N);

		boolean c[] = new boolean[N + 1];

		c = p.sieb(N);

		long primsuche = 10;
		System.out.println(p.primTest(primsuche));
		System.out.println(p.isPrim(primsuche));

	}
}

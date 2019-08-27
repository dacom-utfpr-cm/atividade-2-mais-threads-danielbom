package activity3;

/**
 * 
 * 3. Faça um programa em Java com threads que exiba os números primos entre 0 e
 * 100000.
 * 
 * @author daniel
 *
 */
public class Exercise3 {

	public static void main(String[] args) {
		for (long i = 0; i < 100000; i++) {
			if (Primes.isPrime(i)) {
				System.out.println("Prime (" + i + ")");
			}
		}
	}

}

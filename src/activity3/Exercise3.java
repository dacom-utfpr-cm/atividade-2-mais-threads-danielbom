package activity3;

import java.util.stream.IntStream;

/**
 * 
 * 3. Faça um programa em Java com threads que exiba os números primos entre 0 e
 * 100_000.
 * 
 * @author daniel
 *
 */
public class Exercise3 {

	public static void main(String[] args) {
		long range = 10_000, max = 100_000;

		IntStream.rangeClosed(0, (int) (max / range) - 1).forEach(i -> {
			new Thread(() -> {
				long p = 0;
				for (long j = 0; j < range; j++) {
					long k = (range * i) + j;
					if (Primes.isPrime(k)) {
						System.out.println("Prime (" + p + ")");
					}
				}
			}).start();
		});
	}

}

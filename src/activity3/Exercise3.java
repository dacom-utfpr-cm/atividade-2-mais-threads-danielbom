package activity3;

import java.util.concurrent.atomic.AtomicLong;
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

	private static long getNextNumber(AtomicLong number) {
		long prev, next;
		do {
			prev = number.get();
			next = prev + 1;
		} while (!number.compareAndSet(prev, next));
		return next;
	}
	
	public static void main(String[] args) {
		long max = 100_000;
		AtomicLong number = new AtomicLong(0);

		IntStream.rangeClosed(0, 7).forEach(i -> {
			new Thread(() -> {
				for (long k = getNextNumber(number); k < max; k = getNextNumber(number))
					if (Primes.isPrime(k))
						System.out.println("Prime (" + k + ")");
			}).start();
		});
	}

}

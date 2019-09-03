package activity3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * 3. Faça um programa em Java com threads que exiba os números primos entre 0 e
 * 100_000.
 * 
 * Utilizando a classe ExecutorService para criar classes Runnable e realizar a
 * tarefa pedida.
 * 
 * @author daniel
 *
 */
public class Exercise3_1 {

	public static void main(String[] args) {
		int nthreads = (int) Math.sqrt(Runtime.getRuntime().availableProcessors());
		ExecutorService executorService = Executors.newFixedThreadPool(nthreads); 

		long max = 100_000;
		for (long i = 0; i < max; i++) {
			executorService.submit(new IsPrime(i));
		}
	}

}

class IsPrime implements Runnable {
	private long k;

	public IsPrime(long k) {
		this.k = k;
	}

	@Override
	public void run() {
		if (Primes.isPrime(k))
			System.out.println("Prime (" + k + ")");
	}
}

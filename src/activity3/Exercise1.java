
package activity3;

import java.util.Random;
import java.util.stream.Stream;

/**
 * 1. Faça um programa em Java que consulte periodicamente o estado de um
 * conjunto de threads.
 * 
 * @author daniel
 *
 */
public class Exercise1 {

	public static void main(String[] args) {
		Thread[] threads = Stream.generate(() -> new Thread(new Sleeper()))
				.limit(3).toArray(Thread[]::new);

		// Joker: ThreadsMonitor que a partir de um valor aleatório
		// interrompe uma thread.
		Random random = new Random();
		new Thread(new ThreadsMonitor((monitorThreads) -> {
			try {
				for (Thread thread : monitorThreads) {
					double limit = 0.9;
					double rand = random.nextDouble();
					if (rand > limit) { // 90% para parar a thread
						System.out.printf("Interrompendo a thread %d.\n",
								thread.getId());
						thread.interrupt();
					}
				}
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				System.out.println(
						"Ocorreu uma exceção de interrupção no Joker.");
			}
		}).put(threads)).start();

		// Monitor: ThreadsMonitor que anuncia o estado das suas Threads.
		new Thread(new ThreadsMonitor((monitorThreads) -> {

			for (Thread thread : monitorThreads)
				System.out.printf(
						"Thread [%d] : Estado(%s) : Interrupted(%s).\n",
						thread.getId(), thread.getState().toString(),
						thread.isInterrupted());

			try {
				Thread.sleep(5000); // Period of 5 seconds
			} catch (InterruptedException ie) {
				System.out.println(
						"Ocorreu uma exceção de interrupção no Monitor.");
			}

		}).put(threads).startAll()).start();
	}

}

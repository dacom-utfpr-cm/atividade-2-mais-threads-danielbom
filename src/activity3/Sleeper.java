package activity3;

import java.util.Random;

/**
 * Simples classe que dorme por um período de tempo de 1-5 segundos.
 * 
 * @author daniel
 *
 */
public class Sleeper implements Runnable {

	@Override
	public void run() {
		try {

			while (true) {
				long id = Thread.currentThread().getId();
				int time = new Random().nextInt(4000) + 1000; // In seconds

				Thread.sleep(time);
				System.out.printf("Thread (%d) sleep by %d time.\n", id, time);
			}

		} catch (InterruptedException e) {
			System.out.println("Ocorreu uma exceção de interrupção no Sleeper.");
		}
	}
}

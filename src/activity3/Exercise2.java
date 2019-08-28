package activity3;

import java.util.stream.Stream;

/**
 * 2. Faça um programa em Java para testar um conjunto de operações sobre um
 * grupo de threads. Use o ThreadGroup.
 * 
 * @author daniel
 *
 */
public class Exercise2 {

	public static void main(String[] args) throws InterruptedException {
		ThreadGroup threadGroup = new ThreadGroup("root");
		System.out.println("Observando o resultado do toString do ThreadGroup");
		System.out.println(threadGroup.toString() + "\n");

		Thread[] threads = Stream
				.generate(() -> new Thread(threadGroup, new Sleeper()))
				.limit(5)
				.toArray(Thread[]::new);

		for (Thread t : threads)
			t.start();

		System.out.println("Listando as threads do meu grupo de threads");
		threadGroup.list();
		System.out.println();

		Thread.sleep(11000);
		System.out.println("Interrompendo todas as threads.");
		threadGroup.interrupt();
		System.out.println();
		
	}

}

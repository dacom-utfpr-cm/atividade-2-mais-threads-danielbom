package activity3;

import java.util.ArrayList;

/**
 * Classe monitora de threads que executa a função implementada pela interface
 * Vigilant em todas as threads.
 * 
 * @author daniel
 *
 */
public class ThreadsMonitor implements Runnable {

	private ArrayList<Thread> threads;
	private Vigilant vigilant;

	public ThreadsMonitor(Vigilant vigilant) {
		this.threads = new ArrayList<Thread>();
		this.vigilant = vigilant;
	}

	public ThreadsMonitor startAll() {
		this.threads.forEach(Thread::start);
		return this;
	}

	public ThreadsMonitor put(Thread... threads) {
		for (Thread t : threads)
			this.threads.add(t);
		return this;
	}

	@Override
	public void run() {
		while (!this.threads.isEmpty()) {
			this.vigilant.alert(this.threads);
			this.threads.removeIf(thread -> !thread.isAlive());
		}
	}
}

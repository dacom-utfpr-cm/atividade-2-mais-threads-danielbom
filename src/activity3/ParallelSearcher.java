package activity3;

import java.util.ArrayList;

class SearchInRange<T> implements Runnable {

	private ParallelSearcher<T> searcher;
	private T[] array;
	private T value;
	private int begin;
	private int end;

	public SearchInRange(T[] array, T value, int begin, int end,
			ParallelSearcher<T> searcher) {
		this.searcher = searcher;
		this.array = array;
		this.value = value;
		this.begin = begin;
		this.end = end;
	}

	@Override
	public void run() {
		System.out.printf("Thread %d: Intervalo [%d,%d) \n", Thread.currentThread().getId(), this.begin, this.end);
		for (int i = begin; i < end; i++) {
			T value = this.array[i];
			if (value.equals(this.value)) {
				this.searcher.finished(i);
				break;
			}
		}
	}
}

public class ParallelSearcher<T> implements Runnable {

	private T value;
	private T[] array;
	private int index;
	private int nthreads;
	private ArrayList<Thread> threads;

	public ParallelSearcher(T[] array, T value, int nthreads) {
		this.nthreads = nthreads;
		this.value = value;
		this.array = array;
		this.setIndex(-1);
	}

	@Override
	public void run() {
		int n = array.length;
		int limit = n / this.nthreads;

		this.threads = new ArrayList<Thread>();
		for (int i = 0; i < this.nthreads-1; i++) {
			Thread thread = new Thread(new SearchInRange<T>(array,
					this.value, i * limit, (i + 1) * limit, this));
			thread.start();
			threads.add(thread);
		}
		Thread thread = new Thread(new SearchInRange<T>(array,
				value, limit * (nthreads-1), n, this));
		thread.start();
		threads.add(thread);

		threads.forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}

	public void finished(int i) {
		threads.forEach(t -> {
			t.interrupt();
		});
		this.setIndex(i);
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}

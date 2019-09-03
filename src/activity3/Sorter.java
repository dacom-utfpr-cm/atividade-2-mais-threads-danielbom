package activity3;


import java.util.Comparator;

/**
 * Classe responsável por simplificar o uso de ordenadores.
 * 
 * @author daniel
 *
 */
public class Sorter<T> {
	
	public void mergeSort(T[] array, Comparator<T> comparator) throws InterruptedException {
		Thread t = new Thread(new MergeSort<T>(array, 0, array.length - 1, comparator));
		t.start();
		t.join();
	}
	
	public boolean isSorted(T[] array, Comparator<T> comparator) {
		for (int i = 1; i < array.length; i++)
			if (comparator.compare(array[i - 1], array[i]) > 0)
				return false;
		return true;
	}
}

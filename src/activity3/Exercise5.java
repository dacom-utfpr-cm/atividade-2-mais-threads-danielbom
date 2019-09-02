package activity3;

import java.util.Comparator;
import java.util.Random;

/**
 * 
 * 5. Faça um programa multithreaded em Java que ordene um vetor usando o Merge
 * Sort recursivo. Faça com que a thread principal dispare duas threads para
 * classificar cada metade do vetor.
 * 
 * @author daniel
 *
 */
public class Exercise5 {

	public static void print(Integer[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.printf("%d ", array[i]);			
		System.out.println();
	}
	
	public static void main(String[] args) throws InterruptedException {
	    long start = System.currentTimeMillis();

		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		};
		Sorter<Integer> sorter = new Sorter<Integer>();
		Random random = new Random();

		int max = 10_000_000;
		
		Integer[] array = new Integer[max];
		for (int i = 0; i < max; i++)
			array[i] = random.nextInt(max);
		
//		print(array);
		sorter.mergeSort(array, comparator);
//		print(array);
		
		System.out.println("\nO array esta " + (sorter.isSorted(array, comparator)
			? "ordenado :D"
			: "desordenado :("));
		

	    long end = System.currentTimeMillis();

	    System.out.println("\nTempo de execução: " + (end - start) + " ms");
	}

}

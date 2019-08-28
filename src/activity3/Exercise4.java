
package activity3;

import java.util.Random;

/**
 * 4. Faça um programa em Java que realize uma busca paralela em um vetor de
 * inteiros. Informe para o método: valor procurado, vetor de inteiros e o
 * número de threads.
 * 
 * @author daniel
 *
 */
public class Exercise4 {

	/**
	 * Faz uma busca linear em uma array pelo valor passado por parâmetro.
	 * 
	 * @param array
	 * @param value
	 * @return Retorna o índice onde o valor encontrado.
	 */
	public static int find(Integer[] array, int value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws InterruptedException {	    
		Random random = new Random();
		int max = 1040;

		Integer[] array = new Integer[max];
		for (int i = 0; i < max; i++)
			array[i] = random.nextInt(max);

		int index = random.nextInt(max);
		int value = array[index];
		System.out.printf("Begin setup index(%d) value(%d)\n", index, value);
		ParallelSearcher<Integer> ps = new ParallelSearcher<Integer>(array, value,
				4);

		Thread thread = new Thread(ps);
		thread.start();
		thread.join();


		System.out.println("\n\n" + (ps.getIndex() == find(array, value)));
		System.out.println("Expected: Index do valor " + value + " é " + find(array, value));
		System.out.println("Received: Index do valor " + value + " é " + ps.getIndex());
	}

}

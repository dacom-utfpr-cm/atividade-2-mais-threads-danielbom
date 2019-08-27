package activity3;

/**
 * Classe base para operações com números primos.
 * 
 * @author daniel
 *
 */
public class Primes {
	static boolean isPrime(long n) {
		if (n < 3)
			return true;
		if (n % 2 == 0)
			return false;

		long limit = (long) Math.sqrt(n);
		if (limit * limit == n)
			return false;

		for (int i = 5; i < limit; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}
}

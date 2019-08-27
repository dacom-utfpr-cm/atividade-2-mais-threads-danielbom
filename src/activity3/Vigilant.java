package activity3;

import java.util.ArrayList;

/**
 * Interface usada para fornecer uma interface mediadora para a classe
 * ThreadsMonitor. (SAM interface based)
 * 
 * @author daniel
 *
 */
public interface Vigilant {
	public void alert(ArrayList<Thread> t);
}

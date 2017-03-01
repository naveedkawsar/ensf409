import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Naveed Kawsar
 *
 */
public class SumRandomThreadModified implements Runnable {
	static List<Integer> list;
	
	public void run() {
		try {
			generate_and_sum();
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	synchronized void generate_and_sum() {
		// Reusing provided code from previous labs
		RandomGenerator rand_num = new RandomGenerator();
		list.add(rand_num.discrete(1, 100));
	}
	
	public static void main(String[] args) {
		list = Collections.synchronizedList(new ArrayList<Integer>());
		Runnable r[] = new Runnable[5];
		for (int i = 0; i < r.length; i++) {
			r[i] = new SumRandomThreadModified();
		}
		
		Thread t[] = new Thread[r.length];
		
		for (int j = 0; j < t.length; j++) {
			t[j] = new Thread(r[j]);
			t[j].start();
		}
		
		/* Separate loop for thread joins as we do not
		 * want to wait until one thread finishes running
		 * before creating a new thread
		 */
		for (int k = 0; k < t.length; k++) {
			try {
				t[k].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.printf("The %d random integers are: ", list.size());
		/*Two ways to find sum: both work
		 * Method one
		 */
		int sum = 0;
		for (Integer m : list) {
			System.out.printf("%d ", m);
            sum +=m;
		}
		/* Method two */
		//int sum = list.stream().mapToInt(e -> e).sum();
		System.out.printf("\nThe sum of the %d integers is: %d\n", list.size(), sum);
	}
}

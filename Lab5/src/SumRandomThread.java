/**
 * @author Naveed Kawsar
 *
 */
public class SumRandomThread implements Runnable {
	volatile static int sum = 0;
	public void run() {
		try {
			generate_and_sum();
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	synchronized void generate_and_sum() {
		// Reusing provided code from previous labs
		RandomGenerator rand_num = new RandomGenerator();
		int value = rand_num.discrete(1, 100);
		System.out.printf("%d ", value);
		sum += value;
	}

	public static void main(String[] args) {
		// Template -- one potential solution
		/*
		Runnable r1 = new SumRandomThread();
		Thread t1 = new Thread(r);
		t1.start();							// Then create multiple threads by
											// passing in same Runnable object
											// as states of Runnable can be
											// shared among Threads
		
		while(true) {
			try {
				t1.join();					// Repeat for other 4 threads
				break;
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		*/
		
		Runnable r[] = new Runnable[5];
		for (int i = 0; i < r.length; i++) {
			r[i] = new SumRandomThread();
		}
		
		Thread t[] = new Thread[r.length];
		System.out.printf("The %d random integers are: ", t.length);
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
				// Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.printf("\nThe sum of the %d integers is: %d\n", t.length, sum);
	}
}

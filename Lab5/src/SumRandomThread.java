
/**
 * @author Naveed Kawsar
 *
 */
public class SumRandomThread implements Runnable {
	static int index = 0;
	static Integer[] list;							//  Comment out if using other solution	
	/* An alternate (but less efficient) solution would be to declare 
	global variables to store each of the random generated values: */
	/*
	static int value1 = 0;
	static int value2 = 0;
	static int value3 = 0;
	static int value4 = 0;
	static int value5 = 0;
	*/
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
		list[index++]=rand_num.discrete(1, 100);	// Comment out  if using other solution
		
		// If using the less efficient way:
		/*switch (index++){
			case 0:
				value1 = rand_num.discrete(1, 100);
				break;
			case 1:
				value2 = rand_num.discrete(1, 100);
				break;
			case 2:
				value3 = rand_num.discrete(1, 100);
				break;
			case 3:
				value4 = rand_num.discrete(1, 100);
				break;
			case 4:
				value5 = rand_num.discrete(1, 100);
				break;
		}*/
		return;
	}

	public static void main(String[] args) {
		// Pattern -- one potential solution
		/*
		Runnable r1 = new SumRandomThread();
		Thread t1 = new Thread(r);
		t1.start();									// Then create multiple threads by
													// passing in same Runnable object
													// as states of Runnable can be
													// shared among Threads
		
		while(true) {
			try {
				t1.join();							// Repeat for other 4 threads
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
		list = new Integer[r.length]; 		// Comment out if using other solution
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
		int sum = 0;
		for (Integer m:list)
		{
			System.out.printf(" %d", m);
			sum += m;
		}

		System.out.printf("\nThe sum of the %d integers is: %d\n", list.length, sum);
		
		// If using the less efficient way:
		/*int sum = value1 + value2 + value3 + value4 + value5;
		System.out.printf("The random integers are: %d %d %d %d %d", 
				value1, value2, value3, value4, value5);
		System.out.printf("\nThe sum of the integers is: %d\n", sum);*/
	}
}

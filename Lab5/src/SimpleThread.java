
//public class SimpleThread extends Thread{ /* Modify to use interface instead of inheritance */
public class SimpleThread implements Runnable{


	Resource resource;
	
	public void run() {
		for(int i = 0; i<10; i++){
			try {
			System.out.println(resource.increment());
			
			Thread.sleep(200);
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	SimpleThread(Resource resource){
		this.resource = resource;
	}

	public static void main(String args[]) {
		Resource resource = new Resource();
		
		/* Modify the code below to make use of the Runnable interface */
		/*
		Thread t = new SimpleThread(resource);
		Thread s = new SimpleThread(resource);
		*/
		Runnable t_simple = new SimpleThread(resource);
		Runnable s_simple = new SimpleThread(resource);
		
		Thread t = new Thread(t_simple);
		Thread s = new Thread(s_simple);
		
		t.start();
		s.start();
	}

}

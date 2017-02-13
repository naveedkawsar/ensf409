
import java.io.*;

public class Sums {
	/**
	 * Outputs the sum of sequence of input integers
	 * @param in	sequence of input integers
	 */
    public static void sum(BufferedReader in){
    	
    	int s, nextInt;
    	s = 0;
    	/* nextInt needs to be initialized to check do-while or while loop condition */
    	nextInt = 0;

    	System.out.println("Please input the sequence of integers to sum, "
    			+ "terminated by a 0");
    	/* do-while loop can be replaced with while(nextInt != 0)
    	 * If using a while loop, initialize nextInt = 0; 
    	 * INSIDE the loop.  Otherwise code won't enter loop
    	 */
    	do {	 
    		try {
    			/* Read next datum in input. An integer is expected */
    			nextInt = Integer.parseInt(in.readLine());
    			/* If valid NumberFormat, add to sum, s */
    			s += nextInt;
    		} catch (IOException e) {
    			System.out.printf("Request could not be completed. %s. "
    					+ "Please re-enter.\n",  e.getMessage());
    		} catch (NumberFormatException e) {
    			System.out.printf("Invalid number(%s). "
    					+ "Please re-enter.\n",  e.getMessage());
    		}
    	} while (nextInt != 0);
                
    	System.out.println("The sum is " + s);
    }

    public static void main(String[] arg) {         

    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                         //"in" will receive data from the standard input stream
    	String c;
 
    	System.out.println("Do you wish to calculate a sum? (y/n)");

    	try {
    		c = in.readLine();
    	} catch (IOException e) {
    		//e.printStackTrace(); 
			/* Don't throw exception, only output to re-enter value */
			System.out.printf("Request could not be completed. %s. "
					+ "Please re-enter.\n",  e.getMessage());
			/* Default string value in case of exception to get to while-loop check */
			c = ""; 
    	}
         //Read next datum in input. A string "y" or "n" is expected

    	while (!c.equals("y") && !c.equals("n")) {
    		System.out.println("Please answer y or n");
    		try {
    			c = in.readLine();
    		} catch (IOException e) {
    			//e.printStackTrace(); 
    			/* Don't throw exception, only output to re-enter value */
    			System.out.printf("Request could not be completed. %s. "
    					+ "Please re-enter.\n",  e.getMessage());
    			
    		}
    	}

    	while (c.equals("y")) {
    		sum(in);
    		System.out.println("Do you wish to calculate another sum? (y/n)");
    		try {
    			c = in.readLine();
    		} catch (IOException e) {
    			//e.printStackTrace(); 
    			/* Don't throw exception, only output to re-enter value */
    			System.out.printf("Request could not be completed. %s. "
    					+ "Please re-enter.\n",  e.getMessage());
    		}

    		while (!c.equals("y") && !c.equals("n")) {
    			System.out.println("Please answer y or n");
    			try {
    				c = in.readLine();
    			} catch (IOException e) {
    				//e.printStackTrace(); 
        			/* Don't throw exception, only output to re-enter value */
        			System.out.printf("Request could not be completed. %s. "
        					+ "Please re-enter.\n",  e.getMessage());
    			}
    		}
    	}

    	System.out.println("Goodbye");
    }
}

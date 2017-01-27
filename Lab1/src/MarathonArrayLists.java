import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Naveed Kawsar
 *
 */
public class MarathonArrayLists {
	/**
	 * 
	 * @param _times ArrayList of runner times
	 * @return index of fastest runner time
	 */
	public static int findFastestRunner(ArrayList <Integer> _times)
	{
		int index = 0;
		int min = _times.get(index);
		for (int i=0; i<_times.size(); i++) {
	           if (_times.get(i) < min ){
	               min = _times.get(i);
	               index = i;
	           }
		}
		return index;
	}
	
	public static void main(String[] args) { 
		// Define two array lists here to store the names and the running times
		ArrayList <String> names = new ArrayList <String>();
		ArrayList <Integer> times = new ArrayList <Integer>();
		   
		// Read user input 
		  String sin; 
		  Scanner scan = new Scanner(System.in);   
		  while (true) 
		  { 
		    System.out.println("Please enter the name of the participant"); 
		    sin = scan.nextLine(); 
		    if(sin.toUpperCase().equals("QUIT")) 
		      break; 
		    // Add the name to your ArrayList
		    names.add(sin);
		    System.out.println("Please enter the running time of the participant"); 
		    sin = scan.nextLine(); 
		 
		    // Add the running time to your array list
		    times.add(Integer.parseInt(sin));	   
		  } 
		  // Call the function findFastestRunner and pass the running times array list to it 
		  int fastest = MarathonArrayLists.findFastestRunner(times); 
		  // Print the name of the fastest runner to the console 
		  System.out.println("The fastest runner is " + names.get(fastest) + 
					", with a time of " + times.get(fastest) + " minutes.");
		}  

}

/**
 * @author Naveed Kawsar
 *
 */
public class Marathon {
	/**
	 * @param array of integers corresponding to runners' times
	 * @return index corresponding to the lowest time
	 */
	public static int find_smallest_time (int[] _times) {
		int index = 0;
		int min = _times[index];
		for (int i=0; i<_times.length; i++) {
	           if (_times[i] < min ){
	               min = _times[i];
	               index = i;
	           }
		}
		return index;
	}
	
	public static void main (String[] args) {  
		String[] names = { "Elena", "Thomas", "Hamilton", "Suzie",
				"Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", 
				"Emily", "Daniel", "Neda", "Aaron", "Kate" };  
		int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 
				334, 412, 393, 299, 343, 317, 265 };  
		/* Use class method to access static method*/
		int fastest = Marathon.find_smallest_time(times); 
		System.out.println("The fastest runner is " + names[fastest] + 
				", with a time of " + times[fastest] + " minutes.");

	}

}

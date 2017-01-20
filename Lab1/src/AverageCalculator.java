
/**
 * @author Naveed Kawsar
 *
 */
public class AverageCalculator {

	public static void main(String[] args) {
		double sum = 0;
		System.out.printf("The %d numbers are:", args.length);
		
		for(int i=0; i < args.length; i++) {
			sum+= Double.parseDouble(args[i]);
			System.out.printf(" %.3f", Double.parseDouble(args[i]));
		}
		double average = sum/args.length; 
		System.out.printf("\nAnd their average is: %.3f\n", average);
	}

}

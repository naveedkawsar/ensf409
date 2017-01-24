import java.util.Scanner;
//import java.util.Arrays;

public class SinValidator {

private int[] SIN;

private int sumDigit(int x)
{
	int result =0;
	
	while(x > 0){
		result += x % 10;
		x = x /10;
	}
	
	return result;
}

	public SinValidator(String sin) {

		SIN = new int[9];
		int i =0;
		int counter =0;
		while(i < sin.length()){

			
			if(Character.isDigit(sin.charAt(i))){
				if(counter < 9)
					SIN[counter] =(int) sin.charAt(i) - 48;
				counter++;
			}
			else{
				System.err.println("Error: Invalid input by the user");
				return;
			}
			i++;
		}
		
		if(counter != 9){
			System.err.println("Error: SIN must be 9 digits...");
			return;
		}	
	}
	
	public boolean validateSin()
	{
		
		// THIS METHOD DOESN'T WORK. STUDENTS ARE EXPECTED TO COMPLTETE THIS METHOD
		int check_digit = SIN[SIN.length-1];	// Ninth digit
		int sum = 0;
		boolean even_digit = true;				// First bit is the eighth digit
		for(int i=SIN.length-2; i>=0; i--)
		{
			if(even_digit)
			{
				int double_digit = 2*SIN[i];
				sum += sumDigit(double_digit);	// Add 2 digits together			
			}
			else sum += SIN[i];
			even_digit = !even_digit;			// Toggle flag	
		}
		
		
		//System.out.printf(Arrays.toString(SIN));
		System.out.println(check_digit);
        int calculate_digit = 10 - (sum%10);
        System.out.println(sum);
        System.out.println(calculate_digit);
		if (calculate_digit == check_digit)
			return true;
		return false;
		
	}

	public static void main(String[] args) {
		// Read user input
	
	    String sin;
		Scanner scan = new Scanner(System.in);	
		while (true)
		{
			System.out.println("Please enter your 9 digit social insurance number"
					+ " or enter quit to terminate the program: ");
			sin = scan.nextLine();
			if(sin.toUpperCase().equals("QUIT"))
				break;
			SinValidator sv = new SinValidator(sin);
			if(sv.validateSin())
				System.out.println("Yes this is a valid SIN\n");
			else
				System.out.println("No this is NOT a valid SIN\n");
			
		}
	}

}

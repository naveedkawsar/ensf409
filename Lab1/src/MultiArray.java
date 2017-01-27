import java.util.Scanner;

/**
 * 
 */

/**
 * @author Naveed Kawsar
 *
 */
public class MultiArray {
	
	private static String[][] sentence_array = new String[3][60];
	
	public void reverse_chars(int row, String sentence)
	{
		char[] letters = sentence.toCharArray();	// Convert sentence to an array of chars
		
		int j = 0;
		for (int i = sentence.length() - 1; i >= 0; i--)
		{
	    	/* Turn individual chars back into strings, and store into array row backwards */
			sentence_array[row][j] = Character.toString(letters[i]);
			j++;
		}
	}
	
	public void reverse_words(int row, String sentence)
	{
		String[] words = sentence.split(" ");
		int j = 0;
	    for (int i = words.length - 1; i >= 0; i--)
	    {
	    	sentence_array[row][j] = words[i];
	    	if (i != 0)
	    		sentence_array[row][++j] = " ";		// Add spaces back in between words
	    	j++;
	    }
	}
	
	public void capitalize_fifths(int row, String sentence)
	{
		char[] letters = sentence.toCharArray();	// Convert sentence to an array of chars
		
		for (int i = 0; i < sentence.length() ; i++)
		{
			if ((i % 5) == 0)
				sentence_array[row][i] = Character.toString(Character.toUpperCase(letters[i]));
			else
				sentence_array[row][i] = Character.toString(letters[i]);
		}
				
	}

	public void print_multi_array()
	{
		for (int i  = 0; i < sentence_array.length; i++)
		{
			System.out.print("Sentence " + (i+1) + ":\n");
			for (int j = 0; sentence_array[i][j] != null; j++)
				System.out.print(sentence_array[i][j]);
			System.out.print("\n");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MultiArray manipulate_sentences = new MultiArray();
		Scanner input = new Scanner(System.in);
		
		System.out.print("\nPlease enter your first sentence.\n");
	    String sentence_one = input.nextLine();
	    manipulate_sentences.reverse_chars(0, sentence_one);
	    
		System.out.print("\nPlease enter your second sentence.\n");
		String sentence_two = input.nextLine();
		manipulate_sentences.reverse_words(1, sentence_two);
		
		System.out.print("\nPlease enter your third sentence.\n");
		String sentence_three = input.nextLine();
		manipulate_sentences.capitalize_fifths(2, sentence_three);
		
		manipulate_sentences.print_multi_array();

	}

}

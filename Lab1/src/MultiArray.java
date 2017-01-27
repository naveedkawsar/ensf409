import java.util.Scanner;

/**
 * @author Naveed Kawsar
 *
 */
public class MultiArray {
	
	private static String[][] sentence_array = new String[3][60];
	
	/**
	 * Load into sentence array and reverse each character
	 * @param row
	 * @param sentence
	 */
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
	
	/**
	 * Load into sentence array in reverse order of words in original input sentence
	 * @param row
	 * @param sentence
	 */
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
	
	/**
	 * Load into sentence array and capitalize letters whose indices are divisible by 5
	 * @param row
	 * @param sentence 
	 */
	public void capitalize_fifths(int row, String sentence)
	{
		char[] letters = sentence.toCharArray();	// Convert sentence to an array of chars
		
		for (int i = 0; i < sentence.length() ; i++)
		{
			/* Turn every fifth char upper case, then into strings.  Store in 2D array row */
			if ((i % 5) == 0)						
				sentence_array[row][i] = Character.toString(Character.toUpperCase(letters[i]));
			else
				sentence_array[row][i] = Character.toString(letters[i]);
		}		
	}

	/**
	 * Print each row of sentence array to screen
	 */
	public void print_multi_array()
	{
		for (int i  = 0; i < sentence_array.length; i++)
		{
			System.out.printf("Sentence %d: \n", (i+1));
			for (int j = 0; sentence_array[i][j] != null; j++)
				System.out.print(sentence_array[i][j]);
			System.out.print("\n");
		}
	}

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

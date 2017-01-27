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
		// TODO Auto-generated method stub
		MultiArray manipulate_sentences = new MultiArray();
		Scanner input = new Scanner(System.in);
		
		System.out.print("\nPlease enter your first sentence.\n");
	    String sentence = input.nextLine();
	    manipulate_sentences.reverse_chars(0, sentence);
	    
		System.out.print("\nPlease enter your second sentence.\n");
		//String sentence = input.nextLine();
		//manipulate_sentences.reverse_words(1, sentence);
		
		System.out.print("\nPlease enter your third sentence.\n");
		//String sentence = input.nextLine();
		//manipulate_sentences.capitalize_fifths(2, sentence);
		
		manipulate_sentences.print_multi_array();

	}

}

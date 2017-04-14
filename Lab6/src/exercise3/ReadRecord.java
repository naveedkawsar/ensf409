package exercise3;
/** 
 * Started by M. Moussavi
 * March 2015
 * Completed by: Naveed Kawsar
 * April 2017
 */

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadRecord {
    
    private ObjectInputStream input;
    
    /**
     *  opens an ObjectInputStream using a FileInputStream
     */
    
    private void readObjectsFromFile(String name)
    {
        MusicRecord record ;
        
        try
        {
            input = new ObjectInputStream(new FileInputStream( name ) );
        }
        catch ( IOException ioException )
        {
            System.err.println( "Error opening file." );
        }
        
        /* The following loop is supposed to use readObject method of of
         * ObjectInputSteam to read a MusicRecord object from a binary file that
         * contains several reords.
         * Loop should terminate when an EOFException is thrown.
         */
        
        try
        {
            while ( true )
            {
                
                
                // TO BE COMPLETED BY THE STUDENTS
            	record = ( MusicRecord ) input.readObject();
            	// display record contents on the screen
            	System.out.printf( "%-6d%-20s%-12s%4.2f\n",   
            	record.getYear(), record.getSongName(), 
            	record.getSingerName(), record.getPurchasePrice() );
                
           
            }   // END OF WHILE
        }
                // ADD NECESSARY catch CLAUSES HERE
        catch ( EOFException eof) 
        {
        	System.out.print("End of file reached.\n");
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} 
    }           // END OF METHOD 
    
    
    public static void main(String [] args)
    {
        ReadRecord d = new ReadRecord();
        d.readObjectsFromFile("mySongs.ser");
    }
}
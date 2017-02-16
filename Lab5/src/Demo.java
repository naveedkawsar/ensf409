
public class Demo {
	
	public void lab5_tests()
	{
		LinkedList  list1 = new LinkedList ();
		list1.push_back(2000,  23.0);
		list1.push_back(2001,  24.0);
		list1.push_back(2002,  266.0);
		list1.push_back(2003,  323.0);
		list1.insert(2222,  333.0);
		list1.insert(2222,  331.0);
		System.out.println("\nPrinting list1 after its creation ...\n");
		list1.print();
		
		try_to_find(list1, 2002);
		try_to_find(list1, 6000);
		
		LinkedList list2 = new LinkedList ();
		list2.push_back(1000, 77.0);
		list2.push_back(1500, 88.0);
		System.out.println("Printing the list2:");
		list2.print();
		list1.remove(2992);
        list1.remove(2000);
        list1.remove(2001);
        
        System.out.println("\nPrinting list1 after a few removes ...\n");
        list1.print();
        
		System.out.println ( "***----Finished testing----------------***");
	}


	
	void print   (LinkedList lt)
	{
		if (lt.size() == 0)
			System.out.println( "  list is EMPTY.\n");
		for (lt.go_to_first(); lt.cursor_ok(); lt.step_fwd()) {
			System.out.println(lt);
		}
	}

	 void try_to_find(LinkedList  lt, Integer key )
	{
		lt.find(key);
		if (lt.cursor_ok())

			System.out.println ("Found: " + lt );

		else
			System.out.println("Sorry, couldn't find key: " +  key + " in the table.\n");
	}

		

	public static void main(String [] args)
	{
		Demo d = new Demo();
		d.lab5_tests();

	}
}






/**
 * @author Naveed Kawsar
 *
 */
public class SimpleList {

	private Node headM;
	private static int sizeM;
	private class Node {
		int item;
		Node next;
	}
	
	/**
	 * Default constructor creates empty list
	 */
	public SimpleList()
	{
		this.headM = null;
		sizeM = 0;
	}
	
	private final int size()
	{
		return sizeM;
	}
	
	/**
	 * Adds a node with an item to the end of the list, and increments sizeM
	 * @param item node data
	 */
	public void push_back(final int item)
	{
		Node new_node = new Node();
		
		/* Eclipse IDE declares the following conditional code to be dead code */
	    if(new_node == null)
	    {
	        System.out.print("\nNo memory available to create a node\n");
	        System.exit(1);
	    }
	    
	    new_node.item = item;
	    
	    if (headM == null) {
	        new_node.next = headM;
	        headM = new_node;
	    }
	    else
	    {
	        Node p = headM;
	        while (p.next  != null)
	            p = p.next;
	        
	        p.next = new_node;
	        new_node.next = null;
	    }
	    sizeM++;
	}
	
	/**
	 * Adds a node with an item to the beginning of the list, and increments sizeM
	 * @param item node data
	 */
	public void push_front(final int item)
	{
		Node new_node = new Node();
	    new_node.item = item;
	    new_node.next = headM;
	    headM = new_node;
	    sizeM++;
	}
	
	/**
	 * If n is less than 0 or greater than or equal sizeM
	 * gives the error message: "Illegal Access" and terminates the program
	 * @param n the list index
	 * @return item at the nth position in the list
	 */
	public int get(int n)
	{
		if(n < 0 || n >= sizeM)
	    {
	        System.out.print("\n Illigal Access. program Terminates...\n");
	        System.exit(1);
	    }
		
		Node p = headM;
	    for(int i= 0; i < n; i++)
	        p = p.next;
	    
	    return p.item;
	}
	
	/**
	 * Puts the value of v at the i-th position
	 * @param n the list index
	 * @param v value to be placed into node data
	 */
	public void set(int n, int v)
	{
		if(n < 0 || n >= sizeM)
	    {
	        System.out.print("\n Illigal Access. program Terminates...\n");
	        System.exit(1);
	    }
		
		Node p = headM;
	    for(int i= 0; i < n; i++)
	        p = p.next;

	    p.item = v;
	}
	
	/**
	 * A node with a copy of theItem is inserted at the nth position, and sizeM 
	 * will be incremented if the operation of insert was successful.
	 * if n == sizeM calls push_back
	 * if n < 0 or n > sizeM returns and does nothing.
	 * @param itemA node data
	 * @param n the list index
	 */
	public void insert(final int itemA, int n)
	{
		if(n < 0 || n > sizeM)
			return;
		else if(n == 0)
			this.push_front(itemA);
		else if(n == sizeM) 
			this.push_back(itemA);
		else {
			Node new_node = new Node();
			
			/* Eclipse IDE declares the following conditional code to be dead code */
			if (new_node == null) {
				System.out.print("\nNo memory available to create a node\n");
		        System.exit(1);
			}
			new_node.item = itemA;
	        
	        Node before = headM;		// will point to node in front of new node
	        Node after = headM.next;	// will be null or point to node after new node
	        int i = 1;
	        while(i < n)
	        {
	            before = after;
	            after = after.next;
	            i++;
	        }
	        new_node.next = after;
	        before.next = new_node;
	        sizeM++;
		}
	}
	
	/**
	 * Does nothing if n < 0 or n > sizeM-1. Otherwise, if list is not empty
	 * sets the node at the position n to be null and garbage-collected
	 * @param n the list index
	 */
	public void remove(int n)
	{
		if (headM == null || n < 0 || n >= sizeM)
	        return;
	    Node be_deleted;
	    Node before;
	    
	    if(n == 0)
	    {
	        be_deleted = headM;
	        headM = headM.next;
	    }
	    else
	    {
	        before = headM;
	        be_deleted = before.next;
	        
	        int i = 1;
	        while (i < n)
	        {
	            before = be_deleted;
	            be_deleted = before.next;
	            i++;
	        }
	        
	        before.next = be_deleted.next;

	    }
	    be_deleted = null;	/* "delete" be_deleted */
	    sizeM--;
	}
	
	/**
	 * Sets each node to null, and size to zero
	 */
	public void clear()
	{
		Node p = headM;
	    
	    while(p != null)
	    {
	        headM = headM.next;
	        p = null;		/* "delete" p */
	        p = headM;
	    }

	    //headM = null;		/* Redundant */
	    sizeM = 0;
	}
	
	public void print()
	{
	    for(int i = 0; i < this.size(); i++)
	        System.out.print(this.get(i) + "  ");
	}
	
	public static void main(String[] args) {
		
		SimpleList list = new SimpleList();
		System.out.print("\nList just after creation -- is empty.\n");
	    
	    list.push_front(50);
	    System.out.print("\nAfter calling push_front. list must have: 50\n");
	    list.print();
	    
	    list.push_back(440);
	    
	    list.set(0,770);
	    System.out.print("\nAfter calling push_back and set function list must have: 770  440\n");
	    list.print();
	    
	    list.push_back(330);
	    list.push_back(220);
	    list.push_back(110);
	    
	    System.out.print("\nAfter three more calls to push_back, list must have: 770, 440, 330, 220, 110\n");
	    list.print();
	    
	    list.remove(0);
	    list.remove(2);
	    System.out.print("\nAfter removing two nodes. list must have: 440, 330, 110\n");
	    list.print();
	    list.insert(40, 3);		//insert node with the value of 40 at the 4th position
	    list.insert(20, -1);	// do nothing
	    list.insert(30, 30000); // do nothing
	    list.insert(10, 0);		//insert node with the value of 10 at the 1st position
	    list.insert(33, 2);		// insert node with the value 33 at the 3rd position
	    
	    System.out.print("\nTwo  more nodes inserted, must have: 10, 440, 33, 330, 110, 40\n");
	    list.print();
	    
	    list.remove(0);
	    list.remove(1);
	    list.remove(2);
	    list.remove(3);
	    list.remove(4);
	    list.remove(5);
	    System.out.print("\nAfter 6 removes, list must have: 440, 330, 40: \n");
	    list.print();
	    
	    list.clear();
	    System.out.print("\nAfter call to clear, list must be empty:\n");
	    list.print();
	    
	    list.push_back(331);
	    list.push_back(221);
	    list.push_back(111);
	    
	    System.out.print("\nAfter three calls to push_back, list must have: 331, 221, 111\n");
	    list.print();
   
	    return;
	}
}

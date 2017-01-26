/**
 * 
 */

/**
 * @author Naveed Kawsar
 *
 */
public class SimpleList {

	/**
	 * @param args
	 */
	
	private Node headM;
	private static int sizeM;
	private class Node {
		int item;
		Node next;
	}
	
	public SimpleList()
	{
		this.headM = null;
		sizeM = 0;
	}
	
	private final int size()
	{
		return sizeM;
	}
	
	public void push_back(final int item)
	{
		Node new_node = new Node();
		
		/* Eclipse IDE declares the following conditional code to be dead code */
	    if(new_node == null)
	    {
	        System.out.println("\nNo memory available to create a node\n");
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
	
	public void push_front(final int item)
	{
		Node new_node = new Node();
	    new_node.item = item;
	    new_node.next = headM;
	    headM = new_node;
	    sizeM++;
	}
	
	public void pop_back(final int item)
	{
		
	}
	
	public int get(int n)
	{
		if(n < 0 || n >= sizeM)
	    {
	        System.out.println("\n Illigal Access. program Terminates...\n");
	        System.exit(1);
	    }
		
		Node p = headM;
	    for(int i= 0; i < n; i++)
	        p = p.next;
	    
	    return p.item;
	}
	
	public void set(int n, int v)
	{
		if(n < 0 || n >= sizeM)
	    {
	        System.out.println("\n Illigal Access. program Terminates...\n");
	        System.exit(1);
	    }
		
		Node p = headM;
	    for(int i= 0; i < n; i++)
	        p = p.next;

	    p.item = v;
	}
	
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
				System.out.println("\nNo memory available to create a node\n");
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
	    //delete be_deleted;
	    sizeM--;
	}
	
	public void clear()
	{
		Node p = headM;
	    
	    while(p != null)
	    {
	        headM = headM.next;
	        //delete p;
	        p = headM;
	    }

	    headM = null;
	    sizeM = 0;;
	}
	
	public void print()
	{
	    for(int i = 0; i < this.size(); i++)
	        System.out.println(this.get(i) + "  ");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleList list = new SimpleList();
		System.out.println("\nList just after creation -- is empty.\n");
	    
	    list.push_front(50);
	    System.out.println("\nAfter calling push_front. list must have: 50\n");
	    list.print();
	    
	    list.push_back(440);
	    
	    list.set(0,770);
	    System.out.println("\nAfter calling push_back and set function list must have: 770  440\n");
	    list.print();
	    
	    list.push_back(330);
	    list.push_back(220);
	    list.push_back(110);
	    
	    System.out.println("\nAfter three more calls to push_back, list must have: 770, 440, 330, 220, 110\n");
	    list.print();
	    
	    list.remove(0);
	    list.remove(2);
	    System.out.println("\nAfter removing two nodes. list must have: 440, 330, 110\n");
	    list.print();
	    list.insert(40, 3);		//insert node with the value of 40 at the 4th position
	    list.insert(20, -1);	// do nothing
	    list.insert(30, 30000); // do nothing
	    list.insert(10, 0);		//insert node with the value of 10 at the 1st position
	    list.insert(33, 2);		// insert node with the value 33 at the 3rd position
	    
	    System.out.println("\nTwo  more nodes inserted, must have: 10, 440, 33, 330, 110, 40\n");
	    list.print();
	    
	    list.remove(0);
	    list.remove(1);
	    list.remove(2);
	    list.remove(3);
	    list.remove(4);
	    list.remove(5);
	    System.out.println("\nAfter 6 removes, list must have: 440, 330, 40: \n");
	    list.print();
	    
	    list.clear();
	    System.out.println("\nAfter call to clear, list must be empty:\n");
	    list.print();
	    
	    list.push_back(331);
	    list.push_back(221);
	    list.push_back(111);
	    
	    System.out.println("\nAfter three calls to push_back, list must have: 331, 221, 111\n");
	    list.print();
   
	    return;
	}

}

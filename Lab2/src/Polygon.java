package src;

import java.util.*;

class Polygon {
	private final LinkedHashSet <Line> polygon;
	private int objID;
	private static int classID;
	Iterator <Line> it;

	public Polygon(LinkedHashSet<Line> polygon) {
		 this.polygon = new LinkedHashSet<Line>();
		 for(Line l: polygon)
			 this.polygon.add (l);  
		 objID = ++ classID;
		 it = this.polygon.iterator();
	}
	
	public Iterator <Line> getLine() {
		it = polygon.iterator();
		return it;
	}
	
	public static int classID(){
		return classID;
	}
	
    
        public String toString() {
            // THIS METHOD DOESN'T WORK. AS PART OF EXERCISE-B STUDENTS MUST FIX
            // IT TO RETURN A STRING WITH THE INORMATION ABOUT START AND END
            // POINTS OF N LINES OF A POLYGON. AS SHOW SHOWN IN THE EXAMPLE, BELOW:
            // The lines in polygon 1 are:
            //   Line 1: starts at (20, 30), and ends at (50, 100)
            //   Line 2: starts at (50, 100), and ends at (100, 30)
            //   Line 3: starts at (100, 30), and ends at (20, 30)
            //
     
        	this.getLine();		// Initialize iterator object, it, to traverse over the list
        	
    		String s = "\nThe lines of the polygon " + this.objID +" are :\n";
    		
    		while(it.hasNext())
    		{
    			s += it.next().toString() + "\n";	// Add to string while there are elements in the iteration
    		}
    	return s;	
    }
}



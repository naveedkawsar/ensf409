/**
 * 
 */

/**
 * @author Naveed Kawsar
 *
 */
public class Clock {

	private int day, hour, minute, second;
	
	/* Default constructor*/
	public Clock() 
	{
		this(0,0,0,0);	// Set day, hour, minute, second to 0
	}
	
	/* Constructor with arguments*/
	public Clock(int day,int hour, int minute, int second)
	{
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	/*Getter methods*/
	public int getDay()
	{
		return this.day;
	}
	
	public int getHour()
	{
		return this.hour;
	}
	
	public int getMinute()
	{
		return this.minute;
	}
	
	public int getSecond()
	{
		return this.second;
	}
	
	/*Setter methods*/
	public void setDay(int day)
	{
		this.day = day;
	}
	
	public void setHour(int hour)
	{
		if (hour >= 0 && hour <= 23)
			this.hour = hour;
	}
	
	public void setMinute(int minute)
	{
		if (hour >= 0 && hour <= 59)
			this.minute = minute;
	}
	
	public void setSecond(int second)
	{
		if (second >= 0 && second <= 59)
			this.second = second;
	}
	
	public void increment(int second)
	{
		if ((this.second + second) > 59)
		{
			this.minute++;
			this.second += (second - 60);
		}
	}
	
	public int calculateTotalSeconds()
	{
		return this.second +
				(this.minute * 60) +
				(this.hour * 60 * 60) +
				(this.day * 24 * 60 * 60);
	}
	
	public static void main(String[] args) { 
		 
		// Create elapsed time with the default values of zeros for day, hour, 
		// minute and second. 
		Clock t1 = new Clock(); // Default constructor 
		 
		// sets hour to 23 
		t1.setHour(23); 
		// sets day to 1 
		t1.setDay(1); 
		// sets minute to 59 
		t1.setMinute(59); 
		// sets day to 16 
		t1.setSecond(16); 
		   
		// prints: 1:23:59:16 
		System.out.println(t1.getDay() + ":" + t1.getHour() +":" + t1.getMinute() + ":" + t1.getSecond()); 
		   
		// increments time t1 by 44 seconds: 
		t1.increment(44);  
		// prints: 2:0:0:0 
		System.out.println(t1.getDay() + ":" + t1.getHour() +":" +t1.getMinute() + ":" + t1.getSecond()); 
		   
		// prints the total elapsed time in seconds: 172,800 
		System.out.printf("The elapsed time in seconds is: %d", t1.calculateTotalSeconds()); 
		   
		// REPEAT SIMILAR TESTS FOR t2 
		//Elapsed time is 3 days, 1 hour, 4 mins and 5 secs 
		Clock t2 = new Clock(3, 1, 4, 5); 
		}

}

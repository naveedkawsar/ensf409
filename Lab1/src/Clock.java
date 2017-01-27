
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
		this.day += second / (24*60*60);						// 86400 sec/day
		this.hour += (second % (24*60*60)) / (60*60);			// 3600 sec/hour
		this.minute += ((second % (24*60*60)) % (60*60)) / 60;	// 60 sec/min
		this.second += ((second % (24*60*60)) % (60*60)) % 60;
				
		if (this.second > 59)				// Adding seconds rolls over to the next minute
		{
			if (this.minute + 1 > 59)		// Adding a minute rolls over to the next hour
			{
				if (this.hour + 1 > 23)		// Adding an hour rolls over to the next day
				{
					this.day++;
					this.hour = 0;
					this.minute = 0;
					this.second += -60;
				}
				else
				{
					this.hour++;
					this.minute = 0;
					this.second += -60;
				}
			}
			else
			{
				this.minute++;
				this.second += -60;
			}
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
		   
		// prints the total elapsed time in seconds: 172,800 seconds
		System.out.printf("The elapsed time in seconds is: %d\n", t1.calculateTotalSeconds()); 
		   
		// REPEAT SIMILAR TESTS FOR t2 
		// Elapsed time is 3 days, 1 hour, 4 mins and 5 secs 
		Clock t2 = new Clock(3, 1, 4, 5); 
		
		// prints: 3:1:4:5 
		System.out.println(t2.getDay() + ":" + t2.getHour() +":" + t2.getMinute() + ":" + t2.getSecond());
		
		// increments time t2 by 90172 seconds = 1day:1hour:2min:52sec
		t2.increment(90172);
		
		// prints 4:2:6:57
		System.out.println(t2.getDay() + ":" + t2.getHour() +":" + t2.getMinute() + ":" + t2.getSecond());
		
		// increments time t2 by 5 seconds:
		t2.increment(5);
		
		// prints 4:2:7:2
		System.out.println(t2.getDay() + ":" + t2.getHour() +":" + t2.getMinute() + ":" + t2.getSecond());
		
		// prints the total elapsed time in seconds: 4days:2hours:7min:2sec = 353,222 seconds 
		System.out.printf("The elapsed time in seconds is: %d\n", t2.calculateTotalSeconds());
		}

}

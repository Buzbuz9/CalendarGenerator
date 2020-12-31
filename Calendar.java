import java.util.Scanner; 

public class Calendar {

	//is the current year a leap year
	boolean leapYear = false;
	//array to hold the num of days of each month
	private int[] m = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	/*
	 * input: month
	 * output: month converted to String name
	returns the name of the month as a string for printing
	*/
	public String convertMoth(int month)
	{
		String name = "";
		if(month == 1)
		{
			name = "January";
		}
		else if(month == 2)
		{
			name = "Febuary";
		}
		else if(month == 3)
		{
			name = "March";
		}
		else if(month == 4)
		{
			name = "April";
		}
		else if(month == 5)
		{
			name = "May";
		}
		else if(month == 6)
		{
			name = "June";
		}
		else if(month == 7)
		{
			name = "July";
		}
		else if(month == 8)
		{
			name = "August";
		}
		else if(month == 9)
		{
			name = "September";
		}
		else if(month == 10)
		{
			name = "October";
		}
		else if(month == 11)
		{
			name = "November";
		}
		else 
		{
			name = "December";
		}
		return name;
	}
	
	/* input: year, month, int m[]
	 * output: printed calendar of the month from that year
	 * 
	 * calls the whatDay method to find the day of the week the month starts at then prints the month
	 */
	public void printCalander(int year, int month)
	{
		//find out what day of the week to start on
		int weekDay = this.whatDay(month, year);
		
		//keep track of line length for formating
		int lineLength = 0;
		
		//print out the dates of the month starting with the day of the week we found
		//first line same every time
		System.out.println("    " + this.convertMoth(month) + "     " + year);
		System.out.println("Su  Mo  Tu  We  Th  Fr  Sa");
		
		//print out spaces to start calendar printing in correct position
		for(int w = 0; w < weekDay; w++)
		{
			System.out.print("    ");
			lineLength += 4;
		}
		
		//febuary?
		if(month == 2)
		{
			//is it currently a leap year?
			if(leapYear)
			{
				for(int i = 1; i <= 29; i++)
				{
					
						//time for a new line?
						if(lineLength >= 26)
						{
							System.out.println();
							lineLength = 0;
						}
							//put a leading space if the num is less then 10
							if(i < 10)
							{
								System.out.print(" " + i + "  ");
							}
							else
							{
								System.out.print(i + "  ");
							}
							lineLength += 4;
					
				}
			}
			//feb but not a leap year
			else
			{
				for(int i = 1; i <= 28; i++)
				{
					//time for a new line?
					if(lineLength >= 26)
					{
						System.out.println();
						lineLength = 0;
					}
						//put a leading space if the num is less then 10
						if(i < 10)
						{
							System.out.print(" " + i + "  ");
						}
						else
						{
							System.out.print(i + "  ");
						}
						lineLength += 4;
				}
			}
		}
		//30 day months
		else if(month == 9 || month == 4 || month == 6 || month == 11)
		{
			for(int i = 1; i <= 30; i++)
			{
					//time for a new line?
					if(lineLength >= 26)
					{
						System.out.println();
						lineLength = 0;
					}
						//put a leading space if the num is less then 10
						if(i < 10)
						{
							System.out.print(" " + i + "  ");
						}
						else
						{
							System.out.print(i + "  ");
						}
						lineLength += 4;
				
			}
		}
		//31 day months
		else
		{
			for(int i = 1; i <= 31; i++)
			{
				//time for a new line?
				if(lineLength >= 26)
				{
					System.out.println();
					lineLength = 0;
				}
					//put a leading space if the num is less then 10
					if(i < 10)
					{
						System.out.print(" " + i + "  ");
					}
					else
					{
						System.out.print(i + "  ");
					}
					lineLength += 4;
			}

		}
		
	}
	
	/*
	 * input: year, month, int m[]
	 * output: returns a numerical value to represent day of the week sun = 0, mon =1...
	 * this method will determine what day of the week the month start with
	 * and return a number 0-6 sun-mon to represent that and to be implemented in the printCalander method
	 */ 
	public int whatDay(int month, int year)
	{
		//is it a leap year?
		if(this.isLeapYear(year))
		{
			leapYear = true;
			m[1] = 29;
		}
		
		//how many days has it been since 1, 1, 1771?
		int days = 0;
		
		 for(int y = 1771; y < year; y++)
		 {
		 	if(this.isLeapYear(y) == true)
		 	{
		 		days += 366;
		 	}
		 	else
		 		days += 365;
		 }
		 
		//add days of months that have passed this year already 
		for(int x = 1; x < month; x++)
		{
			days += m[x-1];
		}

		//what day of the week is it? 0 -> tues, 1 -> wen, ect...
		int num = days % 7;
		
		//convert num to sun = 0, mon = 1, ect...
		if(num == 5 || num == 6)
		{
			num = num-5;
		}
		else
		{
			num +=2;
		}
		System.out.println();
		return num;
	}
	
	/*
	 * input: year
	 * output: boolean of if the input year is a leap year or not true if it is a leap year
	 */
	public boolean isLeapYear(int year)
	{
		if(year % 4 == 0)
		{
			//divisible by 100
			if(year % 100 == 0)
			{
				if(year % 400 == 0)
				{
					return true;
				}
			}
			else
			{
				return true;
			}
		}
		
		return false;
	}
		
}

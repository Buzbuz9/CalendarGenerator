import java.util.Scanner;

public class CalendarChecker {

	public static void main(String[] args) 
	{
		Calendar cal = new Calendar();
		Scanner input = new Scanner(System.in);
		
		int month;
		int year;
		
		System.out.print("Please enter a month [1-12]:");
		month = input.nextInt();
		//if input is invalid
		while(month > 12 || month < 1)
		{
			System.out.print("Entry Invalid. \nPlease enter a month [1-12]:");
			month = input.nextInt();
		}
		
		
		System.out.print("Please enter a year [1771-9999]:");
		year = input.nextInt();
		//if input is invalid
		while(year < 1771 || year > 9999)
		{
			System.out.print("Entry Invalid. \nPlease enter a year [1771-9999]:");
			year = input.nextInt();
		}
		
		cal.printCalander(year,month);
		input.close();
	}
}

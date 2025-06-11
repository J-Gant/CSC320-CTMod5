package mod5.csc320.csug;
import java.util.Scanner;

public class GetMonthlyTemperatures {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", 
				"August", "September", "October", "November", "December"};
		int[] monthlyTemp = {25, 26, 34, 52, 63, 85, 94, 93, 83, 66, 51, 42};
		String userInput = "";
		
		//calculate yearlyTemp from monthlyTemp[] array elements
		int sum = 0;
		int yearlyTemp = 0;
		for (int i = 0; i < monthlyTemp.length; ++i) {
			sum = sum + monthlyTemp[i];
		}
		yearlyTemp = sum / monthlyTemp.length;
		
		//find minimum monthly temperature and coldest month
		int minTemp = monthlyTemp[0];
		String coldestMonth = monthNames[0];
		for (int i = 1; i < monthlyTemp.length; ++i) {
			if (monthlyTemp[i] < minTemp) {
				minTemp = monthlyTemp[i];
				coldestMonth = monthNames[i];
			}
		}
		
		//find maximum monthly temperature and hottest month
		int maxTemp = monthlyTemp[0];
		String hottestMonth = monthNames[0];
		for (int i = 1; i < monthlyTemp.length; ++i) {
			if (monthlyTemp[i] > maxTemp) {
				maxTemp = monthlyTemp[i];
				hottestMonth = monthNames[i];
			}
		}

		//output to prompt user input
		System.out.println("Enter the name of a month to view its average temperature.\n");
		System.out.println("Enter \"year\" to see the average, minimum, and maximum");
		System.out.println("monthly and yearly temperatures.\n");
		System.out.println("Enter \"quit\" to quit the program.");
		
		//outer loop checks input validity, allows repeat inputs until 1 of 2 sentinel
		//values entered, and provides error message if input invalid
		userInput = scnr.next();
		while(!userInput.equalsIgnoreCase("quit") && !userInput.equalsIgnoreCase("year")) {
			boolean found = false;
			
			//inner loop iterates through monthNames[] to find a match with user input
			//then outputs the average monthly temperature
			for (int i = 0; i < monthNames.length; ++i) {
				if (userInput.equalsIgnoreCase(monthNames[i])) {
					System.out.print("The average temperature for ");
					System.out.println(monthNames[i] + " is " + monthlyTemp[i] + " degrees F");
					found = true;
					break;
				}
			}
			
			//(back in while loop) prints error message if user input is a typo
			if (!found) {
				System.out.println("Invalid input");
			}
			
			//gives user the option to continue or quit
			System.out.println();
			System.out.println("Type the name of another month, type \"year\",");
			System.out.println("or type \"quit\" to exit.");
			System.out.println();
			userInput = scnr.next();
		}
		
		//displays average yearly temperature & all monthly averages, minimums and maximums
		if (userInput.equalsIgnoreCase("year")) {
			System.out.println("Average annual temp: " + yearlyTemp + " degrees F");
			System.out.println("Minimum avg monthly temp: " + minTemp + " F " + "in " + coldestMonth);
			System.out.println("Maximum avg monthly temp: " + maxTemp + " F " + "in " + hottestMonth);
			System.out.println();
			System.out.println("Average temperatures by month:");
			//loop to output month names and average temps within their arrays
			for (int i = 0; i < monthNames.length; ++i) {
				System.out.println(monthNames[i] + ": " + monthlyTemp[i] + " F");
			}
		}
		//ends program when user types "quit"
		else if (userInput.equalsIgnoreCase("quit")) {
			System.out.println("Thank you!");
			return;
		}
	}
}

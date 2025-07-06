package mod5.csc320.csug;

import java.util.Scanner;

public class GetMonthlyTemperatures {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		Calculations calc = new Calculations();
		String userInput = "";

		// output to prompt user input
		System.out.println("Enter the name of a month to view its average temperature.\n");
		System.out.println("Enter \"year\" to see the average, minimum, and maximum");
		System.out.println("monthly and yearly temperatures.\n");
		System.out.println("Enter \"quit\" to quit the program.");

		// outer loop checks input validity, allows repeat inputs until 1 of 2 sentinel
		// values entered, and provides error message if input invalid
		userInput = scnr.next();
		while (!userInput.equalsIgnoreCase("quit") && !userInput.equalsIgnoreCase("year")) {
			boolean found = false;

			// inner loop iterates through monthNames[] to find a match with user input
			// then outputs the average monthly temperature
			for (int i = 0; i < calc.getMonthNamesLength(); ++i) {
				if (userInput.equalsIgnoreCase(calc.getMonthNames()[i])) {
					System.out.print("The average temperature for ");
					System.out.println(calc.getMonthNames()[i] + " is " + 
							calc.getMonthlyTemp()[i] + " degrees F");
					found = true;
					break;
				}
			}

			// (back in while loop) prints error message if user input is a typo
			if (!found) {
				System.out.println("Invalid input");
			}

			// gives user the option to continue or quit
			System.out.println();
			System.out.println("Type the name of another month, type \"year\",");
			System.out.println("or type \"quit\" to exit.");
			System.out.println();
			userInput = scnr.next();
		}

		// displays average yearly temperature & all monthly averages, minimums and
		// maximums
		if (userInput.equalsIgnoreCase("year")) {
			System.out.println("Average annual temp: " + calc.yearlyTemp() + " degrees F");
			System.out.println("Minimum avg monthly temp: " + calc.minTemp() + " F " + "in " + calc.coldestMonth());
			System.out.println("Maximum avg monthly temp: " + calc.maxTemp() + " F " + "in " + calc.hottestMonth());
			System.out.println();
			System.out.println("Average temperatures by month:");
			// loop to output month names and average temps within their arrays
			for (int i = 0; i < calc.getMonthNamesLength(); ++i) {
				System.out.println(calc.getMonthNames()[i] + ": " + calc.getMonthlyTemp()[i] + " F");
			}
		}
		// ends program when user types "quit"
		else if (userInput.equalsIgnoreCase("quit")) {
			System.out.println("Thank you!");
		}
		scnr.close();
	}
}

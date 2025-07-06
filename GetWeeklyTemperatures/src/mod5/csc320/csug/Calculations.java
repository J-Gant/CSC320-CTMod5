package mod5.csc320.csug;

public class Calculations {
	private String[] monthNames = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };
	private int[] monthlyTemp = { 25, 26, 34, 52, 63, 85, 94, 93, 83, 66, 51, 42 };
	
	public int getMonthNamesLength() {
		int length = monthNames.length;
		return length;
	}
	
	public String[] getMonthNames() {
		return monthNames;
	}
	
	public int[] getMonthlyTemp() {
		return monthlyTemp;
	}

	// calculate yearlyTemp from monthlyTemp[] array elements
	public int yearlyTemp() {
		int sum = 0;
		int yearlyTemp = 0;
		for (int i = 0; i < monthlyTemp.length; ++i) {
			sum = sum + monthlyTemp[i];
		}
		yearlyTemp = sum / monthlyTemp.length;
		return yearlyTemp;
	}

	// find minimum monthly temperature
	public int minTemp() {
		int minTemp = monthlyTemp[0];
		for (int i = 1; i < monthlyTemp.length; ++i) {
			if (monthlyTemp[i] < minTemp) {
				minTemp = monthlyTemp[i];
			}
		}
		return minTemp;
	}

	// find coldest month
	public String coldestMonth() {
		int minTemp = monthlyTemp[0];
		String coldestMonth = monthNames[0];
		for (int i = 1; i < monthlyTemp.length; ++i) {
			if (monthlyTemp[i] < minTemp) {
				coldestMonth = monthNames[i];
				minTemp = monthlyTemp[i];
			}
		}
		return coldestMonth;
	}

	// find maximum monthly temperature
	public int maxTemp() {
		int maxTemp = monthlyTemp[0];
		for (int i = 1; i < monthlyTemp.length; ++i) {
			if (monthlyTemp[i] > maxTemp) {
				maxTemp = monthlyTemp[i];
			}
		}
		return maxTemp;
	}

	// find hottest month
	public String hottestMonth() {
		int maxTemp = monthlyTemp[0];
		String hottestMonth = monthNames[0];
		for (int i = 1; i < monthlyTemp.length; ++i) {
			if (monthlyTemp[i] > maxTemp) {
				hottestMonth = monthNames[i];
				maxTemp = monthlyTemp[i];
			}
		}
		return hottestMonth;
	}

}

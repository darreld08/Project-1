package project1;

import java.util.Calendar;

/**
 * This class contains a constructor that instantiates a Date object with the attributes consisting of
 * year, month, and day and the methods that get the instance attributes, compare objects, and check if a Date is valid.
 *
 * @author Darrel Dsouza
 * @author Anton Derkach
 */
public class Date implements Comparable <Date> {
	private int year;
	private int month;
	private int day;

	/**
	 * Instantiates a Date object with a given input
	 * @param date The String input containing the date
	 */
	public Date (String date) {
		String[] dateInput = date.split("/");
		month = Integer.parseInt(dateInput[0]);
		day = Integer.parseInt(dateInput[1]);
		year = Integer.parseInt(dateInput[2]);
		
	}

	/**
	 * Instantiates a Date object with the current date
	 */
	public Date() {
		Calendar cal = Calendar.getInstance();
		day = cal.get(Calendar.DAY_OF_MONTH);
		month = cal.get(Calendar.MONTH) + 1; //Since Calendar.JAN = 0;
		year = cal.get(Calendar.YEAR);
	}

	/**
	 * Gets the year
	 * @return The year as an integer
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Checks if the year is valid
	 * @return True if the year is valid
	 */
	private boolean yearValid() {
		if (year < Constant.MIN_YEAR) { //checks if year outside bounds
			return false;
		}
		return true;
	}

	/**
	 * Checks if the month is valid
	 * @return True if the month is valid
	 */
	private boolean monthValid() {
		if (month < Constant.MIN_MONTH || month > Constant.MAX_MONTH) { //checks if month outside bounds
			return false;
		}
		return true;
	}

	/**
	 * Checks if the day is valid
	 * @return True if the day is valid
	 */
	private boolean dayValid() {
		if (month == Constant.FEB) { //check if month is february
			if (isLeap()) { //if leap, check if day outside 1-29
				if (day < Constant.MIN_DAY || day > Constant.LEAP_DAY) {
					return false;
				}
			}
			else { //if not leap, check if day outside 1-28
				if (day < Constant.MIN_DAY || day > Constant.FEB_DAY) {
					return false;
				}
			}
		}
		//if a month with 31 days, check if days outside 1 and 31 (MAX_DAY1)
		else if (month == Constant.JAN || month == Constant.MAR || month == Constant.MAY
				|| month == Constant.JUL || month == Constant.AUG || month == Constant.OCT || month == Constant.DEC) {
			if (day < Constant.MIN_DAY || day > Constant.MAX_DAY1) {
				return false;
			}
		}
		//if a remaining month (30 days), check if days outside 1 and 30 (MAX_DAY2)
		else {
			if (day < Constant.MIN_DAY || day > Constant.MAX_DAY2) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if the date
	 * @return True if the date is valid
	 */
	public boolean isValid() {
		if (yearValid() && monthValid() && dayValid()) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if the year is a leap year
	 * @return True if the year is a leap year
	 */
	private boolean isLeap() {
		if (year % Constant.QUADRENNIAL == 0) {
			if (year % Constant.CENTENNIAL == 0) {
				if (year % Constant.QUARTERCENTENNIAL == 0) {
					return true;
				}
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * Compares the date with another date
	 * @param date The date to compare with
	 * @return GREATER (1) if this date is greater than the other date, LESS (-1) if less, and EQUAL (0) if equal
	 */
	@Override
	public int compareTo(Date date) {
		if (this.year > date.year) {
			return Constant.GREATER;
		}
        else if (this.year < date.year) {
        	return Constant.LESS;
        }
        else {
            if (this.month > date.month) {
            	return Constant.GREATER;
            }
            else if (this.month < date.month) {
            	return Constant.LESS;
            }
            else {
            	if (this.day > date.day) {
            		return Constant.GREATER;
            	}
            	else if (this.day < date.day) {
            		return Constant.LESS;
            	}
            	return Constant.EQUAL;
            }
        }
	}

	/**
	 * Converts the date into a String consisting of the year, month, and day
	 * @return The String representation of the instance object
	 */
	@Override
	public String toString() {
		return month + "/" + day + "/" + year;
	}

	/**
	 * Tests the constructor and the methods in the Date class
	 * @param args Not used. Here by default.
	 */
	//Testbed main
	public static void main(String[] args) {
		boolean expectedResult;
		boolean result;
		//Test case #1, date with invalid day of the month
		Date date1 = new Date("11/31/2021");
		System.out.println("Test case #1: Apr, Jun, Sept, and Nov only have 30 days.");
		result = date1.isValid();
		expectedResult = false;
		if (result == expectedResult) {
			System.out.println("Pass.");
		}
		else {
			System.out.println("Fail.");
		}
		
		//Test case #2, date with valid day of the month
		Date date2 = new Date("8/31/2021");
		System.out.println("Test case #2: Jan, Mar, May, Jul, Aug, Oct, and Dec have 31 days.");
		result = date2.isValid();
		expectedResult = true;
		if (result == expectedResult) {
			System.out.println("Pass.");
		}
		else {
			System.out.println("Fail.");
		}
				
		//Test case #3, date with invalid day of the month
		Date date3 = new Date("11/00/2021");
		System.out.println("Test case #3: Minimum day value is 1");
		result = date3.isValid();
		expectedResult = false;
		if (result == expectedResult) {
			System.out.println("Pass.");
		}
		else {
			System.out.println("Fail.");
		}
		
		//Test case #4, date with invalid month
		Date date4 = new Date("13/11/2021");
		System.out.println("Test case #4: Maximum month value is 12");
		result = date4.isValid();
		expectedResult = false;
		if (result == expectedResult) {
			System.out.println("Pass.");
		}
		else {
			System.out.println("Fail.");
		}
		//Test case #5, date with invalid month
		Date date5 = new Date("00/11/2021");
		System.out.println("Test case #5: Minimum month value is 1");
		result = date5.isValid();
		expectedResult = false;
		if (result == expectedResult) {
			System.out.println("Pass.");
		}
		else {
			System.out.println("Fail.");
		}
		//Test case #6, date with invalid year
		Date date6 = new Date("01/13/-54");
		System.out.println("Test case #6: Minimum year is 0.");
		result = date6.isValid();
		expectedResult = false;
		if (result == expectedResult) {
			System.out.println("Pass.");
		}
		else {
			System.out.println("Fail.");
		}
		//Test case #7, date with Feb. 29 on non-leap year
		Date date7 = new Date("02/29/2001");
		System.out.println("Test case #7: February only has 28 days for non-leap year");
		result = date7.isValid();
		expectedResult = false;
		if (result == expectedResult) {
			System.out.println("Pass.");
		}
		else {
			System.out.println("Fail.");
		}
		//Test case #8 date with Feb. 29 on a leap year
		Date date8 = new Date("02/29/2004");
		System.out.println("Test case #8: February has 29 days on a leap year");
		result = date8.isValid();
		expectedResult = true;
		if (result == expectedResult) {
			System.out.println("Pass.");
		}
		else {
			System.out.println("Fail.");
		}
		//Test case #9 date with Feb. 29 on a non-leap year (multiple of 100)
		Date date9 = new Date("02/29/2100");
		System.out.println("Test case #9: February has only 28 days on a centennial year");
		result = date9.isValid();
		expectedResult = false;
		if (result == expectedResult) {
			System.out.println("Pass.");
		}
		else {
			System.out.println("Fail.");
		}
		//Test case #10 date with Feb. 29 on a leap year (multiple of 400)
		Date date10 = new Date("02/29/2000");
		System.out.println("Test case #10: February has 29 days on a quartercentennial year");
		result = date10.isValid();
		expectedResult = true;
		if (result == expectedResult) {
			System.out.println("Pass.");
		}
		else {
			System.out.println("Fail.");
		}
		//Test case #11, today's date
		Date date11 = new Date();
		System.out.println("Test case #11: Today's date is valid");
		result = date11.isValid();
		expectedResult = true;
		if (result == expectedResult) {
			System.out.println("Pass.");
		}
		else {
			System.out.println("Fail.");
		}
		//Test case #12, known valid date without leading zeros for day and month
		Date date12 = new Date("1/2/1903");
		System.out.println("Test case #12: 1/2/1903 is valid without leading zeros for month and day");
		result = date12.isValid();
		expectedResult = true;
		if (result == expectedResult) {
			System.out.println("Pass.");
		}
		else {
			System.out.println("Fail.");
		}
		//Test case #12, known valid date without leading zeros for day and month
		Date date13 = new Date("0001/00021/001953");
		System.out.println("Test case #13: Dates with excessive leading zeros can be valid");
		result = date13.isValid();
		expectedResult = true;
		if (result == expectedResult) {
			System.out.println("Pass.");
		}
		else {
			System.out.println("Fail.");
		}
	}
}

package project1;

/**
 * This class contains a constructor that instantiates a Timeslot object with the attributes consisting of
 * the date and time and the methods that access the attributes, compare Timeslot objects, and check if the timeslot
 * is valid.
 * @author Darrel Dsouza
 * @author Anton Derkach
 */
public class Timeslot implements Comparable<Timeslot> {
    private Date date;
    private Time time;

    /**
     * Instantiates a Timeslot object using a date and time as Strings.
     * @param date The date as a String.
     * @param time The time as a String.
     */
    public Timeslot(String date, String time) {
        this.date = new Date(date);
        this.time = new Time(time);
    }

    /**
     * Instantiates a Timeslot object with the current date and time.
     */
    public Timeslot() {
        this.date = new Date();
        this.time = new Time();
    }

    /**
     * Checks if two timeslots have the same date and time.
     * @param slot The timeslot to compare to.
     * @return True if the two timeslots have the same date and time and false otherwise.
     */
    public boolean equals(Timeslot slot) {
    	if (date.compareTo(slot.date) == Constant.EQUAL && time.compareTo(slot.time) == Constant.EQUAL) {
    		return true;
    	}
    	return false;
    }

    /**
     * Gets the date.
     * @return The date.
     */
    public Date getDate() {
    	return date;
    }

    /**
     * Gets the time.
     * @return The time.
     */
    public Time getTime() {
    	return time;
    }

    /**
     * Checks if the timeslot is valid.
     * @return True if the timeslot is valid and false otherwise.
     */
    public boolean isValid() {
        return date.isValid() && time.isValid();
    }


    /**
     * Converts the timeslot into a String.
     * @return The timeslot as a String.
     */
    @Override
    public String toString() {
        return date.toString() + ", " + time.toString();
    }

    /**
     * Compares two Timeslot objects.
     * @param slot The Timeslot object to compare to.
     * @return 1 if the instance object is greater than the other object, 0 if equal, and -1 if less.
     */
    @Override
    public int compareTo(Timeslot slot) {
        if (this.date.compareTo(slot.date) == Constant.GREATER) return Constant.GREATER;
        else if (this.date.compareTo(slot.date) == Constant.LESS) return Constant.LESS;
        else {
            if (this.time.compareTo(slot.time) == Constant.GREATER) return Constant.GREATER;
            else if (this.time.compareTo(slot.time) == Constant.LESS) return Constant.LESS;
            else return Constant.EQUAL;
        }
    }

    /**
     * Tests the Timeslot class.
     * @param args Not used. Here by default.
     */
    public static void main(String[] args) {
    	int expectedResult;
		int result;
		Timeslot timeslot1;
		Timeslot timeslot2;
		//Test case #1, timeslot 1 date is before timeslot 2
		timeslot1 = new Timeslot("2/27/2021", "1:45");
		timeslot2 = new Timeslot("3/2/2021", "9:15");
		System.out.println("Test case #1: If timeslot 1 date is before timeslot 2, return -1");
		result = timeslot1.compareTo(timeslot2);
		expectedResult = Constant.LESS;
		if (result == expectedResult) {
			System.out.println("Pass.");
		}
		else {
			System.out.println("Fail.");
		}

		//Test case #2, timeslot 1 date is after timeslot 2
		timeslot1 = new Timeslot("3/2/2021", "1:45");
		timeslot2 = new Timeslot("2/27/2021", "9:15");
		System.out.println("Test case #2: If timeslot 1 date is after timeslot 2, return 1");
		result = timeslot1.compareTo(timeslot2);
		expectedResult = Constant.GREATER;
		if (result == expectedResult) {
			System.out.println("Pass.");
		}
		else {
			System.out.println("Fail.");
		}
		
		//Test case #3, timeslots have same date, and timeslot 1 time is before timeslot 2
		timeslot1 = new Timeslot("3/2/2021", "1:45");
		timeslot2 = new Timeslot("3/2/2021", "2:15");
		System.out.println("Test case #3: If timeslots have same date, and timeslot 1 time is before timeslot 2, return -1");
		result = timeslot1.compareTo(timeslot2);
		expectedResult = Constant.LESS;
		if (result == expectedResult) {
			System.out.println("Pass.");
		}
		else {
			System.out.println("Fail.");
		}
		
		//Test case #4, timeslots have same date, and timeslot 1 time is after timeslot 2
		timeslot1 = new Timeslot("3/2/2021", "2:15");
		timeslot2 = new Timeslot("3/2/2021", "1:45");
		System.out.println("Test case #4: If timeslots have same date, and timeslot 1 time is after timeslot 2, return 1");
		result = timeslot1.compareTo(timeslot2);
		expectedResult = Constant.GREATER;
		if (result == expectedResult) {
			System.out.println("Pass.");
		}
		else {
			System.out.println("Fail.");
		}
		
		//Test case #5, timeslot 1 and 2 have same date and time
		timeslot1 = new Timeslot("3/2/2021", "2:15");
		timeslot2 = new Timeslot("3/2/2021", "2:15");
		System.out.println("Test case #5: If timeslot 1 and 2 have the same date and time, return 0");
		result = timeslot1.compareTo(timeslot2);
		expectedResult = Constant.EQUAL;
		if (result == expectedResult) {
			System.out.println("Pass.");
		}
		else {
			System.out.println("Fail.");
		}
    }
}

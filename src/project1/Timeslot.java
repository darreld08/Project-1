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
    	if(date.compareTo(slot.date) == Constant.EQUAL && time.compareTo(slot.time) == Constant.EQUAL) {
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
     * @param time The Timeslot object to compare to.
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
        Timeslot timeslot1 = new Timeslot("1/25/2022", "14:30");
        Timeslot timeslot2 = new Timeslot("2/20/2022", "9:15");
        Timeslot timeslot3 = new Timeslot("1/25/2022", "14:30");
        Timeslot timeslot4 = new Timeslot("1/25/2022", "16:30");
        Timeslot timeslot5 = new Timeslot("1/25/2022", "6:00");
        Timeslot timeslot6 = new Timeslot("2/30/2022", "9:15");
        Timeslot timeslot7 = new Timeslot("2/20/2022", "26:15");
        Timeslot timeslot8 = new Timeslot();

        System.out.println(timeslot1.isValid()); //checks if a valid timeslot is valid
        System.out.println(timeslot6.isValid()); //checks if a timeslot with an invalid date is valid
        System.out.println(timeslot7.isValid()); //checks if a timeslot with an invalid time is valid

        System.out.println(timeslot2.toString());
        System.out.println(timeslot8.toString());

        System.out.println(timeslot1.compareTo(timeslot2)); //should be less
        System.out.println(timeslot1.compareTo(timeslot3)); //should be equal
        System.out.println(timeslot4.compareTo(timeslot1)); //should be greater
        System.out.println(timeslot1.compareTo(timeslot5)); //should be greater
    }
}

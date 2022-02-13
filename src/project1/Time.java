package project1;

import java.util.Calendar;

/**
 * This class contains a constructor that instantiates a Time object with the attributes consisting of
 * the hour and minute and the methods that access the attributes, compare Time objects, and check if the time is valid.
 * @author Darrel Dsouza
 * @author Anton Derkach
 */
public class Time implements Comparable<Time> {
    private int hour;
    private int minute;

    /**
     * Instantiates a Schedule object using a String time input.
     * @param time The String time.
     */
    public Time(String time) {
        String[] timeInput = time.split(":");
        this.hour = Integer.parseInt(timeInput[0]);
        this.minute = Integer.parseInt(timeInput[1]);
    }

    /**
     * Instantiates a Schedule object using the current time.
     */
    public Time() {
        Calendar cal = Calendar.getInstance();
        this.hour = cal.get(Calendar.HOUR_OF_DAY);
        this.minute = cal.get(Calendar.MINUTE);
    }

    /**
     * Gets the hour.
     * @return returns the hour as an integer.
     */
    public int getHour() {
    	return hour;
    }

    /**
     * Gets the minute.
     * @return returns the minute as an integer.
     */
    public int getMinute() {
    	return minute;
    }

    /**
     * Checks if the hour is valid.
     * @return True if the hour is valid and false otherwise.
     */
    private boolean isHourValid() {
        if (this.hour > Constant.MAX_HOUR || this.hour < Constant.MIN_HOUR) return false;
        return true;
    }

    /**
     * Checks if the minute is valid.
     * @return True if the minute is valid and false otherwise.
     */
    private boolean isMinuteValid() {
        if (this.minute > Constant.MAX_MINUTE || this.minute < Constant.MIN_MINUTE) return false;
        return true;
    }

    /**
     * Checks if the time is valid.
     * @return True if the time is valid and false otherwise.
     */
    public boolean isValid() {
        if (isHourValid() && isMinuteValid()) return true;
        return false;
    }

    /**
     * Ensure that if the minute is less than 10, then the "0" in the front is not lost during the conversion to
     * a String.
     * @param minute The minute as an integer.
     * @return The minute as a String.
     */
    private String minuteChecker(int minute) {
        if (minute == Constant.MIN_MINUTE) return "00";
        if (minute < Constant.NUMBER_BASE) return "0" + minute;

        return Integer.toString(minute);
    }

    /**
     * Converts the time into a String.
     * @return The time as a String.
     */
    @Override
    public String toString() {
        return hour + ":" + minuteChecker(minute);
    }

    /**
     * Compares two Time objects.
     * @param time The Time object to compare to.
     * @return 1 if the instance object is greater than the other object, 0 if equal, and -1 if less.
     */
    @Override
    public int compareTo(Time time) {
        if (this.hour > time.hour) return Constant.GREATER;
        else if (this.hour < time.hour) return Constant.LESS;
        else {
            if (this.minute > time.minute) return Constant.GREATER;
            else if (this.minute < time.minute) return Constant.LESS;
            else return Constant.EQUAL;
        }
    }
}
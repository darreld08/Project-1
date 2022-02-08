package project1;

import java.util.Calendar;

public class Time implements Comparable<Time> {
    private int hour;
    private int minute;

    public Time(String time) {
        String[] timeInput = time.split(":");
        this.hour = Integer.parseInt(timeInput[0]);
        this.minute = Integer.parseInt(timeInput[1]);
    }

    public Time() {
        Calendar cal = Calendar.getInstance();
        this.hour = cal.get(Calendar.HOUR_OF_DAY);
        this.minute = cal.get(Calendar.MINUTE);
    }

    private boolean isHourValid() {
        if (this.hour > Constant.MAX_HOUR || this.hour < Constant.MIN_HOUR) return false;
        return true;
    }

    private boolean isMinuteValid() {
        if (this.minute > Constant.MAX_MINUTE || this.minute < Constant.MIN_MINUTE) return false;
        return true;
    }

    public boolean isValid() {
        if (isHourValid() && isMinuteValid()) return true;
        return false;
    }

    @Override
    public String toString() {
        return hour + ":" + minute;
    }

    @Override
    public int compareTo(Time time) {
        if (this.hour > time.hour) return 1;
        else if (this.hour < time.hour) return -1;
        else {
            if (this.minute > time.minute) return 1;
            else if (this.minute < time.minute) return -1;
            else return 0;
        }
    }

    public static void main(String[] args) {
        Time time1 = new Time("9:15");
        Time time2 = new Time("14:45");
        Time time3 = new Time("29:45");
        Time time4 = new Time("22:64");
        Time time5 = new Time("9:15");
        Time time6 = new Time();
        System.out.println("Time 1: The hour is " + time1.hour + " and the minute is " + time1.minute);
        System.out.println("Time 6: The hour is " + time1.hour + " and the minute is " + time1.minute);
        System.out.println(time1.isValid());
        System.out.println(time3.isValid());
        System.out.println(time4.isValid());
        System.out.println(time1.compareTo(time2));
        System.out.println(time1.compareTo(time5));
        System.out.println(time6.compareTo(time1));
    }
}
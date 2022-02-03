package project1;

import java.util.Calendar;

public class Date implements Comparable <Date> {
	private int year;
	private int month;
	private int day;
	
	public Date (String date) {
		day = Integer.parseInt(date.substring(0,2));
		month = Integer.parseInt(date.substring(3,5));
		year = Integer.parseInt(date.substring(6));
		
	}
	
	public Date() {
		Calendar cal = Calendar.getInstance();
		day = cal.get(cal.DAY_OF_MONTH);
		month = cal.get(cal.MONTH);
		year = cal.get(cal.YEAR);
	}
	
	public boolean isValid() {
		return true;
	}
	
	@Override
	public int compareTo(Date date) {
		return -1;
	}
	
	public static void main(String[] args) {
		Date date = new Date();
	}
}

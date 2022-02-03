package project1;

import java.util.Calendar;

public class Date implements Comparable <Date> {
	private int year;
	private int month;
	private int day;
	
	public Date (String date) {
		month = Integer.parseInt(date.substring(0,2));
		day = Integer.parseInt(date.substring(3,5));
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
		int a=Integer.parseInt(Integer.toString(this.year)+Integer.toString(this.month)+Integer.toString(this.day));
		int b=Integer.parseInt(Integer.toString(date.year)+Integer.toString(date.month)+Integer.toString(date.day));
		if(a>b) {
			return 1;
		}
		if(a<b) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		Date date1 = new Date("02/31/0001");
		Date date2 = new Date("02/01/0001");
		System.out.println(date1.compareTo(date2));
	}
}

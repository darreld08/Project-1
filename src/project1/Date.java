package project1;

import java.util.Calendar;

public class Date implements Comparable <Date> {
	private int year;
	private int month;
	private int day;
	
	public Date (String date) {
		String[] dateInput = date.split("/");
		month = Integer.parseInt(dateInput[0]);
		day = Integer.parseInt(dateInput[1]);
		year = Integer.parseInt(dateInput[2]);
		
	}
	
	public Date() {
		Calendar cal = Calendar.getInstance();
		day = cal.get(Calendar.DAY_OF_MONTH);
		month = cal.get(Calendar.MONTH);
		year = cal.get(Calendar.YEAR);
	}
	
	private boolean yearValid() {
		if(year<Constant.MIN_YEAR) { //checks if year outside bounds
			return false;
		}
		return true;
	}
	
	private boolean monthValid() {
		if(month<Constant.MIN_MONTH || month>Constant.MAX_MONTH) { //checks if month outside bounds
			return false;
		}
		return true;
	}
	
	private boolean dayValid() {
		if(month==Constant.FEB) { //check if month is february
			if(isLeap()) { //if leap, check if day outside 1-29
				if(day<Constant.MIN_DAY || day>Constant.LEAP_DAY) {
					return false;
				}
			}
			else { //if not leap, check if day outside 1-28
				if(day<Constant.MIN_DAY || day>Constant.FEB_DAY) {
					return false;
				}
			}
		}
		//if a month with 31 days, check if days outside 1 and 31 (MAX_DAY1)
		else if(month==Constant.JAN || month==Constant.MAR || month==Constant.MAY || month==Constant.JUL || month==Constant.AUG || month==Constant.OCT || month==Constant.DEC) {
			if(day<Constant.MIN_DAY || day>Constant.MAX_DAY1) {
				return false;
			}
		}
		//if a remaining month (30 days), check if days outside 1 and 30 (MAX_DAY2)
		else {
			if(day<Constant.MIN_DAY || day>Constant.MAX_DAY2) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isValid() {
		if(yearValid() && monthValid() && dayValid()) {
			return true;
		}
		return false;
	}
	
	private boolean isLeap() {
		if(year%Constant.QUADRENNIAL==0) {
			if(year%Constant.CENTENNIAL==0) {
				if(year%Constant.QUARTERCENTENNIAL==0) {
					return true;
				}
				else {
					return false;
				}	
			}
			else {
				return true;
			}
		}
		else {
			return false;
		}
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
		Date date1 = new Date("02/01/0001");
		Date date2 = new Date("02/01/0001");
		System.out.println(date1.day + " " + date1.month + " " +date1.year);
		System.out.println(date1.compareTo(date2));
		System.out.println(date1.isValid());
	}
}

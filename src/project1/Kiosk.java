package project1;

import java.util.Scanner;

public class Kiosk {
	private Schedule sch = new Schedule();
	private Scanner scan = new Scanner(System.in);
	private String detail;
	private String command;
	private Appointment appt;
	private Date dob;
	private Date apptDate;
	private Time apptTime;
	private Date today;
	
	public Kiosk() {
		
	}
	
	private void initializeTempAppt(String input) {
		appt = new Appointment(input);
		dob = appt.getPatient().getDOB();
		apptDate = appt.getSlot().getDate();
		apptTime = appt.getSlot().getTime();
		today = new Date();
	}
	
	private boolean isValidInput() {
		if(!dob.isValid()) { //checks if dob not valid calendar date
			System.out.println("Invalid date of birth!");
		}
		else if(!apptDate.isValid() || apptDate.getYear() > today.getYear()) { //checks if appt date valid or after this year
			System.out.println("Invalid appointment date!");
		}
		else if(dob.compareTo(today) >= 0) { //checks if dob today or future
			System.out.println("Date of birth invalid --> it is a future date");
		}
		else if(apptDate.compareTo(today) <= 0) { //checks if appointment date today or day before today
			System.out.println("Appointment date invalid --> must be a future date");
		}
		else if(apptTime.getMinute() % Constant.TIMESLOT_INCREMENT != 0 || apptTime.getHour() < Constant.TIMESLOT_MIN_HOUR || apptTime.getHour() > Constant.TIMESLOT_MAX_HOUR) { //checks if appointment time not at a 15 min interval or outside daily appointment range
			System.out.println("Invalid appointment Time! Must enter a time between 9:00 and 16:45 with a 15-minute interval");
		}
		else if(appt.getLocation()==null) { //checks if county name not valid
			System.out.println("Invalid location!");
		}
		else if(sch.existsInSchedule(appt)) { //checks if appointment with same patient, timeslot, and location already in schedule
			System.out.println("Same appointment exists in schedule.");
		}
		else if(sch.timeSlotTaken(appt)) { //checks if timeslot already taken
			System.out.println("Time slot has been taken at this location.");
		}
		else if(sch.doubleAppt(appt)) { //checks if same patient name and date same, but different location with existing appointment
			System.out.println("Same patient cannot book an appointment with the same date.");
		}
		else return true;
		return false;
	}
	
	private String[] copyPartialArray(String[] arr, int startIndex) {
		String[] copiedArray = new String[arr.length - startIndex];
		for(int i = startIndex; i < arr.length; i++) {
			copiedArray[i-startIndex] = arr[i];
		}
		return copiedArray;
	}
	
	private void formatInput() {
		String thisLine;
		String[] splitThisLine;
		thisLine = scan.nextLine();
		splitThisLine = thisLine.split(" ");
		command = splitThisLine[0];
		detail = String.join(" ",copyPartialArray(splitThisLine, 1));
	}
	
	private void C() {
		if(sch.remove(appt)) {
			System.out.println("Appointment cancelled");
		}
		else {
			System.out.println("Not cancelled, appointment does not exist.");
		}
	}
	
	private void CP() {
		sch.removePatient(appt); //command == CP
		System.out.println("All appointments for " + appt.getPatient().toString() + " have been cancelled.");
	}
	
	private void B() {
		sch.add(appt);
		System.out.println("Appointment booked and added to the schedule.");
	}
	
	public void run() {
		System.out.println("Kiosk running. Ready to process transactions");
		boolean firstLine = true;
		while(scan.hasNextLine()) {
			if(firstLine) System.out.println();
			firstLine = false;
			formatInput();
			if(command.equals("Q")) break;
			else if(command.equals("P")) {
				sch.print();
			}
			else if(command.equals("PZ")) {
				sch.printByZip();
			}
			else if(command.equals("PP")) {
				sch.printByPatient();
			}
			else if(command.equals("B") || command.equals("C") || command.equals("CP" )) {
				initializeTempAppt(detail);
				if(command.equals("C")) {
					C();
				}
				else if(command.equals("CP")) {
					CP();
				}
				else if(isValidInput()) {
					if(command.equals("B")) {
						B();
					}
				}
			}
			else System.out.println("Invalid command!");
		}
		scan.close();
		System.out.println("Kiosk session ended.");
	}
}

package project1;
import java.util.Scanner;

public class Kiosk {
	private Schedule sch = new Schedule();
	
	public Kiosk() {
		
	}
	
	private boolean isValidInput(String input) {
		//checks if date not valid calendar date
		Appointment appt = new Appointment(input);
		Date dob = appt.getPatient().getDOB();
		Date apptDate = appt.getSlot().getDate();
		Time apptTime = appt.getSlot().getTime();
		Date today = new Date();
		String error = "";
		if(!dob.isValid()) {
			error+="Invalid date of birth!";
		}
		else if(!apptDate.isValid()) {
			error+="Invalid appointment date!";
		}
		//checks if dob today or future
		if(dob.compareTo(today) >= 0) {
			error+="Date of birth invalid --> it is a future date";
		}
		//checks if appointment date today, day before today, or after this year
		if(apptDate.compareTo(today) <= 0 || apptDate.getYear() > today.getYear()) {
			error+="Appointment date invalid --> must be a future date";
		}
		//checks if appointment time not at a 15 min interval or outside daily appointment range
		if(apptTime.getMinute() % 15 != 0 || apptTime.getHour() < 9 || apptTime.getHour() > 16) {
			error+="Invalid Appointment Time! Must enter a time between 9:00 and 16:45 with a 15-minute interval";
		}
		//checks if county name not valid
		if(appt.getLocation()==null) {
			error+="Invalid Location!";
		}
		//checks if appointment with same patient, timeslot, and location already in schedule
		if(sch.existsInSchedule(appt)) {
			error+="Same appointment exists in schedule.";
		}
		//checks if timeslot already taken
		if(sch.timeSlotTaken(appt)) {
			error+="Time slot has been taken at this location.";
		}
		//checks if same patient name and date same, but different location with existing appointment
		if(sch.doubleAppt(appt)) {
			error+="Same patient cannot book an appointment with the same date.";
		}
		if(error.equals("")) {
			return true;
		}
		else {
			System.out.println(error);
			return false;
		}
	}
	
	private void continuousInput() {
		Scanner scan = new Scanner(System.in);
		String thisLine;
		String command;
		String detail;
		String output = "";
		
		while(scan.hasNextLine()) {
			thisLine = scan.nextLine();
			command = thisLine.substring(0,1);
			detail = thisLine.substring(2);
			if(command.equals("Q")) {
				break;
			}
			if(command.equals("P")) {
				sch.print();
			}
			
			if(command.equals("PZ")) {
				sch.printByZip();;
			}
			
			if(command.equals("PP")) {
				sch.printByPatient();
			}
			if(command.equals("B") || command.equals("C") || command.equals("CP" )) {
				Appointment appt = new Appointment(detail);
				if(isValidInput(detail)) {
					
					if(command.equals("B")) {
						sch.add(appt);
						System.out.println("Appointment booked and added to the schedule.");
					}
					
					if(command.equals("C")) {
						if(sch.remove(appt)) {
							System.out.println("Appointment cancelled");
						}
						else {
							System.out.println("Not cancelled, appointment does not exist.");
						}
					}
					
					if(command.equals("CP")) {
						sch.removePatient(appt);
					}
				}
			}
		}
		scan.close();
	}
	public void run() {
		System.out.println("Kiosk running. Ready to process transactions");
		continuousInput();
		System.out.println("Kiosk Session Ended.");
	}
	
	public static void main(String[] args) {
		Kiosk kiosk = new Kiosk();
		kiosk.run();
	}
}

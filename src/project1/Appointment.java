package project1;

public class Appointment {
	private Patient patient;
	private Timeslot slot;
	private Location location;
	
	public Appointment(String input) {
		String[] splitInput = input.split(" ");
		patient = new Patient(splitInput[Constant.NAME_INDEX], splitInput[Constant.DOB_INDEX]);
		slot = new Timeslot(splitInput[Constant.APPT_DATE_INDEX], splitInput[Constant.APPT_TIME_INDEX]);
		location = Location
	}
	@Override
	public boolean equals(Object obj) {
		
	}
	
	@Override
	public String toString() {
		
	}
}

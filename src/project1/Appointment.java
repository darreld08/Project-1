package project1;

public class Appointment {
	private Patient patient;
	private Timeslot slot;
	private Location location;
	
	public Appointment(String input) {
		try {
			String[] splitInput = input.split(" ");
			String patientName = splitInput[Constant.FNAME_INDEX] + " " + splitInput[Constant.LNAME_INDEX];
			patient = new Patient(patientName, splitInput[Constant.DOB_INDEX]);
			slot = new Timeslot(splitInput[Constant.APPT_DATE_INDEX], splitInput[Constant.APPT_TIME_INDEX]);
			location = Location.getEnumFromString(splitInput[Constant.COUNTY_INDEX]);
		}
		catch (Exception e) {
			String[] splitInput = input.split(" ");
			String patientName = splitInput[Constant.FNAME_INDEX] + " " + splitInput[Constant.LNAME_INDEX];
			patient = new Patient(patientName, splitInput[Constant.DOB_INDEX]);
			slot = new Timeslot("12/31/2022", "16:45"); //choose placeholder timeslot when not included in command, ex. for CP
			location = Location.SOMERSET; //choose placeholder location when not included in command
		}
	}

	public Location getLocation() {
		return location;
	}

	public Timeslot getSlot() {
		return slot;
	}

	public Patient getPatient() {
		return patient;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Appointment) {
			Appointment other = (Appointment) obj;
			if(this.patient.compareTo(other.patient) == Constant.EQUAL) {
				if(this.slot.compareTo(other.slot) == Constant.EQUAL) {
					if(this.location.name().equals(other.location.name())) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return patient.toString() + ", Appointment Detail: " + slot.toString() + ", " + location.toString();
	}
	
	public static void main (String[] args) {
		Appointment appt1 = new Appointment("1/19/2000 Jane Doe 12/1/2022 9:45 union");
		Appointment appt2 = new Appointment("11/31/1999 John Doe 3/31/2022 9:45 SOMERSET");
		Appointment appt3 = new Appointment("1/19/2000 Jane Doe 12/1/2022 9:45 UNION");
		System.out.println(appt1.equals(appt2));
		System.out.println(appt1.toString());
		
	}
}

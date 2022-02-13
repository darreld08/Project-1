package project1;

/**
 * This class contains a constructor and methods that enable to create an Appointment object
 * with the attributes "Patient", "Timeslot", and "location, and get the attributes and compare
 * Appointment objects
 *
 * @author Darrel Dsouza
 * @author Anton Derkach
 */

public class Appointment {
	private Patient patient;
	private Timeslot slot;
	private Location location;

	/**
	 * Appointment Constructor
	 * @param input The String containing the patient's DOB, first name, last name, the date, the time, and the county
	 */
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

	/**
	 * Gets the location of the appointment
	 * @return The location of the instance object
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Gets the timeslot of the appointment
	 * @return The timeslot of the instance object
	 */
	public Timeslot getSlot() {
		return slot;
	}

	/**
	 * Gets the patient's name and DOB
	 * @return The patient of the instance object
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * Checks if the instance object and another object have the same patient, slot, and location
	 * @param obj The object to compare the instance object to
	 * @return true if the objects are equal (same instance attributes)
	 */
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

	/**
	 * Converts the object into a String consisting of the patient's information, slot, and location
	 * @return The String representation of the instance object
	 */
	@Override
	public String toString() {
		return patient.toString() + ", Appointment Detail: " + slot.toString() + ", " + location.toString();
	}
}

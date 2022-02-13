package project1;

/**
 * This class contains a constructor that instantiates a Schedule object with the attributes consisting of
 * the array of Appointment objects and the number of appointments and the methods that manage the schedule of
 * appointments.
 * @author Darrel Dsouza
 * @author Anton Derkach
 */
public class Schedule {
	private Appointment[] appointments;
	private int numAppts;

	/**
	 * Instantiates a Schedule object using the default schedule length of 4 for the number of appointments in the new
	 * array.
	 */
	public Schedule() {
		appointments = new Appointment[Constant.DEFAULT_SCHEDULE_LENGTH];
	}

	/**
	 * Checks if a particular appointment exists in the schedule.
	 * @param appt The Appointment object to be verified to exist in the schedule.
	 * @return True if the appointment exists in the schedule.
	 */
	public boolean existsInSchedule(Appointment appt) {
		if (find(appt)==Constant.NOT_FOUND) {
			return false;
		}
		return true;
	}

	/**
	 * Checks if a particular timeslot is taken.
	 * @param appt The Appointment object that has a timeslot that needs to be verified to be taken.
	 * @return True if the timeslot is taken.
	 */
	public boolean timeSlotTaken(Appointment appt) {
		Timeslot slot = appt.getSlot();
		for (int i = 0; i < numAppts; i++) {
			if (slot.equals(appointments[i].getSlot()) && appt.getLocation().equals(appointments[i].getLocation())) {
				//checks if timeslots are same and location are same
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the there already is an appointment with the same patient and time in the schedule.
	 * @param appt The Appointment object for which we want to see if there exists an appointment with the same
	 *             patient and time in the schedule.
	 * @return True if there already is an appointment with the same patient and time in the schedule and
	 * false otherwise.
	 */
	public boolean doubleAppt(Appointment appt) {
		for (int i = 0; i < numAppts; i++) {
			if (appointments[i].getPatient().compareTo(appt.getPatient()) == Constant.EQUAL) { //patients are equal
				if (appointments[i].getSlot().getDate().compareTo(appt.getSlot().getDate()) == Constant.EQUAL) {
					//same date
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Finds an appointment in the schedule and returns its index if such an appointment exists. Returns -1 if the
	 * appointment is not found.
	 * @param appt The Appointment object to be found.
	 * @return The integer Appointment array index if the appointment is found and -1 if the appointment is not found.
	 */
	private int find(Appointment appt) { //returns the index, or NOT_FOUND = -1
		for (int i = 0; i < numAppts; i++) {
			if (appointments[i].equals(appt)) {
				return i;
			}
		}
		return Constant.NOT_FOUND;
	}

	/**
	 * Increases the array of appointments by 4.
	 */
	private void grow() { //increase the capacity of the container by 4
		Appointment[] newAppointments = new Appointment[appointments.length + Constant.SCHEDULE_GROW_AMT];
		for (int i = 0; i < numAppts; i++) {
			newAppointments[i] = appointments[i]; //copy elements of appointments to newAppointments
		}
		appointments = newAppointments; //overwrite appointments with newAppointments
	}

	/**
	 * Adds an appointment to the array of appointments.
	 * @param appt The appointment to be added.
	 * @return True.
	 */
	public boolean add(Appointment appt) { //add appointment to array
		appointments[numAppts++] = appt;
		if (numAppts == appointments.length) {
			grow();
		}
		return true;
	}

	/**
	 * Removes a particular appointment.
	 * @param appt The appointment to be removed.
	 * @return True if the appointment is found and removed and false if not found.
	 */
	public boolean remove(Appointment appt) { //remove appointment from array, maintains array order
		int removeIndex = find(appt);
		if (removeIndex != Constant.NOT_FOUND) {
			for (int i = removeIndex; i < numAppts - 1; i++) {
				appointments[i] = appointments[i + 1]; //shift all elements left by 1
			}
			numAppts -= 1;
			appointments[numAppts] = null; //deletes repeated element in last slot
			return true;
		}
		return false; 
	}

	/**
	 * Removes all the appointments of a particular patient.
	 * @param appt The appointment that has the name of the patient whose all appointments are to be removed.
	 * @return True if at least one appointment of a particular patient is found and removed and false otherwise.
	 */
	public boolean removePatient(Appointment appt) {
		int i = 0;
		boolean removedPatient = false;
		while (i < numAppts) {
			if (appointments[i].getPatient().compareTo(appt.getPatient()) == Constant.EQUAL) { //patients are same
				remove(appointments[i]);
				removedPatient = true;
				continue;
			}
			i++;
		}
		return removedPatient;
	}

	/**
	 * Swaps two appointments in the array of appointments.
	 * @param i The index of the first appointment to be swapped.
	 * @param j The index of the second appointment to be swapped.
	 */
	private void swap(int i, int j) {
		Appointment temp = appointments[i];
		appointments[i] = appointments[j];
		appointments[j] = temp;
	}

	/**
	 * Sorts the array of appointments either by the zipcodes or the patients.
	 * @param sortingMethod The sorting method (Zipcode or patient).
	 */
	private void sort(int sortingMethod) {
		int n = numAppts;
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0; j--) {
				if (sortingMethod == Constant.SORT_BY_ZIPCODE) {
					int zipcode1 = Integer.parseInt(appointments[j - 1].getLocation().getZipCode());
					int zipcode2 = Integer.parseInt(appointments[j].getLocation().getZipCode());
					if (zipcode1 > zipcode2) swap(j - 1, j);
					else if (zipcode1 == zipcode2) {
						Timeslot slot1 = appointments[j - 1].getSlot();
						Timeslot slot2 = appointments[j].getSlot();
						if (slot1.compareTo(slot2) == Constant.GREATER) swap(j - 1, j);
						else break;
					} else break;
				} else {
					Patient patient1 = appointments[j - 1].getPatient();
					Patient patient2 = appointments[j].getPatient();
					if (patient1.compareTo(patient2) == Constant.GREATER) swap(j - 1, j);
					else break;
				}
			}
		}
	}

	/**
	 * Prints the appointments in the current order in the array.
	 */
	public void print() { //print all appointments in current order
		System.out.println("\n*list of appointments in schedule*");
		for (int i = 0; i < numAppts; i++) {
			System.out.println(appointments[i].toString());
		}
		System.out.println("*end of schedule*\n");
	}

	/**
	 * Prints the appointments in the ascending order of the zipcodes.
	 */
	public void printByZip() { //
		System.out.println("\n*list of appointments by zip and timeslot*");
		sort(Constant.SORT_BY_ZIPCODE);
		for (int i = 0; i < numAppts; i++) {
			System.out.println(appointments[i].toString());
		}
		System.out.println("*end of schedule*\n");
	}

	/**
	 * Prints the appointments in the ascending order of the patients.
	 */
	public void printByPatient() {
		System.out.println("\n*list of appointments by patient*");
		sort(Constant.SORT_BY_PATIENT);
		for (int i = 0; i < numAppts; i++) {
			System.out.println(appointments[i].toString());
		}
		System.out.println("*end of schedule*\n");
	}
}

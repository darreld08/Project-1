package project1;

public class Schedule {
	private Appointment[] appointments;
	private int numAppts;
	
	public Schedule() {
		appointments = new Appointment[Constant.DEFAULT_SCHEDULE_LENGTH];
	}
	
	public boolean existsInSchedule(Appointment appt) {
		if(find(appt)==Constant.NOT_FOUND) {
			return false;
		}
		return true;
	}
	
	public boolean timeSlotTaken(Appointment appt) {
		Timeslot slot = appt.getSlot();
		for(int i = 0; i < numAppts; i++) {
			if(slot.equals(appointments[i].getSlot()) && appt.getLocation().equals(appointments[i].getLocation())) { //checks if timeslots are same and location are same
				return true;
			}
		}
		return false;
	}
	
	public boolean doubleAppt(Appointment appt) {
		for(int i = 0; i < numAppts; i++) {
			if(appointments[i].getPatient().compareTo(appt.getPatient()) == 0) { //patients are equal
				if(appointments[i].getSlot().getDate().compareTo(appt.getSlot().getDate()) == 0) { //same date
					return true;
				}
			}
		}
		return false;
	}
	
	private int find(Appointment appt) { //returns the index, or NOT_FOUND = -1
		for(int i = 0; i < numAppts; i++) {
			if(appointments[i].equals(appt)) {
				return i;
			}
		}
		return Constant.NOT_FOUND;
	}
	
	private void grow() { //increase the capacity of the container by 4
		Appointment[] newAppointments = new Appointment[appointments.length + Constant.SCHEDULE_GROW_AMT];
		for (int i = 0; i < numAppts; i++) {
			newAppointments[i] = appointments[i]; //copy elements of appointments to newAppointments
		}
		appointments = newAppointments; //overwrite appointments with newAppointments
	}
	
	public boolean add(Appointment appt) { //add appointment to array
		appointments[numAppts++] = appt;
		if (numAppts == appointments.length) {
			grow();
		}
		return true;
	}
	
	public boolean remove(Appointment appt) { //remove appointment from array, maintains array order
		int removeIndex = find(appt);
		if (removeIndex != Constant.NOT_FOUND) {
			for (int i = removeIndex; i < numAppts - 1; i++) { //Changed from numAppts to numAppts - 1 to avoid outofbounds error on the next line
				appointments[i] = appointments[i + 1]; //shift all elements left by 1
			}
			numAppts -= 1;
			appointments[numAppts] = null; //deletes repeated element in last slot
			//Changed from numAppts to numAppts - 1 since the last appointment is at index numAppts because the array starts at index 0
			return true;
		}
		return false; 
	}
	
	public boolean removePatient(Appointment appt) {
		int i = 0;
		boolean removedPatient = false;
		while(i < numAppts) {
			if(appointments[i].getPatient().compareTo(appt.getPatient()) == 0) { //patients are same
				remove(appointments[i]);
				removedPatient = true;
				continue;
			}
			i++;
		}
		return removedPatient;
	}

	private void swap(int i, int j) {
		Appointment temp = appointments[i];
		appointments[i] = appointments[j];
		appointments[j] = temp;
	}

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
	
	public void print() { //print all appointments in current order
		System.out.println("\n*list of appointments in schedule*");
		for (int i = 0; i < numAppts; i++) {
			System.out.println(appointments[i].toString());
		}
		System.out.println("*end of schedule*\n");
	}
	
	public void printByZip() { //
		System.out.println("\n*list of appointments by zip and timeslot*");
		sort(Constant.SORT_BY_ZIPCODE);
		for (int i = 0; i < numAppts; i++) {
			System.out.println(appointments[i].toString());
		}
		System.out.println("*end of schedule*\n");
	}
	
	public void printByPatient() {
		System.out.println("\n*list of appointments by patient*");
		sort(Constant.SORT_BY_PATIENT);
		for (int i = 0; i < numAppts; i++) {
			System.out.println(appointments[i].toString());
		}
		System.out.println("*end of schedule*\n");
	}
		
		
}

package project1;

public class Schedule {
	private Appointment[] appointments;
	private int numAppts;
	
	public Schedule() {
		appointments = new Appointment[Constant.DEFAULT_SCHEDULE_LENGTH];
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
			appointments[numAppts - 1] = null; //deletes repeated element in last slot
			//Changed from numAppts to numAppts - 1 since the last appointment is at index numAppts because the array starts at index 0
			return true;
		}
		return false; 
	}
	
	public void print() { //print all appointments in current order
		for (int i = 0; i < numAppts; i++) {
			System.out.println(appointments[i].toString());
		}
	}
	
	public void printByZip() { //
		
	}
	
	public void printByPatient() {
		
	}
		
		
}

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
		Appointment[] newAppointments = new Appointment[appointments.length+Constant.SCHEDULE_GROW_AMT];
		for(int i = 0; i < numAppts; i++) {
			newAppointments[i] = appointments[i]; //copy elements of appointments to newAppointments
		}
		appointments = newAppointments; //overwrite appointments with newAppointments
	}
	
	public boolean add(Appointment appt) { //add appointment to array
		appointments[numAppts++] = appt;
		if(numAppts == appointments.length) {
			grow();
		}
		return true;
	}
	
	public boolean remove(Appointment appt) { //remove appointment from array, maintains array order
		int removeIndex = find(appt);
		if(removeIndex != -1) {
			for (int i = removeIndex; i < numAppts; i++) {
				appointments[i] = appointments[i + 1]; //shift all elements left by 1
			}
			numAppts--;
			appointments[numAppts] = null; //deletes repeated element in last slot
			return true;
		}
		return false; 
	}
	
	public void print() { //print all appointments in current order
		
	}
	
	public void printByZip() { //
		
	}
	
	public void printByPatient() {
		
	}
		
		
}

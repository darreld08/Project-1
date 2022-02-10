package project1;

public class Patient implements Comparable<Patient> {
	private String fname;
	private String lname;
	private Date dob;
	
	public Patient(String name, String dob) {
		String[] splitName = name.split(" ");
		fname = splitName[0];
		lname = splitName[1];
		this.dob = new Date(dob);
	}
	@Override
	public String toString() {
		return fname + " " + lname + ", DOB: " + dob.toString();
	}
	
	@Override
	public int compareTo(Patient patient) {
		if(lname.compareTo(patient.lname) < 0) {
			return -1;
		}
		else if(lname.compareTo(patient.lname) > 0) {
			return 1;
		}
		else {
			if(fname.compareTo(patient.fname) < 0) {
				return -1;
			}
			else if (fname.compareTo(patient.fname) > 0) {
				return 1;
			}
			else {
				return dob.compareTo(patient.dob);
			}
		}
	}
	
	public static void main (String[] args) {
		Patient patient1 = new Patient("John Doe", "02/26/1966");
		Patient patient2 = new Patient("George Smith", "2/26/2025");
		Patient patient3 = new Patient("Jane Doe", "02/26/1966");
		Patient patient4 = new Patient("John Doe", "03/26/1966");
		Patient patient5 = new Patient("John Doe", "02/26/1966");
		Patient patient6 = new Patient("John Joe", "02/26/1966");
		System.out.println("patient1.toString(): " + patient1.toString());
		System.out.println("patient2.toString(): " + patient2.toString());
		System.out.println("patient3.toString(): " + patient3.toString());
		System.out.println("patient4.toString(): " + patient4.toString());
		System.out.println("patient5.toString(): " + patient5.toString());
		System.out.println("patient6.toString(): " + patient6.toString());
		System.out.println("Compare patient 1 to patient 2: " + patient1.compareTo(patient2));
		System.out.println("Compare patient 1 to patient 3: " + patient1.compareTo(patient3));
		System.out.println("Compare patient 1 to patient 4: " + patient1.compareTo(patient4));
		System.out.println("Compare patient 1 to patient 5: " + patient1.compareTo(patient5));
		System.out.println("Compare patient 1 to patient 6: " + patient1.compareTo(patient6));
		
	}
}

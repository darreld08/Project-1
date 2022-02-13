package project1;

/**
 * This class contains a constructor that instantiates a Patient object with the attributes consisting of
 * the first name, last name, and DOB and the methods that get the instance attributes, compare objects, and
 * convert the object into a String.
 * @author Darrel Dsouza
 * @author Anton Derkach
 */
public class Patient implements Comparable<Patient> {
	private String fname;
	private String lname;
	private Date dob;

	/**
	 * Instantiates a Patient object with a String name and DOB given as the input.
	 * @param name The patient's name as a String
	 * @param dob The patient's DOB as a String
	 */
	public Patient(String name, String dob) {
		String[] splitName = name.split(" ");
		fname = splitName[0];
		lname = splitName[1];
		this.dob = new Date(dob);
	}

	/**
	 * Accesses the DOB
	 * @return The DOB as a date object
	 */
	public Date getDOB() {
		return dob;
	}

	/**
	 * Converts the object into a String.
	 * @return The String consisting of the first name, last name, and the DOB.
	 */
	@Override
	public String toString() {
		return fname + " " + lname + ", DOB: " + dob.toString();
	}

	/**
	 * Compares the object to another object. First compares the last name, then first name, then the DOB.
	 * @param patient The other patient object to compare to.
	 * @return The integer 1 if the instance object is greater than the other object, -1 if less, and 0 if equal.
	 */
	@Override
	public int compareTo(Patient patient) {
		if(lname.compareTo(patient.lname) < Constant.EQUAL) {
			return Constant.LESS;
		}
		else if(lname.compareTo(patient.lname) > Constant.EQUAL) {
			return Constant.GREATER;
		}
		else {
			if(fname.compareTo(patient.fname) < Constant.EQUAL) {
				return Constant.LESS;
			}
			else if (fname.compareTo(patient.fname) > Constant.EQUAL) {
				return Constant.GREATER;
			}
			else {
				return dob.compareTo(patient.dob);
			}
		}
	}

	/**
	 * Tests the Patient class constructor and methods.
	 * @param args Not used. Here by default.
	 */
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

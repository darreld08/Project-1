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
}

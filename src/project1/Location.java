package project1;

/**
 * This class contains a fixed set of possible locations with the instance attributes consisting of zipCode and
 * cityName and methods that retrieve these attributes and compare Location objects.
 *
 * @author Darrel Dsouza
 * @author Anton Derkach
 */
public enum Location {
	SOMERSET 	("08807", "Bridgewater"), 
	MIDDLESEX 	("08854", "Piscataway"),
	MERCER 		("08542", "Princeton"),
	MORRIS 		("07960", "Morristown"), 
	UNION 		("07083", "Union");
	
	private final String zipCode;
	private final String cityName;

	/**
	 * Instantiates a Location object
	 * @param zipCode The String containing the zipcode
	 * @param cityName The String containing the city name
	 */
	Location(String zipCode, String cityName) {
		this.zipCode = zipCode;
		this.cityName = cityName;
	}

	/**
	 * Compares this Location object with another Location object to check if they have the county name.
	 * @param loc The location object to compare with.
	 * @return True if the locations have the same county name.
	 */
	public boolean equals(Location loc) {
		if (this.name().equals(loc.name())) {
			return true;
		}
		return false;
	}

	/**
	 * Accesses the zipcode of the instance object.
	 * @return The String representation of the zipcode.
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * Converts the location into a String consisting of the city name, zipcode, and county name.
	 * @return The String representation of the location object consisting of the city name, zipcode, and county name.
	 */
	@Override
	public String toString() {
		return cityName + " " + zipCode + ", " + this.name();
	}

	/**
	 * Uses the String location input to access the enum location object with the input county name
	 * if the input name exists.
	 * Returns null if the given county name is not in the set of predefined county names.
	 * @param location The String county name
	 * @return The enum Location  object.
	 */
	public static Location getEnumFromString(String location) {
		for (Location loc: Location.values()) {
			if (loc.name().equals(location.toUpperCase())) {
				return loc;
			}
		}
		return null;
	}
}

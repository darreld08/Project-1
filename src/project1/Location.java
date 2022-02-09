package project1;

public enum Location {
	SOMERSET 	("08807", "Bridgewater"), 
	MIDDLESEX 	("08854", "Piscataway"),
	MERCER 		("08542", "Princeton"),
	MORRIS 		("07960", "Morristown"), 
	UNION 		("07083", "Union");
	
	private final String zipCode;
	private final String cityName;
	
	Location(String zipCode, String cityName) {
		this.zipCode = zipCode;
		this.cityName = cityName;
	}
	
	@Override
	public String toString() {
		return cityName + " " + zipCode + ", " + this.name();
	}
	
	public static Location getEnumFromString(String location) {
		return Location.valueOf(location.toUpperCase());
	}
	
	public static void main(String[] args) {
		Location location1 = Location.SOMERSET;
		System.out.println(location1.toString());
	}
}

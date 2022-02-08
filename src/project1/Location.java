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
}

package BusinessLogic;

public class City {
	
	private String cityName;     // Atlanta
	private String location;     // Georgia
	private String cityID;		// ATL
	
	
	
//Constructors
	
	public City() {
		cityName ="Los Angeles";
		location = "California";
		cityID ="LA";
		
	}
	
<<<<<<< HEAD
	
	public City(String cityName, String location, String cityID) {
		this.cityName = cityName;
		this.location = location;
		this.cityID = cityID;
=======
	public City(String a, String b, String c) {
		cityName =a;
		location =b;
		cityID =c;
>>>>>>> branch 'master' of https://github.com/rabinchowdhury/FlightAppProject.git
		
	}	
	
	
	
//Mutators
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCityID() {
		return cityID;
	}
	public void setCityID(String cityID) {
		this.cityID = cityID;
	}
	
	@Override
	public String toString() {
		return "City Name: " + cityName + "\nLocation: " + location + "\nCity ID: " + "";
		
	}
	
}





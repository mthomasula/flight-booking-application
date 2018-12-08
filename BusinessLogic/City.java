package BusinessLogic;

public class City {
	
	private String cityName;
	private String location;
	private String cityID;
	
	public City() {
		cityName ="Los Angeles";
		location = "California";
		cityID ="LA";
		
	}
	
	public City(String a, String b, String c) {
		cityName =a;
		location =b;
		cityID =c;
		
	}	
	
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
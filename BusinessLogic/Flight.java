package BusinessLogic;
public class Flight {
	protected String flightID;
	private String flightNumber;
	private String departureDate;
	private String departureTime;
	private String arrivalTime;
	private String destinationCity;
	private String departureCity;
	private String airlineName;
	private int flightCapacity;
	private int numberBooked;
	private String destinationAirport;
	private String flightPrice;

	public Flight() {}

	public Flight(String flightNumber, String departureDate, String departureTime, String arrivalTime, String destinationCity , String departureCity, String airlineName, int flightCapacity, int numberBooked,
			String destinationAirport, String flightPrice, String flightID) {
		
		this.flightID=flightID;
		this.flightNumber = flightNumber;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.destinationCity = destinationCity;
		this.departureCity = departureCity;
		this.airlineName = airlineName;
		this.flightCapacity = flightCapacity;
		this.numberBooked = numberBooked;
		this.destinationAirport = destinationAirport;
		this.flightPrice = flightPrice;
	}


	public String getFlightID() {
		return flightID;
	}

	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public int getFlightCapacity() {
		return flightCapacity;
	}

	public void setFlightCapacity(int flightCapacity) {
		this.flightCapacity = flightCapacity;
	}

	public int getNumberBooked() {
		return numberBooked;
	}

	public void setNumberBooked(int numberBooked) {
		this.numberBooked = numberBooked;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public String getFlightPrice() {
		return flightPrice;
	}

	public void setFlightPrice(String flightPrice) {
		this.flightPrice = flightPrice;
	}

	public String toString() {
		System.out.println(flightID + "");
		return flightID + "";
	}

	public boolean flightCheck(String flightID) {
		if (flightID.equals(this.getFlightID())) {
			return true;
		}

		return false;

	}
}

	
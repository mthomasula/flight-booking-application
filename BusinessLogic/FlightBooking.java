package BusinessLogic;
	import java.util.Date;
	import BusinessLogic.Flight;
	import Database.CustomerDB;
	import GUI.homepage;
	import javafx.application.Application;

	public class FlightBooking extends Flight {
		
		private static int confirmationNum=0000;
		private long timeBooked;
		private String status;
		private String bookedPrice;
		private String ssn=CustomerDB.getUserSSN(homepage.getUser());;
		
		public String getSsn() {
			return ssn;
		}

		public void setSsn(String ssn) {
			this.ssn = ssn;
		}

		public FlightBooking() {}
		
		public FlightBooking(String flightNum, String departureDate, String departureTime, String arrivalTime,
				String flightDuration, String to, String from, String airlineName, int capacity, int numBooked,
				String destinationAirport, String flight_price, String boardingTime, String flightID) {
			super();
			this.confirmationNum=confirmationNum++;
			this.timeBooked= new Date().getTime();
			this.status= "Booked";
			this.bookedPrice=flight_price;
			this.ssn= ssn;
		}
		public int getConfirmationNum() {
			return confirmationNum;
		}
		public void setConfirmationNum(int confirmationNum) {
			this.confirmationNum = confirmationNum;
		}
		public long getTimeBooked() {
			return timeBooked;
		}
		public void setTimeBooked(long timeBooked) {
			this.timeBooked = timeBooked;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getBookedPrice() {
			return bookedPrice;
		}
		public void setBookedPrice(String bookedPrice) {
			this.bookedPrice = bookedPrice;
		}
		
		
		
	}

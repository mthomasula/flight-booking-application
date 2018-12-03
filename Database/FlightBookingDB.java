package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalTime;

import BusinessLogic.FlightBooking;
import BusinessLogic.Flight;
import GUI.SearchFlights;
import GUI.homepage;

public class FlightBookingDB {

	public static boolean checkDoubleBooked() {
		try {
			Connection connection = getConnection();
			
			try {
				String Cssn= CustomerDB.getUserSSN(homepage.getUsr());
				String flightID=SearchFlights.getBookFlightID();
				
				System.out.println(Cssn +" "+ flightID);
				// select query to run
				
				String str="SELECT flightID, cSSN FROM booking where cSSN='"+Cssn+ "'AND flightID='"+flightID+"';";
				
				

				// Prepare Statement
				Statement statement = connection.prepareStatement(str);

				// Execute Statement
				
				ResultSet resultSet = statement.executeQuery(str);
				
				if(!resultSet.next()) {
					return false;
				}else
					return true;

			} catch (Exception ex) {

			} finally {
				connection.close();
			}

		} catch (Exception e) {
		}
		return true;
	}
	public static boolean checkCapacityOfFlight() {
		try {
			Connection connection = getConnection();
			
			try {
				;
				String flightID=SearchFlights.getBookFlightID();
				
				// select query to run
				
				String str="SELECT Capacity, BookedNum FROM booking where  flightID='"+flightID+"';";
				
				

				// Prepare Statement
				Statement statement = connection.prepareStatement(str);

				// Execute Statement
				
				ResultSet resultSet = statement.executeQuery(str);
				
				if(Integer.parseInt(resultSet.getString("Capacity"))>Integer.parseInt(resultSet.getString("BookedNum"))) {
					return false;
				}else
					return true;

			} catch (Exception ex) {

			} finally {
				connection.close();
			}

		} catch (Exception e) {
		}
		return true;
	}
	
	
	
	public static boolean checkConflict(String flightID,String username) {
		try {
			Connection connection = getConnection();
			
			try {
				String Cssn= CustomerDB.getUserSSN(MainMenu.getUser());
				// select query to run
				String str1="SELECT flightID, DepartureTime,ArrivalTime FROM Flight inner join booking on "+Cssn+"booking.cssn';";
				
				String str2="SELECT DepartureTime, ArrivalTime, FROM flight where flightID='"+flightID+"';";
				

				// Prepare Statement
				Statement statement1 = connection.prepareStatement(str1);
				Statement statement2 = connection.prepareStatement(str2);

				// Execute Statement
				
				ResultSet resultSet1 = statement1.executeQuery(str1);
				ResultSet resultSet2 = statement2.executeQuery(str2);
				while(resultSet1.next()) {
				
					if(LocalTime.parse(resultSet1.getString("DepartureTime")).isAfter(LocalTime.parse(resultSet2.getString("DepartureTime")))&& LocalTime.parse(resultSet1.getString("DepartureTime")).isBefore(LocalTime.parse(resultSet2.getString("ArrivalTime")))) {
						return true;
					}

			}} catch (Exception ex) {

			} finally {
				connection.close();
			}

		} catch (Exception e) {
		}
		return false;
	}
	
	
	public static FlightBooking createBooking() {
		try {
			Connection connection = getConnection();
			
			try {
				
				String flightID=SearchFlights.getBookFlightID();
				// select query to run
				
				String str2="SELECT * FROM flight where flightID='"+flightID+"';";
				

				// Prepare Statement
				
				Statement statement2 = connection.prepareStatement(str2);

				// Execute Statement
				
				
				ResultSet resultSet2 = statement2.executeQuery(str2);
				while(resultSet2.next()) {
				return new FlightBooking(resultSet2.getString("flightNum"),resultSet2.getString("DepartureDate"),resultSet2.getString("DepartureTime"),resultSet2.getString("ArrivalTime"),resultSet2.getString("FlightDuration"),resultSet2.getString("fTo"),resultSet2.getString("fFrom"),resultSet2.getString("AirlineName"),resultSet2.getInt("capacity"),resultSet2.getInt("BookedNum"),resultSet2.getString("DestinationAirport"),resultSet2.getString("Flight_Price"),resultSet2.getString("BoardingTime"),resultSet2.getString("flightID"));		

			}} catch (Exception ex) {

			} finally {
				connection.close();
			}

		} catch (Exception e) {
		}
	
		return new FlightBooking();
	}
	
	public static void addBooking(FlightBooking a) {
			try {
				Connection connection = getConnection();
				// select query to run
				String str = "Insert into Booking Values('" + a.getConfirmationNum() + "','" + a.getTimeBooked() + "','"
						+ a.getStatus() + "','" + a.getBookedPrice() + "', '" + a.getSsn() + "', '" + a.getFlightID()+"');";

				// Prepare Statement
				Statement statement = connection.prepareStatement(str);

				// Execute Statement
				statement.executeUpdate(str);
				connection.close();
			} catch (Exception ex) {
				// send to gui error dialog box
			}
		}

	
	
	
	public static Connection getConnection() throws Exception{
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://flightproject.cwnzf8egwsfw.us-east-2.rds.amazonaws.com:3306/flightproject", "root", "password");
		return connection;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

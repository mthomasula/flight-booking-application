package Database;

import BusinessLogic.Flight;
import GUI.AlertMessage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FlightDB {

	public static void addFlight(Flight flight1) {
		try {
			Connection connection = getConnection();
			// select query to run
			String str = "Insert into Flight "+ " VALUES ('" + flight1.getFlightID()+"', '"+ flight1.getFlightNumber()+"', '"+flight1.getDepartureDate()+"', '"+ flight1.getDestinationCity()+"', '"+flight1.getDepartureCity()+"', '"+flight1.getDepartureTime()+"', '"+flight1.getArrivalTime()+"','"+flight1.getAirlineName()+"', "+flight1.getFlightCapacity()+", "+flight1.getNumberBooked()+", "+flight1.getFlightPrice()+")";

			// Prepare Statement
			Statement statement = connection.prepareStatement(str);

			// Execute Statement
			statement.executeUpdate(str);
			connection.close();
		} catch (Exception ex) {
			// send to gui error dialog box
			}}

	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://flightproject.cwnzf8egwsfw.us-east-2.rds.amazonaws.com:3306/flightproject", "root", "password");
		} catch (Exception e) {
			System.out.println("Cannot connect");
		}
		return connection;

	}
	
}

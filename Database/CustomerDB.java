package Database;

import BusinessLogic.Customer;
import GUI.AlertMessage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDB  {

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
	public static void addUser(Customer customer1) throws Exception {

		
		try {
			Connection connection = getConnection();
			try {
				// select query to run
				String str = "Insert into Customer Values('" + customer1.getSsn() + "','" + customer1.getUsername() + "','"
						+ customer1.getPassword() + "','" + customer1.getFirstName() + "', '" + customer1.getLastName() + "', '" + customer1.getAddress() + "', '" + customer1.getZipcode() + "', '" + customer1.getState()
						+ "','" + customer1.getCountry() + "','" + customer1.getEmail() + "', '" + customer1.getSecurityQuestion() + "','"
						+ customer1.getSecurityAnswer() + "');";

				// Prepare Statement
				Statement statement = connection.prepareStatement(str);

				// Execute Statement
				statement.executeUpdate(str);

			} catch (Exception ex) {
				// send to gui error dialog box
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static String getUserPassword(String username) {

		try {
			Connection connection = getConnection();

					String str= "SELECT CPassword FROM Customer WHERE CUsername ='"+username+"'";
					
					// Prepare Statement
					PreparedStatement statement = connection.prepareStatement(str);

					// Execute Statement
					ResultSet resultSet = statement.executeQuery();
				
					while(resultSet.next()) {
					
						return resultSet.getString(1);
							}
						
					} catch (Exception ex) {}
		return "error";
	}
	
	public static String getUserSecurityQuestion(String username) {

		try {
			Connection connection = getConnection();
			
			try {
				// select query to run
				String str = "select SecurityQuestion from Customer where CUsername='"+ username+"';";

				// Prepare Statement
				Statement statement = connection.prepareStatement(str);

				// Execute Statement
				
				ResultSet resultSet = statement.executeQuery(str);
				
				while(resultSet.next()) {
				return resultSet.getString(1);
				}

			} catch (Exception ex) {

			} finally {
				connection.close();
			}

		} catch (Exception e) {
		}
		return "";
	}
	public static String getUserSecurityAnswer(String username) {

		try {
			Connection connection = getConnection();
			
			try {
				// select query to run
				String str = "select SecurityAnswer from Customer where CUsername='"+ username+"';";

				// Prepare Statement
				Statement statement = connection.prepareStatement(str);

				// Execute Statement
				
				ResultSet resultSet = statement.executeQuery(str);
				
				while(resultSet.next()) {
				return resultSet.getString(1);
				}

			} catch (Exception ex) {

			} finally {
				connection.close();
			}

		} catch (Exception e) {
		}
		return "";
	}
	public static String getUserSSN(String username) {

		try {
			Connection connection = getConnection();

					String str= "SELECT Cssn FROM Customer WHERE CUsername ='"+username+"'";
					
					// Prepare Statement
					PreparedStatement statement = connection.prepareStatement(str);

					// Execute Statement
					ResultSet resultSet = statement.executeQuery();
				
					while(resultSet.next()) {
						return resultSet.getString(1);
							}
						
					} catch (Exception ex) {}
		return "error";
	}

}

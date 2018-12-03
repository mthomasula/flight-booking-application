package Database;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BusinessLogic.Administrator;
import BusinessLogic.Flight;

public class AdministratorDB {
	public static void addAdministrator(Administrator admin1) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		System.out.println("Driver loaded");

		// Connect
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://flightproject.cwnzf8egwsfw.us-east-2.rds.amazonaws.com:3306/flightproject", "root", "password");
			try {
				// select query to run
				String str = "Insert into Administrator Values('" + admin1.getUsername() + "','" + admin1.getPassword() + "','"
						+ admin1.getFirstName() + "','" + admin1.getLastName() + "', '" + admin1.getAddress()
						+ "', '" + admin1.getZipcode() + "', '" + admin1.getState() + "', '" + admin1.getCountry() + "','"
						+ admin1.getEmail() + "','" + admin1.getSecurityQuestion() + "', '" + admin1.getSecurityAnswer() + "');";

				// Prepare Statement
				Statement statement = connection.prepareStatement(str);

				// Execute Statement
				statement.executeUpdate(str);

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
	
	public static String getAdministratorPassword(String username) {

		try {
			Connection connection = getConnection();

					String str= "SELECT APassword FROM Admin WHERE Username ='"+username+"'";
					
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
	
	public static String getAdminSecurityQ(String username) {

		try {
			Connection connection = getConnection();
			
			try {
				// select query to run
				String str = "select SecurityQuestion from Admin where Username='"+ username+"';";

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
	public static String getAdminSecurityA(String username) {

		try {
			Connection connection = getConnection();
			
			try {
				// select query to run
				String str = "select SecurityAnswer from Admin where Username='"+ username+"';";

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
	
	public static boolean isAdministrator(String username) {
		try {
			Connection connection = getConnection();
			
			try {
				// select query to run
				String str = "select Username from Administrator where Username='"+ username+"';";

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
	

	
	
}

package GUI;
import java.sql.Connection;
import GUI.AdminMain;
import GUI.CustomerMain;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BusinessLogic.FlightBooking;
import BusinessLogic.Customer;
import BusinessLogic.Flight;
import Database.AdministratorDB;
import Database.FlightBookingDB;
import Database.CustomerDB;
import Database.FlightDB;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SearchFlights extends Application implements EventHandler<ActionEvent> {
	private static String bookFlightID = "";
	static String dbSearch = "";
	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Search Flights");
		AnchorPane anchor = new AnchorPane();
		anchor.setPadding(new Insets(20, 20, 20, 20));
		TableView<Flight> table = new TableView<>();
		final ObservableList<Flight> data = FXCollections.observableArrayList();

		ChoiceBox<String> dropdown = new ChoiceBox<>();
		dropdown.getItems().addAll("To", "From", "Date", "Time", "Airline");
		dropdown.setValue("To");
		dropdown.setLayoutY(60);
		dropdown.setLayoutX(720);

		Button userView = new Button("Main page");
		userView.setOnAction(a -> {
			if (AdministratorDB.isAdministrator(homepage.getUser())) {
				primaryStage.close();
				AdminMain main = new AdminMain();
				main.start(new Stage());
			} else {
				primaryStage.close();
				CustomerMain cmain = new CustomerMain();
				cmain.start(new Stage());

			}
		});

		TextField flightIDText = new TextField();
		flightIDText.setPromptText("Flight ID");
		flightIDText.setLayoutX(800);
		flightIDText.setLayoutY(600);
		flightIDText.setMinWidth(250);

		Button bkFlight = new Button("Book Flight");
		bkFlight.setLayoutX(1050);
		bkFlight.setLayoutY(600);
		bkFlight.setMinWidth(250);

		TextField search = new TextField();
		search.setLayoutX(800);
		search.setLayoutY(60.0);
		search.setMinWidth(250);

		TableColumn<Flight, String> column1 = new TableColumn<Flight, String>("Flight#");
		column1.setCellValueFactory(new PropertyValueFactory<>("flightNum"));
		column1.setMinWidth(80);
		TableColumn<Flight, String> column2 = new TableColumn<Flight, String>("Departure Date");
		column2.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
		column2.setMinWidth(100);
		TableColumn<Flight, String> column3 = new TableColumn<Flight, String>("Departure Time");
		column3.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
		column3.setMinWidth(100);
		TableColumn<Flight, String> column4 = new TableColumn<Flight, String>("Arrival Time");
		column4.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
		column4.setMinWidth(100);
		TableColumn<Flight, String> column5 = new TableColumn<Flight, String>("Flight Duration");
		column5.setCellValueFactory(new PropertyValueFactory<>("flightDuration"));
		column5.setMinWidth(100);
		TableColumn<Flight, String> column6 = new TableColumn<Flight, String>("To");
		column6.setCellValueFactory(new PropertyValueFactory<>("to"));
		column6.setMinWidth(115);
		TableColumn<Flight, String> column7 = new TableColumn<Flight, String>("From");
		column7.setCellValueFactory(new PropertyValueFactory<>("from"));
		column7.setMinWidth(115);
		TableColumn<Flight, String> column8 = new TableColumn<Flight, String>("Airline");
		column8.setCellValueFactory(new PropertyValueFactory<>("airlineName"));
		column8.setMinWidth(80);
		TableColumn<Flight, Integer> column9 = new TableColumn<Flight, Integer>("Capacity");
		column9.setCellValueFactory(new PropertyValueFactory<>("capacity"));
		column9.setMinWidth(75);
		TableColumn<Flight, Integer> column10 = new TableColumn<Flight, Integer>("#Booked");
		column10.setCellValueFactory(new PropertyValueFactory<>("numBooked"));
		column10.setMinWidth(75);
		TableColumn<Flight, String> column11 = new TableColumn<Flight, String>("Destination Airport");
		column11.setCellValueFactory(new PropertyValueFactory<>("destinationAirport"));
		column11.setMinWidth(128.88);
		TableColumn<Flight, Double> column12 = new TableColumn<Flight, Double>("Flight Price");
		column12.setCellValueFactory(new PropertyValueFactory<>("flight_price"));
		column12.setMinWidth(80);
		TableColumn<Flight, String> column13 = new TableColumn<Flight, String>("Boarding Time");
		column13.setCellValueFactory(new PropertyValueFactory<>("boardingTime"));
		column13.setMinWidth(110);
		table.setTableMenuButtonVisible(false);
		TableColumn<Flight, String> column14 = new TableColumn<Flight, String>("FlightID");
		column14.setCellValueFactory(new PropertyValueFactory<>("flightID"));
		column14.setMinWidth(80);

		Button searchB = new Button("Search Flights");
		searchB.setLayoutX(1050);
		searchB.setLayoutY(60.0);
		searchB.setMinWidth(100);

		searchB.setOnAction(s -> {
			try {
			
				SearchFlights.getChoice(dropdown);
				String searchItem = search.getText().trim().toUpperCase();

				if (dbSearch == "fDate" && !searchItem.matches("\\d{2}-\\d{2}-\\d{4}")) {
					AlertMessage.display("Search Error", "Please insert date as MM-DD-YYYY and try again.");
				}
				if (dbSearch == "DepartureTime" && !searchItem.matches("\\d{2}:\\d{2}")) {
					AlertMessage.display("Search Error",
							"Please insert time as HH:MM (23:59 = 11:59 PM) and try again.");
				}

				
					Connection connection = getConnection();

					String str = "SELECT * FROM Flight WHERE " + dbSearch + " = '" + searchItem + "';";
					PreparedStatement statement = connection.prepareStatement(str);

					ResultSet myResult = statement.executeQuery();
					table.getItems().clear();

					if (!myResult.next()) {
						AlertMessage.display("No Flights Found",
								"No flights were found matching your criteria. Please try again. "
										+ "\nFormat for searches-\nTo/From: City STATE ex. Atlanta GA\nDate:MM-DD-YYYY\nTime: HH:MM ex. 17:45");
					}
					while (myResult.next()) {
						data.add(new Flight(myResult.getString("flightNum"), myResult.getString("FlightDate"),
								myResult.getString("DepartureTime"), myResult.getString("ArrivalTime"),myResult.getString("DestinationCity"),
								myResult.getString("DepartureCity"), myResult.getString("AirlineName"),
								myResult.getInt("FlightCapacity"), myResult.getInt("BookedNum"),
								myResult.getString("DestinationAirport"), myResult.getString("FlightPrice"), myResult.getString(1)));
						table.setItems(data);
					}

					statement.close();
					myResult.close();
					connection.close();

				} catch (SQLException a) {
					System.out.println(a.getMessage());
				}
			
		});

		table.setLayoutX(20);
		table.setLayoutY(100);
		table.setMinWidth(1020);
		table.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9,
				column10, column11, column12, column13, column14);
		anchor.getChildren().addAll(dropdown, search, searchB, table, userView, bkFlight, flightIDText);
		Scene scene = new Scene(anchor, 1600, 900);

		bkFlight.setOnAction(f -> {
			setBookFlightID(flightIDText.getText());
			if (FlightBookingDB.checkConflict(getBookFlightID(), homepage.getUser()) && FlightBookingDB.checkCapacityOfFlight()) {
				AlertMessage.display("Flight Conflict",
						"WARNING!!! The FlightID entered creates a conflict with a previously booked flight!");
				primaryStage.close();
				BookFlight main2 = new BookFlight();
				main2.start(new Stage());
			} else if (!FlightBookingDB.checkConflict(getBookFlightID(), homepage.getUser()) && !FlightBookingDB.checkDoubleBooked()
					&& !FlightBookingDB.checkCapacityOfFlight()) {
				primaryStage.close();
				BookFlight main2 = new BookFlight();
				main2.start(new Stage());

			} else if (FlightBookingDB.checkConflict(getBookFlightID(), homepage.getUser()) && FlightBookingDB.checkDoubleBooked()) {
				AlertMessage.display("Flight Conflict",
						"The FlightID entered creates a conflict with a previously booked flight & has already been booked.");
			} else if (FlightBookingDB.checkDoubleBooked()) {
				AlertMessage.display("Flight Conflict", "The FlightID entered has already been booked.");
			} else if (FlightBookingDB.checkCapacityOfFlight()) {
				AlertMessage.display("Flight Conflict",
						"Sorry!! The FlightID entered is over capacity. Please choose another flight.");
			}

		});

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void handle(ActionEvent arg0) {

	}

	// test
	public static void getChoice(ChoiceBox<String> dropdown) {
		String choice = ((String)dropdown.getValue());
		if (choice.equals("To")) {
			dbSearch = "fTo";
		} else if (choice.equals("From")) {
			dbSearch = "fFrom";
		} else if (choice.equals("Date")) {
			dbSearch = "fDate";
		} else if (choice.equals("Time")) {
			dbSearch = "DepartureTime";
		} else if (choice.equals("Airline")) {
			dbSearch = "AirlineName";
		}
		
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/WrightFlights?useSSL=false", "root",
					"root");
		} catch (Exception e) {
			System.out.println("Cannot connect");
		}
		return connection;

	}

	public static String getBookFlightID() {
		return bookFlightID;
	}

	public static void setBookFlightID(String bookFlightID) {
		SearchFlights.bookFlightID = bookFlightID;
	}
}
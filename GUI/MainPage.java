package GUI;

import java.sql.*;

import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;

import BusinessLogic.Flight;



public class MainPage extends Application implements EventHandler<ActionEvent> {
	
	private ObservableList<ObservableList> data;
	private String usernameID = "";
	
	private boolean isAdmin = false;
	

// Main Method	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Home");
		primaryStage.setResizable(false);
		AnchorPane anchor = new AnchorPane();
		anchor.setPadding(new Insets(10, 10, 10, 10));
		
		TableView<Flight> table = new TableView();
		final ObservableList<Flight> data = FXCollections.observableArrayList();
		
		Label userID = new Label();
		Button searchFlights = new Button();
		Label myFlights = new Label();
		Button deleteFlights = new Button();
		Button logOut = new Button();
		TextField deleteFlightTxt = new TextField();
		Button refresh = new Button("Refresh");
		
		try {
			Connection myConn;
			myConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/flightdatabase", "root",
					"password");

			String sqlUserCheck = "SELECT * FROM `Users` where username = '" + Login.getUser()
					+ "' and isAdmin = '1'";
			
			Statement myStat = myConn.createStatement();
			
			ResultSet myRs;
			myRs = myStat.executeQuery(sqlUserCheck);

			
			int count = 0;
			while (myRs.next()) {
				count = count + 1;

			}

			if (count > 0) {
				setAdmin(true);
			}

		}
		
		catch (Exception exe) {
			
		}
		
		userID.setAlignment(javafx.geometry.Pos.CENTER);
		userID.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
		userID.setLayoutX(928.0);
		userID.setLayoutY(20.0);
		userID.setText("Logged in as: " + Login.getUser() );
		userID.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
		userID.setFont(new Font(18.0));
		
		searchFlights.setLayoutX(1100.0);
		searchFlights.setLayoutY(214.0);
		searchFlights.setMnemonicParsing(false);
		searchFlights.setText("Search Flights");
		searchFlights.setOnAction(e -> {
			SearchPage search = new SearchPage();
			try {
				search.start(primaryStage);
				
			} catch (Exception ex) {
								
			}

		});
		
		table.setLayoutX(10.0);
		table.setLayoutY(57.0);
		table.setPrefHeight(329.0);
		table.setPrefWidth(1031.11);

		myFlights.setLayoutX(420.0);
		myFlights.setLayoutY(10.0);
		myFlights.setText("My Flights");
		myFlights.setFont(new Font(25.0));

		refresh.setLayoutX(1100.0);
		refresh.setLayoutY(179.0);
		refresh.setMnemonicParsing(false);
		refresh.setOnAction(e -> { 
			try {
				
			}
			catch (Exception ex) {
				
			}
		});
		
		logOut.setLayoutX(1100.0);
		logOut.setLayoutY(249.0);
		logOut.setMnemonicParsing(false);
		logOut.setText("Log Out");
		logOut.setOnAction(e -> {
			Login loginPage = new Login();
			try {
				loginPage.start(primaryStage);
				
			} catch (Exception ex) {
				
			}
		});
		
		Label deleteFlightLbl = new Label("Enter Flight Number to Delete:");
		deleteFlightLbl.setLayoutX(1065);
		deleteFlightLbl.setLayoutY(89);

		deleteFlightTxt.setLayoutX(1100);
		deleteFlightTxt.setLayoutY(109);
		deleteFlightTxt.setPrefHeight(25);
		deleteFlightTxt.setPrefWidth(90);

		deleteFlights.setLayoutX(1100.0);
		deleteFlights.setLayoutY(139.0);
		deleteFlights.setMnemonicParsing(false);
		deleteFlights.setText("Delete Flight");
		deleteFlights.setOnAction(e -> {
			try {
				
			}
			catch(Exception ex) {
				
			}
		
		});
		TableColumn<Flight, Integer> column1 = new TableColumn<Flight, Integer>("Flight Number");
		column1.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
		column1.setMinWidth(128.88);

		TableColumn<Flight, String> column2 = new TableColumn<Flight, String>("Airline");
		column2.setCellValueFactory(new PropertyValueFactory<>("Airline"));
		column2.setMinWidth(128.88);

		TableColumn<Flight, String> column3 = new TableColumn<Flight, String>("Origin City");
		column3.setCellValueFactory(new PropertyValueFactory<>("originCity"));
		column3.setMinWidth(128.88);

		TableColumn<Flight, String> column4 = new TableColumn<Flight, String>("Destination City");
		column4.setCellValueFactory(new PropertyValueFactory<>("destinationCity"));
		column4.setMinWidth(128.88);

		TableColumn<Flight, Date> column5 = new TableColumn<Flight, Date>("Departure Date");
		column5.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
		column5.setMinWidth(128.88);

		TableColumn<Flight, Time> column6 = new TableColumn<Flight, Time>("Departure Time");
		column6.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
		column6.setMinWidth(128.88);

		TableColumn<Flight, Date> column7 = new TableColumn<Flight, Date>("Arrival Date");
		column7.setCellValueFactory(new PropertyValueFactory<>("arrivalDate"));
		column7.setMinWidth(128.88);

		TableColumn<Flight, Time> column8 = new TableColumn<Flight, Time>("Arrival Time");
		column8.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
		column8.setMinWidth(128.88);

		table.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8);

		try {
			
		}
		catch(Exception ex) {
			
		}
		
		Button adminTool = new Button("Admin Add flight");
		adminTool.setLayoutX(1100);
		adminTool.setLayoutY(290);
		adminTool.setOnAction(e ->{
			Registration flightRegister =new Registration();
			try {
				flightRegister.start(primaryStage);
				
			} catch (Exception ex) {
				
			}
		});
		
		Button adminTool1 = new Button("Admin Flight Edit/Delete");
		adminTool1.setLayoutX(1100);
		adminTool1.setLayoutY(330);
		adminTool1.setOnAction(e -> {
			UpdateFlight updateFlights = new UpdateFlight();
			try {
				updateFlights.start(primaryStage);
				
			} catch (Exception ex) {
			
			}
		});
		
		if (isAdmin() == true) {
			anchor.getChildren().add(adminTool);
			anchor.getChildren().add(adminTool1);
		}
		
		anchor.getChildren().addAll(deleteFlightLbl, userID, searchFlights, table, myFlights, deleteFlights,
				deleteFlightTxt, logOut, refresh);
		
		Scene scene = new Scene(anchor, 1300, 500);

		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.centerOnScreen();
		
	}
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub

	}
	
	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getUsernameID() {
		return usernameID;
	}

	public void setUsernameID(String usernameID) {
		this.usernameID = usernameID;
	}
	
	

}
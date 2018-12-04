package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import BusinessLogic.Flight;
import BusinessLogic.Administrator; 
import javafx.application.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class FlightReservation extends Application implements EventHandler<ActionEvent> {
	
	public static void main(String[] args)  {
		
		launch(args);
		
	}
	
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Add Flight");
		AnchorPane anchor = new AnchorPane();
		anchor.setPadding(new Insets(20, 20, 20, 20));

		Text airline = new Text("Airline");
		airline.setLayoutX(200);
		airline.setLayoutY(45);

		Text flightNumber = new Text("Flight Number");
		flightNumber.setLayoutX(200);
		flightNumber.setLayoutY(80);

		Text originCity = new Text("Origin City");
		originCity.setLayoutX(200);
		originCity.setLayoutY(115);

		Text destinationCity = new Text("Destination City");
		destinationCity.setLayoutX(200);
		destinationCity.setLayoutY(150);

		Text departureDate = new Text("Departure Date");
		departureDate.setLayoutX(200);
		departureDate.setLayoutY(185);

		Text departureTime = new Text("Departure Time");
		departureTime.setLayoutX(200);
		departureTime.setLayoutY(220);

		Text arrivalDate = new Text("Arrival Date");
		arrivalDate.setLayoutX(200);
		arrivalDate.setLayoutY(255);

		Text arrivalTime = new Text("Arrival Time");
		arrivalTime.setLayoutX(200);
		arrivalTime.setLayoutY(290);

		Text capacity = new Text("Available Seats");
		capacity.setLayoutX(200);
		capacity.setLayoutY(330);

		TextField airlineTxtField = new TextField();
		airlineTxtField.setLayoutX(300);
		airlineTxtField.setLayoutY(25);
		airlineTxtField.setPromptText("Airline");

		TextField flightNumberTxtField = new TextField();
		flightNumberTxtField.setLayoutX(300);
		flightNumberTxtField.setLayoutY(60);
		flightNumberTxtField.setPromptText("Flight Number");

		TextField originCityTxtField = new TextField();
		originCityTxtField.setLayoutX(300);
		originCityTxtField.setLayoutY(95);
		originCityTxtField.setPromptText("Origin City");

		TextField destinationCityTxtField = new TextField();
		destinationCityTxtField.setLayoutX(300);
		destinationCityTxtField.setLayoutY(130);
		destinationCityTxtField.setPromptText("Destination City");

		TextField departureDateTxtField = new TextField();
		departureDateTxtField.setLayoutX(300);
		departureDateTxtField.setLayoutY(165);
		departureDateTxtField.setPromptText("YYYY-MM-DD");

		TextField departureTimeTxtField = new TextField();
		departureTimeTxtField.setLayoutX(300);
		departureTimeTxtField.setLayoutY(200);
		departureTimeTxtField.setPromptText("HH:MM:SS");

		TextField arrivalDateTxtField = new TextField();
		arrivalDateTxtField.setLayoutX(300);
		arrivalDateTxtField.setLayoutY(235);
		arrivalDateTxtField.setPromptText("YYYY-MM-DD");

		TextField arrivalTimeTxtField = new TextField();
		arrivalTimeTxtField.setLayoutX(300);
		arrivalTimeTxtField.setLayoutY(270);
		arrivalTimeTxtField.setPromptText("HH:MM:SS");

		TextField seatsOpenTxtField = new TextField();
		seatsOpenTxtField.setLayoutX(300);
		seatsOpenTxtField.setLayoutY(310);
		seatsOpenTxtField.setPromptText("Capacity");

		Button returnHome = new Button("Return to main Page");
		returnHome.setLayoutX(250);
		returnHome.setLayoutY(450);
		returnHome.setOnAction(e -> {
			MainPage mainPage = new MainPage();
			try {
				mainPage.start(primaryStage);
			} catch (Exception ex) {
				
			}
		});
		
		Button create = new Button("Create Flight");
		create.setLayoutX(250);
		create.setLayoutY(400);
		create.setOnAction(e -> {
			try {
				Connection myConn;
				myConn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/airlinedatabase", "root",
						"confident");
				String sqlFightCheck = "select * From `Flights` where number = '"
						+ flightNumberTxtField.getText() + "'";

				String sqlFlightCreate = "INSERT INTO `Flights`(`number`,`airline`,`origin_city`,`destination_city`,`departure_date`,`departure_time`"
						+ "`arrival_time`,`departure_date`,`arrival_date`,`seats_open`) VALUES('"
						+ flightNumberTxtField.getText() + "', '"+ airlineTxtField.getText() + "', '" 
						+ originCityTxtField.getText() + "', '" + destinationCityTxtField.getText() + "' , '"
						+ departureDateTxtField.getText() + "', '" + departureTimeTxtField.getText() + "', '"
						+ arrivalTimeTxtField.getText() + "', '" + departureDateTxtField.getText() + "','" 
						+ arrivalDateTxtField.getText() + "', '" + seatsOpenTxtField.getText() + "')";

				Statement myStat = myConn.createStatement();
				// execute a query
				;
				ResultSet myRs;
				myRs = myStat.executeQuery(sqlFightCheck);
				int count = 0;
				while (myRs.next()) {
					count += 1;
				}
				if (count == 0) {
					myStat.executeUpdate(sqlFlightCreate);
					AlertBox.display("Success", "FLight Successfully Added!");

				} else {
					AlertBox.display("Error",
							"Flight number " + flightNumberTxtField.getText() + " already exists.");
				}
				
			}
			catch(Exception ex) {
				
				AlertBox.display("Error", "Departure cannot be before a arrival");
				
			}
		});
		
		anchor.getChildren().addAll(airline, flightNumber, originCity, destinationCity, departureDate, departureTime,
				arrivalDate, arrivalTime, capacity, airlineTxtField, flightNumberTxtField, originCityTxtField,
				destinationCityTxtField, departureDateTxtField, departureTimeTxtField, arrivalDateTxtField,
				arrivalTimeTxtField, seatsOpenTxtField, create, returnHome);

		Scene scene = new Scene(anchor, 650, 550);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
		primaryStage.setMaximized(false);
		primaryStage.centerOnScreen();
	}
	
	public int schedulingCheck(Timestamp d, Timestamp a) {

		if (d.compareTo(a) >= 0) {
			return 1;
		} else {
			return 0;
		}

	}
	
	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
		
	
 
}
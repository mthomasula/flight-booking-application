package GUI;

import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;

import BusinessLogic.Flight;

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

public class UpdateFlight extends Application implements EventHandler<ActionEvent> {
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		Button deleteFlights = new Button();
		AnchorPane anchor = new AnchorPane();
		anchor.setPadding(new Insets(20, 20, 20, 20));
		TableView<Flight> table = new TableView<>();
		final ObservableList<Flight> data = FXCollections.observableArrayList();

		ChoiceBox<String> dropdown = new ChoiceBox<>();
		dropdown.getItems().addAll("Flight Number", "Airline", "Destination", "Origin", "Departure Date",
				"Departure Time", "Arrival Date", "Arrival Time");
		dropdown.setValue("Flight Number");
		dropdown.setLayoutY(60);
		dropdown.setLayoutX(535);

		ChoiceBox<String> dropdown2 = new ChoiceBox<>();
		dropdown2.getItems().addAll("Delete", "Update");
		dropdown2.setValue("Update");
		dropdown2.setLayoutY(60);
		dropdown2.setLayoutX(340);

		TextField flightNumberField = new TextField();
		flightNumberField.setLayoutX(430);
		flightNumberField.setLayoutY(60);
		flightNumberField.setPromptText("Flight Number");
		flightNumberField.setPrefWidth(100);

		TextField info = new TextField();
		info.setLayoutY(60);
		info.setLayoutX(655);
		info.setPromptText("Info");
		info.setPrefWidth(100);

		Button returnHome = new Button("Return Home");
		returnHome.setOnAction(e -> {
			MainPage mainPage = new MainPage();
			try {
				mainPage.start(primaryStage);
			} catch (Exception ex) {
				
			}
		});
		returnHome.setLayoutX(970);
		returnHome.setLayoutY(60);
		returnHome.setMinWidth(100);

		Button submit = new Button("Submit");
		submit.setLayoutX(765);
		submit.setLayoutY(60);
		submit.setOnAction(e -> {
			if (getOption(dropdown2).trim().equals("UPDATE")) {
			try {
				
				Connection myConn;
				myConn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/flightdatabase", "root",
						"password");
				String update = getOption(dropdown2).trim() + " Flights` SET "
						+ getChoice(dropdown).trim() + " = '" + info.getText().trim() + "' WHERE num = '"
						+ flightNumberField.getText().trim() + "' ";
				Statement myStat = myConn.createStatement();
				myStat.executeUpdate(update);
				
			}
			catch (Exception ex) {}
			}
			
			if (getOption(dropdown2).trim().equals("DELETE")) {
				try {

					Connection myConn;
					myConn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/flightdatabase", "root",
							"password");

					String delete = "DELETE FROM Flights WHERE num='"
							+ flightNumberField.getText().trim() + "'";
					Statement myStat = myConn.createStatement();
					myStat.executeUpdate(delete);
				}

				catch (SQLException ex) {
				}

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

		TableColumn<Flight, Date> column7 = new TableColumn<Flight, Date>("Arrival date");
		column7.setCellValueFactory(new PropertyValueFactory<>("arrivalDate"));
		column7.setMinWidth(128.88);

		TableColumn<Flight, Time> column8 = new TableColumn<Flight, Time>("Arrival Time");
		column8.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
		column8.setMinWidth(128.88);

		try {
			
		}
		catch(Exception ex) {
			
		}
		
		table.setTableMenuButtonVisible(false);

		table.setLayoutY(100);
		table.setLayoutX(20);
		table.setMinWidth(1160 - 128.88);
		table.setMinHeight(580);
		table.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8);
		anchor.getChildren().addAll(dropdown, table, dropdown2, flightNumberField, info, submit, returnHome);
		Scene scene = new Scene(anchor, 1200, 700);

		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
		primaryStage.setMaximized(false);
		primaryStage.centerOnScreen();

		
	}
	
	public String getChoice(ChoiceBox<String> dropdown) {

		String dbSearch = "";
		String choice = dropdown.getValue();

		if (choice.equals("Destnation")) {
			dbSearch = "destination_city";
		} else if (choice.equals("Flight Number")) {
			dbSearch = "number";
		}

		else if (choice.equals("Origin")) {
			dbSearch = "origin_city";
		} else if (choice.equals("Departure Date")) {
			dbSearch = "departure_date";
		} else if (choice.equals("Departure Time")) {
			dbSearch = "departure_time";
		} else if (choice.equals("Arrival Date")) {
			dbSearch = "arrival_date";
		} else if (choice.equals("Airline")) {
			dbSearch = "airline";
		}
		return dbSearch;

	}

	public String getOption(ChoiceBox<String> dropdown2) {

		String dbquery = "";
		String choice = dropdown2.getValue();

		if (choice.equals("Delete")) {
			dbquery = "DELETE";
		}

		else if (choice.equals("Update")) {
			dbquery = "UPDATE";
		}

		return dbquery;

	}
	
	public int schedulingCheck(Timestamp d, Timestamp a) {

		if (d.compareTo(a) >= 0) {
			return 1;
		} else {
			return 0;
		}

	}
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub

	}
	
}
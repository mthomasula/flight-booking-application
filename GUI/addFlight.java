package GUI;

import Database.FlightDB;
import BusinessLogic.Flight;
import java.sql.Connection;
import java.sql.DriverManager;
import GUI.AdminMain;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class addFlight extends Application{
	@Override
	public void start(Stage Addstage) {
		Text flightid = new Text("Flight ID: ");
		TextField flightIDText = new TextField();
		
		Text flightNum = new Text("Flight Number: ");
		TextField flightNumText = new TextField();
		
		Text fDate = new Text("Flight Date: ");
		TextField fDateText = new TextField();
		
		Text fTo = new Text("To: ");
		TextField fToText = new TextField();
		
		Text fFrom = new Text("From: ");
		TextField fFromText = new TextField();
		
		Text BoardingTime = new Text("Boarding Time: ");
		TextField BoardingTimeText = new TextField();
		
		Text DepartureTime = new Text("Departure Time: ");
		TextField DepartureTimeText = new TextField();
		
		Text ArrivalTime = new Text("Arrival Time: ");
		TextField ArrivalTimeText = new TextField();
		
		Text flightDuration = new Text("Flight Duration: ");
		TextField flightDurationText = new TextField();
		
		Text DestinationAirport = new Text("Destination Airport: ");
		TextField DestinationAirportText = new TextField();
		
		Text AirlineName = new Text("Airline Name: ");
		TextField AirlineNameText = new TextField();
		
		Text capacity = new Text("Capacity: ");
		TextField capacityText = new TextField();
	
		
		Text FlightPrice = new Text("Flight Price: ");
		TextField FlightPriceText = new TextField();
		
		
		Button confirmAdd= new Button("Confirm add");
		Button mainB=new Button("Back");
		
		GridPane gridPane = new GridPane();
		gridPane.setMinSize(500, 500);
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setVgap(5);
		gridPane.setHgap(5);
		gridPane.setAlignment(Pos.CENTER);
		
		gridPane.add(flightid, 0, 0);
		gridPane.add(flightIDText, 1, 0);
		
		gridPane.add(flightNum, 0, 1);
		gridPane.add(flightNumText, 1, 1);
		
		gridPane.add(fDate, 0, 2);
		gridPane.add(fDateText, 1, 2);
		
		gridPane.add(fTo, 0, 3);
		gridPane.add(fToText, 1, 3);
		
		gridPane.add(fFrom, 0, 4);
		gridPane.add(fFromText, 1, 4);
		
		gridPane.add(BoardingTime, 2, 0);
		gridPane.add(BoardingTimeText, 3, 0);
		
		gridPane.add(DepartureTime, 2, 1);
		gridPane.add(DepartureTimeText, 3, 1);
		
		gridPane.add(ArrivalTime, 2, 2);
		gridPane.add(ArrivalTimeText, 3, 2);
		
		gridPane.add(flightDuration, 2, 3);
		gridPane.add(flightDurationText, 3, 3);
		
		gridPane.add(DestinationAirport, 2, 4);
		gridPane.add(DestinationAirportText, 3, 4);
		
		gridPane.add(AirlineName, 4, 0);
		gridPane.add(AirlineNameText, 5, 0);
		
		gridPane.add(capacity, 4, 1);
		gridPane.add(capacityText, 5, 1);
		
		
		
		gridPane.add(FlightPrice, 4, 2);
		gridPane.add(FlightPriceText, 5, 2);
		
		
		gridPane.add(confirmAdd, 6, 5);
		gridPane.add(mainB,6,7);
		gridPane.setStyle("-fx-background-color: SALMON;");
		Scene scene = new Scene(gridPane);
		Addstage.setTitle("Adding a new flight");
		Addstage.setScene(scene);
		Addstage.show();
		
		mainB.setOnAction(h->{
			try {
				homepage home=new homepage();
				home.start(new Stage());
			}finally {
				Addstage.close();
			}
		});
		confirmAdd.setOnAction(b->{
			try {
			Flight flight1=new Flight(flightNumText.getText(),fDateText.getText(),DepartureTimeText.getText(),ArrivalTimeText.getText(),flightDurationText.getText(),
					fToText.getText(),fFromText.getText(),AirlineNameText.getText(),Integer.parseInt(capacityText.getText()),0,DestinationAirportText.getText(),FlightPriceText.getText(),BoardingTimeText.getText(),flightIDText.getText());
					FlightDB.addFlight(flight1);
					Addstage.close();
					
					AdminMain main= new AdminMain();
					main.start(new Stage());

			}catch(Exception e){
				AlertMessage.display("Error", "Add flight error. Please make sure all fields are correct.");
			
			
		}});
	}
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

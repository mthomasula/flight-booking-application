package GUI;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class updateFlight {

	public void start(Stage primaryStage) {
		primaryStage.setTitle("Update Flight");
		
		Label flightIDL = new Label("Flight ID");
		TextField flightIDText = new TextField();

		Text updateLabel = new Text("Attribute to be updated:");
		ChoiceBox attributeBox = new ChoiceBox();
		attributeBox.getItems().addAll("flightNum", "Departure Date", "To", "From", "BoardingTime", "DepartureTime",
				"ArrivalTime", "FlightDuration", "DestinationAirport", "AirlineName", "Capacity", "Flight_Price");
		
		Label setTo = new Label("Set To:");
		TextField setToText= new TextField();
		
		
		Button enter= new Button("Submit");
		
		GridPane grid= new GridPane();
		grid.setHgap(5);
		grid.setVgap(5);
		grid.setPadding(new Insets(20,20,20,20));
		
		grid.add(flightIDL, 0, 0);
		grid.add(flightIDText, 1, 0);
		grid.add(updateLabel, 0, 1);
		grid.add(attributeBox, 1, 1);
		grid.add(setTo, 0, 2);
		grid.add(setToText, 1, 2);
		grid.add(enter, 1, 3);
		
		
		grid.setAlignment(Pos.CENTER);
		
		enter.setOnAction(f->{
			try {
			String updateValue= ((String)attributeBox.getValue());
			
			switch((String)attributeBox.getValue()){
			case "flightNum": updateValue="flightNum";
			break;
			case "Departure Date": updateValue="fDate";
			break;
			case "To":updateValue="fTo";
			break;
			case "From":updateValue="fFrom";
			break;
			case "BoardingTime":updateValue="BoardingTime";
			break;
			case "DepartureTime":updateValue="DepartureTime";
			break;
			case "ArrivalTime":updateValue="ArrivalTime";
			break;
			case "FlightDuration":updateValue="FlightDuration";
			break;
			case "DestinationAirport":updateValue="DestinationAirport";
			break;
			case "AirlineName":updateValue="AirlineName";
			break;
			case "Capacity":updateValue="Capacity";
			break;
			case "Flight_Price":updateValue="Flight_Price";
			break;
				
			}
		
			
			
				Connection connection = getConnection();
				// select query to run
				String str = "UPDATE  `flight` SET `"
						+ updateValue + "` = '" + setToText.getText().trim() + "' WHERE `flightID` = '"
						+ flightIDText.getText().trim() + "' ";
				
				// Prepare Statement
				Statement statement = connection.prepareStatement(str);

				// Execute Statement
				statement.executeUpdate(str);
				connection.close();
				AlertMessage.display("Flight updated", "Flight ID "+ flightIDText.getText()+" was updated successfully!");
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
			
			primaryStage.close();
		}});
		
		
		Scene scene=new Scene(grid, 600, 300);
		primaryStage.setTitle("Update Flight");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
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

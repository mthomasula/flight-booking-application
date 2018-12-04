package GUI;
import BusinessLogic.Administrator;
import BusinessLogic.Flight;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;



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
			
		}
		
		catch (Exception exe) {
			
		}
		
		userID.setAlignment(javafx.geometry.Pos.CENTER);
		userID.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
		userID.setLayoutX(970.0);
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
		refresh.setPrefHeight(25);
		refresh.setPrefWidth(90);
		refresh.setOnAction(e -> { 
			try {
				
			}
			catch (Exception ex) {
				
			}
		});
		
		logOut.setLayoutX(1100.0);
		logOut.setLayoutY(249.0);
		logOut.setMnemonicParsing(false);
		logOut.setPrefHeight(25);
		logOut.setPrefWidth(90);
		logOut.setText("Log Out");
		logOut.setOnAction(e -> {
			Login loginPage = new Login();
			try {
				loginPage.start(primaryStage);
				
			} catch (Exception ex) {
				
			}
		});
		
		
		
		
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
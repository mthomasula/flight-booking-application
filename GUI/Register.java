package GUI;

import BusinessLogic.Admin;
import BusinessLogic.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Database.AdminDB;
import Database.CustomerDB;

public class Register extends Application {
	@Override
	public void start(Stage Registrationstage) {
		Text fnameLabel = new Text("First Name: ");
		TextField fnameText = new TextField();

		Text mnameLabel = new Text("Middle Name:");
		TextField mnameText = new TextField();

		Text lnameLabel = new Text("Last Name:");
		TextField lnameText = new TextField();

		Text addressLabel = new Text("Address:");
		TextField addressText = new TextField();

		Text zipLabel = new Text("Zipcode:");
		TextField zipText = new TextField();

		Text stateLabel = new Text("State:");
		TextField stateText = new TextField();

		Text usernameLabel = new Text("Username:");
		TextField usernameText = new TextField();

		Text passwordLabel = new Text("Password:");
		TextField passwordText = new TextField();

		Text emailLabel = new Text("Email:");
		TextField emailText = new TextField();

		Text ssnLabel = new Text("SSN:XXX-XX-XXXX");
		TextField ssnText = new TextField();

		Text countryLabel = new Text("Country");
		TextField countryText = new TextField();

		Text securityQLable = new Text("Security question");
		ChoiceBox securityQBox = new ChoiceBox();
		securityQBox.getItems().addAll("What is my favorite color?", "What is my favorite pizza?",
				"What is my childhood pet's name?");

		Text securityALabel = new Text("Security answer:");
		TextField securityAText = new TextField();

		Text AdminPWLabel = new Text("Admin Password:");
		AdminPWLabel.setVisible(false);
		TextField AdminPWText = new TextField();
		AdminPWText.setVisible(false);
		Button enter = new Button("Enter");
		enter.setVisible(false);
		

		Button buttonRegisterUser = new Button("Customer Registration");
		Button buttonRegisterAdmin = new Button("Admin Registration");
		Button backtomain=new Button("Back to login");

		GridPane gridPane = new GridPane();
		gridPane.setMinSize(500, 500);
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setVgap(5);
		gridPane.setHgap(5);
		gridPane.setAlignment(Pos.CENTER);

		gridPane.add(fnameLabel, 0, 0);
		gridPane.add(fnameText, 1, 0);

		gridPane.add(mnameLabel, 0, 1);
		gridPane.add(mnameText, 1, 1);

		gridPane.add(lnameLabel, 0, 2);
		gridPane.add(lnameText, 1, 2);

		gridPane.add(addressLabel, 0, 3);
		gridPane.add(addressText, 1, 3);

		gridPane.add(zipLabel, 0, 4);
		gridPane.add(zipText, 1, 4);

		gridPane.add(stateLabel, 0, 5);
		gridPane.add(stateText, 1, 5);

		gridPane.add(countryLabel, 0, 6);
		gridPane.add(countryText, 1, 6);

		gridPane.add(usernameLabel, 0, 7);
		gridPane.add(usernameText, 1, 7);

		gridPane.add(passwordLabel, 0, 8);
		gridPane.add(passwordText, 1, 8);

		gridPane.add(emailLabel, 0, 9);
		gridPane.add(emailText, 1, 9);

		gridPane.add(ssnLabel, 0, 10);
		gridPane.add(ssnText, 1, 10);

		gridPane.add(securityQLable, 2, 0);
		gridPane.add(securityQBox, 3, 0);

		gridPane.add(securityALabel, 2, 1);
		gridPane.add(securityAText, 3, 1);

		gridPane.add(buttonRegisterAdmin, 3, 3);
		gridPane.add(buttonRegisterUser, 2, 3);
		gridPane.add(backtomain, 2, 4);
		
		gridPane.add(AdminPWLabel, 3, 4);
		gridPane.add(AdminPWText, 3, 5);
		gridPane.add(enter, 3, 6);
		gridPane.setStyle("-fx-background-color: LAVENDER;");
		Scene scene = new Scene(gridPane);
		Registrationstage.setTitle("Registration Form");
		Registrationstage.setScene(scene);
		Registrationstage.show();

		buttonRegisterUser.setOnAction(a -> {
			if(ssnText.getText().matches("\\d{3}-\\d{2}-\\d{4}")) {
			try {
				Customer customer = new Customer(fnameText.getText(), mnameText.getText(), lnameText.getText(),
						usernameText.getText(), passwordText.getText(), addressText.getText(), stateText.getText(),
						countryText.getText(), emailText.getText(), (String) securityQBox.getValue(),
						securityAText.getText(), ssnText.getText(), zipText.getText());
				CustomerDB.addUser(customer);
			} catch (Exception e) {
				AlertMessage.display("Registration Error", "Registration Error. Please make sure all information is correct and try again");

			}
			Registrationstage.close();
		}else{
			AlertMessage.display("SSN Error", "SSN Error. Please make sure SSN is in valid format (XXX-XX-XXXX) and try again");
		}});

		buttonRegisterAdmin.setOnAction(a -> {
			
			AdminPWLabel.setVisible(true);
			AdminPWText.setVisible(true);
			enter.setVisible(true);
		});
		
		enter.setOnAction(a->{

			if (Admin.getAdminPW().equals(AdminPWText.getText())) {

				enter.setOnAction(e -> {

					Admin admin = new Admin(fnameText.getText(), mnameText.getText(), lnameText.getText(),
							usernameText.getText(), passwordText.getText(), addressText.getText(), stateText.getText(),
							countryText.getText(), emailText.getText(), (String) securityQBox.getValue(),
							securityAText.getText(), ssnText.getText(), zipText.getText());
					try {
					AdminDB.addAdmin(admin);
					Registrationstage.close();
					}catch(Exception ex) {
						AlertMessage.display("Registration error", "Please make sure all information is correct and try again");
					}
				});

			} else {
				AlertMessage.display("Authentication Failure", "Please verify admin password needed to register as a new admin and try again");
			}
		});
		backtomain.setOnAction(b->{
			try {
				homepage h=new homepage();
				h.start(new Stage());
			}finally {
				Registrationstage.close();
			}
		});
		
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

	public static void main(String[] args) {
		launch(args);
	}
}

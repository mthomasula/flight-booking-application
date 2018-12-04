package GUI;
import javafx.scene.paint.Color;
import java.sql.*;

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class Login extends Application implements EventHandler<ActionEvent>{
	private static String user = "";
	private static String password = "";
	
	/*public Color(double r, double g, double b, double opecity); */
	
	
	
	public static String getUser() {
		return user;
	}
	
	public static void setUser(String user) {
		Login.user = user;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Login.password = password;
	}
	
	public static Scene scene;
	
	public static void main(String[] args) {
		
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		//primaryStage.setFill(new Color(RED);
		primaryStage.setTitle("Log In Window");
		primaryStage.setResizable(false);
		AnchorPane anchor = new AnchorPane();
		anchor.setPadding(new Insets(10, 10, 10, 10));

		Label loginLabel = new Label("Enter your username and password");
		loginLabel.setAlignment(javafx.geometry.Pos.CENTER);
		loginLabel.setLayoutX(144.0);
		loginLabel.setLayoutY(51.0);
		loginLabel.setPrefHeight(32.0);
		loginLabel.setPrefWidth(500.0);
		loginLabel.setText("Enter Your Username And Password");
		loginLabel.setTextAlignment(javafx.scene.text.TextAlignment.LEFT);
		loginLabel.setFont(new Font(22.0));
		
		Label usernameLabel = new Label("Username:");
		usernameLabel.setLayoutX(267.0);
		usernameLabel.setLayoutY(131.0);
		usernameLabel.setText("Username:");
		usernameLabel.setFont(new Font(20.0));
		
		TextField userTxt = new TextField();
		userTxt.setLayoutX(370.0);
		userTxt.setLayoutY(133.0);
		userTxt.setPromptText("Username");
		
		Label passwordLabel = new Label("Password:");
		passwordLabel.setLayoutX(270.0);
		passwordLabel.setLayoutY(174.0);
		passwordLabel.setFont(new Font(20.0));

		PasswordField passwordTxt = new PasswordField();
		passwordTxt.setLayoutX(370.0);
		passwordTxt.setLayoutY(177.0);
		passwordTxt.setPromptText("Password");
		passwordTxt.setOnAction(e -> {
			try {
				
			}
			catch (Exception ex) {
				
			}
		});
		
		
		Button login = new Button("Log In");
		login.setLayoutX(370.0);
		login.setLayoutY(222.0);   
		login.setMnemonicParsing(false);
		login.setPrefHeight(25.0);
		login.setPrefWidth(150.0);
		login.setText("Log In");
		
		login.setOnAction(e -> {
			
			try {
				
				
				Connection myConn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/flightdatabase", "root",
						"password");
			
				Statement myStat = myConn.createStatement();
				
				ResultSet myRs;

				
				setUser(userTxt.getText().trim());

				
				setPassword(passwordTxt.getText().trim());

				
				String sqlUserCheck = "SELECT username FROM Users where username = '" + getUser()
						+ "' and pass = '" + getPassword() + "'";
				myRs = myStat.executeQuery(sqlUserCheck);

				
				int count = 0;

				
				while (myRs.next()) {

					count = count + 1;

				}

				myRs.close();
				myStat.close();
				myConn.close();

				
				if (count == 1) {
					MainPage MainPage = new MainPage();
					MainPage.start(primaryStage);
					

				}

				
				else if (count < 1) {
					AlertBox.display("Incorrect Log In",
							"Username and password conflict. Select the 'Forgot Password' option if needed.");
				}

			}
				
			
				
			
			catch(Exception ex) {
				
			}
		});
		
		Button register = new Button("Register");
		register.setLayoutX(370.0);
		register.setLayoutY(255.0);
		register.setMnemonicParsing(false);
		register.setPrefHeight(25.0);
		register.setPrefWidth(150.0);
		register.setOnAction(e -> {
			Registration registerPage = new Registration();
			try {
				registerPage.start(primaryStage);
				
			}
			catch(Exception ex) {
				
			}
		});
		
		Button passwordRecover = new Button("Forgot Password");
		passwordRecover.setLayoutX(370.0);
		passwordRecover.setLayoutY(290.0);
		passwordRecover.setMnemonicParsing(false);
		passwordRecover.setPrefHeight(25.0);
		passwordRecover.setPrefWidth(150.0);
		passwordRecover.setOnAction(e -> {
			PasswordRecovery recoverPassword = new PasswordRecovery();
			try {

				recoverPassword.start(primaryStage);
				
			}

			catch (Exception ex) {
			}
		});
		
		
		Button exit = new Button("Exit");
		exit.setLayoutX(370.0);
		exit.setLayoutY(328.0);
		exit.setMnemonicParsing(false);
		exit.setPrefHeight(25.0);
		exit.setPrefWidth(150.0);
		exit.setOnAction(e -> {
			System.exit(0);
		});
		
		exit.setMinWidth(150);
		register.setMinWidth(150);
		passwordRecover.setMinWidth(150);
		login.setMinWidth(150);
		
		anchor.getChildren().addAll(userTxt, passwordTxt, login, register, passwordRecover, usernameLabel, exit,
				loginLabel, passwordLabel);
		scene = new Scene(anchor, 825, 500);
		;
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.centerOnScreen();



	}
	
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
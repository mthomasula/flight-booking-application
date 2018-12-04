package GUI;

import java.sql.*;
import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class GetQuestion extends Application implements EventHandler<ActionEvent>{
	
	public static void main(String[] args) {
		
		launch(args);
	}
	String user = PasswordRecovery.user;
	
	String secQuest = "";
	
	String secAns ="";
	
	String userAns = "";
	
	String password = "";
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Security Question");
		primaryStage.setResizable(false);
		GridPane grid = new GridPane();
		// grid.setGridLinesVisible(true);
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(10);
		grid.setHgap(10);

		try {
			
			Connection myConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/airlinedatabase", "root",
					"confident");
			
			Statement myStat = myConn.createStatement();
			
			ResultSet myRs;
			String sqlUserCheck = "SELECT `security_question` FROM `Users` where username = '" + user + "'";
			myRs = myStat.executeQuery(sqlUserCheck);

			
			int count = 0;

			while (myRs.next()) {

				count += 1;

				secQuest = myRs.getString("security_question");

				
				secAns = myRs.getString("security_answer");

				
				password = myRs.getString("password");
			}
			myStat.close();
			myRs.close();
			myConn.close();
		
			if (count == 1) {

			}

		}
		catch (Exception ex) {
			
		}
		
		Label securityQuestionLabel = new Label("Enter The Answer To Your Security Question Below.");
		GridPane.setConstraints(securityQuestionLabel, 1, 0);
		grid.setAlignment(Pos.TOP_CENTER);
		securityQuestionLabel.setTextAlignment(TextAlignment.CENTER);

		Label questionLabel = new Label(secQuest);
		GridPane.setConstraints(questionLabel, 1, 1);

		TextField answerField = new TextField();
		GridPane.setConstraints(answerField, 1, 2);

		Button okay = new Button("Okay");
		GridPane.setConstraints(okay, 1, 3);
		GridPane.setHalignment(okay, HPos.LEFT);
		okay.setOnAction(e -> {
			try {
				
				
				String userAnswer = answerField.getText().trim();
				Connection myConn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/airlinedatabase", "root",
						"confident");
			
				Statement myStat = myConn.createStatement();
				
				ResultSet myRs;
				String sqlUserCheck = "SELECT * FROM `Users` where username = '" + user + "'";
				myRs = myStat.executeQuery(sqlUserCheck);

				
				int count = 0;

				while (myRs.next()) {

					count += 1;

					
					secAns = myRs.getString("security_answer");

					password = myRs.getString("pass");
				}

				myRs.close();
				myStat.close();
				myConn.close();
				
				if (count == 1 && userAnswer.equals(secAns)) {
					AlertBox.display("Password", "The password for your account is: " + password);

				} else if (count == 1 && secAns != userAnswer) {
					AlertBox.display("Incorrect Answer", "That answer is incotrrect. Please try again.");
				}

			}

			catch(Exception ex){
				
			}
		});
		
		Button cancel = new Button("cancel");
		GridPane.setConstraints(cancel, 1, 3);
		GridPane.setHalignment(cancel, HPos.RIGHT);
		cancel.setOnAction(e -> {
			{
				PasswordRecovery recoverPage = new PasswordRecovery();
				try {

					recoverPage.start(primaryStage);
				}

				catch (Exception ex) {
				}
			}
		});
		
		okay.setMinWidth(120);
		cancel.setMinWidth(120);
		grid.getChildren().addAll(securityQuestionLabel, questionLabel, answerField, okay, cancel);
		Scene scene = new Scene(grid, 550, 150);

		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.centerOnScreen();
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
			
			
		
}

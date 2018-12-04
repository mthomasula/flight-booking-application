package GUI;
import java.sql.*;

import GUI_Database.Login;
import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class ForgottenPassword extends Application implements EventHandler<ActionEvent> {
	
	public static String user = "";
	
	public static void main(String[] args) {
		launch(args);
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Recover Password");
		primaryStage.setResizable(false);
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(10);
		grid.setHgap(10);

		Label passwordRecoverLabel = new Label("Recover Your Password");
		GridPane.setConstraints(passwordRecoverLabel, 1, 0);
		grid.setAlignment(Pos.TOP_CENTER);
		GridPane.setHalignment(passwordRecoverLabel, HPos.CENTER);

		Label usernameLabel = new Label("Enter Your Username Below");
		GridPane.setConstraints(usernameLabel, 1, 1);
		grid.setAlignment(Pos.TOP_CENTER);
		GridPane.setHalignment(usernameLabel, HPos.CENTER);

		TextField username = new TextField();
		GridPane.setConstraints(username, 1, 2);
		grid.setAlignment(Pos.CENTER);

		Button recover = new Button("Recover Password");
		GridPane.setConstraints(recover, 1, 4);
		recover.setOnAction(e -> {
			
			try {
				
			}
			catch (Exception ex){
				
			}
			
		});
		
		Button login = new Button("Return To Log In");
		GridPane.setConstraints(login, 1, 5);
		login.setOnAction(e -> {
			Login loginPage = new Login();
			try {

				loginPage.start(primaryStage);
			}

			catch (Exception ex) {
			}
		});
		
		login.setMinWidth(150);
		recover.setMinWidth(150);

		Scene scene = new Scene(grid, 320, 350);

		grid.getChildren().addAll(passwordRecoverLabel, usernameLabel, username, recover, login);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.centerOnScreen();
		

		
	}
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub

	}

	

}
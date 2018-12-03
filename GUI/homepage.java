package GUI;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import GUI.Register;



import javafx.application.Application;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class homepage extends Application  {
	private static String usr="";
	private static String pw="";
@Override
public void start(Stage primaryStage) {
	primaryStage.setTitle("WrightFlights ARS Main Menu");
	
	Label LUsername= new Label("Username");
	TextField username= new TextField();
	Label LPassword= new Label("Password");
	PasswordField password= new PasswordField();
	
	Button login = new Button("Login");
	Button loginAdmin= new Button("Login Admin");
	Button register = new Button("Register");
	Button UserForgotPW = new Button("User Password Retrival");
	Button AdminForgotPW= new Button("Admin Password Retrival");
	
	GridPane grid= new GridPane();
	grid.setHgap(5);
	grid.setVgap(5);
	grid.setPadding(new Insets(20,20,20,20));
	
	grid.add(LUsername, 0, 0);
	grid.add(username, 1, 0);
	grid.add(LPassword, 0, 1);
	grid.add(password, 1, 1);
	grid.add(login, 0, 3);
	grid.add(register, 2, 3);
	grid.add(loginAdmin, 1, 3);
	grid.add(UserForgotPW, 1, 4);
	grid.add(AdminForgotPW, 2, 4);
	
	grid.setAlignment(Pos.CENTER);
	username.setAlignment(Pos.BOTTOM_RIGHT);
	password.setAlignment(Pos.BOTTOM_LEFT);
	
	GridPane.setHalignment(login, HPos.LEFT);
	GridPane.setHalignment(loginAdmin, HPos.CENTER);
	GridPane.setHalignment(register, HPos.RIGHT);
	
	Scene scene=new Scene(grid, 600, 300);
	primaryStage.setTitle("Login");
	primaryStage.setScene(scene);
	primaryStage.show();
	
	UserForgotPW.setOnAction(b->{
		CustomerForgotPassword pw = new CustomerForgotPassword();
		pw.start(new Stage());
	});
	
	AdminForgotPW.setOnAction(d->{
		AdminForgotPassword pw = new AdminForgotPassword();
		pw.start(new Stage());
	});
	register.setOnAction(e->{
		
		try {
		Register user= new Register();
		user.start(new Stage());
	}finally{
		primaryStage.close();
	}
		
	});
	
	
	loginAdmin.setOnAction(b->{
		try {
			Connection connection = getConnection();
			
			String pw= password.getText().trim();
			String usr= username.getText().trim();
	
					String str= "SELECT APassword FROM Admin WHERE UserName ='"+usr+"'";
					
					// Prepare Statement
					PreparedStatement statement = connection.prepareStatement(str);

					// Execute Statement
					ResultSet resultSet = statement.executeQuery();
				
					while(resultSet.next()) {
					
						if(resultSet.getString(1).equals(pw)) { 
							try {
								AdminMain aM= new AdminMain();
								aM.start(new Stage());
							}finally{
								primaryStage.close();
							}
						}
							else
						AlertMessage.display("Incorrect Login", "Username or password is incorrect. Please try again");}
					 connection.close();
					} catch (Exception ex) {

				} 
	});
	
	
	login.setOnAction(a-> {
		
		try {
			
			Connection connection = getConnection();
			
			pw= password.getText().trim();
			setUsr(username.getText().trim());
		

					String str= "SELECT CPassword FROM Customer WHERE CUsername ='"+getUsr()+"'";
					
					// Prepare Statement
					PreparedStatement statement = connection.prepareStatement(str);

					// Execute Statement
					ResultSet resultSet = statement.executeQuery();
				
					while(resultSet.next()) {
					
						if(resultSet.getString(1).equals(pw)) {
							try {
								CustomerMain cM= new CustomerMain();
								cM.start(new Stage());
							}finally{
								primaryStage.close();
							}
						} else {	
							AlertMessage.display("Incorrect Login", "Username or password is incorrect. Please try again");}
					 connection.close();}
					} catch (Exception ex) {

				} 
		
		});
	
	
	}
	public static Connection getConnection() {
		Connection connection=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://flightproject.cwnzf8egwsfw.us-east-2.rds.amazonaws.com:3306/flightproject", "root", "password"); 
		}catch(Exception e) {
			System.out.println("Cannot connect");
		}
		return connection;
		
		
	}
	public static void main(String[] args) {
		launch(args);
	}
	public static String getUsr() {
		return usr;
	}
	public static void setUsr(String usr) {
		homepage.usr = usr;
	}
}

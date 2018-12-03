package GUI;

	import BusinessLogic.Administrator;
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
	import Database.AdministratorDB;
	import Database.CustomerDB;

	public class Registration extends Application {
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
					Customer customer = new Customer(fnameText.getText(), /*mnameText.getText(),*/ lnameText.getText(),
							usernameText.getText(), passwordText.getText(), addressText.getText(), stateText.getText(), 
							import java.sql.Connection;
							import java.sql.DriverManager;
							import java.sql.PreparedStatement;
							import java.sql.ResultSet;
							import java.sql.SQLException;

							import BusinessLogic.Flight;
							import Database.AdminDB;
							import Database.BookingDB;
							import Database.CustomerDB;
							import javafx.application.Application;
							import javafx.collections.FXCollections;
							import javafx.collections.ObservableList;
							import javafx.event.ActionEvent;
							import javafx.event.EventHandler;
							import javafx.geometry.Insets;
							import javafx.scene.Scene;
							import javafx.scene.control.Button;
							import javafx.scene.control.TableColumn;
							import javafx.scene.control.TableView;
							import javafx.scene.control.cell.PropertyValueFactory;
							import javafx.scene.layout.AnchorPane;
							import javafx.stage.Stage;

							public class viewBookings extends Application implements EventHandler<ActionEvent>{
								
								
								public void start(Stage primaryStage) throws Exception {

									primaryStage.setTitle("View Booked Flights");
									AnchorPane anchor = new AnchorPane();
									anchor.setPadding(new Insets(20, 20, 20, 20));
									TableView<Flight> table = new TableView<>();
									final ObservableList<Flight> data = FXCollections.observableArrayList();

									
									Button userView = new Button("Main page");
									userView.setOnAction(a -> {
										if (AdminDB.isAdmin(homepage.getUsr())) {
											primaryStage.close();
											AdminMain main = new AdminMain();
											main.start(new Stage());
										} else {
											primaryStage.close();
											CustomerMain cmain = new CustomerMain();
											cmain.start(new Stage());

										}
									});
									
									TableColumn<Flight, String> column1 = new TableColumn<Flight, String>("Flight#");
									column1.setCellValueFactory(new PropertyValueFactory<>("flightNum"));
									column1.setMinWidth(80);
									TableColumn<Flight, String> column2 = new TableColumn<Flight, String>("Departure Date");
									column2.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
									column2.setMinWidth(100);
									TableColumn<Flight, String> column3 = new TableColumn<Flight, String>("Departure Time");
									column3.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
									column3.setMinWidth(100);
									TableColumn<Flight, String> column4 = new TableColumn<Flight, String>("Arrival Time");
									column4.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
									column4.setMinWidth(100);
									TableColumn<Flight, String> column5 = new TableColumn<Flight, String>("Flight Duration");
									column5.setCellValueFactory(new PropertyValueFactory<>("flightDuration"));
									column5.setMinWidth(100);
									TableColumn<Flight, String> column6 = new TableColumn<Flight, String>("To");
									column6.setCellValueFactory(new PropertyValueFactory<>("to"));
									column6.setMinWidth(115);
									TableColumn<Flight, String> column7 = new TableColumn<Flight, String>("From");
									column7.setCellValueFactory(new PropertyValueFactory<>("from"));
									column7.setMinWidth(115);
									TableColumn<Flight, String> column8 = new TableColumn<Flight, String>("Airline");
									column8.setCellValueFactory(new PropertyValueFactory<>("airlineName"));
									column8.setMinWidth(80);
									TableColumn<Flight, Integer> column9 = new TableColumn<Flight, Integer>("Capacity");
									column9.setCellValueFactory(new PropertyValueFactory<>("capacity"));
									column9.setMinWidth(75);
									TableColumn<Flight, Integer> column10 = new TableColumn<Flight, Integer>("#Booked");
									column10.setCellValueFactory(new PropertyValueFactory<>("numBooked"));
									column10.setMinWidth(75);
									TableColumn<Flight, String> column11 = new TableColumn<Flight, String>("Destination Airport");
									column11.setCellValueFactory(new PropertyValueFactory<>("destinationAirport"));
									column11.setMinWidth(128.88);
									TableColumn<Flight, Double> column12 = new TableColumn<Flight, Double>("Flight Price");
									column12.setCellValueFactory(new PropertyValueFactory<>("flight_price"));
									column12.setMinWidth(80);
									TableColumn<Flight, String> column13 = new TableColumn<Flight, String>("Boarding Time");
									column13.setCellValueFactory(new PropertyValueFactory<>("boardingTime"));
									column13.setMinWidth(110);
									table.setTableMenuButtonVisible(false);
									TableColumn<Flight, String> column14 = new TableColumn<Flight, String>("FlightID");
									column14.setCellValueFactory(new PropertyValueFactory<>("flightID"));
									column14.setMinWidth(80);
									
									Button searchB = new Button("Search Flights");
									searchB.setLayoutX(1050);
									searchB.setLayoutY(60.0);
									searchB.setMinWidth(100);

									searchB.setOnAction(s -> {
										
												try {
													Connection connection = getConnection();
												String str = "SELECT * FROM Booking WHERE Cssn = '" + CustomerDB.getUserSSN(homepage.getUsr()) + "';";
												PreparedStatement statement = connection.prepareStatement(str);

												ResultSet myResult = statement.executeQuery();
												table.getItems().clear();

												if (!myResult.next()) {
													AlertMessage.display("No Flights Found",
															"No flights were found");
												}
												while (myResult.next()) {
													data.add(new Flight(myResult.getString("flightNum"), myResult.getString("fDate"),
															myResult.getString("DepartureTime"), myResult.getString("ArrivalTime"),
															myResult.getString("FlightDuration"), myResult.getString("fTo"),
															myResult.getString("fFrom"), myResult.getString("AirlineName"),
															myResult.getInt("capacity"), myResult.getInt("BookedNum"),
															myResult.getString("DestinationAirport"), myResult.getString("Flight_Price"),
															myResult.getString("BoardingTime"), myResult.getString(1)));
													table.setItems(data);
												}
												statement.close();
												myResult.close();
												connection.close();
												

											} catch (SQLException a) {
												System.out.println(a.getMessage());
											} catch (Exception e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}finally {
												
												} 
											
										});

									table.setLayoutX(20);
									table.setLayoutY(100);
									table.setMinWidth(1020);
									table.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9,
											column10, column11, column12, column13, column14);
									anchor.getChildren().addAll( searchB, table, userView);
									Scene scene = new Scene(anchor, 1600, 900);

									

									primaryStage.setScene(scene);
									primaryStage.show();
								}
									public static Connection getConnection() throws Exception{
										try {
										Class.forName("com.mysql.jdbc.Driver");
										Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/WrightFlights?useSSL=false", "root",
												"root");
										return connection;
										}catch(Exception e) {
											e.printStackTrace();
										}
										return null;
									}
									@Override
									public void handle(ActionEvent event) {
										// TODO Auto-generated method stub
										
									}
									
									
							}
							countryText.getText(), emailText.getText(), (String) securityQBox.getValue(),
							securityAText.getText(), ssnText.getText());
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

				if (Administrator.getAdministratorPassword().equals(AdminPWText.getText())) {

					enter.setOnAction(e -> {

						Administrator admin = new Administrator(fnameText.getText(), mnameText.getText(), lnameText.getText(),
								usernameText.getText(), passwordText.getText(), addressText.getText(), stateText.getText(),
								countryText.getText(), emailText.getText(), (String) securityQBox.getValue(),
								securityAText.getText(), ssnText.getText(), zipText.getText());
						try {
						AdministratorDB.addAdministrator(admin);
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
				connection = DriverManager.getConnection("jdbc:mysql://localhost/WrightFlights?useSSL=false", "root",
						"root");
			} catch (Exception e) {
				System.out.println("Cannot connect");
			}
			return connection;

		}

		public static void main(String[] args) {
			launch(args);
		}
	}
}

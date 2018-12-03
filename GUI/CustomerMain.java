package GUI;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import GUI.viewBookings;

public class CustomerMain extends Application{
	public static void main(String [] args) {
		launch(args);
	}
@Override
public void start(Stage primaryStage) {
	primaryStage.setTitle("Welcome User");
	

	
	GridPane grid= new GridPane();
	grid.setHgap(5);
	grid.setVgap(5);
	grid.setPadding(new Insets(20,20,20,20));
	
	Button searchFlights=new Button("Search Flights");
	Button viewBookings=new Button("View Booked Flights");
	Button logout= new Button("Log out");
	Button removeFlight= new Button("Remove Flight");
	
	grid.add(searchFlights, 0, 0);
	grid.add(logout, 0, 3);
	grid.add(removeFlight, 0, 2);
	grid.add(viewBookings, 0,1);
	
	grid.setAlignment(Pos.CENTER);
	grid.setStyle("-fx-background-color: LAVENDER;");
	
	Scene scene=new Scene(grid, 600, 300);
	primaryStage.setTitle("Welcome User");
	primaryStage.setScene(scene);
	primaryStage.show();
	
	viewBookings.setOnAction(p->{
		viewBookings main=new viewBookings();
		try {
			main.start(primaryStage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	});
	removeFlight.setOnAction(f->{
		try {
		UserRemoveFlight main=new UserRemoveFlight();
		main.start(new Stage());
		}catch(Exception e) {
			
		}
		finally {
			primaryStage.close();
		}
	});
	
	
	searchFlights.setOnAction(a->{
		try {
			SearchFlights sf=new SearchFlights();
			sf.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			primaryStage.close();
		}
	});
	logout.setOnAction(b->{
		try {
			homepage hp=new homepage();
			hp.start(new Stage());
		}finally {
			primaryStage.close();
		}
	});
}

}

package GUI;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	
    public static void main(String[] args) {
    	launch(args);
    }

    SplashScreenController spashScreen = new SplashScreenController();

    @Override
    public void start(Stage primaryStage) {
	
	//Scene
	Scene scene = new Scene(new BorderPane(), 1224, 968);
	

	//Primary Stage
	primaryStage.setTitle("Flight App");
	primaryStage.setScene(scene);

	//Show the SplashScreen
	spashScreen.showWindow();

	PauseTransition splashScreenDelay = new PauseTransition(Duration.seconds(5));
	splashScreenDelay.setOnFinished(y -> {
	    primaryStage.show();
	    spashScreen.hideWindow();
	    
	    homepage main= new homepage();
	    main.start(primaryStage);
	});
	
	splashScreenDelay.playFromStart();
    }
    

}
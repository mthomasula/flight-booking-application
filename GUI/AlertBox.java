package GUI;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.*;

public class AlertBox {
	public static void display (String title, String message) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		
		Text label = new Text(message);
		label.setTextAlignment(TextAlignment.CENTER);
		
		Button okay = new Button("OK");
		okay.setOnAction(e -> {window.close();});
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, okay);
		
		Scene scene = new Scene(layout, 500, 100);
		window.setScene(scene);
		window.showAndWait();
		
		
	}

}
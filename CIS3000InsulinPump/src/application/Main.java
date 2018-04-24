package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.stage.WindowEvent;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage){
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("CIS3000InsulinPumpView.fxml"));
			Scene scene = new Scene(root,800,600);
			primaryStage.setTitle("CIS 3300 Starter Project");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}

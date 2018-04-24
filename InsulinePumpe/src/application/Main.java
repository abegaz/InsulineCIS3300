package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/NewView.fxml"));
			Scene scene = new Scene(root,1000,800);
			primaryStage.setTitle("Sprint 2 Insulin Pump");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
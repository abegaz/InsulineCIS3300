package edu.ung.cis.cis3000.Sprint01.model;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Sprint02Model {

	   private final TableView table = new TableView();
	    public static void main(String[] args) {
	        launch(args);
	    }

	    @Override
	    public void start(Stage stage) {
	        Scene scene = new Scene(new Group());
	        stage.setTitle("Insulin Pump");
	        stage.setWidth(300);
	        stage.setHeight(500);

	        final Label label = new Label("Address Book");
	        label.setFont(new Font("Arial", 20));

	        table.setEditable(true);

	        TableColumn firstNameCol = new TableColumn("First Name");
	        TableColumn lastNameCol = new TableColumn("Last Name");
	        TableColumn emailCol = new TableColumn("Email");

	        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

	        final VBox vbox = new VBox();
	        vbox.setSpacing(5);
	        vbox.setPadding(new Insets(10, 0, 0, 10));
	        vbox.getChildren().addAll(label, table);

	        ((Group) scene.getRoot()).getChildren().addAll(vbox);

	        stage.setScene(scene);
	        stage.show();
	    }


	//---------------------------------------------------------------------------------------------------
	private String basalAmount;
	private String foodAmount;
	private String bolusAmount;
	private String PLACEHOLDER;
	private int patientId;


	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}


	public Sprint02Model(int patientId) {
		super();
		this.patientId = patientId;
	}
	public Sprint02Model(String basalAmount, String foodAmount, String bolusAmount, String PLACEHOLDER) {
		super();
		this.basalAmount = basalAmount;
		this.foodAmount = foodAmount;
		this.bolusAmount = bolusAmount;
		this.PLACEHOLDER = PLACEHOLDER;
	}


	public String getBasalAmount() {
		return basalAmount;
	}
	public void setBasalAmount(String firstName) {
		this.basalAmount = firstName;
	}


	public String getFoodAmount() {
		return foodAmount;
	}
	public void setFoodAmount(String lastName) {
		this.foodAmount = lastName;
	}


	public String getBolusAmount() {
		return bolusAmount;
	}
	public void setBolusAmount(String state) {
		this.bolusAmount = state;
	}


	public String getPLACEHOLDER() {
		return PLACEHOLDER;
	}
	public void setPLACEHOLDER(String party) {
		this.PLACEHOLDER = party;
	}

/*
	public String getWhenTaken() {
		return whenTaken;
	}
	public void setWhenTaken(String whentaken) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.whentaken = dateFormat.format(date);
		this.whentaken = whenTaken;
	}
*/

}

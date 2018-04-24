package csis.cis3300.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import csis.cis3300.Model.Patient;  
import application.DatabaseConnector;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Sprint2Controller {
	//These instance variables are used to create new poll objects
    @FXML private TextField txtBolusAmount;
    @FXML private TextField txtFoodAmount;
    @FXML private TextField txtBasalAmount;
    @FXML private TextField txtDateTime;

	public void onChanges()
    {

		  System.out.println("Hello World");
        Patient patient = new Patient(txtBolusAmount.getText(),
        		txtFoodAmount.getText(),
        		txtBasalAmount.getText(),
        		txtDateTime.getText()
        		);

        System.out.println(patient.toString());

        String query = "insert into patient " + "(BolusAmount, FoodAmount, BasalAmount, DateTime)"
				+ "values(?,?,?,?)";

		try (Connection conn = DatabaseConnector.getConnection();
				PreparedStatement insertpatient = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {

			insertpatient.setString(1, patient.getBolusAmount());
			insertpatient.setString(2, patient.getFoodAmount());
			insertpatient.setString(3, patient.getBasalAmount());
			insertpatient.setString(4, patient.getDateTime());
			// get the number of return rows
			int affectedRow = insertpatient.executeUpdate();

			if (affectedRow == 1) {
				System.out.println("Operation is successful");
				txtBolusAmount.setText("");
				txtFoodAmount.setText("");
				txtBasalAmount.setText("");
				txtDateTime.setText("");

			}

		} catch (Exception e) {
			System.out.println("Status: operation failed due to "+e);

		}

		}

}



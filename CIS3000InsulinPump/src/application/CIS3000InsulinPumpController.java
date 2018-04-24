package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import application.CIS3000InsulinPumpModel;
import application.DatabaseConfig;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CIS3000InsulinPumpController {
	//These instance variables are used to create new poll objects
    @FXML private TextField txtBolusAmount;
    @FXML private TextField txtFoodAmount;
    @FXML private TextField txtBasalAmount;

	public void touchRegister()
    {

        CIS3000InsulinPumpModel c3ipm = new CIS3000InsulinPumpModel(txtBolusAmount.getText(),
                                      txtFoodAmount.getText(),
                                      txtBasalAmount.getText());

        System.out.println(c3ipm.toString());

        String query = "insert into poll " + "(bolusAmount, foodAmount, basalAmount)"
				+ "values(?,?,?)";

		try (Connection conn = DatabaseConfig.getConnection();
				PreparedStatement insertc3ipm = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {

			insertc3ipm.setString(1, c3ipm.getBolusAmount());
			insertc3ipm.setString(2, c3ipm.getFoodAmount());
			insertc3ipm.setString(3, c3ipm.getBasalAmount());
			// get the number of return rows
			int affectedRow = insertc3ipm.executeUpdate();

			if (affectedRow == 1) {
				System.out.println("Operation is successful");
				txtBolusAmount.setText("");
				txtFoodAmount.setText("");
				txtBasalAmount.setText("");
			}

		} catch (Exception e) {
			System.out.println("Status: operation failed due to "+e);

		}

		}
}
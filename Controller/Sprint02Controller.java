package edu.ung.cis.cis3000.Sprint01.controller;

import javafx.scene.control.TableColumn;

public class Sprint02Controller {
	//These instance variables are used to create new poll objects
	//code adjusted through line: 40
    @FXML private TextField txtBasalAmount;
    @FXML private TextField txtFoodAmount;
    @FXML private TextField txtBolusAmount;
    @FXML private TextField txtPLACEHOLDER;
    @FXML private Button buttonSubmitChanges;
    @FXML private TableColumn columnBasalChange;
    @FXML private TableColumn<S, T> columnFoodChange;
    @FXML private TableColumn columnBolusChange;

	public void touchRegister()
    {

		  System.out.println("Hello wolrsdsdfdsf");
        Sprint02Model s2m = new Sprint02Model(txtBasalAmount.getText(),
        		txtFoodAmount.getText(),
        		txtBolusAmount.getText(),
        		txtPLACEHOLDER.getText());

        System.out.println(s2m.toString());

        String query = "insert into poll " + "(basalAmount, foodAmount, bolusAmount, party)"
				+ "values(?,?,?,?)";

		try (Connection conn = DatabaseConfig.getConnection();
				PreparedStatement insertpoll = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {

			insertpoll.setString(1, s2m.getBasalAmount());
			insertpoll.setString(2, s2m.getFoodAmount());
			insertpoll.setString(3, s2m.getbolusAmount());
			insertpoll.setString(4, s2m.getPLACEHOLDER());
			// get the number of return rows
			int affectedRow = insertpoll.executeUpdate();

			if (affectedRow == 1) {
				System.out.println("Operation is successful");
				txtBasalAmount.setText("");
				txtFoodAmount.setText("");
				txtBolusAmount.setText("");
				txtPLACEHOLDER.setText("");



			}

		} catch (Exception e) {
			System.out.println("Status: operation failed due to "+e);

		}

		}

}

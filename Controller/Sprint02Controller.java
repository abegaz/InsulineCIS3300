package edu.ung.cis.cis3000.Sprint01.controller;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.util.Date;

import java.util.Timer;
import java.util.TimerTask;
import java.text.SimpleDateFormat;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import edu.ung.cis.cis3000.Sprint01.model.Sprint02Model;


public class Sprint02Controller {
	//These instance variables are used to create new poll objects
    @FXML
    private TextField txtBasalAmount;
    @FXML
    private TextField txtFoodAmount;
    @FXML
    private TextField txtBolusAmount;
    @FXML
    private TextField txtPLACEHOLDER;
    @FXML
    private Button buttonSubmitChanges;
    @FXML
    private TableColumn columnBasalChange;
    @FXML
    private TableColumn<S, T> columnFoodChange;
    @FXML
    private TableColumn columnBolusChange;
    @FXML
    private TableCell

@Override
    @SuppressWarnings("unchecked")
    public TableCell<S, T> call(TableColumn<S, T> p) {
        TableCell<S, T> cell = new TableCell<S, T>() {
            @Override
            public void updateItem(Object item, boolean empty) {
                if (item == getItem()) {
                    return;
                }
                super.updateItem((T) item, empty);
                if (item == null) {
                    super.setText(null);
                    super.setGraphic(null);
                } else if (format != null) {
                    super.setText(format.format(item));
                } else if (item instanceof Node) {
                    super.setText(null);
                    super.setGraphic((Node) item);
                } else {
                    super.setText(item.toString());
                    super.setGraphic(null);
                }
            }
        };
        cell.setTextAlignment(alignment);
        switch (alignment) {
            case CENTER:
                cell.setAlignment(Pos.CENTER);
                break;
            case RIGHT:
                cell.setAlignment(Pos.CENTER_RIGHT);
                break;
            default:
                cell.setAlignment(Pos.CENTER_LEFT);
                break;
        }
        return cell;
    }
}


/*
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
*/
}

package edu.ung.cis.cis3000.SprintOne.controller;

import javafx.scene.control.TextField;

public class SprintOneController {

	//fx:id tags
	@FXML private TextField amountTaken;
	@FXML private TextField basalbutton;
	@FXML private TextField whenTaken;
	@FXML private TextField actionDisplay;
	@FXML private TextField preActionLevel;
	@FXML private TextField postActionLevel;
	@FXML private TextField amountDisplay;



	public void basalAction(int amount)//administer basal insulin
	{

	}

	public void ontouch()//stop button
	{

	}

	public void eatFood()//eat food button
	{

	}

	public void setAmountTaken(int amount)//bolus insulin button
	{
		amount = amountTaken;
		currentLevel = currentLevel + amount;
	}


}

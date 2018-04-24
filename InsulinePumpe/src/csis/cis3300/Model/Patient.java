package csis.cis3300.Model;

public class Patient {
private String bolusAmount;
private String foodAmount;
private String basalAmount;
private String dateTime;

public Patient(String bolusAmount, String foodAmount, String basalAmount, String dateTime) {
	super();
	this.bolusAmount = bolusAmount;
	this.foodAmount = foodAmount;
	this.basalAmount = basalAmount;
	this.dateTime = dateTime;
}
public String getBolusAmount() {
	return bolusAmount;
}
public void setBolusAmount(String bolusAmount) {
	this.bolusAmount = bolusAmount;
}
public String getFoodAmount() {
	return foodAmount;
}
public void setFoodAmount(String foodAmount) {
	this.foodAmount = foodAmount;
}
public String getBasalAmount() {
	return basalAmount;
}
public void setBasalAmount(String basalAmount) {
	this.basalAmount = basalAmount;
}
public String getDateTime() {
	return dateTime;
}
public void setDateTime(String dateTime) {
	this.dateTime = dateTime;
}

}

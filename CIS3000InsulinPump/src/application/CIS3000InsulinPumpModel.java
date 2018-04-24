package application;

public class CIS3000InsulinPumpModel {
	private String bolusAmount;
	private String foodAmount;
	private String basalAmount;
	private int patientId;
	public int getpatientId() {
		return patientId;
	}
	public void setpatientId(int patientId) {
		this.patientId = patientId;
	}
	public CIS3000InsulinPumpModel(int patientId) {
		super();
		this.patientId = patientId;
	}
	public CIS3000InsulinPumpModel(String bolusAmount, String foodAmount, String basalAmount) {
		super();
		this.bolusAmount = bolusAmount;
		this.foodAmount = foodAmount;
		this.basalAmount = basalAmount;
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

}

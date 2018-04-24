package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CIS3000InsulinPumpModel {
	String url = "jdbc:mysql://localhost:3306/cis3000insulinpump_db";
	String user = "root";
	String password = "";

	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;
	private int bsValue;

	private String bolusAmount;
	private String foodAmount;
	private String basalAmount;
	private String patientId;
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public CIS3000InsulinPumpModel(String patientId) {
		super();
		this.patientId = patientId;
	}
	public CIS3000InsulinPumpModel(String bolusAmount, String foodAmount, String basalAmount, String patientId) {
		super();
		this.bolusAmount = bolusAmount;
		this.foodAmount = foodAmount;
		this.basalAmount = basalAmount;
		this.patientId = patientId;
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

	 public void uploadBSToDB()
	 {
		 try {
				myConn = DriverManager.getConnection(url, user, password);
				myStmt = myConn.createStatement();
				String sql = "insert into bloodsugar " + " (bolusAmount,foodAmount,basalAmount,patientId)"
						+ " values (?,?,?,?)";
				myStmt.executeUpdate(sql);
				System.out.println("Insert complete.");
				} catch (Exception exc) {
					exc.printStackTrace();
				} finally {
					if (myStmt != null) {
						try {
							myStmt.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if (myConn != null) {
						try {
							myConn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
		}
	 }

}

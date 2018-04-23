package edu.ung.cis.cis3000.Sprint01.model;

/*import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.beans.property.SimpleStringProperty;

public class Sprint02Model {
	String url = "jdbc:mysql://localhost:3306/cisinsulinpump";
	String user = "root";
	String password = "";
	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;
	private int insulinCounter = 0;
	private int offset = 0;
	private int lastBS;
	private int secondlastBS;
	private int thirdlastBS;
	private int fourthlastBS;
    private int bsValue; // bs= BloodSugar
	private String basalAmount;
	private String foodAmount;
	private String bolusAmount;
	private String PLACEHOLDER;
	private int patientId;

	private final SimpleStringProperty firstName = new SimpleStringProperty("");
	private final SimpleStringProperty lastName = new SimpleStringProperty("");
	private final SimpleStringProperty email = new SimpleStringProperty("");

/*
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
*/


/*
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
*/
	//Constructor
	public Sprint02Model(){
		this.bsValue = this.generateBS();
	}

	public String getBasalAmount() {
		return basalAmount;
	}
	public void setBasalAmount(String firstName) {
		this.basalAmount = firstName;
	}


	public int eatFood(){
		this.bsValue += 50;
		return this.bsValue;
	}
	public String getFoodAmount() {
		return foodAmount;
	}
	public void setFoodAmount(String lastName) {
		this.foodAmount = lastName;
	}


	public int injectBolus(){
		this.bsValue = this.generateBS(bsValue, true);
		return this.bsValue;
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
//------------------------------------------------------------------------------------------------------------
	//generic method to get insulin levels and create new data point
	public int getBS(boolean createsNew){
		if(createsNew)
			this.bsValue = this.generateBS(this.bsValue, false);
		return this.bsValue;
	}
	//this method will only be invoked for very first BS measurement
	private int generateBS(){
		return (int)(Math.random()*151) + 50;
	}
	//overloading previous method. Used for any subsequent BS measurement
	private int generateBS(int prevBS, boolean withInjection){
		int bs;
		if(withInjection){
			this.insulinCounter = 4;
			this.offset = -24;
		}

		//variable just serves to create a probability distribution of how much next BS value will deviate
		int dist = (int)(Math.random()*99);
		//90% probability of next BS being normal fluctuation:
		//{previous BS+(x | x<=25), previous BS-(x | x<=20)}
		if(dist<35)
			bs = (int)(Math.random()*25)+prevBS+offset; //increasing => person ate something
		else if(dist<90)
			bs = prevBS-(int)(Math.random()*20)+offset; //decrease due to normal bodily function

		//10% probability of next BS being a spike:
		//{previous BS+(x | x<=35), previous BS-(x | x<=25)}
		else if(dist<97)
			bs = (int)(int)(Math.random()*35)+prevBS+offset; //person ate a lot/ food with high glycemic index
		else
			bs = prevBS-(int)(Math.random()*25)+offset; //person may have exercised

		if(insulinCounter != 0){
			insulinCounter--;
			if(insulinCounter==0)
				this.offset=0;
			//offset decreases as blood insulin levels decrease
			this.offset/=2;
		}
		return bs;
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
	 public void uploadBSToDB()
	 {
		 try {
				myConn = DriverManager.getConnection(url, user, password);
				myStmt = myConn.createStatement();
				String sql = "insert into info " + " (bloodSugar)"
						+ " values ('"+bsValue+"')";
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

	 public int getlastBSfromDB() throws SQLException{
		  try {
		   myConn = DriverManager.getConnection(url, user , password);
		   myStmt = myConn.createStatement();
		   myRs = myStmt.executeQuery("SELECT * FROM info WHERE id IN (SELECT MAX(id) FROM info)");
		   while (myRs.next()) {
		   //System.out.println(myRs.getString("bloodSugar") + "  " + myRs.getString("time"));
		   lastBS = Integer.parseInt(myRs.getString("bloodSugar"));
		   }
		  }
		  catch (Exception exc) {
		   exc.printStackTrace();
		  }
		  finally {
		   if (myRs != null) {
		    myRs.close();
		   }

		   if (myStmt != null) {
		    myStmt.close();
		   }

		   if (myConn != null) {
		    myConn.close();
		   }

		  }
		  return lastBS;
		 }


	 public int getlastBS() {
		return lastBS;
	 }


	public int get2ndlastBSfromDB() throws SQLException{
		  try {
		   myConn = DriverManager.getConnection(url, user , password);
		   myStmt = myConn.createStatement();
		   myRs = myStmt.executeQuery("SELECT * FROM info ORDER BY id DESC LIMIT 1,1");
		   while (myRs.next()) {
		   // System.out.println(myRs.getString("bloodSugar") + "  " + myRs.getString("time"));
		    secondlastBS = Integer.parseInt(myRs.getString("bloodSugar"));
		   }
		  }
		  catch (Exception exc) {
		   exc.printStackTrace();
		  }
		  finally {
		   if (myRs != null) {
		    myRs.close();
		   }

		   if (myStmt != null) {
		    myStmt.close();
		   }

		   if (myConn != null) {
		    myConn.close();
		   }
		  }
		  return secondlastBS;
		 }


	public int get2ndlastBS() {
		return secondlastBS;
	 }


	public int get3rdlastBSfromDB() throws SQLException{
		  try {
		   myConn = DriverManager.getConnection(url, user , password);
		   myStmt = myConn.createStatement();
		   myRs = myStmt.executeQuery("SELECT * FROM info ORDER BY id DESC LIMIT 1,2");
		   while (myRs.next()) {
		   // System.out.println(myRs.getString("bloodSugar") + "  " + myRs.getString("time"));
		    thirdlastBS = Integer.parseInt(myRs.getString("bloodSugar"));
		   }
		  }
		  catch (Exception exc) {
		   exc.printStackTrace();
		  }
		  finally {
		   if (myRs != null) {
		    myRs.close();
		   }

		   if (myStmt != null) {
		    myStmt.close();
		   }

		   if (myConn != null) {
		    myConn.close();
		   }
		  }
			return thirdlastBS;
		 }


	public int get3rdlastBS() {
		return thirdlastBS;
	}


	public int get4thlastBSfromDB() throws SQLException{
		  try {
		   myConn = DriverManager.getConnection(url, user , password);
		   myStmt = myConn.createStatement();
		   myRs = myStmt.executeQuery("SELECT * FROM info ORDER BY id DESC LIMIT 1,3");
		   while (myRs.next()) {
		   // System.out.println(myRs.getString("bloodSugar") + "  " + myRs.getString("time"));
		    fourthlastBS = Integer.parseInt(myRs.getString("bloodSugar"));
		   }
		  }
		  catch (Exception exc) {
		   exc.printStackTrace();
		  }
		  finally {
		   if (myRs != null) {
		    myRs.close();
		   }

		   if (myStmt != null) {
		    myStmt.close();
		   }

		   if (myConn != null) {
		    myConn.close();
		   }
		  }
		  return fourthlastBS;
		 }


	public int get4thlastBS() {
		return fourthlastBS;
		}

}

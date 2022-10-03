package dataStructures;

public class Driver {
	
	//Private variables of class. Comprised of driver name, license number, number of penalty points on license and contact number
	private String name;
	private String driveNum;
	private int penNum;
	private String contactNum;
	private boolean hasCar;
	private Car car;
	
	//Empty constructor
	public Driver() {
		
		this.name = "";
		this.driveNum = "";
		this.penNum = 0;
		this.contactNum = "";
		this.hasCar = false;
	}
	
	//Constructor with parameters
	public Driver(String aName, String driverNum, int penaltyNum, String conNum, boolean hasCar) {
		
		this.name = aName;
		this.driveNum = driverNum;
		this.penNum = penaltyNum;
		this.contactNum = conNum;
		this.hasCar = false;
	}
	
	//Getters start
	public String getName() {
		
		return this.name;
		
	}
	
	public String getDriveNum() {
		
		return this.driveNum;
		
	}
	
	public int getPenNum() {
		
		return this.penNum;
		
	}
	
	public String getConNum() {
		
		return this.contactNum;
		
	}
	
	public boolean getHasCar() {
		
		return this.hasCar;
		
	}
	
	public Car getCar() {
		
		return this.car;
		
	}
	//Getters end
	
	//Setters start
	public void setName(String aName) {
		
		this.name = aName;
		
	}
	
	public void setDriveNum(String driverNum) {
		
		this.driveNum = driverNum;
		
	}
	
	public void setPenNum(int penaltyNum) {
		
		this.penNum = penaltyNum;
		
	}
	
	public void setConNum(String contactNum) {
		
		this.contactNum = contactNum;
		
	}
	
	public void setHasCar(boolean hasCar) {
		
		this.hasCar = hasCar;
		
	}
	
	public void setCar(Car aCar) {
		
		this.car = aCar;
		
	}
	//Setters end
	
	//toString function
	public String toString() {
		
		return "Driver details: \nName: "+this.name+"\nLicense number: "+this.driveNum+"\nNo. of penalty points: "
		+this.penNum+"\nContact number: "+this.contactNum;
		
	}
	
}

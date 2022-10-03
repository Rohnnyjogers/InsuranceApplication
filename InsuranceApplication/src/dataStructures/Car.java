package dataStructures;

public class Car {

	//Private variables of class. Comprised of car registration number, year of manufacture, engine size and NCT status 
	private String regNum;
	private int manYear;
	private double engSize;
	private boolean nctStatus;
	
	//Empty constructor
	public Car() {
		
		this.regNum = "";
		this.manYear = 0;
		this.engSize = 0.0;
		this.nctStatus = false;
		
	}
	
	//Constructor with parameters
	public Car(String aRegNum, int aManYear, double anEngSize, boolean anNctStat) {
		
		this.regNum = aRegNum;
		this.manYear = aManYear;
		this.engSize = anEngSize;
		this.nctStatus = anNctStat;		
		
	}
	
	//Getters start
	public String getRegNum() {
		
		return this.regNum;
		
	}
	
	public int getManYear() {
		
		return this.manYear;
		
	}
	
	public double getEngSize() {
		
		return this.engSize;
		
	}
	
	public boolean getNctStatus() {
		
		return this.nctStatus;
		
	}
	//Getters end
	
	//Setter start
	public void setRegNum(String aRegNum) {
		
		this.regNum = aRegNum; 
		
	}
	
	public void setManYear(int aManYear) {
		
		this.manYear = aManYear;
		
	}
	
	public void setEngSize(double anEngSize) {
		
		this.engSize = anEngSize;
		
	}
	
	public void setNctStatus(boolean anNctStat) {
		
		this.nctStatus = anNctStat;
		
	}
	//Setters end
	
	//Boolean to String function used to make NCT status more readable
	public String boolToString() {
		
		String value;
		
		if(this.nctStatus == true) {
			
			value = "Pass";			
		}
		else {
			
			value = "Fail";
		}
		
		return value;
	}
	
	//toString function
	public String toString() {
		
		return "Car details: \nRegistration number:"+this.regNum+"\nYear of manufacture: "+this.manYear+"\nEngine size:"
		+this.engSize+"\nNCT Status: "+boolToString();
		
	} 
}

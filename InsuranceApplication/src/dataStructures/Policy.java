package dataStructures;

public class Policy {
	
	//Private variables of class. Comprised of policy number, premium, number of claims on policy, registration number of car and name of policy holder
	private int policyNum;
	private double premium;
	private int polClaimNum;
	private String regNum;
	private String name;
	
	//Empty constructor
	public Policy() {
		
		this.policyNum = 0;
		this.premium = 0;
		this.polClaimNum = 0;
		this.name = "";
		
	}
	
	//Constructor taking parameters
	public Policy(int aPolNum, int aPremium, int numOfClaims, String aRegNum, String aName) {
		
		this.policyNum = aPolNum;
		this.premium = aPremium;
		this.polClaimNum = numOfClaims;
		this.regNum = aRegNum;
		this.name = aName;
		
	}

	//Getters start
	public int getPolNum() {
		
		return this.policyNum;
		
	}
	
	public double getPremium() {
		
		return this.premium;
		
	}
	
	public int getNumOfClaims() {
		
		return this.polClaimNum;
		
	}
	
	public String getRegNum() {
		
		return this.regNum;
		
	}
	
	public String getPolName() {
		
		return this.name;
		
	}
	//Getters end
	
	//Setters start
	public void setPolNum(int aPolNum) {
		
		this.policyNum = aPolNum;
		
	}
	
	public void setPremium(double aPremium) {
		
		this.premium = aPremium;
		
	}
	
	public void setNumOfClaims(int numOfClaims) {
		
		this.polClaimNum = numOfClaims;
		
	}
	
	public void setRegNum(String aRegNum) {
		
		this.regNum = aRegNum;
		
	}
	
	public void setPolName(String aName) {
		
		this.name = aName;
		
	}
	//Setter end
	
	//toString function
	public String toString() {
		
		return "-- Policy details --\nPolicy number: "+this.policyNum+"\nPremium: "+this.premium+"\nNumber of claims on policy: "
		+this.polClaimNum+"\nCar registration number"+this.regNum+"\nName of policy holder: "+this.name;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

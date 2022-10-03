package Application;

import java.util.ArrayList;
import java.util.Scanner;

import dataStructures.Car;
import dataStructures.Driver;
import dataStructures.Policy;

public class SystemDriver {
	
	//Declaring ArrayLists of Policy, Driver and Car elements
	ArrayList<Policy> policyList = new ArrayList<Policy>();
	ArrayList<Driver> driverList = new ArrayList<Driver>();
	ArrayList<Car> carList = new ArrayList<Car>();
	//Global int variable holding policy number value
	int policyNumber;
	
	//Constructor
	public SystemDriver() {
		
		menu();
		
	}
	
	//A menu module used to display menu options and regulate input
	public void menu() {
		
		Scanner scan = new Scanner(System.in);
		int input;
		
		System.out.println("\f");
		
		System.out.print("-- Menu -- \n1. Add Car.\n2. Add Driver (Note: Car must be registered first). \n3. Add Policy "
		+"(Note: Car and Driver must be registered first).\n4. Add Car to Driver's profile. \n5. Delete policy."
		+" \n6. Increase premiums by 5%. \n7. Total number of claims. \n8. Total revenue generated from premiums. \n9. Exit system.");
		
		do {
		
			System.out.println("\nPlease choose a menu input between 1-9.");
			input = scan.nextInt();
			scan.nextLine();
			
			if(input == 1) {
				
				createCar();
				
			}
			else if(input == 2) {
				
				createDriver();
				
			}
			else if(input == 3) {
				
				createPolicy();
				
			}
			else if(input == 4) {
				
				//addCarToDriver();TBC
								
			}
			else if(input == 5) {
				
				deletePolicy();
				
			}
			else if(input == 6) {
				
				increasePremium();
				
			}
			else if(input == 7) {
				
				totalClaims();
				
			}
			else if(input == 8) {
				
				totalPremiumRev();
				
			}
			else if(input == 9) {
				
				System.out.println("\f");
				
				System.out.println("System exited successfully.");
				
			}
			else {
				
				System.out.println("Invalid entry - Please choose a menu option between 1-6.");
				
			}
			
		}while(input < 1 || input > 9);		
		
	}
	
	//Method that asks user to input details to create a Car object. Car is then added to carList 
	public void createCar() {
		
		Scanner scan = new Scanner(System.in);
		String reg, input;
		int year;
		double size;
		boolean nct = false;
		Car car;
		
		do {
			
			do {	
				System.out.println("-- Car Registration --\nEnter car registration number (Must be of format XXXDXXXX): ");
				reg = scan.nextLine();
				checkReg(reg);
				if(checkReg(reg) == false) {
					System.out.println("Error - Registration number input is not valid. Please try again");
				}
			}while(checkReg(reg) == false);
				
			do {
				System.out.println("Enter year of manufacture (Must be between 1970 - 2022: ");
				year = scan.nextInt();
				scan.nextLine();
				if(year < 1970 || year > 2022 ) {
					System.out.println("Error - Year of manufacture must be between 1970 and 2022. Please try again.");	
				}
			}while(checkReg(reg) == false);
			
			do {	
				System.out.println("Enter engine size (Must be between 0.5 - 6.0 (litres)): ");
				size = scan.nextDouble();
				scan.nextLine();
				if(size < 0.5 || size > 6.0) {
					System.out.println("Error - Engine size must be between 0.5ltr - 6.0ltr. Please try again.");
				}
			}while(size < 0.5 || size > 6.0);
			
			do {
				System.out.println("Has the car a valid NCT certificate? (Enter y for yes, n for no)");
				input = scan.nextLine();
				if(input.equalsIgnoreCase("y")) {
					nct = true;
				}
				else if(input.equalsIgnoreCase("n")) {
					nct = false;
				}
				else {
					System.out.println("Error - Please enter y for yes or n for no.");
				}
			}while(!input.equalsIgnoreCase("y") || !input.equalsIgnoreCase("n"));	
			
			car = new Car(reg, year, size, nct);
			carList.add(car);
			
			System.out.println("Car with registration "+reg+" has been added to the system.");
			
			System.out.println("Add another car to system or return to menu? (Enter c to add car, any other key to return to menu)");
			input = scan.nextLine();
			
		}while(input.equalsIgnoreCase("c"));
		
		menu();
	}
	
	//Method asking user for driver details to create a Driver object. A Car can be added to the Driver and the Driver is added to driverList 
	public void createDriver() {
		
		Scanner scan = new Scanner(System.in);
		String name, licenseNum, contactNum, input, reg;
		int penaltyNum;
		Driver driver;
		Car car = new Car();
		boolean found = false;
		
			
		System.out.println("-- Driver Registration --\nEnter name of driver: ");
		name = scan.nextLine();
		
		do {
			System.out.println("Enter driver license number of driver (Must be a 9-digit number): ");
			licenseNum = scan.nextLine();
			checkLicenseNum(licenseNum);
			if(checkLicenseNum(licenseNum) == false) {
				System.out.println("Error - Driver's License number input is invalid. Please try again.");
			}
		}while(checkLicenseNum(licenseNum) == false);
		
		do {
			System.out.println("Enter the number of penalty points the license has (Must be between 0 - 12):");
			penaltyNum = scan.nextInt();
			scan.nextLine();
			if(penaltyNum < 0 || penaltyNum > 12) {
				System.out.println("Invalid entry - Please enter a value between 0 - 12");
			}
		}while(penaltyNum < 0 || penaltyNum > 12);
		
		do {
			System.out.println("Enter contact number for driver (Must be of format 08XXXXXXXX): ");
			contactNum = scan.nextLine();
			checkContactNum(contactNum);
			if(checkContactNum(contactNum) == false) {
				System.out.println("Invalid entry - Contact number must be of format 08XXXXXXXX");
			}
		}while(checkContactNum(contactNum) == false);
					
		
		driver = new Driver(name, licenseNum, penaltyNum, contactNum, false);
		driverList.add(driver);
		
		System.out.println("Driver "+name+" has been added to the system.");
		
		do {
			do {
				
				System.out.println("Would you like to add a car to driver "+name+"'s profile? (y for yes, m to return to menu. "
				+"NOTE: Car must be registered with system first.)");
				input = scan.nextLine();
				if(input.equalsIgnoreCase("y")) {
					
					System.out.println("Enter the registration number of the car to be added to driver "+name+"'s profile: ");
					reg = scan.nextLine();
					
					for(Car c: carList) {
						
						if(c.getRegNum().equalsIgnoreCase(reg)) {
							
							found = true;
							car = c;
						
						}
						else {
							
							System.out.println("Car with registration number "+reg+" has not been found on the system.");
							
						}
						
					}
					
					if(found) {
						
						System.out.println("Car with registration number "+reg+" found. Add this car to driver's policy? (y for yes, n for no)");
						input = scan.nextLine();
						if(input.equalsIgnoreCase("y")) {
							
							driver.setCar(car);
							driver.setHasCar(true);
							System.out.println("Car with registration "+reg+" has been added to driver "+name+"'s profile.");
							
						}
						else {
							
							System.out.println("Car with registration "+reg+" has not been added to driver "+name+"'s profile.");
							
						}
						
					}
					
				}
				else if(input.equalsIgnoreCase("m")) {
					
					menu();
					
				}
				else {
				
					System.out.println("Invalid entry - Please input y to add a car to "+name+"'s profile, or m to return to menu.");
					
				}
				
			}while(!input.equalsIgnoreCase("y") || !input.equalsIgnoreCase("m"));
			
			System.out.println("Add another driver to system or return to main menu? (Enter d to add a driver, any other key to return to menu)");
			input = scan.nextLine();
			
		}while(input.equalsIgnoreCase("d"));
		
		menu();
	}
	
	//Create policy method. Asks user for a Driver name, if found in driverList the user can then attach claims to the driver and create 
	//a policy for them. Policy is add to policyList.
	public void createPolicy() {
		
		Scanner scan = new Scanner(System.in);
		String name, input;
		int claims;
		boolean found = false;
		Driver driver = new Driver();;
		Policy policy;
		
		System.out.print("-- Policy Creator -- \nEnter name of driver to create policy:");
		name = scan.nextLine();
		for(Driver d: driverList) {
			
			if(d.getHasCar() == true && d.getName().equalsIgnoreCase(name)) {
				
				found = true;
				driver = d;
			}
			else if(d.getHasCar() == false && d.getName().equalsIgnoreCase(name)) {
				
				System.out.println(name + "has been found on the system but has no registered car associated with them.");
				
			}
			else {
				
				System.out.println(name+ " has not been found on the system. Please revise your search and try again.");
				
			}
				
			
		}
		
		if(found) {
			
				System.out.println(name + "has been found on the system. Details of car registered on driver's profile: \n"+
				driver.getCar().toString());
				
			do {
				
				System.out.println("Enter, if any, the amount of claims associated with this driver: ");
				claims = scan.nextInt();
				scan.nextLine();
				if(claims < 0) {
					System.out.println("Invalid entry - Claim value must be greater than 0.");
				}
				
			}while(claims < 0);
			
			premiumCalculator(driver, claims);
			int policyNum = (policyNumber = policyNumber + 1);
			
			System.out.println("The following policy has been calculated for driver "+name+":\nPolicy number: "+policyNum+
					"\nPremium: €"+premiumCalculator(driver, claims));
			
			
			do {
				System.out.println("Create this policy and add it to system? (Enter y for yes, m to exit to menu)");
				input = scan.nextLine();
				if(input.equalsIgnoreCase("y")) {
					
					policyNumber = policyNumber + 1;
					policy = new Policy(policyNumber, premiumCalculator(driver, claims), claims, driver.getCar().getRegNum(), driver.getName());
					policyList.add(policy);
					
					System.out.println("Policy created and saved successfully.");
					
				}
				else if(input.equalsIgnoreCase("m")) {
					
					menu();
					
				}
				else {
					
					System.out.print("Invalid entry - Please enter y for yes or m to exit to menu.");
					
				}
				
			}while(!input.equalsIgnoreCase("y") || input.equalsIgnoreCase("m"));
			
		}
		
		menu();
		
	}
	
	//Delete policy method where user is asked for policy number to be deleted. If found if policyList then policy details are displayed and the user
	//is asked to confirm if they want to delete the policy from the list
	public void deletePolicy() {
		
		Scanner scan = new Scanner(System.in);
		int num;
		boolean found = false;
		String input;
		Policy policy = new Policy();
		
		System.out.println("Enter the policy number of the policy to be deleted: ");
		num = scan.nextInt();
		scan.nextLine();
		for(Policy p: policyList) {
			
			if(p.getPolNum() == num) {
				
				found = true;
				policy = p;
				
			}
			else {
				
				System.out.println("Policy number '"+num+"' was not found on the system.");
				
			}
		}
		
		if(found) {
			
			do {	
				System.out.println("Policy found.\n"+policy.toString()+"\nDelete this policy? (y for yes, m to exit to menu)");
				input = scan.nextLine();
				if(input.equalsIgnoreCase("y")) {
					
					policyList.remove(policy);
					System.out.println("Policy '"+policy.getPolNum()+"' has been deleted from the system.");
					
				}
				else if(input.equalsIgnoreCase("m")) {
					
					menu();
					
				}
				else {
				
					System.out.println("Invalid entry - Please enter y for yes of m to exit to menu.");
					
				}
			}while(!input.equalsIgnoreCase("y") || !input.equalsIgnoreCase("m"));
				
		}
		
		menu();
		
	}
	
	//Increase policy price method
	public void increasePremium() {
		
		Policy policy;
		double newPremium;
		
		for(int i = 0; i <= policyList.size(); i++ ) {
			
			policy = policyList.get(i);
			newPremium = ((policy.getPremium()/100)*5) + policy.getPremium();
			policy.setPremium(newPremium);
			
		}
		
		System.out.println("All premiums have been increased by 5%.\n\n");
		
		menu();
		
	}
	
	//Total number of claims method
	public void totalClaims() {
		
		Policy policy;
		int claimsNum = 0;
		
		for(int i = 0; i <= policyList.size(); i++ ) {
			
			policy = policyList.get(i);
			claimsNum = claimsNum + policy.getNumOfClaims();
			
		}
		
		System.out.println("Number of claims registered on the system: "+claimsNum);
		
		menu();
		
	}
	
	//Total revenue from premiums method
	public void totalPremiumRev() {
		
		Policy policy;
		int premiumRev = 0;
		
		for(int i = 0; i <= policyList.size(); i++ ) {
			
			policy = policyList.get(i);
			premiumRev = premiumRev + policy.getNumOfClaims();
			policy.setPremium(premiumRev);
			
		}
		
		System.out.println("Total revenue generated from policy premiums: €");
		
		menu();
		
	}
	
	//Function that takes a String as a parameter and returns false if it doesn't conform to  number plate format XXXDXXXX
	public boolean checkReg(String aReg) {
		
		boolean valid;
		String reg = aReg;
		String numPart = "" + reg.charAt(0) + reg.charAt(1) + reg.charAt(2) + reg.charAt(4) + reg.charAt(5) + reg.charAt(6) + reg.charAt(7);
		
		try {
			int i = Integer.parseInt(numPart);
		}catch(NumberFormatException e) {
			valid = false;
		}
		
		if(reg.length() != 8 && reg.charAt(3) != 'D') {
			
			valid = false;
			
		}
		else {
			
			valid = true;
		}
	
		return valid;
		
	}

	//Function that takes a string as a parameter and returns false if its non-numeric or have a length longer than 9
	public boolean checkLicenseNum(String aNum) {
		
		boolean valid = true;
		String number = aNum;		
		
		try {
			int i = Integer.parseInt(number);
		}catch(NumberFormatException e) {
			valid = false;
		}
		
		if(number.length() != 9) {
			
			valid = false;
			
		}
		
		return valid;
		
	}
	
	//Function taking a string parameter. Returns false if it doesn't follow telephone format 08XXXXXXXX
	public boolean checkContactNum(String aNum) {
		
		boolean valid = true;
		String number = aNum;
		
		try {
			int i = Integer.parseInt(number);
		}catch(NumberFormatException e) {
			valid = false;
		}
		
		if(number.charAt(0) != '0' && number.charAt(1) != '1' && number.length() != 9) {
			
			valid = false;
			
		}
		
		return valid;
		
	}
	
	//Function taking a Driver class and int as parameters. The function uses these to determine the value of the premium to be applied
	public int premiumCalculator(Driver aDriver, int claimNumber) {
		
		Driver driver = aDriver;
		int claims = claimNumber;
		int penPoints = driver.getPenNum();
		int manYear = driver.getCar().getManYear();
		double engSize = driver.getCar().getEngSize();
		int premium = 0;
		
		//if(claims > )
		
		return premium;
		
	}
	
	
	public static void main(String[] args) {
		
		new SystemDriver();

	}

}

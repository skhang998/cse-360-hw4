package hw4;

public class Patient 
{
	private String fName, lName, email, phone, history, insurance;
	private int patientID;
	
	public Patient()
	{
		fName = "";
		lName = ""; 
		email = "";
		phone = "";
		history = ""; 
		insurance = ""; 
		patientID = 0;
	} //Default constructor
	
	public Patient(String fName, String lName, String email, String phone, String history, String insurance, int patientID)
	{
		this.fName = fName; 
		this.lName = lName; 
		this.email = email;
		this.phone = phone; 
		this.history = history; 
		this.insurance = insurance; 
		this.patientID = patientID;
	} //Overloaded constructor
	
	//Getters
	public int getID() {return patientID;}
	
	public String getFName() {return fName;}
	
	public String getLName() {return lName;}
	
	public String getEmail() {return email;}
	
	public String getPhone() {return phone;}
	
	public String getHistory() {return history;}
	
	public String getInsurance() {return insurance;}
}
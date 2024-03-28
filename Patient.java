/*
 * Name: Sukhmanjot Khangura
 * ID: 1221691458
 * Class: CSE 360 Spring 2024
 * Time: Th 1:30pm
 * Instructor: Lynn Robert Carter
 * Assignment: Homework 4
 */

package hw4;

import java.io.Serializable;

public class Patient implements Serializable
{
	//Make this object serializable
	private static final long serialVersionUID = 360L;
	private String fName, lName, email, phone, history, insurance;
	private int patientID;
	private ScanInfo ctScan;
	
	public Patient()
	{
		fName = "";
		lName = ""; 
		email = "";
		phone = "";
		history = ""; 
		insurance = ""; 
		patientID = 0;
		ctScan = null;
	} //Default constructor
	
	//Create object with field information
	public Patient(String fName, String lName, String email, String phone, String history, String insurance, int patientID)
	{
		this.fName = fName; 
		this.lName = lName; 
		this.email = email;
		this.phone = phone; 
		this.history = history; 
		this.insurance = insurance; 
		this.patientID = patientID;
		ctScan = null;
	} //Overloaded constructor
	
	//Getters
	public int getID() {return patientID;}
	
	public String getFName() {return fName;}
	
	public String getLName() {return lName;}
	
	public String getEmail() {return email;}
	
	public String getPhone() {return phone;}
	
	public String getHistory() {return history;}
	
	public String getInsurance() {return insurance;}
	
	public ScanInfo getScan() {return ctScan;}
	
	//Setter - set the scan corresponding to this patient
	public void setScan(ScanInfo scan) {ctScan = scan;}
}
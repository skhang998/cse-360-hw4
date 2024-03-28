/*
 * Name: Sukhmanjot Khangura
 * ID: 1221691458
 * Class: CSE 360 Spring 2024
 * Time: Th 1:30pm
 * Instructor: Lynn Robert Carter
 * Assignment: Homework 4
 */

package hw4;

import java.util.ArrayList;
import java.util.Random;

//Used as the system object
public class PatientUtil 
{
	//Holds all patients in the system
	private static ArrayList<Patient> patientList = null;
	
	public PatientUtil()
	{
		if(patientList == null)
			patientList = new ArrayList<Patient>();
	}
	
	//Make random 5-digit ID for each patient
	public int generateID()
	{
			Random r = new Random( System.currentTimeMillis() );
			return(1 + r.nextInt(2)) * 10000 + r.nextInt(10000);
	}
	
	//Add patient to system
	public void addPatient(Patient newPatient)
	{
		patientList.add(newPatient);
	}
	
	//Find a patient in the system using their patient ID and return them
	public Patient findPatient(int patientID)
	{
		Patient temp = null;
		for(int i = 0; i < patientList.size(); i++)
		{
			if (patientList.get(i).getID() == patientID)
				temp = patientList.get(i);
		}
		return temp;
	}
	
	//Print all the patients in the system (printing first names)
	public void printPatients()
	{
		for(int i = 0; i < patientList.size(); i++)	
			System.out.println(patientList.get(i).getFName());
	}
	
	//Set the scan corresponding to the given patient
	public void setScan(int patientID, ScanInfo scan)
	{
		Patient temp = new Patient();
		temp = findPatient(patientID);
		temp.setScan(scan);
	}
}
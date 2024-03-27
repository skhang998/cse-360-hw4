package hw4;

import java.util.ArrayList;
import java.util.Random;

public class PatientUtil 
{
	private static ArrayList<Patient> patientList;
	public PatientUtil()
	{
		patientList = new ArrayList<Patient>();
	}
	
	public int generateID()
	{
			Random r = new Random( System.currentTimeMillis() );
			return(1 + r.nextInt(2)) * 10000 + r.nextInt(10000);
	}
	
	public void addPatient(Patient newPatient)
	{
		patientList.add(newPatient);
	}
	
	public Patient findPatient(int patientID)
	{
		Patient temp = new Patient();
		for(int i = 0; i < patientList.size(); i++)
		{
			if (patientList.get(i).getID() == patientID)
				temp = patientList.get(i);
		}
		return temp;
	}
}
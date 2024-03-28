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

public class ScanInfo implements Serializable
{
	//Make this object serializable
	private static final long serialVersionUID = 360L;
	private String agatston, lm, lad, lcx, rca, pda;
	private int id;
	
	public ScanInfo()
	{
		id = 0;
		agatston = "";
		lm = "";
		lad = "";
		lcx = "";
		rca = "";
		pda = "";
	} //Default constructor
	
	//Construct scan object with field information
	public ScanInfo(int id, String agatston, String lm, String lad, String lcx, String rca, String pda)
	{
		this.id = id; 
		this.agatston = agatston;
		this.lm = lm; 
		this.lad = lad; 
		this.lcx = lcx; 
		this.rca = rca; 
		this.pda = pda; 
	} //Overloaded constructor
	
	//Getters
	public int getID() {return id;}
	
	public String getAgatston() {return agatston;}
	
	public String getLM() {return lm;}
	
	public String getLAD() {return lad;}
	
	public String getLCX() {return lcx;}
	
	public String getRCA() {return rca;}
	
	public String getPDA() {return pda;}
}
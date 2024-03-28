/*
 * Name: Sukhmanjot Khangura
 * ID: 1221691458
 * Class: CSE 360 Spring 2024
 * Time: Th 1:30pm
 * Instructor: Lynn Robert Carter
 * Assignment: Homework 4
 */

package hw4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.geometry.Insets;

public class CTView extends GridPane
{
	private static final int WIDTH = 800, HEIGHT = 400, BODY_FONT = 16;
	private PatientUtil utility = new PatientUtil(); //System
	private Label id, agatston, vessel, lm, lad, lcx, rca, pda, error;
	private TextField idT, agatstonT, lmT, ladT, lcxT, rcaT, pdaT;
	private Button save;
	
	public CTView()
	{
		id = new Label("Patient ID:");
		agatston = new Label("The total Agatston CAC score");
		vessel = new Label("Vessel level Agatston CAC score");
		lm = new Label("LM:");
		lad = new Label("LAD:");
		lcx = new Label("LCX:");
		rca = new Label("RCA:");
		pda = new Label("PDA:");
		error = new Label();
		idT = new TextField();
		agatstonT = new TextField();
		lmT = new TextField();
		ladT = new TextField();
		lcxT = new TextField();
		rcaT = new TextField();
		pdaT = new TextField();
		save = new Button("Save");
		
		//Setting up rows/columns
		setPadding(new Insets(10));
		setHgap(15);
		setVgap(3);
		
		//Setting component fonts and styles
		id.setFont(Font.font(BODY_FONT));
		agatston.setFont(Font.font(BODY_FONT));
		vessel.setFont(Font.font(BODY_FONT));
		lm.setFont(Font.font(BODY_FONT));
		lad.setFont(Font.font(BODY_FONT));
		lcx.setFont(Font.font(BODY_FONT));
		rca.setFont(Font.font(BODY_FONT));
		pda.setFont(Font.font(BODY_FONT));
		save.setFont(Font.font(BODY_FONT));
		save.setMinSize(100, 50);
		save.setMaxSize(100, 50);
		save.setStyle("-fx-background-color: #6074bc");
		
		idT.setMaxSize(300, 30);
		idT.setMinSize(300, 30);
		agatstonT.setMaxSize(300, 30);
		agatstonT.setMinSize(300, 30);
		
		//Inputting components into GridPane
		add(id, 0, 0);
		add(agatston, 0, 5);
		add(vessel, 0, 10);
		add(lm, 0, 15);
		add(lad, 0, 20);
		add(lcx, 0, 25);
		add(rca, 0, 30);
		add(pda, 0, 35);
		
		add(idT, 5, 0);
		add(agatstonT, 5, 5);
		add(lmT, 1, 15);
		add(ladT, 1, 20);
		add(lcxT, 1, 25);
		add(rcaT, 1, 30);
		add(pdaT, 1, 35);
		
		add(error, 5, 25);
		add(save, 5, 35);
		
		//Button handler
		save.setOnAction(e -> 
		{
			//Make sure all fields are filled out
			if (!idT.getText().isBlank() && !agatstonT.getText().isBlank() && !lmT.getText().isBlank()
					&& !ladT.getText().isBlank() && !lcxT.getText().isBlank() && !rcaT.getText().isBlank()
					&& !pdaT.getText().isBlank())
			{
				//Make sure patient exists
				int patientID = Integer.parseInt(idT.getText());
				if(utility.findPatient(patientID) != null)
				{
					//Create new scan with field information
					String agatstonScore = agatstonT.getText();
					String lmScore = lmT.getText();
					String ladScore = ladT.getText();
					String lcxScore = lcxT.getText();
					String rcaScore = rcaT.getText();
					String pdaScore = pdaT.getText();
					ScanInfo ctScan = new ScanInfo(patientID, agatstonScore, lmScore, ladScore, lcxScore, rcaScore, pdaScore);
					utility.setScan(patientID, ctScan);
					//Create scan information file
					String filename = patientID + "CTResults.txt";
					File outputFile = new File(filename);
					try {
						outputFile.createNewFile();
					} catch (IOException e1) {
						System.out.println("Failed to create file");
					}
					//Store object information in file
					try {
						FileOutputStream data = new FileOutputStream(filename);
						ObjectOutputStream objectToData = new ObjectOutputStream(data);
						objectToData.writeObject(ctScan);
						objectToData.close();
					} catch (IOException e1) {
						System.out.println("Exception");
					}
					//Switch back to home screen
					Stage stage = (Stage) getScene().getWindow();
					stage.setScene(new Scene(new StackPane(new HomePage()), WIDTH, HEIGHT));
					stage.setTitle("Heart Health - Home Page");
				}
				else //If the patientID does not correspond to a patient in the system
				{
					error.setText("ERROR: Patient not found");
					error.setFont(Font.font(BODY_FONT));
					error.setTextFill(Color.RED);
				}
			}
			else //If some of the fields were left empty
			{
				error.setText("ERROR: Please fill all fields to submit scan");
				error.setFont(Font.font(BODY_FONT));
				error.setTextFill(Color.RED);
			}
		});
	}
}
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
import javafx.scene.text.Font;
import javafx.geometry.Insets;

public class ReceptionistView extends GridPane
{
	private static final int WIDTH = 800, HEIGHT = 400, BODY_FONT = 16, TITLE_FONT = 20;
	private PatientUtil utility = new PatientUtil(); //System
	private Label title, fName, lName, email, phone, history, insurance;
	private TextField fNameT, lNameT, emailT, phoneT, historyT, insuranceT;
	private Button save;
	
	public ReceptionistView()
	{
		title = new Label("Patient Intake Form");
		fName = new Label("First Name:");
		lName = new Label("Last Name:");
		email = new Label("Email:");
		phone = new Label("Phone Number:");
		history = new Label("Health History:");
		insurance = new Label("Insurance ID:");
		fNameT = new TextField();
		lNameT = new TextField();
		emailT = new TextField();
		phoneT = new TextField();
		historyT = new TextField();
		insuranceT = new TextField();
		save = new Button("Save");
		
		//Set rows/columns
		setPadding(new Insets(10));
		setHgap(10);
		setVgap(5);
		
		//Set styling for labels and button
		title.setFont(Font.font(TITLE_FONT));
		fName.setFont(Font.font(BODY_FONT));
		lName.setFont(Font.font(BODY_FONT));
		email.setFont(Font.font(BODY_FONT));
		phone.setFont(Font.font(BODY_FONT));
		history.setFont(Font.font(BODY_FONT));
		insurance.setFont(Font.font(BODY_FONT));
		save.setFont(Font.font(BODY_FONT));
		save.setMinSize(100, 50);
		save.setMaxSize(100, 50);
		save.setStyle("-fx-background-color: #6074bc");
		
		//Add labels and button into the GridPane
		add(title, 7, 0);
		add(fName, 0, 5);
		add(lName, 0, 10);
		add(email, 0, 15);
		add(phone, 0, 20);
		add(history, 0, 25);
		add(insurance, 0, 30);
		add(fNameT, 5, 5);
		add(lNameT, 5, 10);
		add(emailT, 5, 15);
		add(phoneT, 5, 20);
		add(historyT, 5, 25);
		add(insuranceT, 5, 30);
		add(save, 15, 30);
		
		//Button handler
		save.setOnAction(e -> 
		{
			String first = fNameT.getText();
			String last = lNameT.getText();
			String email = emailT.getText();
			String phone = phoneT.getText();
			String history = historyT.getText();
			String insurance = insuranceT.getText();
			int patientID = utility.generateID();
			System.out.println(patientID);
			//Make sure that the names are filled out
			if (!fNameT.getText().isBlank() && !lNameT.getText().isBlank())
			{
				//Create a new patient with the information
				Patient newPatient = new Patient(first, last, email, phone, history, insurance, patientID);
				utility.addPatient(newPatient);
				//Create patient information file
				String filename = newPatient.getID() + "_PatientInfo.txt";
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
					objectToData.writeObject(newPatient);
					objectToData.close();
				} catch (IOException e1) {
					System.out.println("Exception");
				}
				//Switch back to home screen when done
				Stage stage = (Stage) getScene().getWindow();
				stage.setScene(new Scene(new StackPane(new HomePage()), WIDTH, HEIGHT));
				stage.setTitle("Heart Health - Home Page");
			}
			else
				fNameT.setText("Please enter names");
		});
	}
}
/*
 * Name: Sukhmanjot Khangura
 * ID: 1221691458
 * Class: CSE 360 Spring 2024
 * Time: Th 1:30pm
 * Instructor: Lynn Robert Carter
 * Assignment: Homework 4
 */

package hw4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.geometry.Insets;

public class PatientView extends GridPane
{
	private static final int WIDTH = 800, HEIGHT = 400, BODY_FONT = 16, TITLE_FONT = 20;
	private Label title, agatston, lm, lad, lcx, rca, pda;
	private TextField agatstonT, lmT, ladT, lcxT, rcaT, pdaT;
	private Button back;

	public PatientView(Patient patient)
	{
		title = new Label();
		agatston = new Label("The total Agatston CAC score");
		lm = new Label("LM:");
		lad = new Label("LAD:");
		lcx = new Label("LCX:");
		rca = new Label("RCA:");
		pda = new Label("PDA:");
		agatstonT = new TextField();
		lmT = new TextField();
		ladT = new TextField();
		lcxT = new TextField();
		rcaT = new TextField();
		pdaT = new TextField();
		back = new Button("Back");
		
		//Set title to welcome patient
		String hello = "Hello " + patient.getFName();
		title.setText(hello);
		
		//Set rows/columns
		setPadding(new Insets(10));
		setHgap(10);
		setVgap(3);
		
		//Set styling and sizing for labels and text fields
		title.setFont(Font.font(TITLE_FONT));
		agatston.setFont(Font.font(12));
		lm.setFont(Font.font(BODY_FONT));
		lad.setFont(Font.font(BODY_FONT));
		lcx.setFont(Font.font(BODY_FONT));
		rca.setFont(Font.font(BODY_FONT));
		pda.setFont(Font.font(BODY_FONT));
		
		agatstonT.setMaxSize(300, 30);
		agatstonT.setMinSize(300, 30);
		agatstonT.setEditable(false);
		agatstonT.setMouseTransparent(true);
		lmT.setEditable(false);
		ladT.setEditable(false);
		lcxT.setEditable(false);
		rcaT.setEditable(false);
		pdaT.setEditable(false);
		lmT.setMouseTransparent(true);
		ladT.setMouseTransparent(true);
		lcxT.setMouseTransparent(true);
		rcaT.setMouseTransparent(true);
		pdaT.setMouseTransparent(true);
		
		//Set button styling
		back.setMinSize(100, 50);
		back.setMaxSize(100, 50);
		back.setFont(Font.font(BODY_FONT));
		back.setStyle("-fx-background-color: #6074bc");
		
		//Add components into GridPane
		add(title, 2, 0);
		add(agatston, 0, 5);
		add(lm, 0, 15);
		add(lad, 0, 20);
		add(lcx, 0, 25);
		add(rca, 0, 30);
		add(pda, 0, 35);
		
		add(agatstonT, 3, 5);
		add(lmT, 1, 15);
		add(ladT, 1, 20);
		add(lcxT, 1, 25);
		add(rcaT, 1, 30);
		add(pdaT, 1, 35);
		
		add(back, 3, 35);
		
		try {
			//Fetch scan information file and deserialize it
			String filename = patient.getID() + "CTResults.txt";
			FileInputStream fileToData = new FileInputStream(filename);
			ObjectInputStream dataToObject = new ObjectInputStream(fileToData);
			ScanInfo patientScan = (ScanInfo) dataToObject.readObject();
			dataToObject.close();
			
			//Set text fields with retrieved information
			agatstonT.setText(patientScan.getAgatston());
			lmT.setText(patientScan.getLM());
			ladT.setText(patientScan.getLAD());
			lcxT.setText(patientScan.getLCX());
			rcaT.setText(patientScan.getRCA());
			pdaT.setText(patientScan.getPDA());
		} catch (IOException e1) {
			System.out.println("Exception");
		} catch (ClassNotFoundException e1) {
			System.out.println("Class Not Found Exception");
		}
		
		back.setOnAction(e -> 
		{
			//Go back to home page
			Stage stage = (Stage) getScene().getWindow();
			stage.setScene(new Scene(new StackPane(new HomePage()), WIDTH, HEIGHT));
			stage.setTitle("Heart Health - Home Page");
		});
	}
}
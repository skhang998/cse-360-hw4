/*
 * Name: Sukhmanjot Khangura
 * ID: 1221691458
 * Class: CSE 360 Spring 2024
 * Time: Th 1:30pm
 * Instructor: Lynn Robert Carter
 * Assignment: Homework 4
 */

package hw4;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class PatientLoginView extends BorderPane
{
	private static final int WIDTH = 800, HEIGHT = 400, BODY_FONT = 16, TITLE_FONT = 20;
	private PatientUtil utility = new PatientUtil(); //System
	private VBox container;
	private HBox buttonContainer;
	private Label welcome, id, error;
	private TextField enterID;
	private Button search, back;
	private Region r;
	
	public PatientLoginView()
	{
		container = new VBox();
		buttonContainer = new HBox();
		welcome = new Label("Welcome!");
		id = new Label("Enter your patient ID here:");
		error = new Label();
		enterID = new TextField();
		search = new Button("Search");
		back = new Button("Back");
		r = new Region();
		
		//Set title
		welcome.setFont(Font.font(TITLE_FONT));
		welcome.setPadding(new Insets(10,0,0,0));
		BorderPane.setAlignment(welcome, Pos.CENTER);
		this.setTop(welcome);
		
		//Set labels and text field styling
		id.setFont(Font.font(BODY_FONT));
		id.setPadding(new Insets(0,0,10,0));
		error.setFont(Font.font(BODY_FONT));
		error.setTextFill(Color.RED);
		error.setPadding(new Insets(0,0,10,0));
		BorderPane.setAlignment(error, Pos.CENTER);
		
		enterID.setMaxSize(300, 30);
		
		//Set button styling
		search.setStyle("-fx-background-color: #6074bc");
		search.setMinSize(100, 50);
		search.setMaxSize(100, 50);
		search.setFont(Font.font(BODY_FONT));
		search.setAlignment(Pos.CENTER);
		
		back.setStyle("-fx-background-color: #6074bc");
		back.setMinSize(100, 50);
		back.setMaxSize(100, 50);
		back.setFont(Font.font(BODY_FONT));
		back.setAlignment(Pos.CENTER);
		
		//Button handlers
		search.setOnAction(e ->
		{
			//Make sure patient ID is provided
			if (!enterID.getText().isBlank())
			{
				//Make sure patient exists
				int patientID = Integer.parseInt(enterID.getText());
				if(utility.findPatient(patientID) != null)
				{
					//Make sure that the scan is available
					Patient patient = new Patient();
					patient = utility.findPatient(patientID);
					if(patient.getScan() != null)
					{
						//Switch to patient view with scan data
						Stage stage = (Stage) getScene().getWindow();
						stage.setScene(new Scene(new StackPane(new PatientView(patient)), WIDTH, HEIGHT));
						stage.setTitle("Patient Results");
					}
					else //If the scan is not yet available
					{
						error.setText("Your scan is not available yet. Check back soon!");
						error.setFont(Font.font(BODY_FONT));
						error.setTextFill(Color.RED);
					}
				}
				else //If the patient ID does not correspond to a patient in the system
				{
					error.setText("ERROR: Patient not found.");
					error.setFont(Font.font(BODY_FONT));
					error.setTextFill(Color.RED);
				}
			}
			else if (enterID.getText().isBlank()) //If no patient ID was provided
			{
				error.setText("Please enter a patient ID.");
				error.setFont(Font.font(BODY_FONT));
				error.setTextFill(Color.RED);
			}
		});
		
		back.setOnAction(e ->
		{
			//Go back to home page
			Stage stage = (Stage) getScene().getWindow();
			stage.setScene(new Scene(new StackPane(new HomePage()), WIDTH, HEIGHT));
			stage.setTitle("Heart Health - Home Page");
		});
		
		//Set components into HBox, VBox, and BorderPane
		HBox.setHgrow(r, Priority.ALWAYS);
		buttonContainer.getChildren().addAll(search, r, back);
		buttonContainer.setAlignment(Pos.CENTER);
		container.getChildren().addAll(id, enterID, new Label(), buttonContainer);
		container.setAlignment(Pos.CENTER);
		container.setMaxSize(300, 75);
		container.setMinSize(300, 75);

		this.setCenter(container);
		this.setBottom(error);
	}
}
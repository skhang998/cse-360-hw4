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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class HomePage extends BorderPane
{
	private static final int WIDTH = 800, HEIGHT = 400, BODY_FONT = 16, TITLE_FONT = 20;
	private VBox selection;
	private Button receptionist, CTScan, patient;
	private Label title;
	
	public HomePage()
	{
		title = new Label();
		selection = new VBox();
		receptionist = new Button("Patient Intake");
		CTScan = new Button("CT Scan Tech View");
		patient = new Button("Patient View");
		
		//Set title
		title.setText("Welcome to Heart Health Imaging and Recording System");
		title.setFont(Font.font(TITLE_FONT));
		title.setPadding(new Insets(0,0,10,0));
		BorderPane.setAlignment(title, Pos.TOP_CENTER);
		this.setTop(title);
		
		//Set buttons' styling and sizes
		receptionist.setFont(Font.font(BODY_FONT));
		receptionist.setStyle("-fx-background-color: #6074bc");
		receptionist.setMinSize(250, 75);
		receptionist.setMaxSize(250, 75);
		Label blank1 = new Label();
		CTScan.setFont(Font.font(BODY_FONT));
		CTScan.setStyle("-fx-background-color: #6074bc");
		CTScan.setMinSize(250, 75);
		CTScan.setMaxSize(250, 75);
		Label blank2 = new Label();
		patient.setFont(Font.font(BODY_FONT));
		patient.setStyle("-fx-background-color: #6074bc");
		patient.setMinSize(250, 75);
		patient.setMaxSize(250, 75);
		
		//Button handlers to go to corresponding scenes
		receptionist.setOnAction(e ->
		{
			Stage stage = (Stage) getScene().getWindow();
			stage.setScene(new Scene(new StackPane(new ReceptionistView()), WIDTH, HEIGHT));
			stage.setTitle("Patient Intake Form");
		});
		
		CTScan.setOnAction(e ->
		{
			Stage stage = (Stage) getScene().getWindow();
			stage.setScene(new Scene(new StackPane(new CTView()), WIDTH, HEIGHT));
			stage.setTitle("CT Scan");
		});
		
		patient.setOnAction(e ->
		{
			Stage stage = (Stage) getScene().getWindow();
			stage.setScene(new Scene(new StackPane(new PatientLoginView()), WIDTH, HEIGHT));
			stage.setTitle("Patient Login");
		});
		
		//Add buttons into VBox container and add container into root node
		selection.setAlignment(Pos.CENTER);
		selection.getChildren().addAll(receptionist, blank1, CTScan, blank2, patient);
		this.setCenter(selection);
	}
}
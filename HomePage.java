package hw4;

import java.util.HashMap;
import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
		
		title.setText("Welcome to Heart Health Imaging and Recording System");
		title.setFont(Font.font(TITLE_FONT));
		title.setPadding(new Insets(0,0,10,0));
		BorderPane.setAlignment(title, Pos.TOP_CENTER);
		this.setTop(title);
		
		receptionist.setFont(Font.font(BODY_FONT));
		receptionist.setStyle("-fx-background-color: #6074bc");
		Label blank1 = new Label();
		CTScan.setFont(Font.font(BODY_FONT));
		CTScan.setStyle("-fx-background-color: #6074bc");
		Label blank2 = new Label();
		patient.setFont(Font.font(BODY_FONT));
		patient.setStyle("-fx-background-color: #6074bc");
		
		//Button Handlers
		receptionist.setOnAction(e ->
		{
			Stage stage = (Stage) getScene().getWindow();
			stage.setScene(new Scene(new StackPane(new ReceptionistView()), WIDTH, HEIGHT));
			stage.setTitle("Patient Intake Form");
		});
		
		selection.setAlignment(Pos.CENTER);
		selection.getChildren().addAll(receptionist, blank1, CTScan, blank2, patient);
		this.setCenter(selection);
	}
}
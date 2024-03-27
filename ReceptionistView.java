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
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class ReceptionistView extends GridPane
{
	private static final int WIDTH = 800, HEIGHT = 400, BODY_FONT = 16, TITLE_FONT = 20;
	private Label title, fName, lName, email, phone, history, insurance;
	private TextField fNameT, lNameT, emailT, phoneT, historyT, insuranceT;
	private Button save;
	
	public ReceptionistView()
	{
		PatientUtil utility = new PatientUtil();
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
		
		setPadding(new Insets(10));
		setHgap(10);
		setVgap(5);
		
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
		
		save.setOnAction(e -> 
		{
			String first = fNameT.getText();
			String last = lNameT.getText();
			String email = emailT.getText();
			String phone = phoneT.getText();
			String history = historyT.getText();
			String insurance = insuranceT.getText();
			int patientID = utility.generateID();
			Patient patient = new Patient(first, last, email, phone, history, insurance, patientID);
			utility.addPatient(patient);
			Stage stage = (Stage) getScene().getWindow();
			stage.setScene(new Scene(new StackPane(new HomePage()), WIDTH, HEIGHT));
			stage.setTitle("Heart Health - Home Page");
			/*
			 * IMPLEMENT FUNCTIONALITY TO SAVE PATIENT INFO IN TEXT FILE
			 */
		});
	}
}
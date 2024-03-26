package hw4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;


public class HW4 extends Application
{
	private static final int WIDTH = 800, HEIGHT = 400;		
	private Stage stage;
	
	//Main method to control application
	public static void main(String[] args)
	{
		launch(args);
	} //Method main
	
	public void start(Stage stage)
	{
//		this.stage = stage;
//		NurseView scene2 = new NurseView();
//		PatientHistory scene3 = new PatientHistory();
		StackPane root = new StackPane();
		//root.getChildren().add();
		Scene scene = new Scene(root, WIDTH, HEIGHT);
		stage.setTitle("Nurse Portal");
		stage.setScene(scene);
		stage.show();
	} //Method start

}

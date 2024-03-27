package hw4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;


public class HW4 extends Application
{
	private static final int WIDTH = 800, HEIGHT = 400;		
	
	//Main method to control application
	public static void main(String[] args)
	{
		launch(args);
	} //Method main
	
	public void start(Stage stage)
	{
//		HomePage home = new HomePage();
		ReceptionistView home = new ReceptionistView();
		StackPane root = new StackPane();
		root.getChildren().add(home);
		Scene scene = new Scene(root, WIDTH, HEIGHT);
		stage.setTitle("Heart Health - Home Page");
		stage.setScene(scene);
		stage.show();
	} //Method start
}
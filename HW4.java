/*
 * Name: Sukhmanjot Khangura
 * ID: 1221691458
 * Class: CSE 360 Spring 2024
 * Time: Th 1:30pm
 * Instructor: Lynn Robert Carter
 * Assignment: Homework 4
 */

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
		//Start at home page and launch application
		HomePage home = new HomePage();
		StackPane root = new StackPane();
		root.getChildren().add(home);
		Scene scene = new Scene(root, WIDTH, HEIGHT);
		stage.setTitle("Heart Health - Home Page");
		stage.setScene(scene);
		stage.show();
	} //Method start
}
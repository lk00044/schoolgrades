package edu.westga.cs.schoolgrades;

import java.net.URL;

import edu.westga.cs.babble.Babble;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class for the SchoolGrades project
 * 
 * @author Leslie Keller
 * @version Fall 2023
 */

//private static final String GUI_RESOURCE = "edu/westga/cs/babble/views/SchoolGradesGui.fxml";

public class schoolgrades extends Application  {
	  ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
      URL resource = classLoader.getResource(SchoolGrades.GUI_RESOURCE);
      FXMLLoader loader = new FXMLLoader(resource);
      Parent root = (Parent) loader.load();
      Scene scene = new Scene(root);
      primaryStage.setScene(scene);
      primaryStage.setTitle("School Grades");
      primaryStage.show();
  }

  /**
   * Start point for the application.
   * 
   * @param args not used
   */
  public static void main(String[] args) {
      launch(args);
  }

@Override
public void start(Stage arg0) throws Exception {
	// TODO Auto-generated method stub
	
}

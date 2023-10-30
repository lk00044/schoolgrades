package edu.westga.cs.schoolsgrades.controller;

import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.GradeCalculationStrategy;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.util.converter.NumberStringConverter;

public class SchoolGradesController {

	@FXML private TextField txtSubTotQuiz;
	@FXML private TextField txtSubTotHW;
	@FXML private TextField txtSubTotExam;
	@FXML private TextField txtFinalGrade;
    @FXML private ListView <Grade> lstQuizGrades;
    @FXML private ListView <Grade> lstHWGrades;
    @FXML private ListView <Grade> lstExamGrades;
    @FXML private TextInputDialog td;    
    private IntegerProperty grade = new SimpleIntegerProperty(0);

    public static final ObservableList<Grade> quizGrades = FXCollections.observableArrayList();    
    public static final ObservableList<Grade> hwGrades = FXCollections.observableArrayList();    
    public static final ObservableList<Grade> examGrades =  FXCollections.observableArrayList();
    
    /**
     * initialize the game
     * @precondition: none
     * @postcondition: 	School Grades is initialized
     */
    @FXML	
    private void initialize() {
    	 td = new TextInputDialog("Enter the grade"); 
         td.setHeaderText("School Grades"); 
    	 this.td.contentTextProperty().bindBidirectional(this.grade, new NumberStringConverter());  	
    }
    
    
    /**
     * Method to 
     * @precondition: none
     * @postcondition: 
     */
    @FXML protected void handleRecalcuateButtonAction(ActionEvent event) {
        
    }   
    
    
    /**
     * Method to add a quiz grade and update the subtotal
     * @precondition: none
     * @postcondition: Quiz grade is added and the subtotal is updated.
     */
    @FXML protected void handleMenuItemAddQuizAction(ActionEvent event) {

    	SchoolGradesController.quizGrades.add(new SimpleGrade(Double.parseDouble(grade)));
    }   
    
    /**
     * Method to add a homework grade and update the average
     * Note: Average after dropping lowest grade.
     * @precondition: none
     * @postcondition: Homework grade is added and the average is updated.
     */
    @FXML protected void handleMenuItemAddHomeworkAction(ActionEvent event) {
        
    }   
    
    /**
     * Method to add an exam grade and update the average
     * @precondition: none
     * @postcondition: Exam grade is added and the average is updated.
     */
    @FXML protected void handleMenuItemAddExamAction(ActionEvent event) {
        
    }   
    
    private Grade getGrade() {
    	this.td.showAndWait();
    	this.td.setContentText("Grade: ");
    	String inputGrade = this.td.getEditor().getText();
    	int gradeToAdd = Integer.parseInt(inputGrade); 
    	
    	
    	return null;
    }
    
    
}

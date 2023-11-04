package edu.westga.cs.schoolsgrades.controller;

import edu.westga.cs.babble.controllers.BabbleController;
import edu.westga.cs.babble.model.Tile;
import edu.westga.cs.schoolgrades.model.AverageOfGradesStrategy;
import edu.westga.cs.schoolgrades.model.DropLowestStrategy;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.GradeCalculationStrategy;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.converter.StringConverter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.ChoiceBoxListCell;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.Callback;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.NumberStringConverter;

public class SchoolGradesController {

	@FXML private TextField txtSubTotQuiz;
	@FXML private TextField txtSubTotHW;
	@FXML private TextField txtSubTotExam;
	@FXML private TextField txtFinalGrade;
    @FXML private ListView <Double> lstQuizGrades;
    @FXML private ListView <Double> lstHWGrades;
    @FXML private ListView <Double> lstExamGrades;
  
    
    private IntegerProperty grade = new SimpleIntegerProperty(0);
    
    DoubleStringConverter converter;

    public static final ObservableList<Double> quizGrades = FXCollections.observableArrayList();    
    public static final ObservableList<Double> hwGrades = FXCollections.observableArrayList();    
    public static final ObservableList<Double> examGrades =  FXCollections.observableArrayList();
    
    private DropLowestStrategy strategyDropAvg;
    private AverageOfGradesStrategy strategyAvg;
    private SumOfGradesStrategy strategySum;
    
    
    /**
     * initialize the listviews, strategies, and converter
     * @precondition: none
     * @postcondition: 	School Grades is initialized
     */
    @FXML	
    private void initialize() {
    	this.lstQuizGrades = new ListView<Double>(SchoolGradesController.quizGrades);
    	this.lstExamGrades = new ListView<Double>(SchoolGradesController.examGrades);
    	this.lstHWGrades = new ListView<Double>(SchoolGradesController.hwGrades);
    	converter = new DoubleStringConverter();
    	strategyAvg = new AverageOfGradesStrategy();
    	strategySum = new SumOfGradesStrategy();
    	strategyDropAvg = new DropLowestStrategy(strategyAvg);  
    	this.lstQuizGrades.setEditable(true); 
    	this.lstExamGrades.setEditable(true); 
    	this.lstHWGrades.setEditable(true); 
    }
    
    
    /**
     * Method to recalculate grades
     * @precondition: none
     * @postcondition: 
     */
    @FXML protected void handleRecalculateButtonAction(ActionEvent event) {
        
    }   
    
    
    /**
     * Method to add a quiz grade and update the subtotal
     * @precondition: none
     * @postcondition: Quiz grade is added and the subtotal is updated.
     */
    
    @FXML protected void handleMenuItemAddQuizAction(ActionEvent event) {
    	// set up initial value of 0.0
    	SimpleGrade newGrade = new SimpleGrade(0.00);
    	SchoolGradesController.quizGrades.add(newGrade.getValue());   
    	this.lstQuizGrades.setCellFactory(TextFieldListCell.forListView(converter));
    	this.lstQuizGrades.setItems(SchoolGradesController.quizGrades); 
		this.lstQuizGrades.accessibleTextProperty();
		this.lstQuizGrades.setAccessibleText("" + newGrade.getValue());	
		
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
   
    
}

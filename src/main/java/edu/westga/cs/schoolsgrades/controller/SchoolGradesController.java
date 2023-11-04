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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.ChoiceBoxListCell;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.converter.NumberStringConverter;

public class SchoolGradesController {

	@FXML private TextField txtSubTotQuiz;
	@FXML private TextField txtSubTotHW;
	@FXML private TextField txtSubTotExam;
	@FXML private TextField txtFinalGrade;
    @FXML private ListView <Number> lstQuizGrades;
    @FXML private ListView <Number> lstHWGrades;
    @FXML private ListView <Number> lstExamGrades;
  
    
    private IntegerProperty grade = new SimpleIntegerProperty(0);
    
    NumberStringConverter converter;

    public static final ObservableList<Number> quizGrades = FXCollections.observableArrayList();    
    public static final ObservableList<Number> hwGrades = FXCollections.observableArrayList();    
    public static final ObservableList<Number> examGrades =  FXCollections.observableArrayList();
    
    private DropLowestStrategy strategyDropAvg;
    private AverageOfGradesStrategy strategyAvg;
    private SumOfGradesStrategy strategySum;
    
    
    /**
     * initialize the game
     * @precondition: none
     * @postcondition: 	School Grades is initialized
     */
    @FXML	
    private void initialize() {
    	converter = new NumberStringConverter();
    	strategyAvg = new AverageOfGradesStrategy();
    	strategySum = new SumOfGradesStrategy();
    	strategyDropAvg = new DropLowestStrategy(strategyAvg);  
    	 	
    }
    
    
    /**
     * Method to 
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
    	SimpleGrade newGrade = new SimpleGrade(0.00);
    	SchoolGradesController.quizGrades.add(newGrade.getValue());    	
    	this.lstQuizGrades.setCellFactory(TextFieldListCell.forListView(converter));
    	this.lstQuizGrades.getItems().add((Number) SchoolGradesController.quizGrades); 
		this.lstQuizGrades.accessibleTextProperty();
		this.lstQuizGrades.setAccessibleText("" + newGrade.getValue());
		this.lstQuizGrades.setEditable(true); 
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
    	
    	return null;

    }
    
    
}

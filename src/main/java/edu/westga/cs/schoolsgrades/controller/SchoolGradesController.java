package edu.westga.cs.schoolsgrades.controller;

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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.TextFieldListCell;
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
    	this.lstQuizGrades.setEditable(true);
    	Grade newGrade = this.getGrade();
    	this.quizGrades.add(newGrade);
    	this.lstQuizGrades.setItems(SchoolGradesController.quizGrades);

    //	this.lstQuizGrades.setCellFactory(TextFieldListCell.forListView(this.quizGrades));
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
    
    private Grade getGrade() {  
    	
    	return null;

    }
    
    
}

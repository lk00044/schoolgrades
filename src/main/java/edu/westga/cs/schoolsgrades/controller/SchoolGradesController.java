package edu.westga.cs.schoolsgrades.controller;

import java.util.ArrayList;
import java.util.List;


import edu.westga.cs.schoolgrades.model.AverageOfGradesStrategy;
import edu.westga.cs.schoolgrades.model.DropLowestStrategy;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.GradeCalculationStrategy;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.converter.StringConverter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.Callback;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.NumberStringConverter;

public class SchoolGradesController {

	@FXML private TextField txtSubTotQuiz;
	@FXML private TextField txtSubTotHW;
	@FXML private TextField txtSubTotExam;
	@FXML private TextField txtFinalGrade;
	
    @FXML private ListView <Grade> lstQuizGrades;
    @FXML private ListView <Grade> lstHWGrades;
    @FXML private ListView <Grade> lstExamGrades;
   
    DoubleStringConverter converter;
    
    private SimpleDoubleProperty qzScore = new SimpleDoubleProperty(0.0);
    private SimpleDoubleProperty hwScore = new SimpleDoubleProperty(0.0);
    private SimpleDoubleProperty exScore = new SimpleDoubleProperty(0.0);

    public  final ObservableList<Grade> quizGrades = FXCollections.observableArrayList();    
    public  final ObservableList<Grade> hwGrades = FXCollections.observableArrayList();    
    public  final ObservableList<Grade> examGrades =  FXCollections.observableArrayList();
    
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
    	this.lstQuizGrades.setItems(this.quizGrades);
    	this.lstQuizGrades.setCellFactory(new GradeCellFactory());
    	
    	this.lstHWGrades.setItems(this.hwGrades);
    	this.lstHWGrades.setCellFactory(new GradeCellFactory());
    	
    	this.lstExamGrades.setItems(this.examGrades);
    	this.lstExamGrades.setCellFactory(new GradeCellFactory());
    
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
     * @postcondition: Score is displayed in textfield for the final grade.
     */
    @FXML protected void handleRecalculateButtonAction(ActionEvent event) {
    	 	double quiz = this.qzScore.getValue();
    	 	double hw = this.hwScore.getValue() / this.quizGrades.size();
    	 	double exam = this.exScore.getValue();
    	 	
    	 	SimpleDoubleProperty grade = new SimpleDoubleProperty(0.0);    	 	
    	 	grade.setValue(.2 * quiz + .2 * hw + .4 * exam);    	 	
    	 	this.txtFinalGrade.textProperty().bindBidirectional(grade, new NumberStringConverter()); 
    }   
    
    
    /**
     * Method to add a quiz grade and update the subtotal
     * @precondition: none
     * @postcondition: Quiz grade is added and the subtotal is updated.
     */
    
    @FXML protected void handleMenuItemAddQuizAction(ActionEvent event) {
    	// set up initial value of 0.0
    	SimpleGrade newGrade = new SimpleGrade(0.00);
    	this.quizGrades.add(newGrade);
    	this.lstQuizGrades.setItems(this.quizGrades); 	
    	
    	// Calculate Sum and show in textfield    
    	double calcScore = (this.strategySum.calculate(this.quizGrades));

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
    
    
    /*
     * Class to handle the grade in the list cell
     * Sets the text to the value of the grade
     */
    public class GradeCellFactory implements Callback<ListView<Grade>, ListCell<Grade>> {
        @Override
        public ListCell<Grade> call(ListView<Grade> param) {
            return new TextFieldListCell<>(){
            	@Override
                public void updateItem(Grade grade, boolean empty) {
                    super.updateItem(grade, empty);
                    if (empty || grade == null) {
                        setText(null);
                    } else {
                        setText("" + grade.getValue());                         
                    }
                }
            };
        }
    }
   
    
}

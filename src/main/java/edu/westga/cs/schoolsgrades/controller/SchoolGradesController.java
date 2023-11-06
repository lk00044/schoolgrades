package edu.westga.cs.schoolsgrades.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ChangeListener;

import edu.westga.cs.babble.controllers.BabbleController;
import edu.westga.cs.babble.model.Tile;
import edu.westga.cs.schoolgrades.model.AverageOfGradesStrategy;
import edu.westga.cs.schoolgrades.model.DropLowestStrategy;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.GradeCalculationStrategy;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;
import javafx.beans.property.IntegerProperty;
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
   
    DoubleStringConverter converter;
    
    private SimpleDoubleProperty qzScore = new SimpleDoubleProperty(0.0);
    private SimpleDoubleProperty hwScore = new SimpleDoubleProperty(0.0);
    private SimpleDoubleProperty exScore = new SimpleDoubleProperty(0.0);

    public static final ObservableList<Double> quizGrades = FXCollections.observableArrayList();    
    public static final ObservableList<Double> hwGrades = FXCollections.observableArrayList();    
    public static final ObservableList<Double> examGrades =  FXCollections.observableArrayList();
    
    private DropLowestStrategy strategyDropAvg;
    private AverageOfGradesStrategy strategyAvg;
    private SumOfGradesStrategy strategySum;
    
    private List<Grade> gradesQz;
    private List<Grade> gradesHW;
    private List<Grade> gradesEx;
    
    
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
    	
    	this.gradesQz = new ArrayList<Grade>();
    	this.gradesHW = new ArrayList<Grade>();
    	this.gradesEx = new ArrayList<Grade>();
    	
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
    	 	double hw = this.hwScore.getValue() / this.lstQuizGrades.getFixedCellSize();
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
    	SchoolGradesController.quizGrades.add(newGrade.getValue());   
    	this.lstQuizGrades.setCellFactory(TextFieldListCell.forListView(converter)); 	
    	this.lstQuizGrades.setItems(SchoolGradesController.quizGrades); 
    	this.gradesQz.add(newGrade);
    	
    	// Update the grade    	
    	this.lstQuizGrades.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Double>() {
         
    		public void changed(ObservableValue<? extends Double> observable, Double oldValue, Double newValue) {
            
        	  int index = this.lstQuizGrades.getSelectionModel().selectedItemIndex();        	  
        	  SchoolGradesController.quizGrades(index).set(newValue);             	  
        	  this.gradesQz.add(newValue);
        	  
          }
        });
    	
    	
    	// Calc Sum and show in textfield    
    	double calcScore = (this.strategySum.calculate(this.gradesQz));
    	this.qzScore.setValue(calcScore);    	
    	
    	this.txtSubTotQuiz.textProperty().bindBidirectional(this.qzScore, new NumberStringConverter());  
    	
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

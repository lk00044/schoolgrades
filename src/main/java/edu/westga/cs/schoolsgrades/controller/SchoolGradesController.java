package edu.westga.cs.schoolsgrades.controller;

import edu.westga.cs.schoolgrades.model.AverageOfGradesStrategy;
import edu.westga.cs.schoolgrades.model.DropLowestStrategy;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.Callback;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.NumberStringConverter;
import javafx.util.StringConverter;


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
    
    private SimpleDoubleProperty gradeQuiz;
    private SimpleDoubleProperty gradeHW;
    private SimpleDoubleProperty gradeExam;
    
    
    
    /**
     * initialize the listviews, strategies, and converter
     * @precondition: none
     * @postcondition: 	School Grades is initialized
     */
    @FXML	
    private void initialize() {
    	this.lstQuizGrades.setItems(this.quizGrades);
   // 	this.lstQuizGrades.setCellFactory(new GradeCellFactory());
    	
    	this.lstQuizGrades.setCellFactory(lv -> {
    	    TextFieldListCell<Grade> cell = new TextFieldListCell<Grade>();
    	    StringConverter<Grade> converter = new StringConverter<Grade>() {

    	        @Override
    	        public String toString(Grade grade) {
    	            return "" + grade.getValue();
    	        }

    	        @Override
    	        public Grade fromString(String string) {
    	        	 SimpleGrade grade = (SimpleGrade) cell.getItem();
    	             if (grade == null) {
    	            	 Grade newGrade = new SimpleGrade(Double.parseDouble(string));
    	                 return newGrade;
    	             } else {
    	            	 grade.setValue(Double.parseDouble(string));
    	                 return grade ;
    	             }
    	         }

    	    };

    	    cell.setConverter(converter);

    	    return cell ;
    	});
    	
    	
    	
    	this.lstHWGrades.setItems(this.hwGrades);
    //	this.lstHWGrades.setCellFactory(new GradeCellFactory());
    	
    	this.lstHWGrades.setCellFactory(lv -> {
    	    TextFieldListCell<Grade> cell = new TextFieldListCell<Grade>();
    	    StringConverter<Grade> converter = new StringConverter<Grade>() {

    	        @Override
    	        public String toString(Grade grade) {
    	            return "" + grade.getValue();
    	        }

    	        @Override
    	        public Grade fromString(String string) {
    	        	 SimpleGrade grade = (SimpleGrade) cell.getItem();
    	             if (grade == null) {
    	            	 Grade newGrade = new SimpleGrade(Double.parseDouble(string));
    	                 return newGrade;
    	             } else {
    	            	 grade.setValue(Double.parseDouble(string));
    	                 return grade ;
    	             }
    	         }

    	    };

    	    cell.setConverter(converter);

    	    return cell ;
    	});
    	
    	
    	this.lstExamGrades.setItems(this.examGrades);
 //   	this.lstExamGrades.setCellFactory(new GradeCellFactory());
    	
    	this.lstExamGrades.setCellFactory(lv -> {
    	    TextFieldListCell<Grade> cell = new TextFieldListCell<Grade>();
    	    StringConverter<Grade> converter = new StringConverter<Grade>() {

    	        @Override
    	        public String toString(Grade grade) {
    	            return "" + grade.getValue();
    	        }

    	        @Override
    	        public Grade fromString(String string) {
    	        	 SimpleGrade grade = (SimpleGrade) cell.getItem();
    	             if (grade == null) {
    	            	 Grade newGrade = new SimpleGrade(Double.parseDouble(string));
    	                 return newGrade;
    	             } else {
    	            	 grade.setValue(Double.parseDouble(string));
    	                 return grade ;
    	             }
    	         }

    	    };

    	    cell.setConverter(converter);

    	    return cell ;
    	});
    	
    
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
    		double gradeQ = (this.strategySum.calculate(this.quizGrades));
    		gradeQuiz.setValue(gradeQ);  
    		
    		double gradeH = (this.strategySum.calculate(this.quizGrades));
    		gradeHW.setValue(gradeH); 
    		
    		double gradeEx = (this.strategySum.calculate(this.quizGrades));
    		gradeExam.setValue(gradeEx); 
    	
    	 	double quiz = this.qzScore.getValue();
    	 	double hw = this.hwScore.getValue() / this.quizGrades.size();
    	 	double exam = this.exScore.getValue();
    	 	
    	 	SimpleDoubleProperty grade = new SimpleDoubleProperty(0.0);    	 	
    	 	grade.setValue(.2 * quiz + .3 * hw + .5 * exam);    	 	
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
    	
    	
    	// Calculate Sum and show in textfield  
    	this.gradeQuiz= new SimpleDoubleProperty(0.0); 
    	
    	this.quizGrades.add(newGrade);
    	this.lstQuizGrades.setItems(this.quizGrades); 	
    	
    	double grade = (this.strategySum.calculate(this.quizGrades));
    	gradeQuiz.setValue(grade);   

    	this.txtSubTotQuiz.textProperty().bindBidirectional(gradeQuiz, new NumberStringConverter()); 

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
    	// set up initial value of 0.0
    	SimpleGrade newGrade = new SimpleGrade(0.00);
    	this.hwGrades.add(newGrade);
    	this.lstHWGrades.setItems(this.hwGrades); 	

    	// Calculate Sum and show in textfield  
    	SimpleDoubleProperty gradeHW = new SimpleDoubleProperty(0.0); 
    	this.txtSubTotHW.textProperty().bindBidirectional(gradeHW, new NumberStringConverter()); 
    	double grade = (this.strategyDropAvg.calculate(this.hwGrades));
    	gradeHW.setValue(grade);  

    	this.lstQuizGrades.accessibleTextProperty();
		this.lstQuizGrades.setAccessibleText("" + newGrade.getValue());	
    }   
    
    /**
     * Method to add an exam grade and update the average
     * @precondition: none
     * @postcondition: Exam grade is added and the average is updated.
     */
    @FXML protected void handleMenuItemAddExamAction(ActionEvent event) {
    	// set up initial value of 0.0
    	SimpleGrade newGrade = new SimpleGrade(0.00);
    	this.examGrades.add(newGrade);
    	this.lstExamGrades.setItems(this.examGrades); 	
    	
    	// Calculate Sum and show in textfield    
    	SimpleDoubleProperty gradeExam = new SimpleDoubleProperty(0.0); 
    	double grade =  (this.strategyAvg.calculate(this.examGrades));
    	gradeExam.setValue(grade);     	

    	this.txtSubTotExam.textProperty().bindBidirectional(gradeExam, new NumberStringConverter()); 

    	this.lstQuizGrades.accessibleTextProperty();
		this.lstQuizGrades.setAccessibleText("" + newGrade.getValue());	
    }   
    
    
    /*
     * Class to handle the grade in the list cell
     * Sets the text to the value of the grade
     
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
    
    */
   
    
}

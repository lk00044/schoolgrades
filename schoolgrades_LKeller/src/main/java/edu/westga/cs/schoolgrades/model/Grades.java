package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * The Grades is a composite class that will hold multiple Grade-type objects
 * 
 * @author 	Leslie Keller
 * @version	13Oct2023
 */
public class Grades implements Grade{
	double value;
	ArrayList<Grade> grades;
	Strategy strategy;
	String strategyChoice;
	
	/**
	 * The Grades constructor initializes the arraylist that will hold the grade objects.
	 */
	public Grades(String strategyChoice) {
		grades = new ArrayList<Grade>();
		value = 0;
		if (strategyChoice.equals("Average")) {
			this.strategy = new StrategyAverageGrades();
		} else if (strategyChoice.equals("Sum")) {
			this.strategy = new StrategySumGrades();
		}
		
	}
	
	/**
	 * The getGrades method will return the arraylist
	 * @return	grades	the arraylist of Grade objects
	 */
	public ArrayList<Grade> getGrades() {
		return this.grades;
	}
	
	/**
	 * The addGrade method will add a Grade object to the arraylist
	 * @param	grade	the Grade object to be added
	 */
	public void addGrade(Grade aGrade) {
		this.grades.add(aGrade);
	}
	
	
	/**
	 * This method returns the value of the grades object.
	 * @return	value	the value of the grade
	 */
	@Override
	public double getValue() {
		this.value = strategy.calcuateGrade(grades);		
		return value;
	}
	

}

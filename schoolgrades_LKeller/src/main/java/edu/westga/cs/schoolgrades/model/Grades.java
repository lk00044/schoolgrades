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
	
	/**
	 * The Grades constructor initializes the arraylist that will hold the grade objects.
	 */
	public Grades() {
		grades = new ArrayList<Grade>();
		value = 0;
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
		double sum = 0;
		for (Grade grade : this.grades){
			sum += grade.getValue();
		}
		return sum;
	}
	

}

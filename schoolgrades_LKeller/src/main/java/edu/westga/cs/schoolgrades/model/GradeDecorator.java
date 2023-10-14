package edu.westga.cs.schoolgrades.model;


/**
 * Decorator for grade to apply weight
 * 
 * @author 	Leslie Keller
 * @version	14Oct2023
 */
public abstract class GradeDecorator implements Grade{

	protected Grade grade;
	
	public GradeDecorator(Grade grade) {
		this.grade = grade;
	}
	
	public double getValue() {		
		return this.grade.getValue();
	}

}

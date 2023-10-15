package edu.westga.cs.schoolgrades.model;


/**
 * Decorator for grade to apply weight
 * 
 * @author 	Leslie Keller
 * @version	14Oct2023
 */
public class WeightedGrade implements Grade{
	protected Grade grade;
	private double weight;
	
	public WeightedGrade(Grade grade, double weight) {
		if (grade.getValue() < 0) {
			throw new IllegalArgumentException("Negative grades not allowed.");
			
		}
		if (weight < 0) {
			throw new IllegalArgumentException("Negative weights not allowed.");
			
		}
		this.grade = grade;
		this.weight = weight;
	}
	
	public double getValue() {		
		return this.grade.getValue() * this.weight;
	}

}

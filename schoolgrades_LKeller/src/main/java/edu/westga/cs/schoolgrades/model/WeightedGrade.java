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
	
	/**
	 * Construct a weighted grade from a grade and a weight
	 * @param grade		the grade to update
	 * @param weight	the weight to use
	 * @precondition	grade >= 0
	 * @precondition	weight >= 0
	 */
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
	
	/**
	 * Return the value of the weighted grade
	 */
	public double getValue() {		
		return this.grade.getValue() * this.weight;
	}

}

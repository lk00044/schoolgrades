package edu.westga.cs.schoolgrades.model;

/**
 * WeightDecorator class to apply a weight to a grade
 * 
 * @author 	Leslie Keller
 * @version	14Oct2023
 */
public class WeightDecorator extends GradeDecorator{

	private double weight;
	
	/**
	 * Creates the WeightDecorator
	 * @param grade	the grade to apply the weight to
	 */
	public WeightDecorator(Grade grade) {
		super(grade);
		this.weight = .50;
	}
	
	/**
	 * Return the value weighted
	 * @return	the value * the weight
	 */
	public double getValue() {		
		return this.grade.getValue() * this.weight;
	}
}

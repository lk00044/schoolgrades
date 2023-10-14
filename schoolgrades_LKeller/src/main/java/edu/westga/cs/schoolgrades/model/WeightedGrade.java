package edu.westga.cs.schoolgrades.model;

/**
 * The WeightedGrade represents a weighted grade grade
 * 
 * @author 	Leslie Keller
 * @version	13Oct2023
 */
public class WeightedGrade implements Grade{
	
	private double value;
	private double weight;
	
	/**
	 * Constructor to create the WeightedGrade object
	 * @param: 			value	The value of the grade
	 * Precondition: 	value cannot be negative. 
	 */
	public WeightedGrade(double value, double weight) {
		if (value < 0)
		{
			throw new IllegalArgumentException("Grade cannot be negative.");
		}
		if (weight < 0)
		{
			throw new IllegalArgumentException("Grade weight cannot be negative.");
		}
		this.value = value;
		this.weight = weight;
	}

	/**
	 * This method returns the value of the simplegrade object.
	 * @return	value	the value of the grade
	 */
	@Override
	public double getValue() {
		return this.value * this.weight;
	//	Grade wtdGrade = new WeightDecorator(this);
	//	return wtdGrade.getValue();
		
	}

}

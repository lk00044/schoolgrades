package edu.westga.cs.schoolgrades.model;

public class WeightedGrade implements Grade{
	
	private double value;
	
	/**
	 * Constructor to create the SimpleGrade object
	 * @param: 			value	The value of the grade
	 * Precondition: 	value cannot be negative. 
	 */
	public WeightedGrade(double value) {
		if (value < 0)
		{
			throw new IllegalArgumentException("Grade cannot be negative.");
		}
		this.value = value;
	}

	@Override
	public double getValue() {
		return this.value;
	}

}

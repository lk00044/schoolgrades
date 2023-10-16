package edu.westga.cs.schoolgrades.model;

/**
 * The SimpleGrade represents an atomic grade
 * 
 * @author 	Leslie Keller
 * @version	13Oct2023
 */
public class SimpleGrade implements Grade{
	
	private double value;
	
	/**
	 * Constructor to create the SimpleGrade object
	 * @param: 			value	The value of the grade
	 * Precondition: 	value cannot be negative. 
	 */
	public SimpleGrade(double value) {
		if (value < 0.0)
		{
			throw new IllegalArgumentException("Grade cannot be negative.");
		}
		this.value = value;
	}
	
	/**
	 * This method returns the value of the simplegrade object.
	 * @return	value	the value of the grade
	 */
	@Override
	public double getValue() {
		return this.value;
	}

}

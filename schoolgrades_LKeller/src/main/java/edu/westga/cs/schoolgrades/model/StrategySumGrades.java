package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * This class handles the strategy that takes the grades and calculate the sum
 * 
 * @author 	Leslie Keller
 * @verion	13Oct2023
 */
public class StrategySumGrades implements Strategy{

	/**
	 * This method returns the sum of all Grade values
	 * @precondition	Grades is not null and there is 1 or more values in the grades ArrayList
	 * @return sum	the sum of all the Grade values
	 */
	@Override
	public double calcuateGrade(ArrayList<Grade> grades) {
		if (grades == null) {
			throw new IllegalArgumentException("There are no grades to calculate.");
		}
		if (grades.size() == 0) {
			throw new IllegalArgumentException("There are no grades to calculate.");
		}
		
		double sum = 0;
		for(Grade grade : grades) {
			sum += grade.getValue();
		}
		return sum;
	}

}

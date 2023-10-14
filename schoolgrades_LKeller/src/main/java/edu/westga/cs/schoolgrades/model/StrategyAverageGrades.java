package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * This class handles the strategy that calculates the average of the Grades
 * 
 * @author 	Leslie Keller
 * @version	13Oct2023
 */
public class StrategyAverageGrades implements Strategy{

	/**
	 * This method returns the sum of all Grade values
	 * @precondition	Grades is not null and there is 1 or more values in the grades ArrayLis
	 * @return average	the sum of all the Grade values divided by the number of Grades in the arraylist
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
		return sum/grades.size();
	}

}

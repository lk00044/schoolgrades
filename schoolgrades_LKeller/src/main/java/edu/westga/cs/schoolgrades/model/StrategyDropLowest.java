package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * Strategy decorator that will drop the lowest grade
 * 
 * @author	Leslie Keller
 * @version	15Oct2023
 */
public class StrategyDropLowest implements Strategy{
	protected Strategy strategy;
	
	public StrategyDropLowest(Strategy strategy) {
		if(strategy.equals(null)) {
			throw new IllegalArgumentException ("Strategy cannot be null");
		}
		this.strategy = strategy;
	}
	

	@Override
	public double calculateGrade(ArrayList<Grade> grades) {
		if(grades == null) {
			throw new IllegalArgumentException ("Grades cannot be null");
		}
		if(grades.size() <= 0) {
			throw new IllegalArgumentException("There are no grades.");
		}
		
		double lowestValue = Integer.MAX_VALUE;
		int lowestIndex = 0;
		for(int index = 0; index < grades.size(); index++) {
			if (grades.get(index).getValue() < lowestValue) {
				lowestValue = grades.get(index).getValue();
				lowestIndex = index;
			}
		}
		grades.remove(lowestIndex);		
		return this.strategy.calculateGrade(grades);
		
	}
	
	

}

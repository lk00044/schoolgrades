package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * Strategy decorator that will drop the lowest grade
 * 
 * @author	Leslie Kellre
 * @version	15Oct2023
 */
public class StrategyDropLowest implements Strategy{
	protected Strategy strategy;
	
	public StrategyDropLowest(Strategy strategy) {
		this.strategy = strategy;
	}
	

	@Override
	public double calculateGrade(ArrayList<Grade> grades) {
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

package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * This is the interface for the Strategy classes
 * 
 * @author 	Leslie Keller
 * @version	13Oct2023
 */
public interface Strategy {
	
	public double calculateGrade(ArrayList<Grade> grades);

}

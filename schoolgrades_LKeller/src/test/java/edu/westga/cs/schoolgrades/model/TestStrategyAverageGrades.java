package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestStrategyAverageGrades {

	@Test
	void testCalculateGradesWithAverage() {
		Strategy strategy = new StrategyAverageGrades();
		Grades grades = new Grades("Average");
		grades.addGrade(new SimpleGrade(90));
		grades.addGrade(new SimpleGrade(70));
		grades.addGrade(new SimpleGrade(80));
		assertEquals(80, strategy.calculateGrade(grades.getGrades()));		
	}
	
	@Test
	void testCalculateGradesWithAverageNoGrades() {
		Strategy strategy = new StrategyAverageGrades();
		Grades grades = new Grades("Average");
		assertThrows(IllegalArgumentException.class, () -> {
			 strategy.calculateGrade(grades.getGrades());
		});
	}

}

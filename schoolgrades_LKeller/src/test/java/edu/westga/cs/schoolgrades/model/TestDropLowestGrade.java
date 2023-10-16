package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDropLowestGrade {


	@Test
	void testCalculateGradesWithAverageAndSimpleGrades() {
		Strategy strategy = new StrategyAverageGrades();
		Grades grades = new Grades("Average");
		grades.addGrade(new SimpleGrade(90));
		grades.addGrade(new SimpleGrade(70));
		grades.addGrade(new SimpleGrade(80));
		assertEquals(85, new StrategyDropLowest(strategy).calculateGrade(grades.getGrades()));		
	}

	@Test
	void testCalculateGradesWithAveragewithSimpleAndWeighted() {
		Strategy strategy = new StrategyAverageGrades();
		Grades grades = new Grades("Average");
		grades.addGrade(new WeightedGrade(new SimpleGrade(45), 2.0));
		grades.addGrade(new SimpleGrade(70));
		grades.addGrade(new SimpleGrade(80));
		assertEquals(85, new StrategyDropLowest(strategy).calculateGrade(grades.getGrades()));		
	}
	
	
	@Test
	void testCalculateGradesWithSum() {
		Strategy strategy = new StrategySumGrades();
		Grades grades = new Grades("Sum");
		grades.addGrade(new SimpleGrade(90));
		grades.addGrade(new SimpleGrade(70));
		grades.addGrade(new SimpleGrade(80));
		assertEquals(170, new StrategyDropLowest(strategy).calculateGrade(grades.getGrades()));		
	}
	
	@Test
	void testCalculateGradesWithSumWithSimpleAndWeighted() {
		Strategy strategy = new StrategySumGrades();
		Grades grades = new Grades("Sum");
		grades.addGrade(new WeightedGrade(new SimpleGrade(45), 2.0));
		grades.addGrade(new SimpleGrade(70));
		grades.addGrade(new SimpleGrade(80));
		assertEquals(170, new StrategyDropLowest(strategy).calculateGrade(grades.getGrades()));		
	}
	
	@Test
	void testCalculateGradesWithAverageNoGrades() {
		Strategy strategy = new StrategyAverageGrades();
		Grades grades = new Grades("Average");
		Strategy dropStrategy = new StrategyDropLowest(strategy);
		assertThrows(IllegalArgumentException.class, () -> {
			dropStrategy.calculateGrade(grades.getGrades());
		});
	}

}

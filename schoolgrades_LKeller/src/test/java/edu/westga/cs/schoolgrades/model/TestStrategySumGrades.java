package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestStrategySumGrades {

	@Test
	void testCalculateGradesWithSumSimpleGrade() {
		Strategy strategy = new StrategySumGrades();
		Grades grades = new Grades("Sum");
		grades.addGrade(new SimpleGrade(90));
		grades.addGrade(new SimpleGrade(70));
		grades.addGrade(new SimpleGrade(80));
		assertEquals(240, strategy.calculateGrade(grades.getGrades()));		
	}
	
	@Test
	void testCalculateGradesWithSumWimpleAndWeighted() {
		Strategy strategy = new StrategySumGrades();
		Grades grades = new Grades("Sum");
		grades.addGrade(new SimpleGrade(90));
		grades.addGrade(new SimpleGrade(70));
		grades.addGrade(new WeightedGrade(new SimpleGrade(40), 2.0));
		assertEquals(240, strategy.calculateGrade(grades.getGrades()));		
	}
	
	@Test
	void testCalculateGradesWithSumNoGrades() {
		Strategy strategy = new StrategySumGrades();
		Grades grades = new Grades("Sum");
		assertThrows(IllegalArgumentException.class, () -> {
			 strategy.calculateGrade(grades.getGrades());
		});
	}

}

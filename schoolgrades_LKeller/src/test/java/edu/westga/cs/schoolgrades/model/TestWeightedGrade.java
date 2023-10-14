package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestWeightedGrade {

	@Test
	void testWeightedGradeNegativeValue() {
		assertThrows(IllegalArgumentException.class, () -> {
			new WeightedGrade(-4, 100);
		});
	}
	
	@Test
	void testWeightedGradeNegativeWeight() {
		assertThrows(IllegalArgumentException.class, () -> {
			new WeightedGrade(94, -100);
		});
	}
	
	@Test
	void testWeightedGradeIntGradeDecimalWeight() {
		WeightedGrade grade = new WeightedGrade(100, .85);
		assertEquals(85, grade.getValue(), .0001);
	}
	
	@Test
	void testWeightedGradeDecimalGradeIntWeight() {
		WeightedGrade grade = new WeightedGrade(79.0, 1);
		assertEquals(79.0, grade.getValue(), .0001);
	}
	
	@Test
	void testWeightedGradeDecimalGradeDecimalWeight() {
		WeightedGrade grade = new WeightedGrade(200.0, 0.50);
		assertEquals(100.0, grade.getValue(), .0001);
	}
	
	@Test
	void testWeightedGradeIntGradeIntWeight() {
		WeightedGrade grade = new WeightedGrade(98, 1);
		assertEquals(98.0, grade.getValue(), .0001);
	}

}

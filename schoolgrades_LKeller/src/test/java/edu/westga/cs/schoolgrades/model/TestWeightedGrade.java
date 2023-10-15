package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestWeightedGrade {

	
	@Test
	void testWeightedGradeNegativeWeight() {
		Grade grade = new SimpleGrade(94);
		assertThrows(IllegalArgumentException.class, () -> {
			new WeightedGrade(grade, -100);
		});
	}
	
	@Test
	void testWeightedGradeIntGradeDecimalWeight() {
		Grade grade = new SimpleGrade(100);
		Grade wtdGrade = new WeightedGrade(grade, .85);
		assertEquals(85, wtdGrade.getValue(), .0001);
	}
	
	@Test
	void testWeightedGradeDecimalGradeIntWeight() {
		Grade grade = new SimpleGrade(79.0);
		Grade wtdGrade = new WeightedGrade(grade, 1);
		assertEquals(79.0, wtdGrade.getValue(), .0001);
	}
	
	@Test
	void testWeightedGradeDecimalGradeDecimalWeight() {
		Grade grade = new SimpleGrade(200);
		Grade wtdGrade = new WeightedGrade(grade, 0.50);
		assertEquals(100.0, wtdGrade.getValue(), .0001);
	}
	
	@Test
	void testWeightedGradeIntGradeIntWeight() {
		Grade grade = new SimpleGrade(98);
		Grade wtdGrade = new WeightedGrade(grade, 1);
		assertEquals(98.0, wtdGrade.getValue(), .0001);
	}

}

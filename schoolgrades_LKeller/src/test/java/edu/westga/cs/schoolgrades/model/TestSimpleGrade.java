package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSimpleGrade {

	@Test
	void testSimpleGradeNegativeValue() {
		assertThrows(IllegalArgumentException.class, () -> {
			new SimpleGrade(-4);
		});
	}
	
	@Test
	void testSimpleGrade0Value() {
		SimpleGrade grade = new SimpleGrade(0);
		assertEquals(0, grade.getValue(), 0.0001);
	}
	
	@Test
	void testSimpleGrade100Value() {
		SimpleGrade grade = new SimpleGrade(100);
		assertEquals(100, grade.getValue(), 0.0001);
	}

}

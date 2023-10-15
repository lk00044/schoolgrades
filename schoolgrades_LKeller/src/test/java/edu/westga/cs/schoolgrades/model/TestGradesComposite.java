package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestGradesComposite {
	

	@Test
	void testCreationOfEmptyGradesArrayListWithAverage() {
		Grades grades = new Grades("Average");
		assertTrue(grades.getGrades().isEmpty());
	}
	
	@Test
	void testCreationOfEmptyGradesArrayListWithSum() {
		Grades grades = new Grades("Sum");
		assertTrue(grades.getGrades().isEmpty());
	}
	
	@Test
	void testAddingNegativeGradeToGradesArrayListWithAverage() {
		Grades grades = new Grades("Average");
		assertThrows(IllegalArgumentException.class, () -> {
			grades.addGrade(new SimpleGrade(-90));
		});
	}
	
	@Test
	void testAddingNegativeGradeToGradesArrayListWithSum() {
		Grades grades = new Grades("Sum");
		assertThrows(IllegalArgumentException.class, () -> {
			grades.addGrade(new SimpleGrade(-90));
		});
	}
	
	@Test
	void testAddingGradeToGradesArrayListWithAverage() {
		Grades grades = new Grades("Average");
		grades.addGrade(new SimpleGrade(90));
		grades.addGrade(new WeightedGrade(new SimpleGrade(90), 1.0));
		assertEquals(90, grades.getValue(), .0001);
	}
	
	@Test
	void testAddingGradeToGradesArrayListWithSum() {
		Grades grades = new Grades("Sum");
		grades.addGrade(new SimpleGrade(90));
		grades.addGrade(new WeightedGrade(new SimpleGrade(90), 1.0));
		assertEquals(180, grades.getValue(), .0001);
	}
	
	@Test
	void testAdding3GradesToGradesArrayListWithGetValueWithAverage() {
		Grades grades = new Grades("Average");
		grades.addGrade(new SimpleGrade(90));
		grades.addGrade(new SimpleGrade(80));
		grades.addGrade(new WeightedGrade(new SimpleGrade(80), 1.0));
		grades.addGrade(new WeightedGrade(new SimpleGrade(90), 1.0));
		assertEquals(85, grades.getValue(), .0001);
	}
	
	@Test
	void testAdding3GradesToGradesArrayListWithGetValueWithSum() {
		Grades grades = new Grades("Sum");
		grades.addGrade(new SimpleGrade(90));
		grades.addGrade(new SimpleGrade(70));
		grades.addGrade(new SimpleGrade(80));
		assertEquals(240, grades.getValue(), .0001);		
	}
	
	@Test
	void testAdding3GradesToGradesArrayListSizeWithGetGradesWithSum() {
		Grades grades = new Grades("Sum");
		grades.addGrade(new SimpleGrade(90));
		grades.addGrade(new SimpleGrade(70));
		grades.addGrade(new SimpleGrade(80));
		assertEquals(3, grades.getGrades().size());		
	}

}

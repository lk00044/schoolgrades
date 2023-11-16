package edu.westga.cs.schoolgrades.model;



import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class TestDropLowestStrategyCalculate {

	private DropLowestStrategy dropLowestStrategy;
	private GradeCalculationStrategy childStrategy;
	
	private static final double DELTA = 0.001;
	private Grade mockGrade0;
	private Grade mockGrade1;
	private Grade mockGrade2;
	
	private List<Grade> grades;
	private List<Grade> lowGrades;
	
	@BeforeEach
	public void setUp() throws Exception {
		mockGrade0 = mock(Grade.class);
		when(mockGrade0.getValue()).thenReturn(10.00);
		mockGrade1 = mock(Grade.class);
		when(mockGrade1.getValue()).thenReturn(20.00);
		mockGrade2 = mock(Grade.class);
		when(mockGrade2.getValue()).thenReturn(30.00);
		
		grades = new ArrayList<Grade>();
		lowGrades = new ArrayList<Grade>();
		
		childStrategy = new SumOfGradesStrategy();
		dropLowestStrategy = new DropLowestStrategy(childStrategy);
	}

	@Test
	public void shouldNotAllowNullGradesList() {
		assertThrows(IllegalArgumentException.class, () ->{ 
			dropLowestStrategy.calculate(null);
		});
	}

	@Test
	public void shouldNotDropLowestIfGradesListIsEmpty() {
		assertEquals(0, dropLowestStrategy.calculate(grades), DELTA);
	}
	
	public void shouldNotDropLowestIfGradesListHasOneElement() {
		grades.add(mockGrade0);
		assertEquals(mockGrade0.getValue(), dropLowestStrategy.calculate(grades), DELTA);
	}
	
	@Test
	public void canDropWhenLowestIsFirst() {
		grades.add(mockGrade0);
		grades.add(mockGrade1);
		grades.add(mockGrade2);
		this.lowGrades.add(mockGrade1);
		this.lowGrades.add(mockGrade2);
		
		
	//	ArgumentCaptor<List<Grade>> argumentCaptor = ArgumentCaptor.forClass(List.class);
	//	verify(grades).addAll(argumentCaptor.capture());
		
		double lowSum = childStrategy.calculate(lowGrades);
		double gradesSum = dropLowestStrategy.calculate(grades);
		double diff = lowSum - gradesSum;
		
		//ArgumentCaptor<Grade> argumentCaptor = ArgumentCaptor.forClass(Grade.class);
		//verify(grades).addAll(this.lowGrades);
		
		
		assertEquals(0, diff, DELTA);
		assertEquals(50, dropLowestStrategy.calculate(grades), DELTA);
		
	}
	
	
	@Test
	public void canDropWhenLowestIsLast() {
		grades.add(mockGrade1);
		grades.add(mockGrade2);
		grades.add(mockGrade0);
		assertEquals(50, dropLowestStrategy.calculate(grades), DELTA);
	}
	
	@Test
	public void canDropWhenLowestIsInMiddle() {
		grades.add(mockGrade1);
		grades.add(mockGrade0);
		grades.add(mockGrade2);
		assertEquals(50, dropLowestStrategy.calculate(grades), DELTA);
	}
	
	@Test
	public void dropsOnlyOneIfThereAreMultipleLowestGrades() {
		grades.add(mockGrade1);
		grades.add(mockGrade0);
		grades.add(mockGrade2);
		grades.add(mockGrade0);
		assertEquals(60, dropLowestStrategy.calculate(grades), DELTA);
	}
}

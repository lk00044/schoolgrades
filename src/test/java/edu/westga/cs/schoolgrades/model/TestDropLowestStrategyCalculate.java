package edu.westga.cs.schoolgrades.model;



import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

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
		this.grades = new ArrayList<Grade>();
		this.lowGrades = new ArrayList<Grade>();
		
		this.mockGrade0 = mock(Grade.class);
		when(this.mockGrade0.getValue()).thenReturn(10.00);
		this.mockGrade1 = mock(Grade.class);
		when(this.mockGrade1.getValue()).thenReturn(20.00);
		this.mockGrade2 = mock(Grade.class);
		when(this.mockGrade2.getValue()).thenReturn(30.00);
		
		this.childStrategy = mock(GradeCalculationStrategy.class);
		this.dropLowestStrategy = new DropLowestStrategy(this.childStrategy);
	}

	@Test
	public void shouldNotAllowNullGradesList() {
		this.dropLowestStrategy.calculate(this.grades);
		verify(this.childStrategy).calculate(this.lowGrades);
		
//		assertThrows(IllegalArgumentException.class, () ->{ 
//			dropLowestStrategy.calculate(null);
//		});
	}

	@Test
	public void shouldNotDropLowestIfGradesListIsEmpty() {
		this.dropLowestStrategy.calculate(this.grades);
		verify(this.childStrategy).calculate(this.lowGrades);	
		
	//	assertEquals(0, dropLowestStrategy.calculate(grades), DELTA);
	}
	
	public void shouldNotDropLowestIfGradesListHasOneElement() {
		this.grades.add(mockGrade0);
		
		this.dropLowestStrategy.calculate(this.grades);
		verify(this.childStrategy).calculate(this.lowGrades);
		
	//	assertEquals(mockGrade0.getValue(), this.dropLowestStrategy.calculate(this.grades), DELTA);
	}
	
	@Test
	public void canDropWhenLowestIsFirst() {
		this.grades.add(mockGrade0);
		this.grades.add(mockGrade1);
		this.grades.add(mockGrade2);		
		this.lowGrades.add(mockGrade1);
		this.lowGrades.add(mockGrade2);
		
		this.dropLowestStrategy.calculate(this.grades);
		verify(this.childStrategy).calculate(this.lowGrades);
		
	//	assertEquals(50, this.dropLowestStrategy.calculate(this.grades), DELTA);		
	}
	
	
	@Test
	public void canDropWhenLowestIsLast() {
		this.grades.add(mockGrade1);
		this.grades.add(mockGrade2);
		this.grades.add(mockGrade0);
		this.lowGrades.add(mockGrade1);
		this.lowGrades.add(mockGrade2);
		
		this.dropLowestStrategy.calculate(this.grades);
		verify(this.childStrategy).calculate(this.lowGrades);
		
	//	assertEquals(50, this.dropLowestStrategy.calculate(this.grades), DELTA);
	}
	
	@Test
	public void canDropWhenLowestIsInMiddle() {
		grades.add(mockGrade1);
		grades.add(mockGrade0);
		grades.add(mockGrade2);

		this.lowGrades.add(mockGrade1);
		this.lowGrades.add(mockGrade2);
		
		this.dropLowestStrategy.calculate(this.grades);
		verify(this.childStrategy).calculate(this.lowGrades);
		
//		assertEquals(50, dropLowestStrategy.calculate(this.grades), DELTA);
	}
	
	@Test
	public void dropsOnlyOneIfThereAreMultipleLowestGrades() {
		
		this.grades.add(mockGrade1);
		this.grades.add(mockGrade0);
		this.grades.add(mockGrade2);
		this.grades.add(mockGrade0);
		this.lowGrades.add(mockGrade1);		
		this.lowGrades.add(mockGrade2);
		this.lowGrades.add(mockGrade0);
		
		this.dropLowestStrategy.calculate(this.grades);
		verify(this.childStrategy).calculate(this.lowGrades);
		
		// assertEquals(60, dropLowestStrategy.calculate(grades), DELTA);
	}
}

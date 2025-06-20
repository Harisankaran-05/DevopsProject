package com.devops.devopsProject;

import static org.junit.Assert.*;
import org.junit.*;

public class StudentGradeCalculatorTest {

    @Test
    public void testGradeS() {
        assertEquals("S", StudentGradeCalculator.calculateGrade(95));
        assertEquals("S", StudentGradeCalculator.calculateGrade(90));
    }

    @Test
    public void testGradeA() {
        assertEquals("A", StudentGradeCalculator.calculateGrade(89));
        assertEquals("A", StudentGradeCalculator.calculateGrade(80));
    }

    @Test
    public void testGradeB() {
        assertEquals("B", StudentGradeCalculator.calculateGrade(79));
        assertEquals("B", StudentGradeCalculator.calculateGrade(70));
    }

    @Test
    public void testGradeC() {
        assertEquals("C", StudentGradeCalculator.calculateGrade(69));
        assertEquals("C", StudentGradeCalculator.calculateGrade(60));
    }

    @Test
    public void testGradeD() {
        assertEquals("D", StudentGradeCalculator.calculateGrade(59));
        assertEquals("D", StudentGradeCalculator.calculateGrade(50));
    }

    @Test
    public void testGradeF() {
        assertEquals("F", StudentGradeCalculator.calculateGrade(49));
        assertEquals("F", StudentGradeCalculator.calculateGrade(0));
    }

    @Test
    public void testInvalidGradeNotS() {
        assertNotEquals("S", StudentGradeCalculator.calculateGrade(89));
    }

    @Test
    public void testInvalidGradeNotF() {
        assertNotEquals("F", StudentGradeCalculator.calculateGrade(55));
    }
}

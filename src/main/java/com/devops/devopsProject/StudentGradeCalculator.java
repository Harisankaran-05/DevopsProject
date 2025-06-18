package com.devops.devopsProject;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class StudentGradeCalculator {
    static final Logger logger = Logger.getLogger(StudentGradeCalculator.class);

    public static String calculateGrade(int marks) {
        if (marks >= 90) return "S";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else return "F";
    }

    public static void main(String[] args) {
        BasicConfigurator.configure();

        if (args.length == 0) {
            logger.error("Please pass subject marks as command-line arguments.");
            logger.info("Example: java StudentGradeCalculator 90 80 70 65");
            return;
        }

        int numberOfSubjects = args.length;
        int[] marks = new int[numberOfSubjects];
        int total = 0;
        boolean allPassed = true;

        for (int i = 0; i < numberOfSubjects; i++) {
            try {
                int mark = Integer.parseInt(args[i]);
                if (mark < 0 || mark > 100) {
                    logger.error("Invalid mark for subject " + (i + 1) + ": " + mark);
                    return;
                }
                marks[i] = mark;
                total += mark;
                if (mark < 50) allPassed = false;
            } catch (NumberFormatException e) {
                logger.error("Invalid input for subject " + (i + 1) + ": " + args[i]);
                return;
            }
        }

        logger.info("\nSubject-wise Grades:");
        for (int i = 0; i < numberOfSubjects; i++) {
            logger.info("Subject " + (i + 1) + ": " + marks[i] + " → " + calculateGrade(marks[i]));
        }

        double average = total / (double) numberOfSubjects;
        int maxTotal = numberOfSubjects * 100;
        String overallGrade = calculateGrade((int) average);

        logger.info("\nTotal Marks Obtained: " + total + " out of " + maxTotal);
        logger.info(String.format("Average: %.2f", average));
        logger.info("Overall Grade: " + overallGrade);
        logger.info("Result: " + (allPassed ? "PASS" : "FAIL"));
    }
}

package com.baba.demo;

import java.util.List;

public class GradeCalculator {

    private int numberOfSubjects;
    private List<Integer> marks;

    public GradeCalculator(int numberOfSubjects, List<Integer> marks) {
        this.numberOfSubjects = numberOfSubjects;
        this.marks = marks;
    }

    public String calculateGrade() {
        int totalMarks = 0;

        for (int mark : marks) {
            totalMarks += mark;
        }

        double average = (double) totalMarks / numberOfSubjects;

        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else if (average >= 50) {
            return "E";
        } else {
            return "F";
        }
    }
}

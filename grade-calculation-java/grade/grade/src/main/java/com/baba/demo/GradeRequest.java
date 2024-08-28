package com.baba.demo;

import java.util.List;

public class GradeRequest {

    private int numberOfSubjects;
    private List<Integer> marks;

    // Getters and Setters
    public int getNumberOfSubjects() {
        return numberOfSubjects;
    }

    public void setNumberOfSubjects(int numberOfSubjects) {
        this.numberOfSubjects = numberOfSubjects;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }
}

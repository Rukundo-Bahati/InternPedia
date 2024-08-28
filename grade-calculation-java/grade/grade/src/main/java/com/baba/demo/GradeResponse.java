package com.baba.demo;

import java.util.List;

public class GradeResponse {

    private List<String> subjectMarks;
    private double totalMarks;
    private double maxMarks;
    private double percentage;
    private String grade;

    // Getters and Setters
    public List<String> getSubjectMarks() {
        return subjectMarks;
    }

    public void setSubjectMarks(List<String> subjectMarks) {
        this.subjectMarks = subjectMarks;
    }

    public double getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(double totalMarks) {
        this.totalMarks = totalMarks;
    }

    public double getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(double maxMarks) {
        this.maxMarks = maxMarks;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

package com.baba.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GradeController {

    @PostMapping("/calculate")
    public ResponseEntity<GradeResponse> calculateGrade(@RequestBody GradeRequest request) {
        List<Integer> marks = request.getMarks();
        int numberOfSubjects = request.getNumberOfSubjects();

        double totalMarks = 0;
        double maxMarks = 100 * numberOfSubjects;  // Assuming each subject is out of 100
        List<String> subjectMarks = new ArrayList<>();

        for (int i = 0; i < numberOfSubjects; i++) {
            int mark = marks.get(i);
            totalMarks += mark;
            subjectMarks.add("Subject " + (i + 1) + " : " + mark);
        }

        double percentage = (totalMarks / maxMarks) * 100;
        String grade = calculateGrade(percentage);

        GradeResponse response = new GradeResponse();
        response.setSubjectMarks(subjectMarks);
        response.setTotalMarks(totalMarks);
        response.setMaxMarks(maxMarks);
        response.setPercentage(percentage);
        response.setGrade("Your grade is : " + grade);

        return ResponseEntity.ok(response);
    }

    private String calculateGrade(double percentage) {
        if (percentage >= 90) return "A";
        else if (percentage >= 80) return "B";
        else if (percentage >= 70) return "C";
        else if (percentage >= 60) return "D";
        else return "F";
    }
}

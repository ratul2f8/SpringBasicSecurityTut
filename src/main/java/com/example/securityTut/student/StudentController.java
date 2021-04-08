package com.example.securityTut.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student("James", 1),
            new Student("Helena", 2),
            new Student("John", 3)
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(
            @PathVariable("studentId")
                    Integer studentId
    ) throws IllegalStateException {
        return STUDENTS.stream()
                .filter((student) -> student.getId().equals(studentId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "Student with " + studentId + " doesn't exist"
                ));
    }
}

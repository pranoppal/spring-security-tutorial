package com.pranoppal.springsecuritycourse.student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/management/api/v1/students")
public class StudentManagementController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Pranoppal"),
            new Student(2, "James"),
            new Student(3, "Adam")
    );
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_STUDENT','ROLE_ADMIN','ROLE_ADMIN_TRAINEE')")
    public List<Student> getAllStudent(){
        return STUDENTS;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void registerStudent(@RequestBody Student student){
        System.out.println("registerStudent");
        System.out.println(student);
    }

    @DeleteMapping(path = "/{studentId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        System.out.println("deleteStudent");
        System.out.println(studentId);
    }

    @PutMapping(path = "/{studentId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void updateStudent(@PathVariable("studentId") Integer studentId,@RequestBody Student student){
        System.out.println("updateStudent");
        System.out.println(String.format("%s %s",studentId, student));
    }
}

package com.javaBrains.javaBrains.service.admin;

import com.javaBrains.javaBrains.entity.school.Student;
import com.javaBrains.javaBrains.service.student.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final StudentService studentService;

    public AdminService(StudentService studentService) {
        this.studentService = studentService;
    }

    public List<Student> fetchAllRegisteredStudents() {
        return studentService.fetchAllRegisteredStudents();
    }
}

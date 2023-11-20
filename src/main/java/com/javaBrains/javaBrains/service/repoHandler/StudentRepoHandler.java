package com.javaBrains.javaBrains.service.repoHandler;

import com.javaBrains.javaBrains.entity.school.Student;
import com.javaBrains.javaBrains.repository.student.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentRepoHandler {

    private final StudentRepository studentRepository;

    public StudentRepoHandler(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void registerStudent(Student student) {studentRepository.save(student);}

    public List<Student> fetchAllStudents() {return studentRepository.findAll();}
}

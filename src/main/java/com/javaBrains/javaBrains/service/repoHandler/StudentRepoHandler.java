package com.javaBrains.javaBrains.service.repoHandler;

import com.javaBrains.javaBrains.entity.school.Student;
import com.javaBrains.javaBrains.repository.student.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentRepoHandler {

    private final StudentRepository studentRepository;

    public StudentRepoHandler(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void registerStudent(Student student) {studentRepository.save(student);}

    public List<Student> fetchAllStudents() {return studentRepository.findAll();}

    public Optional<Student> fetchStudentById(String id) {
        return studentRepository.findById(Long.parseLong(id));
    }
}

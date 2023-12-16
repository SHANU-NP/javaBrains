package com.javaBrains.javaBrains.service.student;

import com.javaBrains.javaBrains.constants.StudentConstants;
import com.javaBrains.javaBrains.entity.school.Student;
import com.javaBrains.javaBrains.model.SuccessResponse;
import com.javaBrains.javaBrains.model.request.StudentRegisterRequest;
import com.javaBrains.javaBrains.service.repoHandler.StudentRepoHandler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepoHandler studentRepoHandler;

    public StudentService(StudentRepoHandler studentRepoHandler) {
        this.studentRepoHandler = studentRepoHandler;
    }

    public SuccessResponse registerStudent(StudentRegisterRequest request) {
        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setDob(request.getDob());
        student.setContactNumber(request.getContactNumber());
        student.setAddress(request.getAddress());
        studentRepoHandler.registerStudent(student);
        return new SuccessResponse(StudentConstants.SUCCESS);
    }

    public List<Student> fetchAllRegisteredStudents() {
        return studentRepoHandler.fetchAllStudents();
    }

    public Optional<Student> fetchStudentByAdmissionNumber(String id) {
        return studentRepoHandler.fetchStudentById(id);
    }
}

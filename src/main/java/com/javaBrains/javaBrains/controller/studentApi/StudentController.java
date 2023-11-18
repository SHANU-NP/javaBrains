package com.javaBrains.javaBrains.controller.studentApi;

import com.javaBrains.javaBrains.model.SuccessResponse;
import com.javaBrains.javaBrains.model.request.StudentRegisterRequest;
import com.javaBrains.javaBrains.service.student.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/register")
    public SuccessResponse registerStudent(@RequestBody StudentRegisterRequest request){
        return studentService.registerStudent(request);
    }
}

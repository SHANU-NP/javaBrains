package com.javaBrains.javaBrains.controller.admin;

import com.javaBrains.javaBrains.entity.school.Student;
import com.javaBrains.javaBrains.service.admin.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/students")
    public List<Student> fetchAllRegisteredStudents(){
        return adminService.fetchAllRegisteredStudents();
    }

    @GetMapping("/students/{id}")
    public Optional<Student> fetchStudentByAdmissionNumber(@PathVariable(value = "id")String id){
        return adminService.fetchStudentByAdmissionNumber(id);
    }
}

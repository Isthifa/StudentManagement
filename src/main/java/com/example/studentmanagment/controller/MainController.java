package com.example.studentmanagment.controller;

import com.example.studentmanagment.dto.AuthRequest;
import com.example.studentmanagment.dto.StudentDepartment;
import com.example.studentmanagment.entity.Departments;
import com.example.studentmanagment.entity.Students;
import com.example.studentmanagment.entity.UserInfo;
import com.example.studentmanagment.repository.StudentRepo;
import com.example.studentmanagment.service.JwtService;
import com.example.studentmanagment.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private Services services;

    @Autowired
    private JwtService service;

    @GetMapping("/studentlist")
    public List<Students> all() {
        return services.listall();
    }

    @PostMapping("/studentadd")
    public Students save(@RequestBody Students students) {
        return services.save(students);
    }

    @PostMapping("/departmentadd")
    public Departments save(@RequestBody Departments departments) {
        return services.save(departments);
    }

    @GetMapping("/departmentlist")
    public List<Departments> listall() {
        return services.listalldep();
    }

    @PostMapping("/new/user")
    public UserInfo save(@RequestBody UserInfo userInfo) {
        return services.save(userInfo);
    }

    @PostMapping("/authenticate")
    public String authenticateandgettoken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return "token: " + service.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("Invalid user");
        }
    }

    @GetMapping("/students/{studentId}")
    public StudentDepartment getStudentDepartments(@PathVariable int studentId) {
        return services.findbyid(studentId);
    }
}

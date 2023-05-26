package com.example.studentmanagment.service;

import com.example.studentmanagment.dto.StudentDepartment;
import com.example.studentmanagment.entity.Departments;
import com.example.studentmanagment.entity.Students;
import com.example.studentmanagment.entity.UserInfo;
import com.example.studentmanagment.repository.DepartmentRepo;
import com.example.studentmanagment.repository.StudentRepo;
import com.example.studentmanagment.repository.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements Services{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private UserInfoRepo userInfoRepo;

    @Override
    public List<Students> listall() {
        return studentRepo.findAll();
    }

    @Override
    public Students save(Students students) {
        return studentRepo.save(students);
    }

    @Override
    public Departments save(Departments departments) {
        return departmentRepo.save(departments);
    }

    @Override
    public List<Departments> listalldep() {
        return departmentRepo.findAll();
    }

    @Override
    public StudentDepartment findbyid(int id) {
        Optional<Students> student=studentRepo.findById(id);
        System.out.println(student);
        StudentDepartment studentDepartment=new StudentDepartment();
        studentDepartment.setName(student.get().getName());
        studentDepartment.setDepartmentname(student.get().departments.getDepName());
        System.out.println(studentDepartment);
        return studentDepartment;
    }

    @Override
    public UserInfo save(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        return userInfoRepo.save(userInfo);
    }


}

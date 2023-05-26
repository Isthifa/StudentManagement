package com.example.studentmanagment.service;

import com.example.studentmanagment.dto.StudentDepartment;
import com.example.studentmanagment.entity.Departments;
import com.example.studentmanagment.entity.Students;
import com.example.studentmanagment.entity.UserInfo;

import java.util.List;

public interface Services {
    List<Students> listall();
    Students save(Students students);

    Departments save(Departments departments);

    List<Departments> listalldep();

    StudentDepartment findbyid(int id);
    UserInfo save(UserInfo userInfo);






}

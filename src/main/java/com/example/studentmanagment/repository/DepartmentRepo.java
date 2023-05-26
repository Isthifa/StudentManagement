package com.example.studentmanagment.repository;

import com.example.studentmanagment.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Departments,Integer> {
}

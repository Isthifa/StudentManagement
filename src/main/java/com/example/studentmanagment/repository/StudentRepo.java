package com.example.studentmanagment.repository;

import com.example.studentmanagment.dto.StudentDepartment;
import com.example.studentmanagment.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepo extends JpaRepository<Students,Integer> {

}

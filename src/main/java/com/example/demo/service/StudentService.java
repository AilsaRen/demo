package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;

public interface StudentService {
    Integer create(StudentDTO studentDTO);
}

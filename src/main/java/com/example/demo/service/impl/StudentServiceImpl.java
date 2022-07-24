package com.example.demo.service.impl;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import com.example.demo.utils.DtoMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Integer create(StudentDTO studentDTO) {
        Student student = DtoMapper.convert(studentDTO, Student.class);
        return studentRepository.save(student).getId();
    }
}

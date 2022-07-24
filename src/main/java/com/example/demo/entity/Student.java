package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "学生姓名重复", columnNames = {"stuNo", "name"})
})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;

    private Integer stuNo;
}

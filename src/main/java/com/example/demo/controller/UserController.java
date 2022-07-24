package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@Api(tags = {"测试学生管理"})
@RestController
@RequestMapping("/student")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "添加学生信息")
    @PostMapping("")
    public Integer create(@RequestBody @Valid UserDTO userDTO) {
        return userService.create(userDTO);
    }
}

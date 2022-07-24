package com.example.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>Title: StudentDTO</p >
 * <p>Description: </p >
 * <p>Company: www.h-visions.com</p >
 * <p>create date: 2022/7/24</p >
 *
 * @author :xtren
 * @version :1.0.0
 */
@ApiModel
@Data
public class StudentDTO implements Serializable {
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("学生姓名")
    @NotBlank(message = "姓名不能为空")
    private String name;

    @ApiModelProperty("学生邮箱")
    @Email(message = "邮箱填写不正确")
    private String email;

    @ApiModelProperty("学号")
    @NotNull(message = "学号不能为空")
    private Integer stuNo;
}

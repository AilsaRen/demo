package com.example.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.*;
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
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("姓名")
    @NotBlank(message = "姓名不能为空")
    @Size(min = 2, message = "name must be at least 2 characters long")
    private String name;

    @ApiModelProperty("邮箱")
    @Email(message = "邮箱填写不正确")
    private String email;

    @ApiModelProperty("信用卡号")
    @CreditCardNumber(message = "not a valid credit card number")
    private String ccNumber;

    @ApiModelProperty("")
    @Pattern(regexp = "^(0[1-9]|1[0-2]) (\\/) ([1-9][0-9])$", message = "must be formatted MM/YY")
    private String ccExpiration;

    @ApiModelProperty("")
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;
}

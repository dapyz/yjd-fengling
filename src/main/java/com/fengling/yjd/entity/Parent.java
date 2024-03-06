package com.fengling.yjd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("Parent")
public class Parent implements  Serializable{
    @TableId("PID")
    private Integer PID;
    private String Pname;
    private String Psex;
    private String Plocation;
    private String Ptel;
    @TableField("Paccountbalance")
    private double Pbalance;
    private String openid;
    private String nickName;
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    private Date registerDate;
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    private Date lastLoginDate;
    @TableField(select = false,exist = false)
    private String code;
}

package com.fengling.yjd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("Parent")
public class Parent {
    @TableId(type = IdType.AUTO)
    private Integer PID;
    private String Pname;
    private String Psex;
    private String Plocation;
    private String Ptel;
    @TableField("Paccountbalance")
    private BigDecimal Pbalance;
}

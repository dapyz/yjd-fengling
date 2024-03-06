package com.fengling.yjd.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.Date;

/**
 * @Author: dapyz
 * @Description:
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@Data
@TableName("auditor")
public class auditor {
    @TableId("AID")
    private Integer AID;
    private String username;
    private String password;
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    private Date Registtime;
    @TableField(select = false)
    private String newPassword;
}

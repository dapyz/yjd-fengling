package com.fengling.yjd.entity;

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
public class Auditor {
    private int AID;
    private String Aname;
    private String Account;
    private String Password;
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    private Date Registtime;
}

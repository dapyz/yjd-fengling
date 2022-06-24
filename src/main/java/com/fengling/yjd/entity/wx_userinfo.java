package com.fengling.yjd.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: dapyz
 * @Description:
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@TableName("wx_userinfo")
@Data
public class wx_userinfo implements Serializable {
    private Integer id;
    private String openid;
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    private Date registerDate;
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    private Date lastLoginDate;
    @TableField(select = false,exist = false)
    private String code;
}

package com.fengling.yjd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.ietf.jgss.Oid;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: dapyz
 * @Description:
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@Data
@TableName("p_order")
public class Order {
    @TableId(value = "Ono")
    private String Ono;
    private String Userid;
    private Integer Gid;
    private String Gname;
    @TableField(select = false)
    private Parent parent;
    private double Oprice;
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    private Date Odate;
    private String Otype;
}

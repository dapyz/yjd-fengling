package com.fengling.yjd.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.Date;

/**
 * @Author: dapyz
 * @Description: 预约记录
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@Data
public class Yuyue {
    @TableId("Yid")
    private String Yid;
    private String Userid;
    private Integer Tid;
    private String Tname;
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    private Date Yuyuetime;
    private double Yuyueprice;
}

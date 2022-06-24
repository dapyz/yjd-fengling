package com.fengling.yjd.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: dapyz
 * @Description:
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@Data
public class Teacher {
    @TableId(type = IdType.AUTO)
    private Integer TID;
    private String Tname;
    private String Tsex;
    private String Ttel;
    @TableField("Taccountbalance")
    private BigDecimal Tbalance;
    private String Tedubkg;
    private String Tintroduction;
    private Integer CertificateID;
    private BigDecimal TPrice;
    private String Yuyuetype;
}


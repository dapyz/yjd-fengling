package com.fengling.yjd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Author: dapyz
 * @Description:
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@Data
public class Course {
    @TableId(type = IdType.AUTO)
    private Integer Cid;
    private String Cname;
    private String Cintroduction;
    private String type;
    private double price;
}

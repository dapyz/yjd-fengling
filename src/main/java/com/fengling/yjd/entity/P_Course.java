package com.fengling.yjd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: dapyz
 * @Description:
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@Data
@TableName("pcourse")
public class P_Course {
    @TableId(value = "Pc_id",type = IdType.AUTO)
    private Integer pc_id;
    private String Userid;
    private Integer Cid;
    private String Cname;
}

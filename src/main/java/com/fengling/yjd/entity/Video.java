package com.fengling.yjd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Video {
    @TableId(type = IdType.AUTO)
    private Integer Vid;
    private Integer Tid;
    private String Vintroduction;
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    private Date Vupdatetime;
    private Integer RecommVyn;
    private String Vurl;
}

package com.fengling.yjd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.yjd.entity.P_Course;
import com.fengling.yjd.mapper.P_CourseMapper;
import com.fengling.yjd.service.IP_CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: dapyz
 * @Description:家长已购买的课程service实现类
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@Service("p_courseService")
public class IP_CourseServiceImpl extends ServiceImpl<P_CourseMapper, P_Course> implements IP_CourseService {
    @Resource
    private P_CourseMapper p_courseMapper;
}

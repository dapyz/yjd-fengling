package com.fengling.yjd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.yjd.entity.Course;
import com.fengling.yjd.mapper.CourseMapper;
import com.fengling.yjd.service.ICourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: dapyz
 * @Description: 课程service实现类
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@Service("courseService")
public class ICourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

    @Resource
    private CourseMapper courseMapper;
}

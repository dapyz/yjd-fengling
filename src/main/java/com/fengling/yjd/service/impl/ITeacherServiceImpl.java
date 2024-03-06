package com.fengling.yjd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.yjd.entity.Teacher;
import com.fengling.yjd.mapper.TeacherMapper;
import com.fengling.yjd.service.ITeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: dapyz
 * @Description: 指导师service实现类
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@Service("teacherService")
public class ITeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService{

    @Resource
    private TeacherMapper teacherMapper;
}

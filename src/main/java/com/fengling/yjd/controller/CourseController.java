package com.fengling.yjd.controller;

import com.fengling.yjd.entity.Course;
import com.fengling.yjd.entity.R;
import com.fengling.yjd.service.ICourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: dapyz
 * @Description: 课程Controller
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Resource
    private ICourseService courseService;

    @GetMapping("/findall")
    public R findall() {
        List<Course> courseList = courseService.list();
        Map<String , Object> map = new HashMap<>();
        map.put("message",courseList);
        return R.ok(map);
    }
    @GetMapping("/getinfo")
    public R detail(Integer Cid){
        Course course= courseService.getById(Cid);
        Map<String,Object> map = new HashMap<>();
        map.put("message",course);
        return R.ok(map);
    }
}

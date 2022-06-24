package com.fengling.yjd.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fengling.yjd.entity.R;
import com.fengling.yjd.entity.Teacher;
import com.fengling.yjd.service.ITeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: dapyz
 * @Description:指导师Controller
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Resource
    private ITeacherService teacherService;
    /**
     * @Author: dapyz
     * @Description: 查询所有指导师大类
     * @Date: 2022/6/20 17:26
     */
    @GetMapping("/findall")
    public R findAllteacher(){
        List<Teacher> teacherList = teacherService.list();
        Map<String, Object> map = new HashMap<>();
        map.put("message",teacherList);
        return R.ok(map);
    }
}

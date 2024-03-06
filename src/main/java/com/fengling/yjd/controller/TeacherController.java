package com.fengling.yjd.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fengling.yjd.entity.Parent;
import com.fengling.yjd.entity.R;
import com.fengling.yjd.entity.Teacher;
import com.fengling.yjd.entity.Yuyue;
import com.fengling.yjd.service.IParentService;
import com.fengling.yjd.service.ITeacherService;
import com.fengling.yjd.service.IYuyueService;
import com.fengling.yjd.util.DateUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: dapyz
 * @Description: 指导师Controller
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Resource
    private ITeacherService teacherService;
    @Resource
    private IYuyueService yuyueService;
    @Resource
    private IParentService parentService;

    /**
     * @Author: dapyz
     * @Description: 查询所有指导师大类
     * @Date: 2022/6/20 17:26
     */
    @GetMapping("/findall")
    public R findAllteacher() {
        List<Teacher> teacherList = teacherService.list();
        Map<String, Object> map = new HashMap<>();
        map.put("message", teacherList);
        return R.ok(map);
    }
    @RequestMapping("/my/yuyuecreate")
    public R yuyueteacher(@RequestBody Yuyue yuyue, @RequestHeader(value = "token")String token){
        //通过token获取openid
        System.out.println("token="+token);
        System.out.println("yuyue="+yuyue);
        String openid = "oUFLB5Y6fq3T7ARcjP5wTH-divXA";
        String Yid = "Yuyue"+ DateUtil.getCurrentDateStr();
        double Yuyueprice = 200;
        //添加预约记录到数据库
        yuyue.setUserid(openid);
        yuyue.setYid(Yid);
        yuyue.setYuyueprice(Yuyueprice);
        yuyue.setYuyuetime(new Date());
        yuyueService.save(yuyue);
        Parent resultparent = parentService.getOne(new QueryWrapper<Parent>().eq("openid",openid));
        resultparent.setPbalance(resultparent.getPbalance()-yuyue.getYuyueprice());
        parentService.updateById(resultparent);
        //返回前端预约编号
        Map<String,Object> resultmap = new HashMap<>();
        resultmap.put("yuyueid",Yid);
        System.out.println(resultmap.put("yuyueid",Yid));
        return R.ok(resultmap);
    }
    @GetMapping("/yuyuefindall")
    public R findAll() {
        List<Yuyue> yuyuelist = yuyueService.list();
        Map<String, Object> map = new HashMap<>();
        map.put("message", yuyuelist);
        return R.ok(map);
    }
}

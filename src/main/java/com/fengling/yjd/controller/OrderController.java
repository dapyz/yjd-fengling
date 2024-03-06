package com.fengling.yjd.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fengling.yjd.entity.*;
import com.fengling.yjd.service.IOrderService;
import com.fengling.yjd.service.IP_CourseService;
import com.fengling.yjd.service.IParentService;
import com.fengling.yjd.service.IYuyueService;
import com.fengling.yjd.util.DateUtil;
import com.fengling.yjd.util.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: dapyz
 * @Description: 订单Controller
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@RestController
@RequestMapping("/my/order")
public class OrderController {
    @Resource
    private IOrderService orderService;
    @Resource
    private IP_CourseService p_courseService;
    @Resource
    private IParentService parentService;

    @RequestMapping("/my/create")
    public R create(@RequestBody Order order, @RequestHeader(value = "token")String token) {
        //通过token获取openid
        System.out.println("token="+token);
        System.out.println("order="+order);
        String openid = "oUFLB5Y6fq3T7ARcjP5wTH-divXA";
        int Gid = 3;
        String Gname = "家庭纠纷";
        String Ono = "yjd"+ DateUtil.getCurrentDateStr();
        double price = 38;
        String type = "课程";
        //添加订单到数据库
        order.setGid(Gid);
        order.setUserid(openid);
        order.setGname(Gname);
        order.setOno(Ono);
        order.setOprice(price);
        order.setOtype(type);
        order.setOdate(new Date());
        orderService.save(order);
        Parent resultparent = parentService.getOne(new QueryWrapper<Parent>().eq("openid",openid));
        resultparent.setPbalance(resultparent.getPbalance()-order.getOprice());
        parentService.updateById(resultparent);
        if(order.getOtype()=="课程"){
            P_Course resultp_course = new P_Course();
            resultp_course.setUserid(order.getUserid());
            resultp_course.setCid(order.getGid());
            resultp_course.setCname(order.getGname());
            p_courseService.save(resultp_course);
        }
        //返回前端订单编号
        Map<String,Object> resultmap = new HashMap<>();
        resultmap.put("orderid",order.getOno());
        return R.ok(resultmap);
    }
    @GetMapping("/all")
    private R findall() {
//        Map<String, Object> order = orderService.getMap(new QueryWrapper<Order>().eq("Oid",Oid));
        List<Order> order = orderService.list();
        Map<String,Object> map = new HashMap<>();
        map.put("message",order);
        return R.ok(map);
    }
}

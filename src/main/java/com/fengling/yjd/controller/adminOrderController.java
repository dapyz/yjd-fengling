package com.fengling.yjd.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.yjd.entity.Order;
import com.fengling.yjd.entity.PageBean;
import com.fengling.yjd.entity.Parent;
import com.fengling.yjd.entity.R;
import com.fengling.yjd.service.IOrderService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: dapyz
 * @Description: 管理员管理订单Controller
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@RestController
@RequestMapping("/admin/order")
@CrossOrigin("*")
public class adminOrderController {

    @Resource
    private IOrderService orderService;

    @RequestMapping("/all")
    private R findall(@RequestBody PageBean pageBean){
        System.out.println(pageBean);
        Map<String,Object> map = new HashMap<>();
        map.put("Ono",pageBean.getQuery().trim());
        map.put("start",pageBean.getStart());
        map.put("pageSize",pageBean.getPageSize());
        List<Order> orderList =orderService.list(map);
        Long total = orderService.getTotal(map);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("orderList",orderList);
        resultMap.put("total",total);
        return R.ok(resultMap);
    }
}

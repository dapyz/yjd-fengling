package com.fengling.yjd.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fengling.yjd.entity.Parent;
import com.fengling.yjd.entity.R;
import com.fengling.yjd.service.IParentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: dapyz
 * @Description:家长Controller
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@RestController
@RequestMapping("/parent")
public class ParentController {
    @Resource
    private IParentService parentservice;
    
    /**
     * @Description: 查询家长账号
     * @Date: 2022/6/20 16:56
     */
    @GetMapping("/findall")
   private R findall(){
        List<Parent> parentlist = parentservice.list();
        Map<String ,Object> map = new HashMap<>();
        map.put("message",parentlist);
        return R.ok(map);
    }
}

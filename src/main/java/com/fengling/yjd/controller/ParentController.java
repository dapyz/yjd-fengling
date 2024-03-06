package com.fengling.yjd.controller;

import com.fengling.yjd.entity.Parent;
import com.fengling.yjd.entity.R;
import com.fengling.yjd.service.IParentService;
import com.fengling.yjd.util.JwtUtils;
import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: dapyz
 * @Description: 家长Controller
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@RestController
@RequestMapping("/parent")
public class ParentController {
    @Resource
    private IParentService parentservice;
    /**
     * @Description: 查询家长
     * @Date: 2022/6/20 16:56
     */
    @GetMapping("/findall")
   private R findall(){
        List<Parent> parentlist = parentservice.list();
        Map<String ,Object> map = new HashMap<>();
        map.put("message",parentlist);
        return R.ok(map);
    }
    @RequestMapping("/updateall")
    private R updateall(@RequestBody Parent parent, @RequestHeader(value = "token")String token){
        //通过token获取openid
        System.out.println("token="+token);
        Claims claims = JwtUtils.validateJWT(token).getClaims();
        if(claims!=null)
        {
            System.out.println("openid"+claims.getId());
            parent.setOpenid(claims.getId());
        }
        parentservice.updateById(parent);
        Parent parentlist = parentservice.getById(parent.getPID());
        Map<String,Object> map = new HashMap<>();
        map.put("修改成功",parentlist);
        return R.ok(map);
    }
}

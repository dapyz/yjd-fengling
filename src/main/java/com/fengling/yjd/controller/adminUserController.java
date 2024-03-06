package com.fengling.yjd.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.yjd.entity.PageBean;
import com.fengling.yjd.entity.Parent;
import com.fengling.yjd.entity.R;
import com.fengling.yjd.service.IParentService;
import com.fengling.yjd.util.StringUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: dapyz
 * @Description: 后台管理用户Controller
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@RestController
@RequestMapping("/admin/user")
@CrossOrigin("*")
public class adminUserController {

    @Resource
    private IParentService parentService;

    /**
     * @Author: dapyz
     * @Description: 根据条件分页查询用户信息
     * @Date: 2022/6/28 23:18
     */
    @RequestMapping("/list")
    public R list(@RequestBody PageBean pageBean){
        System.out.println(pageBean);
        String query = pageBean.getQuery().trim();
        Page<Parent> page = new Page<>(pageBean.getPageNum(),pageBean.getPageSize());
        Page<Parent> pageResult = parentService.page(page, new QueryWrapper<Parent>()
                .like(StringUtil.isNotEmpty(query), "nickName", query));
        Map<String,Object> map = new HashMap<>();
        map.put("userList",pageResult.getRecords());
        map.put("total",pageResult.getCurrent());
        return R.ok(map);
    }
}

package com.fengling.yjd.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.fengling.yjd.constant.SystemConstant;
import com.fengling.yjd.entity.auditor;
import com.fengling.yjd.entity.R;
import com.fengling.yjd.service.IauditorService;
import com.fengling.yjd.util.JwtUtils;
import com.fengling.yjd.util.StringUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: dapyz
 * @Description: 管理员Controller
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@RestController
@CrossOrigin("*")
public class auditorController {

    @Resource
    private IauditorService auditorService;


    @PostMapping("/login")
    public R adminLogin(@RequestBody auditor auditor) {
        if (auditor == null) {
            R.error();
        }
        if (StringUtil.isEmpty(auditor.getUsername())) {
            return R.error("用户名不能为空！");
        }
        if (StringUtil.isEmpty(auditor.getPassword())) {
            return R.error("密码不能为空!");
        }
        auditor resultadmin = auditorService.getOne(new QueryWrapper<auditor>().eq("Username", auditor.getUsername()));
        if (resultadmin == null) {
            return R.error("用户不存在");
        }
        if (!resultadmin.getPassword().trim().equals(auditor.getPassword())) {
            return R.error("用户名或者密码错误");
        }
        String token = JwtUtils.createJWT("-1", "admin", SystemConstant.JWT_TTL);
        Map<String, Object> resultmap = new HashMap<>();
        resultmap.put("token", token);
        return R.ok(resultmap);
    }

    @PostMapping("/modifyPassword")
    public R modifyPassword(@RequestBody auditor auditor) {
        if (StringUtil.isEmpty(auditor.getUsername())) {
            return R.error("用户名不能为空！");
        }
        if (StringUtil.isEmpty(auditor.getNewPassword())) {
            return R.error("新密码不能为空！");
        }
        auditorService.update(new UpdateWrapper<auditor>
                ().set("password", auditor.getNewPassword()).eq("username", auditor.getUsername()));
        return R.ok();
    }
}

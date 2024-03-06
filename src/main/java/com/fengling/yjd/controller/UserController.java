package com.fengling.yjd.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fengling.yjd.constant.SystemConstant;
import com.fengling.yjd.entity.Parent;
import com.fengling.yjd.entity.R;
import com.fengling.yjd.properties.WeixinProperties;
import com.fengling.yjd.service.IParentService;
import com.fengling.yjd.util.HttpClientUtil;
import com.fengling.yjd.util.JwtUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: dapyz
 * @Description: 用户微信授权登录
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private WeixinProperties weixinProperties;

    @Resource
    private HttpClientUtil httpClientUtil;

    @Resource
    private IParentService parentService;

    @RequestMapping("/wxlogin")
    public R wxlogin(@RequestBody Parent parent){
        System.out.println(parent.getCode());
        String jscode2sessionUrl=weixinProperties.getJscode2sessionUrl()+"?appid="+weixinProperties.getAppid()+"&secret="+weixinProperties.getSecret()+"&js_code="+parent.getCode()+"&grant_type=authorization_code";
        System.out.println(jscode2sessionUrl);
        String result = httpClientUtil.sendHttpPost(jscode2sessionUrl);
        System.out.println(result);
        JSONObject jsonObject = JSON.parseObject(result);
        String openid = jsonObject.get("openid").toString();
        System.out.println(openid);
        //插入用户到数据库 假如说 用户不存在 我们插入用户 如果用户存在 我们更新用户
        Parent resultwxUserinfo = parentService.getOne(new QueryWrapper<Parent>().eq("openid",openid));
        if(resultwxUserinfo==null){
            System.out.println("不存在,插入用户");
            parent.setOpenid(openid);
            parent.setRegisterDate(new Date());
            parent.setLastLoginDate(new Date());
            parentService.save(parent);
        }else{
            System.out.println("存在,更新用户");
            resultwxUserinfo.setNickName(parent.getNickName());
            resultwxUserinfo.setLastLoginDate(new Date());
            parentService.updateById(resultwxUserinfo);
        }
        //利用jwt生成token返回到前端
        String token = JwtUtils.createJWT(openid,parent.getNickName(), SystemConstant.JWT_TTL);
        System.out.println(token);
        Map<String,Object> resultmap = new HashMap<>();
        resultmap.put("token",token);
        return R.ok(resultmap);
    }
}

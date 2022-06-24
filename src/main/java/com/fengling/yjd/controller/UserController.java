package com.fengling.yjd.controller;

import com.fengling.yjd.entity.R;
import com.fengling.yjd.entity.wx_userinfo;
import com.fengling.yjd.properties.WeixinProperties;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: dapyz
 * @Description:
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private WeixinProperties weixinProperties;
    @RequestMapping("/wxlogin")
    public R wxlogin(@RequestBody wx_userinfo wxUserinfo){
        System.out.println(wxUserinfo.getCode());
        String jscode2sessionUrl=weixinProperties.getJscode2sessionUrl()+"?appid="+weixinProperties.getAppid()+"&secret="+weixinProperties.getSecret()+"&js_code="+wxUserinfo.getCode()+"&grant_type=authorization_code";
        System.out.println(jscode2sessionUrl);
        return R.ok();
    }
}

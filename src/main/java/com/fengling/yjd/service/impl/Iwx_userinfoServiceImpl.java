package com.fengling.yjd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.yjd.entity.wx_userinfo;
import com.fengling.yjd.mapper.wx_userinfoMapper;
import com.fengling.yjd.service.Iwx_userinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: dapyz
 * @Description:课程service实现类
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@Service("wx_userinfoService")
public class Iwx_userinfoServiceImpl extends ServiceImpl<wx_userinfoMapper, wx_userinfo> implements Iwx_userinfoService {

    @Resource
    private wx_userinfoMapper wxUserinfoMapper;
}

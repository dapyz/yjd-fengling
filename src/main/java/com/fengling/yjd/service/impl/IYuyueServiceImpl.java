package com.fengling.yjd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.yjd.entity.Yuyue;
import com.fengling.yjd.mapper.YuyueMapper;
import com.fengling.yjd.service.IYuyueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: dapyz
 * @Description: 预约service实现类
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@Service("yuyueservice")
public class IYuyueServiceImpl extends ServiceImpl<YuyueMapper, Yuyue> implements IYuyueService {
    @Resource
    private YuyueMapper yuyueMapper;
}

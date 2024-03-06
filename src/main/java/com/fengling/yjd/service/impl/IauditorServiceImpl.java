package com.fengling.yjd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.yjd.entity.auditor;
import com.fengling.yjd.mapper.auditorMapper;
import com.fengling.yjd.service.IauditorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: dapyz
 * @Description:
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@Service("adminService")
public class  IauditorServiceImpl extends ServiceImpl<auditorMapper, auditor> implements IauditorService {

    @Resource
    private auditorMapper auditorMapper;
}

package com.fengling.yjd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.yjd.entity.Parent;
import com.fengling.yjd.mapper.ParentMapper;
import com.fengling.yjd.service.IParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: dapyz
 * @Description:家长service实现类
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@Service("parentService")
public class IParentServiceImpl extends ServiceImpl<ParentMapper, Parent> implements IParentService {

       @Resource
      private ParentMapper parentMapper;
}

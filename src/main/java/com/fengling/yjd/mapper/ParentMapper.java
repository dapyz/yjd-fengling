package com.fengling.yjd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fengling.yjd.entity.Parent;

/**
 * @Author: dapyz
 * @Description: 家长Mapper接口
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
public interface ParentMapper extends BaseMapper<Parent> {
    public Parent findByOpenid(String openid);
}

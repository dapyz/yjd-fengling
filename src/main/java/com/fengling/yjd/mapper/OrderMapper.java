package com.fengling.yjd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fengling.yjd.entity.Order;

import java.util.List;
import java.util.Map;

/**
 * @Author: dapyz
 * @Description: 订单接口
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
public interface OrderMapper extends BaseMapper<Order> {
    List<Order> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);

}

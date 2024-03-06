package com.fengling.yjd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fengling.yjd.entity.Order;

import java.util.List;
import java.util.Map;

/**
 * @Author: dapyz
 * @Description:
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */

public interface IOrderService extends IService<Order> {
    List<Order> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);

}

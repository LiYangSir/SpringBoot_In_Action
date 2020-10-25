package com.quguai.service;

import com.quguai.bean.Order;
import com.quguai.bean.User;
import com.quguai.mapper.OrderMapper;
import com.quguai.mapper.UserMapper;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@CacheConfig(cacheNames = "user")                        //抽取所有缓存的名称
@Service
public class OrderService {

    @Resource //等同于@Autowired
    OrderMapper orderMapper;

    @Cacheable(cacheNames = "order")
    public Order getUser(Integer id) {
        System.out.println("查询" + id + "号员工");
        return orderMapper.getOrderById(id);
    }
}

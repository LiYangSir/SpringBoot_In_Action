package com.quguai.controller;

import com.quguai.bean.Order;
import com.quguai.bean.User;
import com.quguai.service.OrderService;
import com.quguai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ResponseBody
    @GetMapping("/order/{id}")
    public Order getUser(@PathVariable("id") Integer id) {
        Order user = orderService.getUser(id);
        return user;
    }
}

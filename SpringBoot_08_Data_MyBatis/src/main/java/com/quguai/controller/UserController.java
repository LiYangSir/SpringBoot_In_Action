package com.quguai.controller;

import com.quguai.bean.User;
import com.quguai.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    UserMapper userMapper;

    @ResponseBody
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        User user = userMapper.getUserById(id);
        return user;
    }

    @ResponseBody
    @PostMapping("/user")
    public User insertUser(User user) {
        userMapper.insertUser(user);
        return user;
    }
}

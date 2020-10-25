package com.quguai.controller;

import com.quguai.bean.User;
import com.quguai.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id")Integer id) {
        User user = userDao.findById(id).orElse(null);
        return user;
    }
}

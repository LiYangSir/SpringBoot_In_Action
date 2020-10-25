package com.quguai.controller;

import com.quguai.bean.User;
import com.quguai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        User user = userService.getUser(id);
        return user;
    }

    @ResponseBody
    @GetMapping("/user")
    public User updateUser(User user) {
        System.out.println(user);
        User user1 = userService.updateUser(user);
        System.out.println(user1);
        return user1;
    }

    @ResponseBody
    @DeleteMapping("/user/{id}")
    public User deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return null;
    }
}

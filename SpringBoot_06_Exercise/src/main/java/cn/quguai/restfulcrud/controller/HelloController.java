package cn.quguai.restfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }


    @GetMapping("/success")
    public String success(Map<String, Object> map) {
//        model.addAttribute("hello", "Hello World");
        map.put("Hello", "Hello World");
        return "success";
    }
}

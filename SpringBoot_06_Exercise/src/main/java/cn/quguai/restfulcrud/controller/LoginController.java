package cn.quguai.restfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @PostMapping("/login")
    public String login(String username, String password, RedirectAttributes attributes, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            attributes.addFlashAttribute("message", "恭喜登录");
            session.setAttribute("user", username);
            return "redirect:/admin/dashboard";
        } else {
            attributes.addFlashAttribute("message", "用户名错误");
            return "login";
        }
    }
}

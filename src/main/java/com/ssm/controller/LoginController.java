package com.ssm.controller;

import com.ssm.model.Student;
import com.ssm.model.User;
import com.ssm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("toLogin")
    public String toLogin(Model model) {
        model.addAttribute("msg", "测试参数传递");
        return "login.jsp";
    }

    @RequestMapping("login")
    public String login(User user, HttpServletRequest request) {

        String username = user.getUsername();
        String password = user.getPassword();
        Map<String, Object> mapMsg = loginService.login(username, password);
        List<Student> students = loginService.getAllStudent();
        request.setAttribute("user", user);
        request.setAttribute("students", students);
        request.setAttribute("message", mapMsg.get("message"));
        request.setAttribute("status",mapMsg.get("status"));

        if (mapMsg.get("status").equals("200")) {
            return "success.jsp";
        }
        else if (mapMsg.get("status").equals("100")) {;
            return "error.jsp";
        }
        else {
            return "failed.jsp";
        }
    }
}
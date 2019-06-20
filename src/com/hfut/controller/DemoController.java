package com.hfut.controller;

import com.hfut.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class DemoController {
    @RequestMapping("{page}")
    public String main(@PathVariable String page) throws IOException{
        return page;
    }

    @RequestMapping("login")
    public String login(Users users, HttpSession session) throws IOException{
        if(users.getUsername().equals("admin")&&users.getPassword().equals("123")){
            session.setAttribute("users",users);
            return "main";
        }else{
            return "redirect:/login.jsp";
        }
    }
}

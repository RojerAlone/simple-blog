package cn.alone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by RojerAlone on 2017/4/8.
 */
@Controller
public class Redirect extends AbstractController{
    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }
    @RequestMapping(value = "/register")
    public String register() {
        return "register";
    }
    @RequestMapping(value = "/login")
    public String login() {
        // 登录之前记录登录之前的页面，如果登录成功则返回到该页面
        this.getSession().setAttribute("link", this.getRequest().getHeader("Referer"));
        return "login";
    }
    @RequestMapping(value = "/about")
    public String about() {
        return "about";
    }
}

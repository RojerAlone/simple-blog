package cn.alone.controller;

import cn.alone.pojo.User;
import cn.alone.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Alone on 2017/3/28.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends AbstractController{

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/test")
    public String selectUserByPrimaryId() {
        User user = userService.selectById(1);
        this.getModel().addAttribute("user", user);
        return "test";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(User user) {
        if (userService.register(user)) {
            this.getModel().addAttribute("user", user);     // 用来自动填充输入框
            return "/login";
        } else {
            this.getModel().addAttribute("info", "该用户名已被注册！");
            this.getModel().addAttribute("user", user);
            return "register";
        }
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String username, String password) {
        if (userService.login(username, password)) {
            this.getSession().setAttribute("user", userService.selectByName(username));
            Object link = this.getSession().getAttribute("link");
            this.getSession().removeAttribute("link");
            return "redirect:" + link;
        } else {
            this.getModel().addAttribute("info", "账号或密码错误");
            return "/login";
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {
        this.getSession().removeAttribute("user");
        return "redirect:" + this.getRequest().getHeader("Referer");    // 跳转回到退出登录之前的页面
    }
}

package cn.alone.controller;

import cn.alone.pojo.dto.BlogDTO;
import cn.alone.services.IBlogService;
import cn.alone.services.IKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by RojerAlone on 2017/4/8.
 */
@Controller
public class Redirect extends AbstractController{

    @Autowired
    private IBlogService blogService;
    @Autowired
    private IKindService kindService;

    @RequestMapping(value = "/index")
    public String index() {
        Map<String, List<BlogDTO>> indexBlogs = blogService.getIndexBlogs();
        this.getModel().addAttribute("hotBlogs", indexBlogs.get("hotBlogs"));   // 热门文章前五名
        this.getModel().addAttribute("firstPage", indexBlogs.get("firstPage")); // 第一页的文章
        this.getModel().addAttribute("kinds", kindService.getAllKind());
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

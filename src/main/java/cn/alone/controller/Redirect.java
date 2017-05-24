package cn.alone.controller;

import cn.alone.pojo.dto.BlogDTO;
import cn.alone.services.IBlogService;
import cn.alone.services.IKindService;
import cn.alone.utils.PageUtil;
import org.javatuples.Pair;
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
        Pair<PageUtil, List<BlogDTO>> pageBlog = blogService.getByPage(1);
        this.getModel().addAttribute("firstPage", pageBlog.getValue1());        // 第一页的文章
        this.getModel().addAttribute("page", pageBlog.getValue0());
        this.getModel().addAttribute("hotBlogs", blogService.getHotBlogs());   // 热门文章前五名
        this.getModel().addAttribute("kinds", kindService.getAllKind());       // 文章类别
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

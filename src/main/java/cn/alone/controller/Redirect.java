package cn.alone.controller;

import cn.alone.pojo.dto.BlogDTO;
import cn.alone.services.IBlogService;
import cn.alone.services.IKindService;
import cn.alone.utils.PageUtil;
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
        Map<String, Object> indexInfo = blogService.getIndexInfo();
        this.getModel().addAttribute("hotBlogs", (List<BlogDTO>) indexInfo.get("hotBlogs"));   // 热门文章前五名
        this.getModel().addAttribute("firstPage", (List<BlogDTO>) indexInfo.get("firstPage")); // 第一页的文章
        this.getModel().addAttribute("page", (PageUtil) indexInfo.get("page"));
        this.getModel().addAttribute("kinds", kindService.getAllKind());        // 文章类别
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

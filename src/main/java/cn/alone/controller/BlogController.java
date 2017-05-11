package cn.alone.controller;

import cn.alone.pojo.Blog;
import cn.alone.services.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by RojerAlone on 2017/4/9.
 */
@Controller
@RequestMapping(value = "/blog")
public class BlogController  extends AbstractController{

    @Autowired
    private IBlogService blogService;

    @RequestMapping(value = "write", method = RequestMethod.POST)
    public String write(Blog blog) {
//        blog.setUid((User) this.getSession().getAttribute("user"));
        if (blogService.write(blog) == 1) {
            return "redirect:" + getBlog(blog.getBid());
        }
        return "newblog";
    }
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public String delete(int bid) {
        blogService.delBlog(bid);
        return "redirect:" + this.getRequest().getHeader("Referer");
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public String getAll(Integer pageIndex) {
        if (pageIndex == null) {
            this.getModel().addAttribute("blogs", blogService.getByPage(1));
        } else {
            this.getModel().addAttribute("blogs", blogService.getByPage(pageIndex));
        }
        return "bloglist";
    }

    @RequestMapping(value = "{bid}", method = RequestMethod.GET)
    public String getBlog(@PathVariable Integer bid) {
        Blog blog;
        if ((blog = blogService.selectById(bid)) == null) {
            return "ErrorCode/ErrorCode404";
        }
        this.getModel().addAttribute("blog", blog);
        return "blog";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(Blog blog) {
        if (blogService.update(blog)) {
            return "redirect:/blog/" + blog.getBid();
        }
        return "redirect:" + edit(blog.getBid());
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(int bid) {
        Blog blog;
        if ((blog = blogService.selectById(bid)) != null) {
            this.getModel().addAttribute("blog", blog);
        }
        return "newblog";
    }

    // 需要jackson包，否则出现406错误
//    @RequestMapping(value = "hotblogs",
//            method = RequestMethod.GET,
//            produces = {"application/json;charset=UTF-8"})
//    @ResponseBody
//    public List<Blog> getHotBlogs() {
//        return blogService.get();
//    }

}

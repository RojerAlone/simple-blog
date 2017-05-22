package cn.alone.services;

import cn.alone.pojo.Blog;
import cn.alone.pojo.dto.BlogDTO;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by RojerAlone on 2017/4/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml", "classpath:spring-service.xml"})
public class IBlogServiceTest {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private IBlogService service;

    @Test
    public void delBlog() throws Exception {
        int id = 2;
        try {
            if (service.delBlog(id)) {
                logger.info("删除成功");
            } else {
                logger.info("删除失败");
            }
        } catch (Exception e) {
            logger.info("错误", e);
        }
    }

    @Test
    public void selectById() throws Exception {
        int id = 2;
        try {
            BlogDTO blog = service.selectById(id);
            if (blog != null) {
                logger.info("查询成功");
                System.out.println(blog);
            } else {
                logger.info("查询失败");
            }
        } catch (Exception e) {
            logger.info("错误", e);
        }
    }

//    @Test
//    public void getByPage() throws Exception {
//        try {
//            List<Blog> blogs = service.getByPage(0);
//            if (blogs == null) {
//                logger.info("查询结果为null");
//            } else if (blogs.size() == 0) {
//                logger.info("结果集为0");
//            } else {
//                logger.info("查询成功");
//                System.out.println(blogs);
//            }
//        } catch (Exception e) {
//            logger.error("错误", e);
//        }
//    }

    @Test
    public void privateBlog() throws Exception {
        int id = 3;
        try {
            if (service.privateBlog(id)) {
                logger.info("设置为私密文章成功");
            } else {
                logger.info("设置失败");
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void update() throws Exception {
        Blog blog = new Blog();
        blog.setBid(3);
        blog.setUid(1);
        blog.setTitle("title");
        blog.setKind(1);
        blog.setContent("Content");
        try {
            if (service.update(blog)) {
                logger.info("更新成功");
            } else {
                logger.info("更新失败");
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void getBlogsOfKind() throws Exception {
        try {
            List<Blog> blogs = service.getBlogsOfKind(1, 1);
            if (blogs == null) {
                logger.info("查询结果为null");
            } else if (blogs.size() == 0) {
                logger.info("结果集为0");
            } else {
                logger.info("查询成功");
                System.out.println(blogs);
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

//    @Test
//    public void getHotBlogs() throws Exception {
//        try {
//            List<Blog> blogs = service.getHotBlogs();
//            if (blogs == null) {
//                logger.info("查询结果为null");
//            } else if (blogs.size() == 0) {
//                logger.info("结果集为0");
//            } else {
//                logger.info("查询成功");
//                System.out.println(blogs);
//            }
//        } catch (Exception e) {
//            logger.error("错误", e);
//        }
//    }

}
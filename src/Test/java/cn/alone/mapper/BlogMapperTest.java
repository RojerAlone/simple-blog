package cn.alone.mapper;

import cn.alone.pojo.Blog;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by RojerAlone on 2017/4/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-dao.xml"})
public class BlogMapperTest {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private BlogMapper mapper;
    @Test
    public void insert() throws Exception {
        Blog blog = new Blog();
        blog.setUid(1);
        blog.setTitle("Title");
        blog.setKind(1);
        blog.setContent("Content");
        try {
            if (1 == mapper.insert(blog)) {
                logger.info("成功插入，插入的blog的bid为" + blog.getBid());
            } else {
                logger.info("没有插入");
            }
        } catch (Exception e) {
            logger.error("出现异常", e);
        }
    }

    @Test
    public void selectById() throws Exception {
        int id = 10;
        try {
            Blog blog = mapper.selectById(id);
            if (blog != null) {
                System.out.println(blog);
                logger.info("查询成功");
            } else {
                logger.info("没有查询到结果");
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void selectKeyInfoById() throws Exception {
        int id = 2;
        try {
            Blog blog = mapper.selectKeyInfoById(id);
            if (blog != null) {
                System.out.println(blog);
                logger.info("查询成功");
            } else {
                logger.info("没有查询到结果");
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

//    @Test
//    public void selectByUp() throws Exception {
//        try {
//            List<Blog> blogs = mapper.selectByUp();
//            logger.info("根据点赞数查询成功");
//            System.out.println(blogs);
//        } catch (Exception e) {
//            logger.error("根据点赞数查询失败", e);
//        }
//    }

    @Test
    public void selectByComment() throws Exception {
        try {
            List<Blog> blogs = mapper.selectByComment();
            logger.info("根据评论数查询成功");
            System.out.println(blogs);
        } catch (Exception e) {
            logger.error("根据评论数查询失败", e);
        }
    }

    @Test
    public void selectByClicked() throws Exception {
        try {
            List<Blog> blogs = mapper.selectByClicked();
            logger.info("根据点击数查询成功");
            System.out.println(blogs);
        } catch (Exception e) {
            logger.error("根据点击数查询失败", e);
        }
    }

    @Test
    public void selectOnePage() throws Exception {
        try {
            List<Blog> blogs = mapper.selectOnePage(2, 2);
            logger.info("查询一页数据成功");
            System.out.println(blogs);
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void selectBlogsByKind() throws Exception {
        int kind = 1;
        try {
            List<Blog> blogs = mapper.selectBlogsByKind(kind,0, 2);
            logger.info("查询一页数据成功");
            System.out.println(blogs);
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void getNumsByKind() throws Exception {
        int kind = 1;
        try {
            logger.info("kind为 " + kind + " 的文章有 " + mapper.getNumsByKind(kind) + " 篇");
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void getBlogNums() throws Exception {
        try {
            logger.info(mapper.getBlogNums());
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void update() throws Exception {
        Blog blog = new Blog();
        blog.setBid(1);
        blog.setTitle("title");
        blog.setContent("content");
        blog.setKind(1);
        blog.setUp(1);
        blog.setUid(1);
        blog.setStat(1);
        blog.setClicked(1);
        blog.setComments(1);
        blog.setPtime(new Timestamp(1));
        try {
            if (mapper.update(blog) == 1) {
                logger.info("更新成功");
            } else {
                logger.info("更新失败");
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void updateClicked() throws Exception {
        int id = 1;
        try {
            if (mapper.updateClicked(id) == 1) {
                logger.info("更新点击数成功");
            } else {
                logger.info("更新点击数失败");
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void updateUp() throws Exception {
        int id = 1;
        try {
            if (mapper.updateUp(id) == 1) {
                logger.info("更新点赞数成功");
            } else {
                logger.info("更新点赞数失败");
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void updateComment() throws Exception {
        int id = 1;
        try {
            if (mapper.updateComment(id) == 1) {
                logger.info("更新评论数成功");
            } else {
                logger.info("更新评论数失败");
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

}
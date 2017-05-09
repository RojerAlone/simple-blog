package cn.alone.services;

import cn.alone.pojo.Comment;
import cn.alone.services.ICommentService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by RojerAlone on 2017/4/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml", "classpath:spring-service.xml"})
public class ICommentServiceTest {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private ICommentService service;

    @Test
    public void comment() throws Exception {
        Comment comment = new Comment();
        comment.setUid(1);
        comment.setBid(1);
        comment.setIp("202.117.180.51");
        comment.setContent("评论");
        try {
            if (service == null) {
                logger.info("service为空");
                return;
            }
            System.out.println(comment);
            if (service.comment(comment)) {
                logger.info("评论成功");
            } else {
                logger.info("评论失败");
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void delComment() throws Exception {
        int id =5;
        try {
            if (service.delComment(id)) {
                logger.info("删除成功");
            } else {
                logger.info("删除失败");
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void getBlogComment() throws Exception {
        int bid = 1;
        try {
            List<Comment> comments = service.getBlogComment(bid);
            if (comments == null) {
                logger.info("根据bid查询所有评论失败");
            } else if (comments.size() == 0) {
                logger.info("评论条数为0");
            } else {
                logger.info("查询成功");
                System.out.println(comments);
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void getAuditComment() throws Exception {
        try {
            List<Comment> comments = service.getAuditComment();
            if (comments == null) {
                logger.info("查询所有待审核评论失败");
            } else if (comments.size() == 0) {
                logger.info("待审核评论条数为0");
            } else {
                logger.info("查询成功");
                System.out.println(comments);
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void auditComment() throws Exception {
        int id = 3;
        try {
            if (service.auditComment(id)) {
                logger.info("审核成功");
            } else {
                logger.info("审核失败");
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

}
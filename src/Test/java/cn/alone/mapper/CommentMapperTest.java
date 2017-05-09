package cn.alone.mapper;

import cn.alone.pojo.Comment;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by RojerAlone on 2017/4/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-dao.xml"})
public class CommentMapperTest {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private CommentMapper mapper;
    @Test
    public void insert() throws Exception {
        Comment comment = new Comment();
        comment.setBid(2);
        comment.setUid(1);
        comment.setContent("评论");
        comment.setIp("202.117.180.51");
        try {
            if (1 == mapper.insert(comment)) {
                logger.info("插入成功");
            } else {
                logger.info("插入失败");
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void selectByBid() throws Exception {
        int bid = 1;
        try {
            List<Comment> comments = mapper.selectByBid(bid);
            logger.info("查询成功");
            if (comments == null) {
                logger.info("null");
            } else if (comments.size() == 0) {
                logger.info("size == 0");
            } else {
                System.out.println(comments);
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void selectByStat() throws Exception {
        try {
            List<Comment> comments = mapper.selectByStat(Comment.STAT_AUDIT);
            logger.info("查询成功");
            if (comments == null) {
                logger.info("null");
            } else if (comments.size() == 0) {
                logger.info("size == 0");
            } else {
                System.out.println(comments);
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void update() throws Exception {
        Comment comment = new Comment();
        comment.setCid(1);
        comment.setStat(Comment.STAT_PUBLIC);
        try {
            if (1 == mapper.update(comment)) {
                logger.info("更新成功");
            } else {
                logger.info("更新失败");
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

}
package cn.alone.mapper;

import cn.alone.pojo.User;
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
@ContextConfiguration({"classpath:spring-dao.xml"})
public class UserMapperTest {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private UserMapper mapper;
    @Test
    public void insert() throws Exception {
        User user = new User();
        user.setUsername("Rojer");
        user.setPassword("123456");
        user.setNickname("Alone");
        user.setEmail("1091165843@qq.com");
        user.setPhone(12345678901L);
        try {
            if (1 == mapper.insert(user)) {
                logger.info("插入成功");
            } else {
                logger.info("插入失败");
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void selectById() throws Exception {
        int id = 6;
        try {
            User user = mapper.selectById(id);
            if (user != null) {
                logger.info("查询到了uid为 " + id + " 的用户");
                System.out.println(user);
            } else {
                logger.info("没有该用户");
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void selectByName() throws Exception {
        String name = "Rojer";
        try {
            User user = mapper.selectByName(name);
            if (user != null) {
                logger.info("查询到了username为 " + name + " 的用户");
                System.out.println(user);
            } else {
                logger.info("没有该用户");
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void selectByStat() throws Exception {
        try {
            List<User> users = mapper.selectByStat(User.STAT_NO);
            if (users == null) {
                logger.info("users为空");
            } else if (users.size() == 0) {
                logger.info("users的大小为0");
            } else {
                logger.info("查询到了结果");
                System.out.println(users);
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void update() throws Exception {
        User user = new User();
        user.setUid(6);
//        user.setUsername("rojer");  // 用户名不能改变
        user.setPassword("123456");
        user.setNickname("alone");
        user.setEmail("1091165843@qq.com");
        user.setPhone(12345678901L);
        try {
            if (1 == mapper.update(user)) {
                logger.info("更新成功");
            } else {
                logger.info("更新失败");
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

}
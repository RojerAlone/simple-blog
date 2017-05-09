package cn.alone.services;

import cn.alone.pojo.User;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by RojerAlone on 2017/4/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml", "classpath:spring-service.xml"})
public class IUserServiceTest {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private IUserService service;
    @Test
    public void register() throws Exception {
        User user = new User();
        user.setUsername("tong");
        user.setPassword("123456");
        user.setNickname("桐");
        user.setEmail("1@qq.com");
        try {
            if (service.register(user)) {
                logger.info("注册成功");
            } else {
                logger.info("注册失败");
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void login() throws Exception {
        String username = "tong";
        String password = "12345";
        try {
            if (service.login(username, password)) {
                logger.info("登录成功");
            } else {
                logger.info("登录失败");
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

}